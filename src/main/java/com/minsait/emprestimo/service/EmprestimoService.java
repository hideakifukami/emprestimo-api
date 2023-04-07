package com.minsait.emprestimo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.minsait.emprestimo.entity.Cliente;
import com.minsait.emprestimo.entity.Emprestimo;
import com.minsait.emprestimo.enums.RelacionamentoEnum;
import com.minsait.emprestimo.exception.EmprestimoNaoEncontradoException;
import com.minsait.emprestimo.repository.ClienteRepository;
import com.minsait.emprestimo.repository.EmprestimoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmprestimoService {
	
	private EmprestimoRepository emprestimoRepository;
	private ClienteRepository clienteRepository;

	
	public Emprestimo cadastrarEmprestimo(Long cpf, Emprestimo emprestimo) {
		Cliente cpfClienteEncontrado = clienteRepository.findById(cpf).get();
		emprestimo.setCpfCliente(cpfClienteEncontrado);
		RelacionamentoEnum relacionamento = emprestimo.getRelacionamento();
		double valorInicial = emprestimo.getValorInicial();
		emprestimo.setValorFinal(relacionamento.calcularValorFinal(valorInicial));
		return this.emprestimoRepository.save(emprestimo);
	}

	public MensagemDeSucesso deletarEmprestimo(Long id) throws EmprestimoNaoEncontradoException {
		if (this.emprestimoRepository.existsById(id)) {
			Emprestimo emprestimoEncontrado = this.emprestimoRepository.findById(id).get();
			this.emprestimoRepository.delete(emprestimoEncontrado);
			MensagemDeSucesso mensagem = new MensagemDeSucesso();
			mensagem.setMensagem("Registro de empréstimo deletado com sucesso!");
			return mensagem;
		}
		
		throw new EmprestimoNaoEncontradoException(id);
	}
	
	public Emprestimo retornarEmprestimo(Long id) throws EmprestimoNaoEncontradoException {
		if (this.emprestimoRepository.existsById(id)) {
			return this.emprestimoRepository.findById(id).get();
		}
		
		throw new EmprestimoNaoEncontradoException(id);
	}
	
	public List<Emprestimo> retornarTodosOsEmprestimos() {
		return emprestimoRepository.findAll();
	}
	
	
}
