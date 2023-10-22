package test.spring.graphql.comment.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.spring.graphql.comment.domain.Comment;
import test.spring.graphql.comment.domain.repository.CommentRepository;
import test.spring.graphql.comment.presentation.dto.request.CommentRequestDto;
import test.spring.graphql.comment.presentation.dto.response.CommentResponseDto;
import test.spring.graphql.post.domain.Post;
import test.spring.graphql.post.domain.repository.PostRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentService implements CommentCommandUseCase {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Override
    public CommentResponseDto findById(Long id) {
        return commentRepository.findById(id).orElseThrow().toResponseDto();
    }

    @Override
    public List<CommentResponseDto> findAllByPost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow();

        return commentRepository.findByPost(post).stream().map(Comment::toResponseDto).toList();
    }

    @Override
    public CommentResponseDto save(CommentRequestDto commentRequestDto) {
        Post post = postRepository.findById(commentRequestDto.getPostId()).orElseThrow();

        return commentRepository.save(commentRequestDto.toEntity(post)).toResponseDto();
    }
}
