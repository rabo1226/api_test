package com.green.api_test.dto;

import lombok.Data;
//['설비용량(MW)', '기온', '습도', '풍속', 'encoded_시도명']
@Data
public class WeatherRequestDTO {
  private Double mw;
  private Double temperature;
  private Double humidity;
  private Double wind;
  private String region;
}
