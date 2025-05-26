<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>FiapStore</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./resources/css/bootstrap.css">
</head>
<body>
<%@include file="header.jsp"%>
<div class="container">
    <div class="mt-5 ms-5 me-5">

        <div class="card mb-3">
            <div class="card-header">
               RESUMO DE RECEITAS
            </div>
            <div class="card-body">
                <h5 class="card-title">Aqui você acompanha suas ultimas receitas </h5>
                <p class="card-text">Mantenha os dados de suas receitas  sempre atualizados para uma melhor gestão das suas finanças.</p>
                <table class="table table-striped table-bordered">
                    <thead>
                    <tr>
                        <th>Receita</th>
                        <th class="text-end">Valor</th>
                        <th class="text-center">Data de Recebimento</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>Aluguel</td>
                        <td class="text-end">30.99</td>
                        <td class="text-center">15-09-2024</td>
                    </tr>
                    <tr>
                        <td>Salario</td>
                        <td class="text-end">700.00</td>
                        <td class="text-center">21-11-2023</td>
                    </tr>
                    </tbody>
                </table>
                <a href="cadastro-receita.jsp" class="btn btn-primary">Adicione uma Receita</a>
                <br><br>
            </div>
            <div class="card mb-3">
                <div class="card-header">
                    RESUMO DE DESPESAS
                </div>
                <div class="card-body">
                    <h5 class="card-title">Aqui você acompanha suas ultimas despesas </h5>
                    <p class="card-text">Mantenha os dados de suas despesas  sempre atualizados para uma melhor gestão das suas finanças.</p>
                    <table class="table table-striped table-bordered">
                        <thead>
                        <tr>
                            <th>Despesa</th>
                            <th class="text-end">Valor</th>
                            <th class="text-center">Forma de pagamento </th>
                            <th class="text-center">Data da Despesa </th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>Aluguel</td>
                            <td class="text-end">30.99</td>
                            <td class="text-center">cartão de debito</td>
                            <td class="text-center">15-09-2024</td>
                        </tr>
                        <tr>
                            <td>Salario</td>
                            <td class="text-end">700.00</td>
                            <td class="text-center">cartão de debito</td>
                            <td class="text-center">21-11-2023</td>
                        </tr>
                        </tbody>
                    </table>
                    <a href="cadastro-despesa.jsp" class="btn btn-primary">Adicione uma Despesa </a>
                </div>
        </div>
            <br><br>
            <div class="card mb-3">
                <div class="card-header">
                    RESUMO DOS  INVESTIMENTOS
                </div>
                <div class="card-body">
                    <h5 class="card-title">Aqui você acompanha seus ultimos investimentos </h5>
                    <p class="card-text">Mantenha os dados de seus investimentos  sempre atualizados para acompannhar a sua evolução financeira.</p>
                    <table class="table table-striped table-bordered">
                        <thead>
                        <tr>
                            <th>Investimentos</th>
                            <th class="text-end">Descrição do Investimento</th>
                            <th class="text-end">Valor Investido</th>
                            <th class="text-center">Instituição</th>
                            <th class="text-center">Data do Investimento</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>Renda Fixa</td>
                            <td class="text-end">CDB</td>
                            <td class="text-end">1000,00</td>
                            <td class="text-center">Nubank</td>
                            <td class="text-center">14-05-2025</td>
                        </tr>
                        <tr>
                            <td>Renda variavel </td>
                            <td class="text-end">CDB</td>
                            <td class="text-end">1000,00</td>
                            <td class="text-center">Nubank</td>
                            <td class="text-center">14-05-2025</td>
                        </tr>
                        </tbody>
                    </table>
                    <a href="cadastro-investimento.jsp" class="btn btn-primary">Adicione um novo Investimento </a>
                </div>
            </div>
            <br><br>
            <div class="card mb-3">
                <div class="card-header">
                    RESUMO DOS  OBJETIVO  FINANCEIRO
                </div>
                <div class="card-body">
                    <h5 class="card-title">Aqui você acompanha seus ultimos Objetivos Financeiros </h5>
                    <p class="card-text">Mantenha os dados de seus Objetivos Financeiros  sempre atualizados para acompannhar a sua evolução financeira.</p>
                    <table class="table table-striped table-bordered">
                        <thead>
                        <tr>
                            <th>Objetivo Financeiro</th>
                            <th class="text-end">Descrição do Objetivo Financeiro</th>
                            <th class="text-end">Valor Objetivo Financeiro</th>
                            <th class="text-center">Data de Conclusão do Objetivo</th>


                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>Casa Propria</td>
                            <td class="text-end">Compra da casa</td>
                            <td class="text-center">100,00</td>
                            <td class="text-center">15-09-2024</td>
                        </tr>

                        </tbody>
                    </table>
                    <a href="cadastro-objetivoFinanceiro.jsp" class="btn btn-primary">Adicione um novo Objetivo Financeiro </a>
                </div>
            </div>
    </div>
</div>
<%@include file="footer.jsp"%>
<script src="resources/js/bootstrap.bundle.js"></script>
</body>
</html>