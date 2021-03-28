package com.fitsum.annonymous.controller;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fitsum.annonymous.entity.es.AnnonymousPostIndex;
import com.fitsum.annonymous.service.AnnonymousPostSearchService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value="/api/v1/post/search", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class AnnonymousPostSearchController { 
	
    private final AnnonymousPostSearchService annonymousSearchPostService; 

    @ApiOperation(value = "retrieves paginated annonymous post index")  
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message = "the record has been successfully retrieved"),
    		@ApiResponse(code = 500, message = "there is error in the operation")
    })
    @GetMapping  
    @Cacheable(value = "annonymousPostIndex", key = "#annonymousPostIndex.title")
    public ResponseEntity<Page<AnnonymousPostIndex>> getPaginatedAnnoymousPost(@RequestParam String title, 
    		@RequestParam(defaultValue = "0") int page,
    		@RequestParam(defaultValue = "5") int size){
    	return ResponseEntity.ok(annonymousSearchPostService.findByTitle(title, page, size));
    }    
      
}  
