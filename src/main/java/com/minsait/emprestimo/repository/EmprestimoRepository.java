package com.minsait.emprestimo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.minsait.emprestimo.entity.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long>{

}
