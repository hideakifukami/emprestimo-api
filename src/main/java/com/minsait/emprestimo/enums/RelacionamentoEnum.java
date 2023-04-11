package com.minsait.emprestimo.enums;

import java.math.BigDecimal;

public enum RelacionamentoEnum {
	
	BRONZE {
		@Override
		public BigDecimal calcularValorFinal(BigDecimal valorInicial, int emprestimoQtd) {
			return valorInicial.multiply(new BigDecimal("1.8"));
		}
	},
	
	PRATA {
		@Override
		public BigDecimal calcularValorFinal(BigDecimal valorInicial, int emprestimoQtd) {
			int comparacao = valorInicial.compareTo(new BigDecimal("5000"));
			if (comparacao == 1) {
				return valorInicial.multiply(new BigDecimal("1.4"));
			} else {
				return valorInicial.multiply(new BigDecimal("1.6"));
			}			
		}
	},
	
	OURO {
		@Override
		public BigDecimal calcularValorFinal(BigDecimal valorInicial, int emprestimoQtd) {
			if (emprestimoQtd > 1) {
				return valorInicial.multiply(new BigDecimal("1.3"));
			} else {
				return valorInicial.multiply(new BigDecimal("1.2"));
			}
		}
	};

	public abstract BigDecimal calcularValorFinal(BigDecimal valorInicial, int emprestimoQtd);
}
