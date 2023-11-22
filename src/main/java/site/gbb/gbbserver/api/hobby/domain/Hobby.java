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
    private List<String> like;

    @Convert(converter = StringListConverter.class)
    private List<String> hate;

    @Builder
    public Hobby(Member member, List<String> like, List<String> hate) {
        this.member = member;
        this.like = like;
        this.hate = hate;
    }

}
