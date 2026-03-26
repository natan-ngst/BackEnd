package com.backend.demo.dto;

import lombok.Data;
import java.util.List;

@Data
public class BookDto {
    private String title;
    private String isbn;
    private Long authorId;
    private List<Long> userIds;
    
}
