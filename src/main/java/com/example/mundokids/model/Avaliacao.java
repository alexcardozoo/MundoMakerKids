package com.example.mundokids.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "avaliacoes")
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String atividadeSlug;
    private String q0;
    private String q1;
    private String q2;
    private String q3;

    private LocalDateTime dataEnvio;

    public Avaliacao() {}

    public Avaliacao(String atividadeSlug, String q0, String q1, String q2, String q3) {
        this.atividadeSlug = atividadeSlug;
        this.q0 = q0;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
        this.dataEnvio = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAtividadeSlug() { return atividadeSlug; }
    public void setAtividadeSlug(String atividadeSlug) { this.atividadeSlug = atividadeSlug; }

    public String getQ0() { return q0; }
    public void setQ0(String q0) { this.q0 = q0; }

    public String getQ1() { return q1; }
    public void setQ1(String q1) { this.q1 = q1; }

    public String getQ2() { return q2; }
    public void setQ2(String q2) { this.q2 = q2; }

    public String getQ3() { return q3; }
    public void setQ3(String q3) { this.q3 = q3; }

    public LocalDateTime getDataEnvio() { return dataEnvio; }
    public void setDataEnvio(LocalDateTime dataEnvio) { this.dataEnvio = dataEnvio; }
}