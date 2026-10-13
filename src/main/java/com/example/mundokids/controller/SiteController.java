package com.example.mundokids.controller;

import com.example.mundokids.model.Atividade;
import com.example.mundokids.model.AvaliacaoForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class SiteController {

    private static final Logger log = LoggerFactory.getLogger(SiteController.class);

    private static final List<Atividade> ATIVIDADES = List.of(
        new Atividade(
            "escravos-de-jo",
            "Escravos de Jó Algorítmico",
            "A cantiga tradicional vira um programa: um comando que se repete e uma condição que o altera.",
            "f", "Folclore", "Repetição (loop)", 20
        ),
        new Atividade(
            "chapeuzinho",
            "O Algoritmo da Chapeuzinho Vermelho",
            "Uma história conhecida para treinar sequência de eventos e decisões do tipo \"se isso, então aquilo\".",
            "p", "Língua Portuguesa", "Se / Senão", 30
        ),
        new Atividade(
            "amarelinha",
            "Amarelinha dos Padrões",
            "A amarelinha ganha uma regra de algoritmo: números pares passam, ímpares são \"bug\".",
            "m", "Matemática", "Sequência e depuração", 25
        ),
        new Atividade(
            "robo-humano",
            "O Robô Humano",
            "Uma criança vira robô e outra programadora: comandos verbais precisos para chegar ao destino sem errar.",
            "f", "Folclore", "Algoritmos", 20
        ),
        new Atividade(
            "sequencia-do-dia",
            "A Sequência do Dia",
            "Ordenar as ações da rotina matinal revela que algoritmos do cotidiano têm uma ordem que não pode ser trocada.",
            "p", "Língua Portuguesa", "Sequenciamento", 25
        ),
        new Atividade(
            "caca-ao-caminho",
            "Caça ao Caminho",
            "Com fita no chão e instruções escritas, a turma descobre que um robô precisa de direções absolutas, não de intenções.",
            "m", "Matemática", "Algoritmos e Direções", 25
        ),
        new Atividade(
            "classificando-objetos",
            "Classificando Objetos",
            "Agrupar sucatas por cor, forma e material ensina que todo banco de dados tem uma lógica de categorias.",
            "m", "Matemática", "Reconhecimento de padrões", 20
        ),
        new Atividade(
            "montando-historias",
            "Montando Histórias",
            "Cartões embaralhados de uma história: a turma descobre que o texto tem um algoritmo — começo, meio e fim.",
            "p", "Língua Portuguesa", "Decomposição", 30
        ),
        new Atividade(
            "desafio-labirinto",
            "Desafio do Labirinto",
            "Labirinto no chão com bifurcações: siga o caminho verde se a condição for verdadeira, o vermelho se for falsa.",
            "m", "Matemática", "Condicionais", 25
        ),
        new Atividade(
            "receita-algoritmo",
            "A Receita Algorítmica",
            "Escrever a receita do bolo da vovó passo a passo revela que qualquer tarefa pode ser descrita como algoritmo.",
            "p", "Língua Portuguesa", "Algoritmos", 20
        ),
        new Atividade(
            "padroes-da-natureza",
            "Padrões da Natureza",
            "Folhas, flores e simetrias: identificar padrões visuais no mundo natural é o primeiro passo para programar.",
            "m", "Matemática", "Reconhecimento de padrões", 20
        ),
        new Atividade(
            "ciranda-algoritmica",
            "Ciranda Algorítmica",
            "A brincadeira de roda vira um programa com loops aninhados e condições que mudam a coreografia.",
            "f", "Folclore", "Loop aninhado", 25
        ),
        new Atividade(
            "historia-decomposta",
            "A História Decomposta",
            "Decomponha um conto em personagens, cenários e eventos para ver como o computador divide para conquistar.",
            "p", "Língua Portuguesa", "Decomposição", 30
        )
    );

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("atividades", ATIVIDADES);
        return "index";
    }

    @GetMapping("/atividades")
    public String atividades(Model model) {
        model.addAttribute("atividades", ATIVIDADES);
        return "atividades";
    }

    @GetMapping("/atividades/amarelinha")
    public String amarelinha() {
        return "atividade/amarelinha";
    }

    @GetMapping("/atividades/chapeuzinho")
    public String chapeuzinho() {
        return "atividade/chapeuzinho";
    }

    @GetMapping("/atividades/escravos-de-jo")
    public String escravosDeJo() {
        return "atividade/escravos-de-jo";
    }

    @GetMapping("/atividades/robo-humano")
    public String roboHumano() { return "atividade/robo-humano"; }

    @GetMapping("/atividades/sequencia-do-dia")
    public String sequenciaDoDia() { return "atividade/sequencia-do-dia"; }

    @GetMapping("/atividades/caca-ao-caminho")
    public String cacaAoCaminho() { return "atividade/caca-ao-caminho"; }

    @GetMapping("/atividades/classificando-objetos")
    public String classificandoObjetos() { return "atividade/classificando-objetos"; }

    @GetMapping("/atividades/montando-historias")
    public String montandoHistorias() { return "atividade/montando-historias"; }

    @GetMapping("/atividades/desafio-labirinto")
    public String desafioLabirinto() { return "atividade/desafio-labirinto"; }

    @GetMapping("/atividades/receita-algoritmo")
    public String receitaAlgoritmo() { return "atividade/receita-algoritmo"; }

    @GetMapping("/atividades/padroes-da-natureza")
    public String padroesDaNatureza() { return "atividade/padroes-da-natureza"; }

    @GetMapping("/atividades/ciranda-algoritmica")
    public String cirandaAlgoritmica() { return "atividade/ciranda-algoritmica"; }

    @GetMapping("/atividades/historia-decomposta")
    public String historiaDecomposta() { return "atividade/historia-decomposta"; }

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
        log.info("Avaliação recebida — atividade={} q0={} q1={} q2={} q3={}",
                slug, form.getQ0(), form.getQ1(), form.getQ2(), form.getQ3());
        return ResponseEntity.ok(Map.of("mensagem", "Avaliação enviada. Obrigado!"));
    }
}
