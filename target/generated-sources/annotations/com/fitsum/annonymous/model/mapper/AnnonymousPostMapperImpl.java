package com.fitsum.annonymous.model.mapper;

import com.fitsum.annonymous.entity.es.AnnonymousPostIndex;
import com.fitsum.annonymous.entity.mongo.AnnonymousPostDocument;
import com.fitsum.annonymous.entity.mongo.AnnonymousPostDocument.AnnonymousPostDocumentBuilder;
import com.fitsum.annonymous.model.request.AnnonymousPostRequest;
import com.fitsum.annonymous.model.response.AnnonymousPostResponse;
import com.fitsum.annonymous.model.response.AnnonymousPostResponse.AnnonymousPostResponseBuilder;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-28T17:35:52+0530",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_261 (Oracle Corporation)"
)
@Component
public class AnnonymousPostMapperImpl implements AnnonymousPostMapper {

    @Override
    public AnnonymousPostDocument toAnnonymousPostDocument(AnnonymousPostRequest annonymousPostRequest) {
        if ( annonymousPostRequest == null ) {
            return null;
        }

        AnnonymousPostDocumentBuilder annonymousPostDocument = AnnonymousPostDocument.builder();

        annonymousPostDocument.username( annonymousPostRequest.getUsername() );
        annonymousPostDocument.title( annonymousPostRequest.getTitle() );
        annonymousPostDocument.content( annonymousPostRequest.getContent() );

        return annonymousPostDocument.build();
    }

    @Override
    public AnnonymousPostResponse toAnnonymousPostResponse(AnnonymousPostDocument annonymousPostDocument) {
        if ( annonymousPostDocument == null ) {
            return null;
        }

        AnnonymousPostResponseBuilder annonymousPostResponse = AnnonymousPostResponse.builder();

        annonymousPostResponse.id( annonymousPostDocument.getId() );
        annonymousPostResponse.username( annonymousPostDocument.getUsername() );
        annonymousPostResponse.title( annonymousPostDocument.getTitle() );
        annonymousPostResponse.content( annonymousPostDocument.getContent() );
        annonymousPostResponse.createdDate( annonymousPostDocument.getCreatedDate() );
        annonymousPostResponse.updatedDate( annonymousPostDocument.getUpdatedDate() );

        return annonymousPostResponse.build();
    }

    @Override
    public AnnonymousPostIndex toAnnonymousPostIndex(AnnonymousPostDocument annonymousPostDocument) {
        if ( annonymousPostDocument == null ) {
            return null;
        }

        AnnonymousPostIndex annonymousPostIndex = new AnnonymousPostIndex();

        annonymousPostIndex.setId( annonymousPostDocument.getId() );
        annonymousPostIndex.setUsername( annonymousPostDocument.getUsername() );
        annonymousPostIndex.setTitle( annonymousPostDocument.getTitle() );
        annonymousPostIndex.setContent( annonymousPostDocument.getContent() );
        annonymousPostIndex.setCreatedDate( annonymousPostDocument.getCreatedDate() );
        annonymousPostIndex.setUpdatedDate( annonymousPostDocument.getUpdatedDate() );

        return annonymousPostIndex;
    }
}
