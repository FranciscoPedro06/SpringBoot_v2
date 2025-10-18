package com.example.demo.controllers;

import com.example.demo.entities.Pessoa;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {
    private final List<Pessoa> pessoas = new ArrayList<>();

    public PessoaController() {
        this.pessoas.add(new Pessoa("Maria"));
        this.pessoas.add(new Pessoa("João"));
        this.pessoas.add(new Pessoa("José"));
    }

    @GetMapping("/")
    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    @GetMapping("/nome/{nome}")
    public Pessoa getPessoaPorNome(@PathVariable String nome) {
        return pessoas.stream()
                .filter(c -> c.getNome().equals(nome))
                .findFirst()
                .orElse(null);
    }

    @GetMapping("/id/{id}")
    public Pessoa getPessoaPorId(@PathVariable int id) {
        return pessoas.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @PostMapping("/")
    public void adicionarPessoa(@RequestBody Pessoa pessoa) {
        this.pessoas.add(pessoa);
    }

    @PutMapping("/id/{id}")
    public void atualizarPessoa(@PathVariable int id, @RequestBody Pessoa pessoa) {
        Pessoa pessoaMem = pessoas.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);

        if (pessoaMem != null) {
            pessoaMem.setNome(pessoa.getNome());
        }
    }

    @DeleteMapping("/id/{id}")
    public void removerPessoa(@PathVariable int id) {
        pessoas.removeIf(c -> c.getId() == id);
    }
}

