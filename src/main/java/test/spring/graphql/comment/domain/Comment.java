package test.spring.graphql.comment.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import test.spring.graphql.comment.presentation.dto.response.CommentResponseDto;
import test.spring.graphql.post.domain.Post;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_comment")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @CreationTimestamp
    private LocalDateTime createdTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    public CommentResponseDto toResponseDto() {
        return CommentResponseDto.builder()
                .id(this.id)
                .content(this.content)
                .createdTime(this.createdTime)
                .post(this.post.postResponseDto())
                .build();
    }
}
