package miu.edu.cs.cs545.Lab1.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor
public class PostDto {
    private long id;
    private String content;
    private String author;

    public PostDto(long id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }
}
