package site.gbb.gbbserver.api.result.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.gbb.gbbserver.api.result.domain.Result;


public interface ResultRepository extends JpaRepository<Result, Long> {
    Result findByHobbyId(Long hobbyId);
}