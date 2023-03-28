package br.com.dio.transportadora.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_pacote_historico")
public class PacoteHistorico {
    @EmbeddedId
    private PacoteHistoricoId id;
    private String cep;
    private String bairro;
    private String logradouro;
    private String uf;
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

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
