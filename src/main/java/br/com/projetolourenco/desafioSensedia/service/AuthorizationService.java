package br.com.projetolourenco.desafioSensedia.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthorizationService {

	@Autowired
	private RestTemplate restTemplate;
	
	public String getAuthorization(String clientId) {
		String url = "https://api-suporte.sensedia.com/oauth/grant-code";

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		JSONObject json = new JSONObject();
		try {
			json.put("client_id", clientId);
			json.put("redirect_uri", "https://www.url.com");
			json.put("state", "string");
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpEntity<String> httpEntity = new HttpEntity<String>(json.toString(), httpHeaders);
		return restTemplate.postForObject(url, httpEntity, String.class);
	}

}
