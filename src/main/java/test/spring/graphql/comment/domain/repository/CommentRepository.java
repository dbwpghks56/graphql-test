package test.spring.graphql.comment.domain.repository;

import test.spring.graphql.comment.domain.Comment;
import test.spring.graphql.post.domain.Post;

import java.util.List;
import java.util.Optional;

public interface CommentRepository {
    Optional<Comment> findById(Long id);
    List<Comment> findByPost(Post post);
    Comment save(Comment comment);
}
