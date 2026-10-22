package com.example.mundokids.controller;

import com.example.mundokids.model.Avaliacao;
import com.example.mundokids.repository.AvaliacaoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final AvaliacaoRepository avaliacaoRepository;

    public AdminController(AvaliacaoRepository avaliacaoRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
    }

    @GetMapping("/avaliacoes")
    public String listarAvaliacoes(Model model) {
        List<Avaliacao> avaliacoes = avaliacaoRepository.findAll();
        model.addAttribute("avaliacoes", avaliacoes);
        return "admin/avaliacoes";
    }
}