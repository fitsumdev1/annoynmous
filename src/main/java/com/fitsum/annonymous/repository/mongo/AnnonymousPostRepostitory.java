package com.fitsum.annonymous.repository.mongo;

import com.fitsum.annonymous.entity.mongo.AnnonymousPostDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnonymousPostRepostitory extends MongoRepository<AnnonymousPostDocument, String> {
	
	
  
}
