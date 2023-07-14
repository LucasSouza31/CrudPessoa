package br.edu.ifba.crudpessoa.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import br.edu.ifba.crudpessoa.model.Pessoa;
import br.edu.ifba.crudpessoa.repository.PessoaRepository;

@Controller
@RequestMapping("/pessoa")
public class PessoaControler {

    @Autowired
    private PessoaRepository pessoaRepository;
    
    @PostMapping("/cadastrar")
    public Pessoa cadastrarPessoa(@RequestBody Pessoa pessoa ){
        return pessoaRepository.save(pessoa);
    }

    @PatchMapping("/atualizar-cadastro/{id}")
    public Pessoa atualizarPorPartes(@PathVariable long id ,@RequestBody Pessoa pessoa){
        Pessoa encontrarPessoa = pessoaRepository.getReferenceById(id);
        encontrarPessoa.setIdade(Optional.ofNullable(pessoa.getIdade()).orElse(encontrarPessoa.getIdade()));
        encontrarPessoa.setNome(Optional.ofNullable(pessoa.getNome()).orElse(encontrarPessoa.getNome()));    
        return pessoaRepository.save(encontrarPessoa);
    }

    @PutMapping("/atualizar-total/{id}")
    public Pessoa atualizarPorCompleto(@PathVariable long id, @RequestBody Pessoa pessoa){
        Pessoa encontrarPessoa = pessoaRepository.getReferenceById(id);
        encontrarPessoa.setIdade(pessoa.getIdade());
        encontrarPessoa.setNome(pessoa.getNome());
        return pessoaRepository.save(encontrarPessoa);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarPessoa(@PathVariable long id){
        pessoaRepository.deleteById(id);
    }
    
}
