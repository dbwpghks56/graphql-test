package test.spring.graphql.post.presentation.dto.response;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.*;
import test.spring.graphql.comment.presentation.dto.response.CommentResponseDto;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class PostResponseDto {
    private Long id;
    private String title;
    private Long commentCnt;

    @GraphQLQuery(name = "throwTitle")
    public String throwTitle() {
        return this.title;
    }
}
