package com.minsait.emprestimo.service;

import com.minsait.emprestimo.controller.ClienteController;
import com.minsait.emprestimo.entity.Cliente;
import com.minsait.emprestimo.exception.ClienteNaoEncontradoException;

public class EncontrarCliente {

	private ClienteController clienteController;
	
	public Cliente encontrarCliente(Long cpfCliente) throws ClienteNaoEncontradoException {
		Cliente clienteEncontrado = clienteController.retornarCliente(cpfCliente);
		return clienteEncontrado;
	}
}
