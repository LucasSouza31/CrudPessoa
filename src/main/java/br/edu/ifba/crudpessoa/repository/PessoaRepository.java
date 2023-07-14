package br.edu.ifba.crudpessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifba.crudpessoa.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
    
}
