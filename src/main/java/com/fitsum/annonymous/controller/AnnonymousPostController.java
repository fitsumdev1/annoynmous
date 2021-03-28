package com.fitsum.annonymous.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fitsum.annonymous.model.request.AnnonymousPostRequest;
import com.fitsum.annonymous.model.response.AnnonymousPostResponse;
import com.fitsum.annonymous.service.AnnonymousPostService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value="/api/v1/post", consumes = {MediaType.APPLICATION_JSON_VALUE}, 
 produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class AnnonymousPostController {

    private final AnnonymousPostService annonymousPostService; 
    
     
    
    
    @ApiOperation(value = "creates annonymous data and insert into database") 
    @ApiResponses(value = {
    		@ApiResponse(code = 201, message = "the record has been successfully created"),
    		@ApiResponse(code = 500, message = "there is error in the operation")
    })
    @PostMapping  
    public ResponseEntity<AnnonymousPostResponse>createAnnoymousPost(@RequestBody AnnonymousPostRequest annonymousPostRequest){

        return new ResponseEntity<AnnonymousPostResponse>(annonymousPostService
        		.createAnnonymousPost(annonymousPostRequest), HttpStatus.CREATED);
    } 
       
}   
  