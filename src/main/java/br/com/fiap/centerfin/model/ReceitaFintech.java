package br.com.fiap.centerfin.model;

import java.time.LocalDate;

public class ReceitaFintech extends TransacaoFintech {

    private int id;         // ID da receita (chave primária)
    private int codigo;     // Código do usuário (CD_USUARIO)

    public ReceitaFintech() {
        super();
    }


    public ReceitaFintech(int codigo, String descricao, double valor, LocalDate data) {
        super(descricao, valor, data);
        this.codigo = codigo;
    }


    public ReceitaFintech(int id, int codigo, String descricao, double valor, LocalDate data) {
        super(descricao, valor, data);
        this.id = id;
        this.codigo = codigo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public void resumoTransacao() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Receita: " + descricao + " | Valor: " + valor + " | Data: " + data;
    }

    @Override
    public void adicionarSaldoFintech(double valor) {
        super.adicionarSaldoFintech(valor);
    }

    @Override
    public void removerSaldoFintech(double valor) {
        super.removerSaldoFintech(valor);
    }
}
