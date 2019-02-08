https://dzone.com/articles/running-apache-kafka-on-windows-os

testing kafka 

need zookeeper running first then kafka - both folders in root of C:
N.B. ZooKeeper is really just for distributed systems but in this example only 1

need this command for the consumer
kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic test
rather than in tutorial as didnt work (got this from comments)

this runs the producer -
kafka-console-producer.bat --broker-list localhost:9092 --topic test

which then has a command prompt - enter anything there and it appears in the consumer console

The above is just about running kafka on pc rather than through this app! 

However I think I need it running for this app to use too...(like apacheMQ)
https://www.tutorialspoint.com/spring_boot/spring_boot_apache_kafka.htm

// N.B. only worked here (i.e. consumer output) when changed consumer config port to be 9092 rather than the zookeeper port
// N.B the command line consumer also gets the message (and this get cmd line producer messages too)
// N.B. this works without the command line producer and comsumer running - prob just needs kafka and zookeeper



