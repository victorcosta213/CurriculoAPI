package com.example.vcm.service;

import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vcm.model.Pessoal;
import com.example.vcm.repository.PessoalRepository;

@Service
public class CurriculoService {

    @Autowired
    private PessoalRepository curriculoRepository;

    public Pessoal create(Pessoal curriculo) {
        return curriculoRepository.save(curriculo);
    }

    public List<Pessoal> getAll() {
        return curriculoRepository.findAll();
    }

    public Pessoal findById(Long id) {
        return curriculoRepository.findById(id).orElseThrow(() -> new RuntimeException("Currículo não encontrado!"));
    }

    @Transactional
    public Pessoal update(Long id, Pessoal curriculoAtualizado) {
        Optional<Pessoal> optionalCurriculo = curriculoRepository.findById(id);

        if (optionalCurriculo.isPresent()) {
            Pessoal curriculoExistente = optionalCurriculo.get();

            // Atualizando dados básicos
            curriculoExistente.setNome(curriculoAtualizado.getNome());
            curriculoExistente.setEmail(curriculoAtualizado.getEmail());
            curriculoExistente.setTelefone(curriculoAtualizado.getTelefone());
            curriculoExistente.setEndereco(curriculoAtualizado.getEndereco());

            // Atualizando a lista de formações
            curriculoExistente.getFormacoes().clear(); // Limpa a lista existente
            curriculoExistente.getFormacoes().addAll(curriculoAtualizado.getFormacoes()); // Adiciona as novas formações

            return curriculoRepository.save(curriculoExistente);
        } else {
            throw new RuntimeException("Currículo não encontrado com o ID: " + id);
        }
    }



    public void delete(Long id) {
        curriculoRepository.deleteById(id);
    }
}
