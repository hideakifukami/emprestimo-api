package com.minsait.emprestimo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.minsait.emprestimo.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
}
