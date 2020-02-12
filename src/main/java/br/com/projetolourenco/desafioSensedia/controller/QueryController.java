package br.com.projetolourenco.desafioSensedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetolourenco.desafioSensedia.model.Identification;
import br.com.projetolourenco.desafioSensedia.model.dto.SalarysDto;
import br.com.projetolourenco.desafioSensedia.service.SortQueryService;

@RestController
@RequestMapping("/sortSalary")
public class QueryController {

	@Autowired
	private SortQueryService sortQueryService;

	@PostMapping
	public SalarysDto getSalarys(@RequestBody Identification identification) {
		return new SalarysDto(sortQueryService.getSalarys(identification.getClientId(), identification.getAccessToken()));
	}

}
