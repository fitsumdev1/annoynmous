package com.fitsum.annonymous.model.mapper;

import org.mapstruct.Mapper;

import com.fitsum.annonymous.entity.es.AnnonymousPostIndex;
import com.fitsum.annonymous.entity.mongo.AnnonymousPostDocument;
import com.fitsum.annonymous.model.request.AnnonymousPostRequest;
import com.fitsum.annonymous.model.response.AnnonymousPostResponse;

@Mapper(componentModel  = "spring")
public interface AnnonymousPostMapper {

//    @Mapping(target="createdDate", ignore=true)
//    @Mapping(target="id", ignore=true)
//    @Mapping(target="updatedDate", ignore=true)
    AnnonymousPostDocument toAnnonymousPostDocument(AnnonymousPostRequest annonymousPostRequest);

    AnnonymousPostResponse toAnnonymousPostResponse(AnnonymousPostDocument annonymousPostDocument);
    
    AnnonymousPostIndex toAnnonymousPostIndex(AnnonymousPostDocument annonymousPostDocument);
       
}    
    
