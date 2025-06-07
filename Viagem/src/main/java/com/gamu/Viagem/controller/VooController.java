package com.gamu.Viagem.controller;

import com.gamu.Viagem.decorator.SignatureDecorator;
import com.gamu.Viagem.decorator.content.BasicEmailContent;
import com.gamu.Viagem.decorator.interfce.EmailContent;
import com.gamu.Viagem.entity.Voo;
import com.gamu.Viagem.repository.VooRepository;
import com.gamu.Viagem.service.EmailService;
import com.gamu.Viagem.service.VooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/voo")
public class VooController {
    @Autowired
    private EmailService emailService;

    @Autowired
    private VooRepository vooRepository;

    //---------Controller Thymeleaf ----------------------------------------------

    @GetMapping({"", "/"})
    public String getVoo(Model model) {
        var voo = vooRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        model.addAttribute("voo", voo);

        return "voo/index";
    }

    @GetMapping("/create")
    public String createVoo(Model model) {
        Voo voo = new Voo();
        model.addAttribute("voo", voo);
        return "voo/create";
    }

    @PostMapping("/create")
    public String createVoo(@Validated @ModelAttribute Voo voo, BindingResult result) {

        if (result.hasErrors()) {
            return "/voo/create";
        }

        voo.setDestino(voo.getDestino());
        voo.setLocalIda(voo.getLocalIda());
        voo.setDiaIda(voo.getDiaIda());
        voo.setHoraIda(voo.getHoraIda());
        voo.setLocalVolta(voo.getLocalVolta());
        voo.setDiaVolta(voo.getDiaVolta());
        voo.setHoraVolta(voo.getHoraVolta());

        Voo newUser = vooRepository.save(voo);

        EmailContent content = new BasicEmailContent();
        content = new SignatureDecorator(content);
        String mensagem = content.generateContent(newUser.getDestino());

        emailService.sendEmail("murilho2302@gmail.com","Cadastro realizado", mensagem);
        vooRepository.save(voo);

        return "redirect:/voo";
    }

    @GetMapping("/edit")
    public String editVoo(Model model, @RequestParam Long id) {
        Voo voo = vooRepository.findById(id).orElse(null);

        voo.setDestino(voo.getDestino());
        voo.setLocalIda(voo.getLocalIda());
        voo.setDiaIda(voo.getDiaIda());
        voo.setHoraIda(voo.getHoraIda());
        voo.setLocalVolta(voo.getLocalVolta());
        voo.setDiaVolta(voo.getDiaVolta());
        voo.setHoraVolta(voo.getHoraVolta());

        model.addAttribute("voo", voo);

        return "/voo/edit";
    }

    @PostMapping("/edit")
    public String editVoo(Model model, @RequestParam Long id, @Validated @ModelAttribute Voo voo, BindingResult result) {
//        model.addAttribute("voo", voo);
//        voo = vooRepository.findById(id).orElse(null);

        voo.setDestino(voo.getDestino());
        voo.setLocalIda(voo.getLocalIda());
        voo.setDiaIda(voo.getDiaIda());
        voo.setHoraIda(voo.getHoraIda());
        voo.setLocalVolta(voo.getLocalVolta());
        voo.setDiaVolta(voo.getDiaVolta());
        voo.setHoraVolta(voo.getHoraVolta());

        vooRepository.save(voo);
        return "redirect:/voo";
    }

    @GetMapping("/delete")
    public String deleteVoo(@RequestParam Long id){
        Voo voo = vooRepository.findById(id).orElse(null);
        vooRepository.delete(voo);

        return "redirect:/voo";
    }


}

//    public VooController(VooService vooService) {
//        this.vooService = vooService;
//    }

//    // LISTAR Pagamentos
//    @GetMapping
//    public String listarVoo(Model model) {
//        model.addAttribute("voo", vooService.listarTodos());
//        return "/listar";
//    }
//
//    // FORMULÁRIO PARA CRIAR Pagamento
//    @GetMapping("/novo")
//    public String mostrarFormularioNovoVoo(Model model) {
//        model.addAttribute("voo", new Voo());
//        return "voo/adicionar";
//    }
//
//    // SALVAR NOVO pagamento
//    @PostMapping
//    public String salvarVoo(@ModelAttribute Voo voo) {
//        vooService.salvar(voo);
//        return "redirect:/voo";
//    }
//
//    // FORMULÁRIO DE EDIÇÃO
//    @GetMapping("/editar/{id}")
//    public String editarVoo(@PathVariable Long id, Model model) {
//        Voo voo = vooService.buscarPorId(id);
//        if (voo == null) {
//            return "redirect:/voo";
//        }
//        model.addAttribute("voo", voo);
//        return "voo/form";
//    }
//
//    // DELETAR
//    @GetMapping("/deletar/{id}")
//    public String deletarVoo(@PathVariable Long id) {
//        vooService.deletar(id);
//        return "redirect:/voo";
//    }