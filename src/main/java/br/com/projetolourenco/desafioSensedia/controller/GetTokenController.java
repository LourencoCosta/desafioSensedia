package br.com.projetolourenco.desafioSensedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetolourenco.desafioSensedia.service.AuthorizationService;
import br.com.projetolourenco.desafioSensedia.service.TokenService;

@RestController
@RequestMapping("/getToken")
public class GetTokenController {
	
	
	@Autowired
	AuthorizationService authorizationService;

	@Autowired
	TokenService tokenService;

	@PostMapping
	public String token(@RequestBody String clientId) {
		/*
		 * Essa nao eh a melhor forma de lida com os dados 
		 * que chegam em formato JSON da requisicao
		 */
		String client = clientId.split(":")[1].replace("}", "").replace("\"", "").trim();
		return tokenService.getToken(authorizationService.getAuthorization(client).replace("\"}", "").split("code=")[1]);
	}
}
