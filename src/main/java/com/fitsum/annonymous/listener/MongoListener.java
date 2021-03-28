package com.fitsum.annonymous.listener;

import com.fitsum.annonymous.config.KafkaProducerConfig;
import lombok.SneakyThrows;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.AfterSaveEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.fitsum.annonymous.entity.mongo.AnnonymousPostDocument;
import com.fitsum.annonymous.model.mapper.AnnonymousPostMapper;
import com.fitsum.annonymous.repository.es.AnnonymousPostIndexRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@AllArgsConstructor
public class MongoListener extends AbstractMongoEventListener<AnnonymousPostDocument> { 
	
	private final KafkaTemplate<String, AnnonymousPostDocument>kafkaTemplate;
	 
	private final AnnonymousPostMapper annonymousPostMapper;

	private final KafkaProducerConfig kafkaProducerConfig;
	
	private final AnnonymousPostIndexRepository annonymousPostIndexRepository;
	 
	@SneakyThrows
	@Override
	public void onAfterSave(AfterSaveEvent<AnnonymousPostDocument> event) {  
		 
		log.info("syncing data from mongo to elasticsearch for document: {} ", event.getSource()); 
		
//		annonymousPostIndexRepository.save(annonymousPostMapper.toAnnonymousPostIndex(event.getSource()));
		log.info("Successfully pushed data to elasticsearch");

		kafkaTemplate.send(kafkaProducerConfig.getDefaultTopic(), event.getSource());
	}
	   
}          
      