package site.gbb.gbbserver.api.result.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.gbb.gbbserver.api.result.domain.Result;

import java.util.Optional;


public interface ResultRepository extends JpaRepository<Result, Long> {
    Optional<Result> findByHobbyId(Long hobbyId);
}
