package test.spring.graphql.post.application;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import test.spring.graphql.post.domain.service.PostCommandUseCase;
import test.spring.graphql.post.presentation.dto.request.PostRequestDto;
import test.spring.graphql.post.presentation.dto.response.PostResponseDto;

import java.util.List;

@Service
@RequiredArgsConstructor
@GraphQLApi
@Slf4j
public class PostFacade {
    private final PostCommandUseCase postCommandUseCase;

    @GraphQLQuery(name = "findByIdFromPost")
    public PostResponseDto findById(@GraphQLArgument(name = "id") Long id) {
        return postCommandUseCase.findById(id);
    }

    @GraphQLQuery(name = "findByTitleFromPost")
    public PostResponseDto findByTitle(@GraphQLArgument(name = "title") String title) {
        return postCommandUseCase.findByTitle(title);
    }

    @GraphQLMutation(name = "savePost")
    public PostResponseDto save(@GraphQLArgument(name = "requestDto") PostRequestDto requestDto) {
        return postCommandUseCase.save(requestDto);
    }

    @GraphQLQuery(name = "findAllFromPost")
    public List<PostResponseDto> findAll() {
        return postCommandUseCase.findAll();
    }
}
