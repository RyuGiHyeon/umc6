package umc.spring.service.storeService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.*;
import umc.spring.web.dto.StoreRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreCommandServiceImpl implements StoreCommandService {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    @Transactional
    public Review postReview(Long memberId, Long storeId, StoreRequestDTO.PostRequestDTO request) {

        Review newReview = ReviewConverter.toReview(request);
        newReview.setMember(memberRepository.findById(memberId).get());
        newReview.setStore(storeRepository.findById(storeId).get());

        return reviewRepository.save(newReview);
    }

    @Override
    public MemberMission challengeMission(Long memberId, Long missionId) {

        Member member = memberRepository.findById(memberId).get();
        Mission mission = missionRepository.findById(missionId).get();

        return MemberMissionConverter.toMemberMission(member, mission);
    }
}
