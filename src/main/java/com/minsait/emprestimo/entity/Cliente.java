package com.minsait.emprestimo.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
    @Size(min = 11, max = 11, message = "O CPF deve ter 11 dígitos.")
	private Long cpf;
	
	@NotBlank(message = "O telefone é obrigatório.")
    private String telefone;

	@Valid
    @Embedded
    private ClienteEndereco endereco;

    @NotNull(message = "O rendimento mensal é obrigatório.")
    @Min(value = 0, message = "O rendimento mensal deve ser positivo.")
    private Double rendimentoMensal;
	
}


