package test.spring.graphql.comment.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import test.spring.graphql.comment.domain.Comment;
import test.spring.graphql.comment.domain.repository.CommentRepository;
import test.spring.graphql.post.domain.Post;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CommentRepositoryImpl implements CommentRepository {
    private final CommentJpaRepository commentJpaRepository;

    @Override
    public Optional<Comment> findById(Long id) {
        return commentJpaRepository.findById(id);
    }

    @Override
    public List<Comment> findByPost(Post post) {
        return commentJpaRepository.findAllByPost(post);
    }

    @Override
    public Comment save(Comment comment) {
        return commentJpaRepository.save(comment);
    }
}
