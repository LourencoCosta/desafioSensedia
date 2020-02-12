package br.com.projetolourenco.desafioSensedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetolourenco.desafioSensedia.model.Identification;
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
	public String token(@RequestBody Identification indentification) {
		return tokenService.getToken(indentification.getClientId(), authorizationService.getAuthorization(indentification.getClientId()).replace("\"}", "").split("code=")[1]);
	}
}
