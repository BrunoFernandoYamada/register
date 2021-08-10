package br.com.byamada.register.queue.config;

import org.apache.avro.specific.SpecificRecordBase;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.producer.Producer;

public interface MessagingConfigPort<T extends SpecificRecordBase> {

    Producer<String, T> configureProducer();

    Consumer configureConsumer();
}
