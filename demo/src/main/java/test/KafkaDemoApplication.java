package test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

// this is just testing kafka send and receive from this SB application rather than a 'proper' app
// noticed how we need to  implements ApplicationRunner to run the sendMessage
// N.B. only worked here (i.e. consumer output) when changed consumer config port to be 9092 rather than the zookeeper port
// N.B the command line consumer also gets the message (and this get cmd line producer messages too)
// N.B. this works without the command line producer and comsumer running - prob just needs kafka and zookeeper
@SpringBootApplication
public class KafkaDemoApplication implements ApplicationRunner {

	 @Autowired
	   private KafkaTemplate<String, String> kafkaTemplate;

	   public static void main(String[] args) {
	      SpringApplication.run(KafkaDemoApplication.class, args);
	   }
	   @KafkaListener(topics = "test", groupId = "group-id")
	   public void listen(String message) {
	      System.out.println("Received Messasge in group - group-id: " + message);
	   }
	   	   
	   public void sendMessage(String msg) {
		      kafkaTemplate.send("test", msg);
		   }
	   @Override
	   public void run(ApplicationArguments args) throws Exception {
		   System.out.println("About so send message using SB application runner");
	      sendMessage("Hi Welcome to Spring For Apache Kafka");
	   }
}
