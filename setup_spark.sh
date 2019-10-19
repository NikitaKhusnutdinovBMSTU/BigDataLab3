#!/bin/bash
echo
while [ -n "$1" ]
do
case "$1" in
-s)echo "******START_ALL_SPARK_BY_KHUSNUTDINOV******" &&
stop-yarn.sh && stop-dfs.sh && start-dfs.sh && 
start-yarn.sh && 
echo "******STARTING_INITIALISE******" && 
mvn package && spark-submit --class khusnutdinov.bmstu.lab3.FlightsDelayedCancelledInfo --master yarn-client --num-executors 3 target/khusnutdinov.bmstu.lab3-1.0-SNAPSHOT.jar >> solution.txt
echo "******OUTPUT_IN_SOLUTION.TXT******" && cat * > solution.txt ;;
-d)echo "******START_SPARK_BY_KHUSNUTDINOV******" &&
echo "******STARTING_INITIALISE******" && 
mvn package && spark-submit --class khusnutdinov.bmstu.lab3.FlightsDelayedCancelledInfo --master yarn-client --num-executors 3 target/khusnutdinov.bmstu.lab3-1.0-SNAPSHOT.jar >> solution.txt
echo "******OUTPUT_IN_SOLUTION.TXT******" && cat * > solution.txt ;;
*) echo "******USAGE: -d classic_start(without reboot), -s start_with_reboot OUTPUT_IN_SOLUTION.TXT******"
esac
shift
done