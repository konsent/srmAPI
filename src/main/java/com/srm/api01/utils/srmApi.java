package com.srm.api01.utils;

import lombok.SneakyThrows;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

public class srmApi {
    @SneakyThrows
    public String search() {
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        String body = "";

        HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
        URI uri = new URI("http://openapi.kepco.co.kr/service/bidInfoService/getBidSearchList?serviceKey=BLWS9PdbSrtSL0vf%2BjBIADd695SRxWjNhtTja27KMP6oBdZRsnODs%2BeNaJSFJmvn1h7eGvbm8Vp64ftV552yMw%3D%3D&numOfRows=10&pageNo=1&ntDate=20150101&ntCloseDate=20211201&comId=COM01");
        ResponseEntity<String> responseEntity = rest.exchange(uri, HttpMethod.GET, requestEntity, String.class); //
        HttpStatus httpStatus = responseEntity.getStatusCode();
        int status = httpStatus.value();
        String response = responseEntity.getBody();
        System.out.println("Response status: " + status);
        System.out.println(response);
        return response;
    };

    public static void main(String[] args) {
        srmApi srmApi = new srmApi();
        srmApi.search();
    }
}