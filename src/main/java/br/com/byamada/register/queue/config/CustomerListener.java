package br.com.byamada.register.queue.config;

import br.com.byamada.register.avro.Customer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.util.Arrays;
import java.util.Map;

@Configuration
public class CustomerListener implements Listener{

    @Autowired
    @Qualifier("customerConsumer")
    private KafkaConsumer consumer;


    @Override
    public void consumer() {

        consumer.subscribe(Arrays.asList("customer-received-avro"));

        while(true){
            ConsumerRecords<String, Customer> records = consumer.poll(Duration.ofMillis(100));
            for (ConsumerRecord<String, Customer> record : records) {
                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
                final var topicPartition = new TopicPartition(record.topic(), record.partition());
                final var offsetAndMetadata = new OffsetAndMetadata(record.offset() + 1);
                consumer.commitSync(Map.of(topicPartition, offsetAndMetadata));
            }
        }
    }

}
