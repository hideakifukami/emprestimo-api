package com.minsait.emprestimo.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
	
	@NotEmpty(message = "O nome é obrigatório.") 
	private String nome;
	
	@Id
	@NotEmpty(message = "O CPF é obrigatório.")
	private String cpf;
	
	@NotEmpty(message = "O telefone é obrigatório.")
    private String telefone;

	@Valid
    @Embedded
    private ClienteEndereco endereco;

    @NotNull(message = "O rendimento mensal é obrigatório.")
    @Min(value = 0, message = "O rendimento mensal deve ser positivo.")
    private BigDecimal rendimentoMensal;
    
    
    @OneToMany(mappedBy = "cliente", targetEntity = Emprestimo.class, orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();


	public String getNome() {
		return nome;
	}


	public String getCpf() {
		return cpf;
	}


	public String getTelefone() {
		return telefone;
	}


	public ClienteEndereco getEndereco() {
		return endereco;
	}


	public BigDecimal getRendimentoMensal() {
		return rendimentoMensal;
	}

	@JsonManagedReference
	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}
	
}


