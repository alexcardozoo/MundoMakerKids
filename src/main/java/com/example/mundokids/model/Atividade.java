package com.example.mundokids.model;

public class Atividade {

    private final String slug;
    private final String titulo;
    private final String descricao;
    private final String disciplina; // "p" = Português, "m" = Matemática, "f" = Folclore
    private final String disciplinaLabel;
    private final String conceito;
    private final int tempoMinutos;

    public Atividade(String slug, String titulo, String descricao,
                     String disciplina, String disciplinaLabel,
                     String conceito, int tempoMinutos) {
        this.slug = slug;
        this.titulo = titulo;
        this.descricao = descricao;
        this.disciplina = disciplina;
        this.disciplinaLabel = disciplinaLabel;
        this.conceito = conceito;
        this.tempoMinutos = tempoMinutos;
    }

    public String getSlug() { return slug; }
    public String getTitulo() { return titulo; }
    public String getDescricao() { return descricao; }
    public String getDisciplina() { return disciplina; }
    public String getDisciplinaLabel() { return disciplinaLabel; }
    public String getConceito() { return conceito; }
    public int getTempoMinutos() { return tempoMinutos; }
    public String getTempoLabel() { return tempoMinutos + " min"; }
}
