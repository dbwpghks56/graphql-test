package test.spring.graphql.post.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.spring.graphql.post.domain.Post;

import java.util.Optional;

public interface PostJpaRepository extends JpaRepository<Post, Long> {
    Optional<Post> findByTitle(String title);
}
