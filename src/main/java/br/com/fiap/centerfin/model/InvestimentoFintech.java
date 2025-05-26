package br.com.fiap.centerfin.model;

import java.time.LocalDate;

public class InvestimentoFintech extends TransacaoFintech {
    private int id; // cd_investimento
    private int codigoUsuario; // cd_usuario
    private String nomeAplicacao; // nm_aplicacao
    private String instituicao; // int_financeira
    private LocalDate dataVencimento; // dt_vencimento

    public InvestimentoFintech() {
        super();
    }

    public InvestimentoFintech(int id, int codigoUsuario, String nomeAplicacao, String instituicao,
                               double valor, LocalDate dataAplicacao, LocalDate dataVencimento) {
        super(nomeAplicacao, valor, dataAplicacao);
        this.id = id;
        this.codigoUsuario = codigoUsuario;
        this.nomeAplicacao = nomeAplicacao;
        this.instituicao = instituicao;
        this.dataVencimento = dataVencimento;
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

    public String getNomeAplicacao() {
        return nomeAplicacao;
    }

    public void setNomeAplicacao(String nomeAplicacao) {
        this.nomeAplicacao = nomeAplicacao;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    @Override
    public void resumoTransacao() {
        System.out.println("Investimento realizado: " + nomeAplicacao + " | Valor: " + valor + " | Data: " + data +
                " | Instituição: " + instituicao + " | Vencimento: " + dataVencimento);
    }
}
