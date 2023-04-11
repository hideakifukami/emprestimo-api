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
@Setter
@NoArgsConstructor
public class Emprestimo {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
    @ManyToOne
    @JoinColumn(name = "cliente")
    private Cliente cliente;
        
    @Setter
	@NotNull(message = "O valor inicial é obrigatório.")
    private double valorInicial;
	
    private double valorFinal;
    
	@NotNull(message = "O relacionamento é obrigatório.")
    private RelacionamentoEnum relacionamento;
    
    @NotNull
    private LocalDate dataInicial;
    
    @NotNull
    private LocalDate dataFinal;

	public Emprestimo(double valorInicial, RelacionamentoEnum relacionamento, LocalDate dataInicial, LocalDate dataFinal) {
		super();
		this.valorInicial = valorInicial;
		this.relacionamento = relacionamento;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
	}



	
}
