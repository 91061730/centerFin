package br.com.fiap.centerfin.factory;

import br.com.fiap.centerfin.dao.*;
import br.com.fiap.centerfin.dao.impl.*;

public class DaoFactory {

    public static ReceitaDao getReceitaDao()
    {
        return new OracleReceitaDao();
    }

    public static DespesaDao getDespesaDao() {

        return new OracleDespesaDao();
    }

    public static InvestimentoDao getInvestimentoDao()
    {
        return new OracleInvestimentoDao();
    }

    public static ObjetivoDao getObjetivoDao() {
        return new OracleObjetivoFinanceiroDao();
    }

    public static UsuarioDao getUsuarioDao() {
        return new OracleUsuarioDao();
    }

}
