package com.fitsum.annonymous.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnnonymousPostRequest {
    @NotBlank
    private String username;
    @NotBlank(message = "title is required")
    private String title;
    @NotBlank(message = "content is required")
    private String content;
}  
     