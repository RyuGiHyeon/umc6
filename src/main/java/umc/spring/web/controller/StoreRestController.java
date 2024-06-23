package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.storeService.StoreCommandService;
import umc.spring.validation.annotation.ExistMember;
import umc.spring.validation.annotation.ExistStore;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    @PostMapping("/{storeId}/reviews")
    public ApiResponse<StoreResponseDTO.PostResultDTO> post(@RequestBody @Valid StoreRequestDTO.PostRequestDTO request,
                                                            @ExistStore @PathVariable(name = "storeId") Long storeId,
                                                            @ExistMember @RequestParam(name = "memberId") Long memberId){

        Review review = storeCommandService.postReview(memberId, storeId, request);
        return ApiResponse.onSuccess(ReviewConverter.toPostResultDTO(review));
    }

    @PostMapping("/{storeId}/{missionId}")
    public ApiResponse<StoreResponseDTO.ChallangeMissionResultDTO> challenge(@ExistStore @PathVariable(name = "missionId") Long storeId,
                                                                             @ExistMember @RequestParam(name = "memberId") Long memberId){

        MemberMission memberMission = storeCommandService.challengeMission(memberId, memberId);
        return ApiResponse.onSuccess(MemberMissionConverter.toMemberMissionResultDTO(memberMission));
    }
}
