package br.com.dio.transportadora.entity;

public class PacoteEnderecoForm {
    private Long pacoteId;
    private String origemCep;
    private String origemNumero;
    private String origemComplemento;
    private String destinoCep;
    private String destinoNumero;
    private String destinoComplemento;

    public Long getPacoteId() {
        return pacoteId;
    }

    public void setPacoteId(Long pacoteId) {
        this.pacoteId = pacoteId;
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
