package com.winter.app.rest;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class RestFulController {

	
	@RequestMapping("/rest/t1")
	public void f1() throws Exception {
		
		// Server에서 다른 서버로 요청을 보내려 함 
		
		
		//URL,, Method, parameter, Header 
		RestTemplate restTemplate = new RestTemplate();
		
		
		//1. Header 생성
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json;charset=utf-8");
//		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		
		
		//2. parameter 생성 
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("grant_type", "authorization_code");
		params.add("client_id", "authorization_code");
		
		//3. 요청 객체 생성 
		HttpEntity<MultiValueMap<String, String>> req = new HttpEntity<MultiValueMap<String,String>>(params,headers);
		
		
		//4.요청 전송 결과 처리 
		ResponseEntity<JsonDTO> res = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/posts/1", JsonDTO.class ,req);
		
		JsonDTO result = res.getBody();
		System.out.println(result.getTitle());
		
		
		
		
	}
	
}
