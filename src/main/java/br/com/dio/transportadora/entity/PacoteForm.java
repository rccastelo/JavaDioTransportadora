package br.com.dio.transportadora.entity;

public class PacoteForm {
    private String descricao;
    private Double volumeM3;
    private Double pesoGrama;
    private Long pessoaId;
    private String situacao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getVolumeM3() {
        return volumeM3;
    }

    public void setVolumeM3(Double volumeM3) {
        this.volumeM3 = volumeM3;
    }

    public Double getPesoGrama() {
        return pesoGrama;
    }

    public void setPesoGrama(Double pesoGrama) {
        this.pesoGrama = pesoGrama;
    }

    public Long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
}
