package com.green.api_test;


import com.green.api_test.dto.PredictDTO;
import com.green.api_test.dto.WeatherRequestDTO;
import com.green.api_test.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {
  private final TestService testService;

  // html(클라이언트) -> spring controller -> FastAPI : 데이터 예측(python) -> spring controller -> html(클라이언트)
  //예측 데이터 주세요
  @GetMapping("/test-1")
  public String test1(){
    WeatherRequestDTO weatherRequestDTO = new WeatherRequestDTO();
    weatherRequestDTO.setMw(295.334);
    weatherRequestDTO.setTemperature(-3.0);
    weatherRequestDTO.setHumidity(24.0);
    weatherRequestDTO.setWind(4.3);
    weatherRequestDTO.setRegion("경남");

    PredictDTO dto = testService.predict(weatherRequestDTO);
    Double result = dto.getPredictData();
    System.out.println("!!!!!!!!!!!!");
    System.out.println("예측데이터 : " + result);
    return "hello";
  }




}
