package br.com.projetolourenco.desafioSensedia.service;

import org.apache.tomcat.util.codec.binary.Base64;
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

	private static final String SECRET = "e9c543aa-1951-3555-b32f-52b8d3d13987";
	
	public String getToken(String clientId, String code) {
		String url = "https://api-suporte.sensedia.com/oauth/access-token";
		String composeClienteIdSecret = toBase64(clientId, SECRET);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		httpHeaders.set("Authorization", "Basic ".concat(composeClienteIdSecret));
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
	
	public static void main(String[] args) {

		// Gerando Base64
		String encoded = Base64.encodeBase64String("Gerando texto em Base64".getBytes());
		System.out.println("Base64 : "+ encoded);

		// Gerando o texto a partir da Base64
		byte[] decodedBytes = Base64.decodeBase64("ZmRmYTk5MzMtNDU1Mi0zNmVhLTkxMDUtZDFmZjUwNWYwM2FhOmU5YzU0M2FhLTE5NTEtMzU1NS1iMzJmLTUyYjhkM2QxMzk4Nw");
		System.out.println("Texto: " + new String(decodedBytes));
	}
	
	public String toBase64(String clientId, String secret) {
		return Base64.encodeBase64String(clientId.concat(":").concat(secret) .getBytes());
	}
	
}
