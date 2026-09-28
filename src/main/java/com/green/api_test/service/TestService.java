package com.green.api_test.service;

import com.green.api_test.dto.WeatherRequestDTO;
import com.green.api_test.dto.PredictDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
public class TestService {
  private final RestClient restClient;

  //응답이 오면 발전량 예측을 python에 요청을 보내는 메서드
  public PredictDTO predict(WeatherRequestDTO weatherRequestDTO){
    return restClient.post()
            //요청정보
            .uri("/test-1")
            .contentType(MediaType.APPLICATION_JSON)
            .body(weatherRequestDTO)  //axios.post('body')  <- body 내용을 json으로 번역해서 전달한다!
            //응답정보
            .retrieve()
            .body(PredictDTO.class); //python의 리턴값을 predictDTO.class로 받아오겠다. axios.post().then(respose.data('body'))
  }

}
