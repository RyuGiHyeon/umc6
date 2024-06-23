package umc.spring.converter;

import umc.spring.domain.Review;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;
import java.util.List;

public class StoreConverter {

    public static Review toReview(StoreRequestDTO.PostRequestDTO request){
        return Review.builder()
                .title(request.getTitle())
                .score(request.getScore())
                .build();
    }

    public static StoreResponseDTO.PostResultDTO toCreateReviewResultDTO(Review review){
        return StoreResponseDTO.PostResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static StoreResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review){
        return null;
    }
    public static StoreResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(List<Review> reviewList){
        return null;
    }
}
