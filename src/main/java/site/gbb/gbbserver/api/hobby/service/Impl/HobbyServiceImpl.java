package site.gbb.gbbserver.api.hobby.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.gbb.gbbserver.api.hobby.domain.Hobby;
import site.gbb.gbbserver.api.hobby.dto.request.HobbyCreateRequestDto;
import site.gbb.gbbserver.api.hobby.dto.response.HobbyCreateResponseDto;
import site.gbb.gbbserver.api.hobby.repository.HobbyRepository;
import site.gbb.gbbserver.api.hobby.service.HobbyService;
import site.gbb.gbbserver.api.member.domain.Member;
import site.gbb.gbbserver.api.member.repository.MemberRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class HobbyServiceImpl implements HobbyService {
    private final HobbyRepository hobbyRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public HobbyCreateResponseDto createHobby(Long memberId, HobbyCreateRequestDto requestDto) {

        Hobby hobby = Hobby.builder()
                .member(memberRepository.findByIdOrThrow(memberId))
                .likes(requestDto.getLikes())
                .hates(requestDto.getHates())
                .build();

        hobbyRepository.save(hobby);

        return HobbyCreateResponseDto.builder()
                .id(hobby.getId()).build();
    }
}
