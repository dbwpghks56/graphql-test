package test.spring.graphql.comment.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.spring.graphql.comment.domain.Comment;
import test.spring.graphql.post.domain.Post;

import java.util.List;
import java.util.Optional;

public interface CommentJpaRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByPost(Post post);
}
