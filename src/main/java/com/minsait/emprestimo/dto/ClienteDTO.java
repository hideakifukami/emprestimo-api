package com.minsait.emprestimo.dto;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Embedded;
import com.minsait.emprestimo.entity.Cliente;
import com.minsait.emprestimo.entity.ClienteEndereco;
import com.minsait.emprestimo.entity.Emprestimo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

	private String nome;
	private Long cpf;
    private String telefone;
    @Embedded private ClienteEndereco endereco;
    private BigDecimal rendimentoMensal;
    private List<Emprestimo> emprestimos;


    public static ClienteDTO retornaCliente(Cliente cliente) {
		ClienteDTO clienteDTO = new ClienteDTO(cliente.getNome(), cliente.getCpf(), cliente.getTelefone(), cliente.getEndereco(), cliente.getRendimentoMensal(), cliente.getEmprestimos());
		return clienteDTO;
		
	}
	
	public static Cliente retornaCliente(ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente(clienteDTO.getNome(), clienteDTO.getCpf(), clienteDTO.getTelefone(), clienteDTO.getEndereco(), clienteDTO.getRendimentoMensal(), clienteDTO.getEmprestimos());
		return cliente;
		
	}
}
