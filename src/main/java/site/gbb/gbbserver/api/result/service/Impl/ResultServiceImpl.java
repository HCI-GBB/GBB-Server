package site.gbb.gbbserver.api.result.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.gbb.gbbserver.api.hobby.domain.Hobby;
import site.gbb.gbbserver.api.hobby.repository.HobbyRepository;
import site.gbb.gbbserver.api.member.domain.Member;
import site.gbb.gbbserver.api.member.repository.MemberRepository;
import site.gbb.gbbserver.api.result.domain.Result;
import site.gbb.gbbserver.api.result.dto.response.ResultGetResponseDto;
import site.gbb.gbbserver.api.result.repository.ResultRepository;
import site.gbb.gbbserver.api.result.service.ResultService;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ResultServiceImpl implements ResultService {
    private final MemberRepository memberRepository;
    private final ResultRepository resultRepository;
    private final HobbyRepository hobbyRepository;

    @Override
    @Transactional
    public ResultGetResponseDto getResult(Long memberId, Long hobbyId) {

        Member member = memberRepository.findByIdOrThrow(memberId);
        Hobby hobby = hobbyRepository.findByMemberId(member.getId());
        Result result = resultRepository.findByHobbyId(hobby.getId());

        return ResultGetResponseDto.of(hobby.getMember().getNickname(), result.getActive(), result.getPercent());

    }
}
