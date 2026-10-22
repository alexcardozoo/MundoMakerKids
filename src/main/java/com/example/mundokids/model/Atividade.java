package com.example.mundokids.model;

import jakarta.persistence.*;

@Entity
@Table(name = "atividades")
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String slug;

    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    private String disciplina; // "p" = Português, "m" = Matemática, "f" = Folclore
    private String disciplinaLabel;
    private String conceito;
    private int tempoMinutos;

    private String idade;
    private String espaco;

    @Column(columnDefinition = "TEXT")
    private String objetivo;

    @Column(columnDefinition = "TEXT")
    private String passosHtml;

    @Column(columnDefinition = "TEXT")
    private String dica;

    @Column(columnDefinition = "TEXT")
    private String materiaisHtml;

    @Column(columnDefinition = "TEXT")
    private String conceitoDescricao;

    public Atividade() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSlug() { return slug; }
    public void setSlug(String slug) { this.slug = slug; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getDisciplina() { return disciplina; }
    public void setDisciplina(String disciplina) { this.disciplina = disciplina; }

    public String getDisciplinaLabel() { return disciplinaLabel; }
    public void setDisciplinaLabel(String disciplinaLabel) { this.disciplinaLabel = disciplinaLabel; }

    public String getConceito() { return conceito; }
    public void setConceito(String conceito) { this.conceito = conceito; }

    public int getTempoMinutos() { return tempoMinutos; }
    public void setTempoMinutos(int tempoMinutos) { this.tempoMinutos = tempoMinutos; }

    public String getTempoLabel() { return tempoMinutos + " min"; }

    public String getIdade() { return idade; }
    public void setIdade(String idade) { this.idade = idade; }

    public String getEspaco() { return espaco; }
    public void setEspaco(String espaco) { this.espaco = espaco; }

    public String getObjetivo() { return objetivo; }
    public void setObjetivo(String objetivo) { this.objetivo = objetivo; }

    public String getPassosHtml() { return passosHtml; }
    public void setPassosHtml(String passosHtml) { this.passosHtml = passosHtml; }

    public String getDica() { return dica; }
    public void setDica(String dica) { this.dica = dica; }

    public String getMateriaisHtml() { return materiaisHtml; }
    public void setMateriaisHtml(String materiaisHtml) { this.materiaisHtml = materiaisHtml; }

    public String getConceitoDescricao() { return conceitoDescricao; }
    public void setConceitoDescricao(String conceitoDescricao) { this.conceitoDescricao = conceitoDescricao; }
}