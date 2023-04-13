package com.minsait.emprestimo.service;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Service;
import com.minsait.emprestimo.entity.Cliente;
import com.minsait.emprestimo.entity.Emprestimo;
import com.minsait.emprestimo.enums.RelacionamentoEnum;
import com.minsait.emprestimo.exception.ClienteNaoEncontradoException;
import com.minsait.emprestimo.exception.ClienteSemEmprestimosException;
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

	public Emprestimo cadastrarEmprestimo(Long cpf, Emprestimo emprestimo) throws ClienteNaoEncontradoException, ValorEmprestimosLimiteException {
		if (this.clienteRepository.existsById(cpf)) {
			Cliente cliente = clienteRepository.findById(cpf).get();
			BigDecimal clienteRenda = cliente.getRendimentoMensal();
			BigDecimal valorLimiteEmprestimo = clienteRenda.multiply(new BigDecimal(10));
			
			List<Emprestimo> clienteEmprestimo = cliente.getEmprestimos();
			BigDecimal emprestimoSoma = clienteEmprestimo.stream().map(x -> x.getValorInicial()).reduce(emprestimo.getValorInicial(), BigDecimal::add);
			
			int comparacao = emprestimoSoma.compareTo(valorLimiteEmprestimo);
			
			if (comparacao == 1) {
				throw new ValorEmprestimosLimiteException();
			}
			
			int emprestimoQtd = cliente.getEmprestimos().size();
			
			emprestimo.setCliente(cliente);
			RelacionamentoEnum relacionamento = emprestimo.getRelacionamento();
			BigDecimal valorInicial = emprestimo.getValorInicial();
			emprestimo.setValorFinal(relacionamento.calcularValorFinal(valorInicial, emprestimoQtd));
			cliente.getEmprestimos().add(emprestimo);
			return this.emprestimoRepository.save(emprestimo);

		}
		throw new ClienteNaoEncontradoException(cpf);
				
	}

	public MensagemDeSucesso deletarEmprestimo(Long cpf, Long id) throws EmprestimoNaoEncontradoException, ClienteNaoEncontradoException {
		if (this.clienteRepository.existsById(cpf)) {
			Long cpfEmprestimo = this.emprestimoRepository.findById(id).get().getCliente().getCpf();
			Long cpfCliente = this.clienteRepository.findById(cpf).get().getCpf();
			if ( cpfEmprestimo == cpfCliente) {
				Emprestimo emprestimoEncontrado = this.emprestimoRepository.findById(id).get();
				this.emprestimoRepository.delete(emprestimoEncontrado);
				MensagemDeSucesso mensagem = new MensagemDeSucesso();
				mensagem.setMensagem("Registro de empréstimo deletado com sucesso!");
				return mensagem;
			}
			
			throw new EmprestimoNaoEncontradoException(id);
		}
		
		throw new ClienteNaoEncontradoException(cpf);
		
	}
	
	public Emprestimo retornarEmprestimo(Long cpf, Long id) throws EmprestimoNaoEncontradoException, ClienteNaoEncontradoException, ClienteSemEmprestimosException {
		if (this.clienteRepository.existsById(cpf)) {
			Cliente clienteEncontrado = this.clienteRepository.findById(cpf).get();
			if (clienteEncontrado.getEmprestimos().size() != 0) {
				if (this.emprestimoRepository.existsById(id)) {
					return this.emprestimoRepository.findById(id).get();
				}
				
				throw new EmprestimoNaoEncontradoException(id);
				}
			throw new ClienteSemEmprestimosException();
			}
		throw new ClienteNaoEncontradoException(cpf);
	}

		
	
	public List<Emprestimo> retornarTodosOsEmprestimos(Long cpf) throws ClienteNaoEncontradoException, ClienteSemEmprestimosException {
		if (this.clienteRepository.existsById(cpf)) {
			Cliente clienteEncontrado = this.clienteRepository.findById(cpf).get();
			if (clienteEncontrado.getEmprestimos().size() != 0) {
				return clienteEncontrado.getEmprestimos();
			}
			
			throw new ClienteSemEmprestimosException();
		
		}
		
		throw new ClienteNaoEncontradoException(cpf);
	}}
	
