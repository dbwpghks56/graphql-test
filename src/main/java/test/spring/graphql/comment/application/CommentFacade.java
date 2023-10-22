package test.spring.graphql.comment.application;

import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import test.spring.graphql.comment.domain.service.CommentCommandUseCase;
import test.spring.graphql.comment.presentation.dto.request.CommentRequestDto;
import test.spring.graphql.comment.presentation.dto.response.CommentResponseDto;

import java.util.List;

@Service
@RequiredArgsConstructor
@GraphQLApi
public class CommentFacade {
    private final CommentCommandUseCase commentCommandUseCase;

    @GraphQLQuery(name = "findByIdComment")
    public CommentResponseDto findByIdComment(Long id) {
        return commentCommandUseCase.findById(id);
    }

    @GraphQLQuery(name = "findAllByPost")
    public List<CommentResponseDto> findAllByPost(Long postId) {
        return commentCommandUseCase.findAllByPost(postId);
    }

    @GraphQLMutation(name = "saveComment")
    public CommentResponseDto save(CommentRequestDto commentRequestDto) {
        return commentCommandUseCase.save(commentRequestDto);
    }
}
