package com.minsait.emprestimo.service;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Service;
import com.minsait.emprestimo.entity.Cliente;
import com.minsait.emprestimo.entity.Emprestimo;
import com.minsait.emprestimo.enums.RelacionamentoEnum;
import com.minsait.emprestimo.exception.ClienteNaoEncontradoException;
import com.minsait.emprestimo.exception.EmprestimoNaoEncontradoException;
import com.minsait.emprestimo.exception.ValorEmprestimosLimiteException;
import com.minsait.emprestimo.repository.EmprestimoRepository;
import com.minsait.emprestimo.repository.ClienteRepository;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class EmprestimoService {
	
	private EmprestimoRepository emprestimoRepository;
	private ClienteRepository clienteRepository;

	public Emprestimo cadastrarEmprestimo(Long cpfCliente, Emprestimo emprestimo) throws ClienteNaoEncontradoException, ValorEmprestimosLimiteException {
		Cliente cliente = clienteRepository.findById(cpfCliente).get();
		
		if (cliente == null) {
			throw new ClienteNaoEncontradoException(cpfCliente);
		}
		
		BigDecimal clienteRenda = cliente.getRendimentoMensal();
		BigDecimal valorLimiteEmprestimo = clienteRenda.multiply(new BigDecimal(10));
		
		List<Emprestimo> clienteEmprestimo = cliente.getEmprestimos();
		BigDecimal emprestimoSoma = clienteEmprestimo.stream().map(x -> x.getValorInicial()).reduce(emprestimo.getValorInicial(), BigDecimal::add);
		
		int comparacao = emprestimoSoma.compareTo(valorLimiteEmprestimo);
		
		if (comparacao == 1) {
			throw new ValorEmprestimosLimiteException();
		}
		
		int emprestimoQtd = cliente.getEmprestimos().size();
		
		RelacionamentoEnum relacionamento = emprestimo.getRelacionamento();
		BigDecimal valorInicial = emprestimo.getValorInicial();
		emprestimo.setValorFinal(relacionamento.calcularValorFinal(valorInicial, emprestimoQtd));
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
