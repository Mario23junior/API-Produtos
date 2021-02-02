package com.project.produto.ControllerAdivce;

import java.util.Arrays;
import java.util.List;

public class MessageErros {

	private List<String> erros;

	public MessageErros(String message) {
		this.erros = Arrays.asList(message);
	}

	public MessageErros(List<String> erros) {
		this.erros = erros;
	}

	public List<String> getErros() {
		return erros;
	}

	public void setErros(List<String> erros) {
		this.erros = erros;
	}
}
