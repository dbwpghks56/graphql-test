package test.spring.graphql.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import test.spring.graphql.domain.Post;
import test.spring.graphql.domain.repository.PostRepository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository {
    private final PostJpaRepository postJpaRepository;

    @Override
    public Optional<Post> findById(Long id) {
        return postJpaRepository.findById(id);
    }

    @Override
    public Optional<Post> findByTitle(String title) {
        return postJpaRepository.findByTitle(title);
    }

    @Override
    public Post save(Post post) {
        return postJpaRepository.save(post);
    }

    @Override
    public List<Post> findAll() {
        return postJpaRepository.findAll();
    }
}
