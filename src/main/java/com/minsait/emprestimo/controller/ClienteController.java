package com.minsait.emprestimo.controller;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.minsait.emprestimo.dto.ClienteDTO;
import com.minsait.emprestimo.entity.Cliente;
import com.minsait.emprestimo.exception.ClienteNaoEncontradoException;
import com.minsait.emprestimo.service.ClienteService;
import com.minsait.emprestimo.service.MensagemDeSucesso;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/clientes")
@AllArgsConstructor
public class ClienteController {
	
	private ClienteService clienteService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente cadastrarCliente(@Valid @RequestBody Cliente cliente) {
		Cliente novoCliente = this.clienteService.cadastrarCliente(cliente);
		return novoCliente;
	}
	
	@GetMapping
	public List<Cliente> retornarTodosOsClientes() {
		List<Cliente> todosOsClientes = this.clienteService.retornarTodosOsClientes();
		return todosOsClientes;
	}
	
	@GetMapping("/{cpf}")
	public Cliente retornarCliente(@PathVariable Long cpf) throws ClienteNaoEncontradoException {
		Cliente clienteEncontrado = this.clienteService.retornarCliente(cpf);
		return clienteEncontrado;
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{cpf}")
	public MensagemDeSucesso deletarCliente(@PathVariable Long cpf) throws ClienteNaoEncontradoException {
		return this.clienteService.deletarCliente(cpf);
	}
	
	@PutMapping("/{cpf}")
	public ClienteDTO alterarCliente(@PathVariable Long cpf, @Valid @RequestBody ClienteDTO cliente) throws ClienteNaoEncontradoException {
		Cliente clienteRequest = ClienteDTO.retornaCliente(cliente);
		Cliente clienteAlterado = this.clienteService.alterarCliente(cpf, clienteRequest);
		
		return ClienteDTO.retornaCliente(clienteAlterado);
	}
}
