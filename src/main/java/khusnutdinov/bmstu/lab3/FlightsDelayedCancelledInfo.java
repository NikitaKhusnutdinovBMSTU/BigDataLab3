package khusnutdinov.bmstu.lab3;


import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class FlightsDelayedCancelledInfo {
    SparkConf sparkConf = new SparkConf();
    JavaSparkContext sc = new JavaSparkContext(sparkConf);

    JavaRDD<String> flightsData = sc.textFile("Flights");
    JavaRDD<String> airportsData = sc.textFile("Airports");

    


}
