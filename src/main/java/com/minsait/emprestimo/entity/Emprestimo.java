package com.minsait.emprestimo.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.minsait.emprestimo.enums.RelacionamentoEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
public class Emprestimo {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
    @NotNull(message = "O cliente deve estar cadastrado no sistema.")
    @ManyToOne
    @JoinColumn(name = "cpfCliente", insertable = false, updatable = false)
    @Setter
    private Cliente cpfCliente;
    
    @Setter
	@NotNull(message = "O valor inicial é obrigatório.")
    private double valorInicial;
	
    @Setter
    private double valorFinal;
    
    @Setter
	@NotNull(message = "O relacionamento é obrigatório.")
    private RelacionamentoEnum relacionamento;
    
    @Setter
    @NotNull
    private LocalDate dataInicial;
    
    @Setter
    @NotNull
    private LocalDate dataFinal;

	public Emprestimo(@NotNull(message = "O valor inicial é obrigatório.") double valorInicial,
			@NotNull(message = "O relacionamento é obrigatório.") RelacionamentoEnum relacionamento,
			@NotNull LocalDate dataInicial, @NotNull LocalDate dataFinal) {
		super();
		this.valorInicial = valorInicial;
		this.relacionamento = relacionamento;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
	}

	
}
