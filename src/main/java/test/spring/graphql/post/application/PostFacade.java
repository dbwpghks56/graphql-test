package test.spring.graphql.post.application;

import io.leangen.graphql.annotations.*;
import io.leangen.graphql.execution.ResolutionEnvironment;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderFactory;
import org.dataloader.DataLoaderRegistry;
import org.springframework.graphql.data.method.annotation.ContextValue;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;
import test.spring.graphql.config.PostDataLoaderFactory;
import test.spring.graphql.post.domain.Post;
import test.spring.graphql.post.domain.service.PostCommandUseCase;
import test.spring.graphql.post.presentation.dto.request.PostRequestDto;
import test.spring.graphql.post.presentation.dto.response.PostResponseDto;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
@GraphQLApi
@Slf4j
public class PostFacade {
    private final PostCommandUseCase postCommandUseCase;
    private final PostDataLoaderFactory dataLoaderFactory;

    @GraphQLQuery(name = "findByIdFromPost")
    public PostResponseDto findById(
            @GraphQLArgument(name = "id") Long id) {
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

    @GraphQLQuery(name = "currentFunding")
    public CompletableFuture<Long> currentFunding(@GraphQLContext Post post, @GraphQLEnvironment ResolutionEnvironment env) {
        DataLoader<Post, Long> fundingLoader = env.dataFetchingEnvironment.getDataLoader("posting");
        return fundingLoader.load(post);
    }
}
