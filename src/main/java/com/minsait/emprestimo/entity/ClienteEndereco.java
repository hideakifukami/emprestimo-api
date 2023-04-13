package com.minsait.emprestimo.entity;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteEndereco {
    @NotEmpty(message = "A rua é obrigatória")
    private String rua;

    @NotNull(message = "O número é obrigatório")
    private int numero;
    
    @NotEmpty(message = "O CEP é obrigatório")
    @Size(min = 8, max = 8, message = "O CEP deve ter 8 dígitos")
    private String cep;
}
