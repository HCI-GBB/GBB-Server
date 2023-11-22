package site.gbb.gbbserver.api.hobby.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import site.gbb.gbbserver.api.member.domain.Member;
import site.gbb.gbbserver.common.util.StringListConverter;

import java.util.List;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Hobby {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Convert(converter = StringListConverter.class)
    private List<String> likes;

    @Convert(converter = StringListConverter.class)
    private List<String> hates;

    @Builder
    public Hobby(Member member, List<String> likes, List<String> hates) {
        this.member = member;
        this.likes = likes;
        this.hates = hates;
    }

}
