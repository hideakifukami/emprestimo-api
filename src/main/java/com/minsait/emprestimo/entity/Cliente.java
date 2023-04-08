package com.minsait.emprestimo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
	
	@NotBlank(message = "O nome é obrigatório.") 
	private String nome;
	
	@Id
	@NotNull(message = "O CPF é obrigatório.")
	private Long cpf;
	
	@NotBlank(message = "O telefone é obrigatório.")
    private String telefone;

	@Valid
    @Embedded
    private ClienteEndereco endereco;

    @NotNull(message = "O rendimento mensal é obrigatório.")
    @Min(value = 0, message = "O rendimento mensal deve ser positivo.")
    private Double rendimentoMensal;
    
    @OneToMany(mappedBy = "cliente", targetEntity = Emprestimo.class, orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
	
}


