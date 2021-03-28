package com.fitsum.annonymous.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.fitsum.annonymous.entity.es.AnnonymousPostIndex;
import com.fitsum.annonymous.repository.es.AnnonymousPostIndexRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class AnnonymousPostSearchService {
	
	private final AnnonymousPostIndexRepository annonymousPostIndexRepository;
	
	public Page<AnnonymousPostIndex> findByTitle(String title, int page, int size){
		log.info("fetching annonymous post index for title {}, page {}, and size {}", title, page, size);
		return annonymousPostIndexRepository.findByTitle(title, PageRequest.of(page, size));
	}
	
  
}
