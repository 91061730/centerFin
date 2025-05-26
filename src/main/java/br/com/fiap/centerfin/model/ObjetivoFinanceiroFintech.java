package br.com.fiap.centerfin.model;

import java.time.LocalDate;

public class ObjetivoFinanceiroFintech extends TransacaoFintech {

    private int id;
    private int codigoUsuario;
    private String nomeObjetivo;
    private LocalDate dataConclusao;

    public ObjetivoFinanceiroFintech() {
        super();
    }

    public ObjetivoFinanceiroFintech(int id, int codigoUsuario, String nomeObjetivo, String descricao, double valor, LocalDate dataConclusao) {
        super(descricao, valor, dataConclusao);
        this.id = id;
        this.codigoUsuario = codigoUsuario;
        this.nomeObjetivo = nomeObjetivo;
        this.dataConclusao = dataConclusao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getNomeObjetivo() {
        return nomeObjetivo;
    }

    public void setNomeObjetivo(String nomeObjetivo) {
        this.nomeObjetivo = nomeObjetivo;
    }

    public LocalDate getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDate dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    @Override
    public void resumoTransacao() {
        System.out.println("Objetivo financeiro definido: " + getDescricao()
                + " | Nome: " + nomeObjetivo
                + " | Meta: " + getValor()
                + " | Data de conclusão: " + dataConclusao);
    }
}
