package com.minsait.emprestimo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClienteJaCadastradoException extends Exception {
	private static final long serialVersionUID = 5L;
	
	public ClienteJaCadastradoException(Long cpf) {
		super(String.format("O CPF %l já foi cadastrado para outro cliente.", cpf));
	}
}
