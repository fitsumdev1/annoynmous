package com.fitsum.annonymous.config;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import com.fitsum.annonymous.entity.mongo.AnnonymousPostDocument;

@Configuration
@PropertySource("classpath:application.yml")
@ConfigurationProperties(prefix = "kafka")
public class KafkaProducerConfig {

	@Value("${bootstrap-servers}")
	private String bootStrapServers;

	public String getDefaultTopic() {
		return defaultTopic;
	}

	@Value("${default-topic}")
	public String defaultTopic;

	@Autowired
	private KafkaProperties kafkaProperties;

	@Bean
	public ProducerFactory<String, AnnonymousPostDocument> producerFactory() {
		Map<String, Object> config = new HashMap<>();

		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapServers);
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		 
		return new DefaultKafkaProducerFactory<>(config);

	} 
	 
	@Bean
	public KafkaTemplate<String, AnnonymousPostDocument> kafkaTemplate(){
		return new KafkaTemplate<>(producerFactory());
	}
	
	
}