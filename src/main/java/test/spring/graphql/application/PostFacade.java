package test.spring.graphql.application;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import test.spring.graphql.domain.service.PostCommandUseCase;
import test.spring.graphql.presentation.dto.request.PostRequestDto;
import test.spring.graphql.presentation.dto.response.PostResponseDto;

import java.util.List;

@Service
@RequiredArgsConstructor
@GraphQLApi
@Slf4j
public class PostFacade {
    private final PostCommandUseCase postCommandUseCase;

    @GraphQLQuery(name = "findById")
    public PostResponseDto findById(@GraphQLArgument(name = "id") Long id) {
        return postCommandUseCase.findById(id);
    }

    @GraphQLQuery(name = "findByTitle")
    public PostResponseDto findByTitle(@GraphQLArgument(name = "title") String title) {
        return postCommandUseCase.findByTitle(title);
    }

    @GraphQLMutation(name = "save")
    public PostResponseDto save(@GraphQLArgument(name = "requestDto") PostRequestDto requestDto) {
        return postCommandUseCase.save(requestDto);
    }

    @GraphQLQuery(name = "findAll")
    public List<PostResponseDto> findAll() {
        return postCommandUseCase.findAll();
    }
}
