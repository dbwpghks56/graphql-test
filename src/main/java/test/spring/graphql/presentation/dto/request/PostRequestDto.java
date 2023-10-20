package test.spring.graphql.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import test.spring.graphql.domain.Post;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostRequestDto {
    private Long id;
    private String title;

    public Post toEntity() {
        return Post.builder().title(this.title).build();
    }
}
