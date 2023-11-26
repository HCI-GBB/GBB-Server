package site.gbb.gbbserver.api.member.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import site.gbb.gbbserver.api.hobby.domain.Hobby;
import site.gbb.gbbserver.api.result.domain.Result;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Member {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String nickname;

    @Builder
    public Member(Long id,String nickname) {
        this.id = id;
        this.nickname = nickname;
    }
}
