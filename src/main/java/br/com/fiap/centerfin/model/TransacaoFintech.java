package br.com.fiap.centerfin.model;

import java.time.LocalDate;

public abstract class TransacaoFintech {
    protected String descricao;
    protected double valor;
    protected LocalDate data;
    protected double saldoTransacao;

    public TransacaoFintech() {
    }

    public TransacaoFintech(String descricao, double valor, LocalDate data) {
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
    }


    public abstract void resumoTransacao();

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public LocalDate getData() {
        return data;
    }


    public void adicionarSaldoFintech(double valor) {
        if (valor > 0) {
            saldoTransacao += valor;
            System.out.println("Saldo atualizado: +" + valor + " | Saldo total: " + saldoTransacao);
        } else {
            System.out.println("Valor inválido para adição.");
        }
    }


    public void removerSaldoFintech(double valor) {
        if (valor > 0 && saldoTransacao >= valor) {
            saldoTransacao -= valor;
            System.out.println("Saldo atualizado: -" + valor + " | Saldo total: " + saldoTransacao);
        } else {
            System.out.println("Saldo insuficiente ou valor inválido.");
        }
    }
}
