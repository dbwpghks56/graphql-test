package test.spring.graphql.post.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import test.spring.graphql.comment.domain.Comment;
import test.spring.graphql.post.presentation.dto.response.PostResponseDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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

    private String description;

    @CreationTimestamp
    private LocalDateTime createdTime;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

    public PostResponseDto postResponseDto() {
        return PostResponseDto.builder()
                .id(this.id)
                .title(this.title)
                .commentCnt((long) comments.size())
                .build();
    }

}
