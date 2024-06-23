package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.StoreResponseDTO;

public class MemberMissionConverter {

    public static MemberMission toMemberMission(Member member, Mission mission){
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(MissionStatus.valueOf("CHALLENGING"))
                .build();
    }

    public static StoreResponseDTO.ChallangeMissionResultDTO toMemberMissionResultDTO(MemberMission memberMission){
        return StoreResponseDTO.ChallangeMissionResultDTO.builder()
                .reward(memberMission.getMission().getReward())
                .status(memberMission.getStatus())
                .storeName(memberMission.getMission().getStore().getName())
                .deadLine(memberMission.getMission().getDeadline())
                .missionSpec(memberMission.getMission().getMissionSpec())
                .build();

    }
}
