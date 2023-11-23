package site.gbb.gbbserver.api.member.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.gbb.gbbserver.api.hobby.repository.HobbyRepository;
import site.gbb.gbbserver.api.member.domain.Member;
import site.gbb.gbbserver.api.member.repository.MemberRepository;
import site.gbb.gbbserver.api.member.dto.MemberRequestDto;
import site.gbb.gbbserver.api.member.dto.MemberResponseDto;
import site.gbb.gbbserver.api.result.repository.ResultRepository;



@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final HobbyRepository hobbyRepository;
    private final ResultRepository resultRepository;


    @Transactional
    public Member join(MemberRequestDto member) {
        validateDuplicateMember(member.toEntity().getNickname());
        save(member);
        return memberRepository.findByNickname(member.getNickname()).get();
    }

    public String save(MemberRequestDto memberRequestDto){
        return memberRepository.save(memberRequestDto.toEntity()).getNickname();
    }

    public MemberResponseDto findById(Long id){
        return MemberResponseDto.builder()
                .member(memberRepository.findById(id).get())
                .hobby(hobbyRepository.findById(id).get())
                .result(resultRepository.findById(id).get())
                .build();
    }
    private void validateDuplicateMember(String nickname) {
        memberRepository.findByNickname(nickname)
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 사용 중인 닉네임입니다.");
                });
    }
}
