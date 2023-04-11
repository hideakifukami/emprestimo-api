package com.minsait.emprestimo.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.minsait.emprestimo.entity.Cliente;
import com.minsait.emprestimo.exception.ClienteNaoEncontradoException;
import com.minsait.emprestimo.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClienteService {
	
	private ClienteRepository clienteRepository;

    public Cliente cadastrarCliente(Cliente cliente) {
        return this.clienteRepository.save(cliente);
    }
        		
	public List<Cliente> retornarTodosOsClientes() {
		return clienteRepository.findAll();
	}
	
	public Cliente retornarCliente(Long cpf) throws ClienteNaoEncontradoException {
		if (this.clienteRepository.existsById(cpf)) {
			return  this.clienteRepository.findById(cpf).get();
		}
		
		throw new ClienteNaoEncontradoException(cpf);
	}
	
	public MensagemDeSucesso deletarCliente(Long cpf) throws ClienteNaoEncontradoException {
		if (this.clienteRepository.existsById(cpf)) {
			Cliente clienteEncontrado = this.clienteRepository.findById(cpf).get();
			this.clienteRepository.delete(clienteEncontrado);
			MensagemDeSucesso mensagem = new MensagemDeSucesso();
			mensagem.setMensagem("Registro de cliente deletado com sucesso!");
			return mensagem;
		}
		
		throw new ClienteNaoEncontradoException(cpf);
	}
	
	public Cliente alterarCliente(Long cpf, @Valid Cliente cliente) throws ClienteNaoEncontradoException {
		if (this.clienteRepository.existsById(cpf)) {
			Cliente clienteEncontrado = this.clienteRepository.findById(cpf).get();
			
			if (cliente.getNome() == null) {
				cliente.setNome(clienteEncontrado.getNome());
			}
			
			if (cliente.getCpf() == null) {
				cliente.setCpf(clienteEncontrado.getCpf());
			}
			
			if (cliente.getTelefone() == null) {
				cliente.setTelefone(clienteEncontrado.getTelefone());
			}
			
			if (cliente.getEndereco() == null) {
				cliente.setEndereco(clienteEncontrado.getEndereco());
			}

			if (cliente.getRendimentoMensal() == null) {
				cliente.setRendimentoMensal(clienteEncontrado.getRendimentoMensal());
			}
			
			if (cliente.getEmprestimos() == null) {
				cliente.setEmprestimos(clienteEncontrado.getEmprestimos());
			}
			
			return this.clienteRepository.save(cliente);
		}
		throw new ClienteNaoEncontradoException(cpf);

	}
	
	
	
}
