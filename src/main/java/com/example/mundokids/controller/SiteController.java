package com.example.mundokids.controller;

import com.example.mundokids.model.Atividade;
import com.example.mundokids.model.Avaliacao;
import com.example.mundokids.model.AvaliacaoForm;
import com.example.mundokids.repository.AtividadeRepository;
import com.example.mundokids.repository.AvaliacaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class SiteController {

    private static final Logger log = LoggerFactory.getLogger(SiteController.class);

    private final AtividadeRepository atividadeRepository;
    private final AvaliacaoRepository avaliacaoRepository;

    public SiteController(AtividadeRepository atividadeRepository, AvaliacaoRepository avaliacaoRepository) {
        this.atividadeRepository = atividadeRepository;
        this.avaliacaoRepository = avaliacaoRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("atividades", atividadeRepository.findAll());
        return "index";
    }

    @GetMapping("/atividades")
    public String atividades(Model model) {
        model.addAttribute("atividades", atividadeRepository.findAll());
        return "atividades";
    }

    @GetMapping("/atividades/{slug}")
    public String exibirAtividade(@PathVariable String slug, Model model) {
        Atividade atividade = atividadeRepository.findBySlug(slug)
                .orElseThrow(() -> new IllegalArgumentException("Atividade não encontrada: " + slug));

        model.addAttribute("atividade", atividade);
        return "atividade/detalhe-atividade";
    }

    @GetMapping("/sobre")
    public String sobre() {
        return "sobre";
    }

    @PostMapping("/avaliacao/{slug}")
    @ResponseBody
    public ResponseEntity<Map<String, String>> avaliacao(
            @PathVariable String slug,
            @ModelAttribute AvaliacaoForm form) {
        if (!form.isCompleta()) {
            return ResponseEntity.badRequest()
                    .body(Map.of("erro", "Responda as quatro perguntas para enviar."));
        }

        // Converte o formulário recebido na entidade JPA e salva no banco de dados
        Avaliacao avaliacao = new Avaliacao(slug, form.getQ0(), form.getQ1(), form.getQ2(), form.getQ3());
        avaliacaoRepository.save(avaliacao);

        log.info("Avaliação gravada com sucesso — atividade={} q0={} q1={} q2={} q3={}",
                slug, form.getQ0(), form.getQ1(), form.getQ2(), form.getQ3());

        return ResponseEntity.ok(Map.of("mensagem", "Avaliação enviada. Obrigado!"));
    }
}