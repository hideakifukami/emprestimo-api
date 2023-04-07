package com.minsait.emprestimo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmprestimoNaoEncontradoException extends Exception {
	private static final long serialVersionUID = 2L;
	
	public EmprestimoNaoEncontradoException(Long id) {
		super(String.format("O emprestimo de ID %l não foi encontrado", id));
	}
}
