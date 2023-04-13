package com.minsait.emprestimo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClienteSemEmprestimosException extends Exception {
	private static final long serialVersionUID = 4L;
	
	public ClienteSemEmprestimosException() {
		super(String.format("O cliente não realizou nenhum empréstimo em seu nome."));
	}
}
