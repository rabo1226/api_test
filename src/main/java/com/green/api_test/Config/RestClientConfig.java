package com.green.api_test.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

//설정과 관련된 클래스
@Configuration
public class RestClientConfig {
  @Value("${py.base.url}") //yaml의 py:base:url
  private String pyUrl;

  //@Bean은 메서드 위에 작성, 메서드에서 리턴하는 데이터를 개체로 생성하는 기능
  @Bean
  public RestClient restClient(){
    //RestClient 객체 생성 및 리턴하는 메서드
    //RestClient 객체는 스프링에서 다른 서버로 요청을 보낼 수 있는 기능을 제공하는 개체 -> bulid.gradle restclient가 추가되어 있당!
    //파이썬 경로를 저장한 restclient를 리턴
    return RestClient.builder().baseUrl(pyUrl).build();
  }

}
