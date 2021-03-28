package com.fitsum.annonymous.entity.mongo;

import java.util.Date;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "post")
public class AnnonymousPostDocument {
	
    @Id
    private String id; 
    private String username;
    private String title;
    private String content;
    @CreatedDate
    private Date createdDate;
    @LastModifiedDate
    private Date updatedDate;
    
}


 
