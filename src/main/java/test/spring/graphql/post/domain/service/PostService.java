package test.spring.graphql.post.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.spring.graphql.post.domain.Post;
import test.spring.graphql.post.domain.repository.PostRepository;
import test.spring.graphql.post.presentation.dto.request.PostRequestDto;
import test.spring.graphql.post.presentation.dto.response.PostResponseDto;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService implements PostCommandUseCase{
    private final PostRepository postRepository;

    @Override
    public PostResponseDto findById(Long id) {
        return postRepository.findById(id).orElseThrow().postResponseDto();
    }

    @Override
    public PostResponseDto findByTitle(String title) {
        return postRepository.findByTitle(title).orElseThrow().postResponseDto();
    }

    @Override
    public PostResponseDto save(PostRequestDto postRequestDto) {
        return postRepository.save(postRequestDto.toEntity()).postResponseDto();
    }

    @Override
    public List<PostResponseDto> findAll() {
        return postRepository.findAll().stream().map(Post::postResponseDto).toList();
    }
}
