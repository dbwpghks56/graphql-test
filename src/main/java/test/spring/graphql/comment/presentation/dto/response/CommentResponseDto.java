package test.spring.graphql.comment.presentation.dto.response;

import lombok.*;
import test.spring.graphql.post.domain.Post;
import test.spring.graphql.post.presentation.dto.response.PostResponseDto;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CommentResponseDto {
    private Long id;
    private String content;
    private LocalDateTime createdTime;
    private PostResponseDto post;
}
