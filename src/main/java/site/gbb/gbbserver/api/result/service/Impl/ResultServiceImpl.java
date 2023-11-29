package site.gbb.gbbserver.api.result.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import site.gbb.gbbserver.api.hobby.domain.Hobby;
import site.gbb.gbbserver.api.hobby.repository.HobbyRepository;
import site.gbb.gbbserver.api.member.domain.Member;
import site.gbb.gbbserver.api.member.repository.MemberRepository;
import site.gbb.gbbserver.api.result.dto.response.CsvResultGetResponseDto;
import site.gbb.gbbserver.api.result.dto.response.ResultGetResponseDto;
import site.gbb.gbbserver.api.result.service.ResultService;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ResultServiceImpl implements ResultService {
    @Value("${flask.url}") private String FLASK_URL;
    private final MemberRepository memberRepository;
    private final HobbyRepository hobbyRepository;

    @Override
    @Transactional
    public ResultGetResponseDto getResult(Long memberId, Long hobbyId) {

        Member member = memberRepository.findByIdOrThrow(memberId);
        Hobby hobby = hobbyRepository.findByMemberId(member.getId());

        CsvResultGetResponseDto csvResultGetResponseDto = sendRequestToFlask();

        return ResultGetResponseDto.of(hobby.getMember().getNickname(), csvResultGetResponseDto.getData().getTop(), csvResultGetResponseDto.getData().getInterest(), csvResultGetResponseDto.getData().getInterest_percent(), csvResultGetResponseDto.getData().getFocus(), csvResultGetResponseDto.getData().getFocus_percent());

    }
    public CsvResultGetResponseDto sendRequestToFlask() {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-type", "application/json; charset=UTF-8");

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<CsvResultGetResponseDto> responseEntity = restTemplate.getForEntity(
                    FLASK_URL,
                    CsvResultGetResponseDto.class
            );

            return responseEntity.getBody();
        } catch (HttpClientErrorException e) {
            throw new RuntimeException(e);
        }
    }
}
