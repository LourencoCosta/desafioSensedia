package br.com.projetolourenco.desafioSensedia.model.dto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import br.com.projetolourenco.desafioSensedia.model.Salarys;

public class SalarysDto {

	private Salarys salarys;

	public SalarysDto(Salarys salarys) {
		this.salarys = salarys;
	}

	private List<Double> salarysDto;

	public List<Double> getSalarios() {
		try {
			this.salarysDto = salarys.getSalarios().stream().map(salaryLong -> Double.parseDouble(salaryLong))
					.collect(Collectors.toList());
			Collections.sort(salarysDto);
			Collections.reverse(salarysDto);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return salarysDto;
	}

}
