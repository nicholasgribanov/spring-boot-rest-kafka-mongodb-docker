package name.nicholasgribanov.consumer.kafka;

import name.nicholasgribanov.consumer.services.DataService;
import name.nicholasgribanov.dto.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

public class MessageListener {

    @Autowired
    private DataService dataService;

    @KafkaListener(topics = "${kafka.topic.name}", containerFactory = "kafkaListenerContainerFactory")
    public void listener(Data data) {
        System.out.println("Recieved message: " + data);
        dataService.saveMessage(data);
    }
}
