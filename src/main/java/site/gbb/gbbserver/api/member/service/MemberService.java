package site.gbb.gbbserver.api.member.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.gbb.gbbserver.api.hobby.domain.Hobby;
import site.gbb.gbbserver.api.hobby.repository.HobbyRepository;
import site.gbb.gbbserver.api.member.domain.Member;
import site.gbb.gbbserver.api.member.dto.MemberResponseDto;
import site.gbb.gbbserver.api.member.repository.MemberRepository;
import site.gbb.gbbserver.api.member.dto.MemberRequestDto;
import site.gbb.gbbserver.api.result.repository.ResultRepository;
import site.gbb.gbbserver.common.exception.DuplicateException;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final HobbyRepository hobbyRepository;
    private final ResultRepository resultRepository;


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

    public String save(MemberRequestDto memberRequestDto){
        return memberRepository.save(memberRequestDto.toEntity()).getNickname();
    }

    public MemberResponseDto findById(Long id) {
        MemberResponseDto dto = MemberResponseDto.builder()
                .id(id)
                .nickname(memberRepository.findByIdOrThrow(id).getNickname())
                .like(hobbyRepository.findByMemberId(id).get().getLikes())
                .hate(hobbyRepository.findByMemberId(id).get().getHates())
                .active(resultRepository.findByHobbyId(id).get().getActive())
                .build();
        return dto;
    }

    public boolean checkNickname(String nickname){
        if(memberRepository.findByNickname(nickname).isPresent()){
            return true;
        }else
            return false;
    }
}
