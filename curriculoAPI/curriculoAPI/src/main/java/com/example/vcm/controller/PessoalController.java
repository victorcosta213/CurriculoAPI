package com.example.vcm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.vcm.model.Pessoal;
import com.example.vcm.service.CurriculoService;

import java.util.List;

@RestController
@RequestMapping("/api/curriculos")
public class PessoalController {

    @Autowired
    private CurriculoService curriculoService;

    @PostMapping
    public ResponseEntity<Pessoal> creat(@RequestBody Pessoal curriculo) {
        return ResponseEntity.ok(curriculoService.create(curriculo));
    }

    @GetMapping
    public ResponseEntity<List<Pessoal>> listAll() {
        List<Pessoal> curriculos = curriculoService.getAll();
        return ResponseEntity.ok(curriculos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoal> findById(@PathVariable Long id) {
        Pessoal curriculo = curriculoService.findById(id);
        return ResponseEntity.ok(curriculo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoal> Update(@PathVariable Long id, @RequestBody Pessoal curriculo) {
        Pessoal curriculoAtualizado = curriculoService.update(id, curriculo);
        return ResponseEntity.ok(curriculoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        curriculoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
