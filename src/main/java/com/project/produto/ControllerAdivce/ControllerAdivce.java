package com.project.produto.ControllerAdivce;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdivce {
   
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public MessageErros handleMethodNotValidException(MethodArgumentNotValidException ex) {
		List<String> ResultDefautErros = ex.getBindingResult().getAllErrors()
				             .stream()
				             .map(erro -> erro.getDefaultMessage())
				             .collect(Collectors.toList());
		return new MessageErros(ResultDefautErros);
	}
}
