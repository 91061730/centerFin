package br.com.fiap.centerfin.model;

import java.time.LocalDate;

public class DespesasFintech extends TransacaoFintech {

    private int id;               // CD_DESPESA
    private int codigo;           // CD_USUARIO
    private String formaPagamento; // FM_PAGAMENTO

    public DespesasFintech() {
        super();
    }

    public DespesasFintech(int id, int codigo, String descricao, double valor, LocalDate data, String formaPagamento) {
        super(descricao, valor, data);
        this.id = id;
        this.codigo = codigo;
        this.formaPagamento = formaPagamento;
    }

    @Override
    public void resumoTransacao() {
        System.out.println("Despesa: " + descricao + " | Valor: " + valor + " | Data: " + data + " | Forma de pagamento: " + formaPagamento);
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

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
}
