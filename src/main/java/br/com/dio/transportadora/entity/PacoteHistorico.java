package br.com.dio.transportadora.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_pacote_historico")
public class PacoteHistorico {
    @EmbeddedId
    private PacoteHistoricoId id;
    private String cep;
    private String numero;
    private String complemento;
    private String tipo;

    public PacoteHistoricoId getId() {
        return id;
    }

    public void setId(PacoteHistoricoId id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
