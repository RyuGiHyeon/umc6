package umc.spring.service.storeService;

import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.StoreRequestDTO;

public interface StoreCommandService {

    Review postReview(Long memberId, Long storeId, StoreRequestDTO.PostRequestDTO request);

    MemberMission challengeMission(Long memberId, Long missionId);
}
