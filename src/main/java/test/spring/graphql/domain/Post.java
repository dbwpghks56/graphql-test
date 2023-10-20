package test.spring.graphql.domain;

import io.leangen.graphql.annotations.GraphQLQuery;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import test.spring.graphql.presentation.dto.response.PostResponseDto;

@Entity
@Table(name = "tb_post")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    public PostResponseDto postResponseDto() {
        return PostResponseDto.builder().id(this.id).title(this.title).build();
    }

}
