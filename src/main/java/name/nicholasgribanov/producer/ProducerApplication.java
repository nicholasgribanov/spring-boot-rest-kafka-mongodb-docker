package name.nicholasgribanov.producer;

import name.nicholasgribanov.producer.kafka.MessageProducer;
import name.nicholasgribanov.producer.restclient.services.ApiService;
import name.nicholasgribanov.producer.restclient.services.ApiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ProducerApplication {


    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ProducerApplication.class, args);

        MessageProducer producer = context.getBean(MessageProducer.class);
        ApiService service = context.getBean(ApiServiceImpl.class);

        service.getData(3).forEach(producer::sendMessage);

    }

}
