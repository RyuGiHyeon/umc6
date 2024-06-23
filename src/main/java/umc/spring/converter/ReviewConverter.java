package umc.spring.converter;

import umc.spring.domain.Review;
import umc.spring.repository.ReviewRepository;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

public class ReviewConverter {

    public static Review toReview(StoreRequestDTO.PostRequestDTO request) {
        return Review.builder()
                .score(request.getScore())
                .title(request.getTitle())
                .build();
    }

    public static StoreResponseDTO.PostResultDTO toPostResultDTO(Review review){
        return StoreResponseDTO.PostResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(review.getCreatedAt())
                .build();
    }
}
