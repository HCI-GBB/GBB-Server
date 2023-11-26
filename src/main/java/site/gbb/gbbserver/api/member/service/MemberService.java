package site.gbb.gbbserver.api.member.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.gbb.gbbserver.api.hobby.repository.HobbyRepository;
import site.gbb.gbbserver.api.member.domain.Member;
import site.gbb.gbbserver.api.member.repository.MemberRepository;
import site.gbb.gbbserver.api.member.dto.MemberRequestDto;
import site.gbb.gbbserver.api.result.repository.ResultRepository;
import site.gbb.gbbserver.common.exception.DuplicateException;


@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;


    @Transactional
    public Member join(MemberRequestDto member) throws DuplicateException {
        if (checkNickname(member.getNickname())){
            throw new DuplicateException("이미 사용 중인 닉네임입니다!");
        }else
        {
            save(member);
            return memberRepository.findByNickname(member.getNickname()).get();
        }
    }

    public Member save(MemberRequestDto memberRequestDto){
        return memberRepository.save(memberRequestDto.toEntity());
    }

    public Member findById(Long id) {
        return memberRepository.findByIdOrThrow(id);
    }

    public boolean checkNickname(String nickname){
        if(memberRepository.findByNickname(nickname).isPresent()){
            return true;
        }else
            return false;
    }
}
