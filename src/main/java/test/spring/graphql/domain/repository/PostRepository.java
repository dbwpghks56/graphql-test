package test.spring.graphql.domain.repository;

import test.spring.graphql.domain.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepository {
    Optional<Post> findById(Long id);
    Optional<Post> findByTitle(String title);
    Post save(Post post);
    List<Post> findAll();
}
