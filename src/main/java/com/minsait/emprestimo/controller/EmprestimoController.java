package com.minsait.emprestimo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.minsait.emprestimo.entity.Emprestimo;
import com.minsait.emprestimo.exception.EmprestimoNaoEncontradoException;
import com.minsait.emprestimo.service.EmprestimoService;
import com.minsait.emprestimo.service.MensagemDeSucesso;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/clientes/{cpfCliente}/emprestimos")
@AllArgsConstructor
public class EmprestimoController {
 
	private EmprestimoService emprestimoService;
		
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	// Necessário construir condicionamento da soma dos emprestimos em aberto.
	public Emprestimo cadastrarEmprestimo(@PathVariable Long cpfCliente, @Valid @RequestBody Emprestimo emprestimo) {	
		Emprestimo novoEmprestimo = this.emprestimoService.cadastrarEmprestimo(cpfCliente, emprestimo);
		return novoEmprestimo;
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public MensagemDeSucesso deletarEmprestimo(@PathVariable Long id) throws EmprestimoNaoEncontradoException {
		return this.emprestimoService.deletarEmprestimo(id);
	}
	
	@GetMapping("/{id}")
	public Emprestimo retornarEmprestimo(@PathVariable Long id) throws EmprestimoNaoEncontradoException {
		Emprestimo emprestimoEncontrado = this.emprestimoService.retornarEmprestimo(id);
		return emprestimoEncontrado;
	}
	
	@GetMapping
	public List<Emprestimo> retornarTodosOsEmprestimos() {
		List<Emprestimo> todosOsEmprestimos = this.emprestimoService.retornarTodosOsEmprestimos();
		return todosOsEmprestimos;
	}
}
