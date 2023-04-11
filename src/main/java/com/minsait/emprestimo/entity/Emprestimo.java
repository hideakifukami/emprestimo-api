package com.minsait.emprestimo.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.minsait.emprestimo.enums.RelacionamentoEnum;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@NoArgsConstructor
public class Emprestimo {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
    @ManyToOne
    @JoinColumn(name = "cliente_cpf")
    private Cliente cliente;
        
	@NotNull(message = "O valor inicial é obrigatório.")
    private BigDecimal valorInicial;
	
    private BigDecimal valorFinal;
    
	@NotNull(message = "O relacionamento é obrigatório.")
    private RelacionamentoEnum relacionamento;
    
    @NotNull
    private LocalDate dataInicial;
    
    @NotNull
    private LocalDate dataFinal;

	public Emprestimo(BigDecimal valorInicial, RelacionamentoEnum relacionamento, LocalDate dataInicial, LocalDate dataFinal) {
		super();
		this.valorInicial = valorInicial;
		this.relacionamento = relacionamento;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
	}

	public Long getId() {
		return id;
	}

	@JsonBackReference
	public Cliente getCliente() {
		return cliente;
	}

	public BigDecimal getValorInicial() {
		return valorInicial;
	}

	public BigDecimal getValorFinal() {
		return valorFinal;
	}

	public RelacionamentoEnum getRelacionamento() {
		return relacionamento;
	}

	public LocalDate getDataInicial() {
		return dataInicial;
	}

	public LocalDate getDataFinal() {
		return dataFinal;
	}
	
}
