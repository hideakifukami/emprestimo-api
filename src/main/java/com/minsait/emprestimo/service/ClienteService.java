package com.minsait.emprestimo.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.minsait.emprestimo.dto.ClienteDTO;
import com.minsait.emprestimo.entity.Cliente;
import com.minsait.emprestimo.exception.ClienteJaCadastradoException;
import com.minsait.emprestimo.exception.ClienteNaoEncontradoException;
import com.minsait.emprestimo.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClienteService {
	
	private ClienteRepository clienteRepository;

    public Cliente cadastrarCliente(Cliente cliente) throws ClienteJaCadastradoException {
    	if (this.clienteRepository.findByCpf(cliente.getCpf()) != null) {
    		throw new ClienteJaCadastradoException(cliente.getCpf());
    	} else {
        
    		return this.clienteRepository.save(cliente);
    	}
    }
        		
	public List<Cliente> retornarTodosOsClientes() {
		return clienteRepository.findAll();
	}
	
	public Cliente retornarCliente(String cpf) throws ClienteNaoEncontradoException {
    	if (this.clienteRepository.findByCpf(cpf) != null) {
			return  this.clienteRepository.findByCpf(cpf);
		}
		
		throw new ClienteNaoEncontradoException(cpf);
	}
	
	public MensagemDeSucesso deletarCliente(String cpf) throws ClienteNaoEncontradoException {
    	if (this.clienteRepository.findByCpf(cpf) != null) {
			Cliente clienteEncontrado = this.clienteRepository.findByCpf(cpf);
			this.clienteRepository.delete(clienteEncontrado);
			MensagemDeSucesso mensagem = new MensagemDeSucesso();
			mensagem.setMensagem("Registro de cliente deletado com sucesso!");
			return mensagem;
		}
		
		throw new ClienteNaoEncontradoException(cpf);
	}
	
	public Cliente alterarCliente(String cpf, @Valid ClienteDTO cliente) throws ClienteNaoEncontradoException {
    	if (this.clienteRepository.findByCpf(cpf) != null) {
			Cliente clienteEncontrado = this.clienteRepository.findByCpf(cpf);
			
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
			
			Cliente clienteAlterado = ClienteDTO.retornaCliente(cliente);
			
			return this.clienteRepository.save(clienteAlterado);
		}
		throw new ClienteNaoEncontradoException(cpf);

	}
	
	
	
}
