package com.fitsum.annonymous.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.fitsum.annonymous.entity.mongo.AnnonymousPostDocument;
import com.fitsum.annonymous.model.mapper.AnnonymousPostMapper;
import com.fitsum.annonymous.model.request.AnnonymousPostRequest;
import com.fitsum.annonymous.model.response.AnnonymousPostResponse;
import com.fitsum.annonymous.repository.mongo.AnnonymousPostRepostitory;
import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor
@Transactional 
public class AnnonymousPostService {  

    private final AnnonymousPostRepostitory annonymousPostRepostitory;

    private final AnnonymousPostMapper annonymousPostMapper;

    public AnnonymousPostResponse createAnnonymousPost(AnnonymousPostRequest annonymousPostRequest){
        AnnonymousPostDocument savedDocument = annonymousPostRepostitory.save(annonymousPostMapper.toAnnonymousPostDocument(annonymousPostRequest));
        return annonymousPostMapper.toAnnonymousPostResponse(savedDocument);
    }
 
}
 