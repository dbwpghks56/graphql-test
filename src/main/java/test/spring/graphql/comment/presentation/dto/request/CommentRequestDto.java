package test.spring.graphql.comment.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import test.spring.graphql.comment.domain.Comment;
import test.spring.graphql.post.domain.Post;

@Getter
@ToString
@NoArgsConstructor
public class CommentRequestDto {
    private String content;
    private Long postId;

    public Comment toEntity(Post post) {
        return Comment.builder().content(this.content).post(post).build();
    }
}
