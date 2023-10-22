package test.spring.graphql.comment.domain.service;

import test.spring.graphql.comment.presentation.dto.request.CommentRequestDto;
import test.spring.graphql.comment.presentation.dto.response.CommentResponseDto;

import java.util.List;

public interface CommentCommandUseCase {
    CommentResponseDto findById(Long id);

    List<CommentResponseDto> findAllByPost(Long postId);

    CommentResponseDto save(CommentRequestDto commentRequestDto);
}
