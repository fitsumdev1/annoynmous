package com.fitsum.annonymous.entity.es;

import java.util.Date;

import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "post")
public class AnnonymousPostIndex {
    
    private String id;
    private String username;
    private String title;
    private String content;
    private Date createdDate;
    private Date updatedDate;

} 
    