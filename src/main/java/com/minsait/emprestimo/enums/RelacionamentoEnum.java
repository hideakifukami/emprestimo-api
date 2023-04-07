package com.minsait.emprestimo.enums;

public enum RelacionamentoEnum {
	
	BRONZE {
		@Override
		public double calcularValorFinal(double valorInicial) {
			return valorInicial * 1.8;
		}
	},
	
	PRATA {
		@Override
		public double calcularValorFinal(double valorInicial) {
			if (valorInicial > 5000) {
				return valorInicial * 1.4;
			} else {
				return valorInicial * 1.6;
			}			
		}
	},
	
//	Necessário implementar relacionamento ouro. 
	OURO {
		@Override
		public double calcularValorFinal(double valorInicial) {
			return valorInicial;
		}
	};

	public abstract double calcularValorFinal(double valorInicial);
}
