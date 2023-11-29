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

    private String top;

    @Convert(converter = StringListConverter.class)
    private List<String> interest;

    @Convert(converter = StringListConverter.class)
    private List<String> interest_percent;

    @Convert(converter = StringListConverter.class)
    private List<String> focus;

    @Convert(converter = StringListConverter.class)
    private List<String> focus_percent;

    @Builder

    public Result(Hobby hobby, String top, List<String> interest, List<String> interest_percent, List<String> focus, List<String> focus_percent) {
        this.hobby = hobby;
        this.top = top;
        this.interest = interest;
        this.interest_percent = interest_percent;
        this.focus = focus;
        this.focus_percent = focus_percent;
    }
}
