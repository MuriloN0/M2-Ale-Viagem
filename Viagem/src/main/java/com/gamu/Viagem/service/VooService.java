package com.gamu.Viagem.service;


import com.gamu.Viagem.entity.Voo;
import com.gamu.Viagem.repository.VooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VooService {

    @Autowired
    private VooRepository vooRepository;

    public VooService(VooRepository vooRepository) {
        this.vooRepository = vooRepository;
    }

    public List<Voo> listarTodos() {
        return vooRepository.findAll();
    }

    public Voo salvar(Voo voo) {
        return vooRepository.save(voo);
    }

    public Voo buscarPorId(Long id) {
        return vooRepository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        vooRepository.deleteById(id);
    }
}
