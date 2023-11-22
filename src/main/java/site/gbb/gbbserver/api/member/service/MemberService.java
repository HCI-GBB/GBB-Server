package site.gbb.gbbserver.api.member.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.gbb.gbbserver.api.member.domain.Member;
import site.gbb.gbbserver.api.member.repository.MemberRepository;
import site.gbb.gbbserver.api.member.dto.MemberRequestDto;
import site.gbb.gbbserver.api.member.dto.MemberResponseDto;


@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;


    @Transactional
    public String join(MemberRequestDto member) {
        validateDuplicateMember(member.toEntity());
        save(member);
        return memberRepository.findByNickname(member.getNickname()).get().getNickname();
    }
    @Transactional
    public MemberResponseDto show(Long id) {
        if(memberRepository.findById(id).isPresent()){
            return findById(id);
        }else
            return validateMember(id);
    }

    public String save(MemberRequestDto memberRequestDto){
        return memberRepository.save(memberRequestDto.toEntity()).getNickname();
    }
    public MemberResponseDto findById(Long id){
        Member member = memberRepository.findById(id).get();
        return new MemberResponseDto(member);
    }

    private MemberResponseDto validateMember(Long id) {
        Member m = memberRepository.findByIdOrThrow(id);
        return new MemberResponseDto(m);
    }
    private void validateDuplicateMember(Member member) {
        memberRepository.findByNickname(member.getNickname())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 사용 중인 닉네임입니다.");
                });
    }
}
