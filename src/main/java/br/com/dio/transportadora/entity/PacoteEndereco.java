package br.com.dio.transportadora.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_pacote_endereco")
public class PacoteEndereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "pacote_id")
    private Pacote pacote;
    private String origemCep;
    private String origemNumero;
    private String origemComplemento;
    private String destinoCep;
    private String destinoNumero;
    private String destinoComplemento;

    public Pacote getPacote() {
        return pacote;
    }

    public void setPacote(Pacote pacote) {
        this.pacote = pacote;
    }

    public String getOrigemCep() {
        return origemCep;
    }

    public void setOrigemCep(String origemCep) {
        this.origemCep = origemCep;
    }

    public String getOrigemNumero() {
        return origemNumero;
    }

    public void setOrigemNumero(String origemNumero) {
        this.origemNumero = origemNumero;
    }

    public String getOrigemComplemento() {
        return origemComplemento;
    }

    public void setOrigemComplemento(String origemComplemento) {
        this.origemComplemento = origemComplemento;
    }

    public String getDestinoCep() {
        return destinoCep;
    }

    public void setDestinoCep(String destinoCep) {
        this.destinoCep = destinoCep;
    }

    public String getDestinoNumero() {
        return destinoNumero;
    }

    public void setDestinoNumero(String destinoNumero) {
        this.destinoNumero = destinoNumero;
    }

    public String getDestinoComplemento() {
        return destinoComplemento;
    }

    public void setDestinoComplemento(String destinoComplemento) {
        this.destinoComplemento = destinoComplemento;
    }
}
