package com.fitsum.annonymous.repository.es;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import com.fitsum.annonymous.entity.es.AnnonymousPostIndex;

public interface AnnonymousPostIndexRepository extends ElasticsearchRepository<AnnonymousPostIndex, String> {
	
	Page<AnnonymousPostIndex> findByTitle(String title, Pageable pageable);
}
   