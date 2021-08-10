/* Classe para manter configuração do kafka*/

package br.com.byamada.register.queue.config;

import io.confluent.kafka.serializers.KafkaAvroSerializer;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "kafka")
@Data
@NoArgsConstructor
public class KafkaProperties {

    private String bootstrapServers;
    private String acksConfig;
    private String retriesConfig;
    private Class<?> keySerializer = StringSerializer.class;
    private Class<?> valueSerializer = KafkaAvroSerializer.class;
    private String schemaRegistryUrl;

}
