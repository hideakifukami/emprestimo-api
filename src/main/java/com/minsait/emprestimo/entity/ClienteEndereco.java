package com.minsait.emprestimo.entity;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
    @Pattern(regexp = "\\d{8}", message = "O CEP deve conter 8 dígitos.")
    private String cep;
}
