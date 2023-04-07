package com.minsait.emprestimo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class ValorEmprestimosLimiteException extends Exception {
	
	private static final long serialVersionUID = 3L;
	
	public ValorEmprestimosLimiteException() {
		super(String.format("Empréstimo não autorizado! Favor contactar o gerente."));
	}
}
