package test.spring.graphql.domain.service;

import test.spring.graphql.presentation.dto.request.PostRequestDto;
import test.spring.graphql.presentation.dto.response.PostResponseDto;

import java.util.List;

public interface PostCommandUseCase {
    PostResponseDto findById(Long id);
    PostResponseDto findByTitle(String title);
    PostResponseDto save(PostRequestDto postRequestDto);
    List<PostResponseDto> findAll();
}
