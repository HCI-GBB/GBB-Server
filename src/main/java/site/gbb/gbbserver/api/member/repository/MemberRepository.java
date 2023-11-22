package site.gbb.gbbserver.api.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.gbb.gbbserver.api.member.domain.Member;
import site.gbb.gbbserver.common.exception.NotFoundException;
import site.gbb.gbbserver.common.response.ErrorCode;

public interface MemberRepository extends JpaRepository<Member, Long> {

    default Member findByIdOrThrow(Long memberId) {
        return findById(memberId)
                .orElseThrow(() -> new NotFoundException(ErrorCode.NOT_FOUND_MEMBER));
    }
}
