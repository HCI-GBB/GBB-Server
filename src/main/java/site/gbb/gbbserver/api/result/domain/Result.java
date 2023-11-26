package site.gbb.gbbserver.api.result.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import site.gbb.gbbserver.api.hobby.domain.Hobby;
import site.gbb.gbbserver.common.util.StringListConverter;

import java.util.List;
import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;
@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Result {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "hobby_id")
    private Hobby hobby;

    @Convert(converter = StringListConverter.class)
    private List<String> active;
    @Convert(converter = StringListConverter.class)
    private List<String> percent;

    @Builder
    public Result(Hobby hobby, List<String> active, List<String> percent) {
        this.hobby = hobby;
        this.active = active;
        this.percent = percent;
    }
}