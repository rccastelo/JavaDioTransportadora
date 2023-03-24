package br.com.dio.transportadora.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import java.io.Serializable;
import java.time.LocalDateTime;

@Embeddable
public class PacoteHistoricoId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "pacote_id")
    private Pacote pacote;
    private LocalDateTime dataHora;

    public Pacote getPacote() {
        return pacote;
    }

    public void setPacote(Pacote pacote) {
        this.pacote = pacote;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
