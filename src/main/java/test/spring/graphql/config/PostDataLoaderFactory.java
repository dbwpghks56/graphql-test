package test.spring.graphql.config;

import io.leangen.graphql.spqr.spring.autoconfigure.DataLoaderRegistryFactory;
import org.dataloader.*;
import org.springframework.stereotype.Component;
import test.spring.graphql.post.domain.Post;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class PostDataLoaderFactory implements DataLoaderRegistryFactory {
    private static final BatchLoader<Post, Long> fundingBatchLoader = PostDataLoaderFactory::postings;

    @Override
    public DataLoaderRegistry createDataLoaderRegistry() {
        DataLoader<Post, Long> fundingLoader = new DataLoader<>(fundingBatchLoader);
        DataLoaderRegistry loaders = new DataLoaderRegistry();
        loaders.register("posting", fundingLoader);
        return loaders;
    }

    private static CompletableFuture<List<Long>> postings(List<Post> posts) {
        return CompletableFuture.completedFuture(
                IntStream.range(0, posts.size())
                        .mapToObj(i -> ThreadLocalRandom.current().nextLong(1000) * 1000)
                        .collect(Collectors.toList())
        );
    }
}
