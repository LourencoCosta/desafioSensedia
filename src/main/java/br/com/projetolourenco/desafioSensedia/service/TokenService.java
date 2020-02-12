package br.com.projetolourenco.desafioSensedia.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TokenService {
	
	@Autowired
	private RestTemplate restTemplate;

	public String getToken(String code) {
		String url = "https://api-suporte.sensedia.com/oauth/access-token";

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		httpHeaders.set("Authorization", "Basic ZmRmYTk5MzMtNDU1Mi0zNmVhLTkxMDUtZDFmZjUwNWYwM2FhOmU5YzU0M2FhLTE5NTEtMzU1NS1iMzJmLTUyYjhkM2QxMzk4Nw==");
		JSONObject json = new JSONObject();
		try {
			json.put("grant_type", "authorization_code");
			json.put("code", code);
		} catch (Exception e) {
			e.printStackTrace();
		}
		HttpEntity<String> httpEntity = new HttpEntity<String>(json.toString(), httpHeaders);
		return restTemplate.postForObject(url, httpEntity, String.class);
	}
	
}
