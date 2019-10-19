package khusnutdinov.bmstu.lab3;


import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.broadcast.Broadcast;
import scala.Tuple2;

import java.util.Map;

public class FlightsDelayedCancelledInfo {

    private final static String FLIGHTS_CSV_PATH = "664600583_T_ONTIME_sample.csv";
    private final static String AIRPORT_CSV_PATH = "L_AIRPORT_ID.csv";

    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf();
        JavaSparkContext sc = new JavaSparkContext(sparkConf);

        JavaRDD<String> flightsCSV = sc.textFile(FLIGHTS_CSV_PATH);
        JavaRDD<String> airportsCSV = sc.textFile(AIRPORT_CSV_PATH);
        String filterFlights = flightsCSV.first();
        String filterAirport = airportsCSV.first();
        flightsCSV = flightsCSV.filter(line -> !line.equals(filterFlights));
        airportsCSV = airportsCSV.filter(line -> !line.equals(filterAirport));
        JavaPairRDD<Tuple2, FlightsData> flightsData = flightsCSV.mapToPair(in -> {
            FlightsData flData = new FlightsData(in);
            return new Tuple2<>(new Tuple2<>(flData.getOriginAirportID(), flData.getDestAirportID()), flData);
        });

        JavaPairRDD<Tuple2, AirportPair> combineFlData = flightsData.combineByKey(
                airport -> new AirportPair(
                        1,
                        airport.getCancelled(),
                        airport.getDelayed(),
                        airport.getDelay()
                ),
                (pair, airport) -> pair.addFlight(
                        airport.getCancelled(),
                        airport.getDelayed(),
                        airport.getDelay()
                ),
                AirportPair::addData
        );

        Map<Integer, String> pair = airportsCSV.mapToPair(
                row -> {
                    int divided = row.indexOf(",");

                    return new Tuple2<>(Integer.parseInt(row.substring(1, divided - 1)), row.substring(divided + 2, row.length() - 1));
                }
        ).collectAsMap();

        final Broadcast<Map<Integer, String>> broadcast = sc.broadcast(pair);

        System.out.println(combineFlData.map(
                s ->
                "{"+ broadcast.getValue().get(s._1._1) + " | " +
                broadcast.getValue().get(s._1._2) + " | " +
                s._2.getInfoString() + "}\n").collect());
    }

}
