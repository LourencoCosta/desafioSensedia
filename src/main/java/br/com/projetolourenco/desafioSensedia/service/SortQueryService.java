package br.com.projetolourenco.desafioSensedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.projetolourenco.desafioSensedia.model.Salarys;

@Service
public class SortQueryService {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	AuthorizationService authorizationService;

	@Autowired
	TokenService tokenService;

	
	public Salarys getSalarys(String clientId, String accessToken) {
		
		String url = "https://api-suporte.sensedia.com/onboarding/analytical/listar/salarios";
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		httpHeaders.set("client_id", clientId);
		httpHeaders.set("access_token", accessToken);
		HttpEntity<String> httpEntity = new HttpEntity<String>(httpHeaders);
		return restTemplate.exchange(url, HttpMethod.POST, httpEntity, Salarys.class).getBody();
	}

}
