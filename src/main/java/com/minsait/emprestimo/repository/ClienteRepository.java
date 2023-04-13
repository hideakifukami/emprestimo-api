package com.minsait.emprestimo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.minsait.emprestimo.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, String>{
	

    @Query("SELECT cliente FROM Cliente cliente WHERE cliente.cpf = :cpf")
    Cliente findByCpf(String cpf);
}
