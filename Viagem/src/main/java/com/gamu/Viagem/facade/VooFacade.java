package com.gamu.Viagem.facade;
import com.gamu.Viagem.entity.Voo;
import com.gamu.Viagem.service.VooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class VooFacade {
    private final VooService vooService;

    @Autowired
    public VooFacade(VooService vooService) {
        this.vooService = vooService;
    }

    public List<Voo> buscarVooPorId(Long id) {
        return Collections.singletonList(vooService.buscarPorId((long) id));
    }

    public List<Voo> listarTodosVoos() {
        return vooService.listarTodos();
    }

    public Voo salvarVoo(Voo voo) {
        return vooService.salvar(voo);
    }

    public void deletarVoo(long id) {
        vooService.deletar((long) id);
    }


}
