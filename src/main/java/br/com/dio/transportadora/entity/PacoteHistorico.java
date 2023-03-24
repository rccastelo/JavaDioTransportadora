package br.com.dio.transportadora.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_pacote_historico")
public class PacoteHistorico {
    @EmbeddedId
    private PacoteHistoricoId id;
    private String cep;
    private String numero;
    private String complemento;
}
