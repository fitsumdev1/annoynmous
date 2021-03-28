package com.fitsum.annonymous.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnnonymousPostResponse {
	
    private String id;
    private String username;
    private String title;
    private String content;
    private Date createdDate;
    private Date updatedDate;

}
 