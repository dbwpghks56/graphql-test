package test.spring.graphql.presentation.dto.response;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class PostResponseDto {
    private Long id;
    private String title;
}
