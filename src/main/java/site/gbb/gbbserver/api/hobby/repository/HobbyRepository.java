package site.gbb.gbbserver.api.hobby.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.gbb.gbbserver.api.hobby.domain.Hobby;

import java.util.Optional;


@Repository
public interface HobbyRepository extends JpaRepository<Hobby, Long> {
    Optional<Hobby> findByMemberId(Long memberId);
}
