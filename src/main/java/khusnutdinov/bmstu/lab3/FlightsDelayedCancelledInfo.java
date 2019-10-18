package khusnutdinov.bmstu.lab3;


import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

public class FlightsDelayedCancelledInfo {
    SparkConf sparkConf = new SparkConf();
    JavaSparkContext sc = new JavaSparkContext(sparkConf);

    JavaRDD<String> flightsCSV = sc.textFile("Flights");
    JavaRDD<String> airportsCSV = sc.textFile("Airports");

    JavaPairRDD<Tuple2, FlightsData> flightsData = flightsCSV.mapToPair(in -> {
        FlightsData flData = new FlightsData(in);
        return new Tuple2<>(new Tuple2<>(flData.getOriginAirportID(), flData.getDestAirportID()), flData);
    });


}
