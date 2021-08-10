package br.com.byamada.register.queue.config;

import br.com.byamada.register.avro.Customer;
import br.com.byamada.register.model.dto.CommonDTO;
import br.com.byamada.register.model.dto.CustomerDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerService implements MessagingPort<Customer> {

    @Autowired
    @Qualifier("customerProducer")
    private KafkaProducer<String, Customer> producer;

    @Override
    public String topic() {
        return "customer-received-avro";
    }

    @Override
    public ProducerRecord<String, Customer> createProducerRecord(Customer customer) {

        return new ProducerRecord<String, Customer>(this.topic(), customer);

    }

    @Override
    public void send(CommonDTO customerDTO) {

        Customer customer = Customer.newBuilder().setName(((CustomerDTO) customerDTO).getName())
                .setDocument(((CustomerDTO) customerDTO).getDocument())
                .setAge(((CustomerDTO) customerDTO).getAge())
                .setIsActive(true)
                .build();

        producer.send(this.createProducerRecord(customer), (rm, ex) -> {
            if (ex == null) {
                log.info("Data sent with success!!!");
            } else {
                log.error("Fail to send message", ex);
            }
        });



    }

}