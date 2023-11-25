package site.gbb.gbbserver.api.member.repository;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import org.springframework.data.jpa.repository.JpaRepository;
import site.gbb.gbbserver.api.hobby.domain.Hobby;
import site.gbb.gbbserver.api.member.domain.Member;
import site.gbb.gbbserver.api.result.domain.Result;
import site.gbb.gbbserver.common.exception.NotFoundException;
import site.gbb.gbbserver.common.response.ErrorCode;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    default Member findByIdOrThrow(Long memberId) {
        return findById(memberId)
                .orElseThrow(() -> new NotFoundException(ErrorCode.NOT_FOUND_MEMBER));
    }
    Optional<Member> findByNickname(String nickname);
    Optional<Member> findById(Long memberId);

}
