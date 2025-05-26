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
<%@include file="header.jsp" %>
<div class="container">
    <div class="mt-5 ms-5 me-5">
        <div class="card mb-3">
            <div class="card-header">
                RESUMO DE OBJETIVOS FINANCEIROS
            </div>
            <div class="card-body">
                <h5 class="card-title">Aqui você acompanha seus últimos Objetivos Financeiros</h5>
                <p class="card-text">Mantenha os dados de seus Objetivos sempre atualizados para uma melhor gestão das
                    suas finanças.</p>
                <table class="table table-striped table-bordered">
                    <thead>
                    <tr>
                        <th>Objetivo Financeiro</th>
                        <th class="text-end">Descrição do Objetivo Financeiro</th>
                        <th class="text-end">Valor Objetivo Financeiro</th>
                        <th class="text-center">Data de Conclusão do Objetivo</th>
                    </thead>
                    <tbody>
                    <c:forEach items="${objetivo}" var="objetivo">

                        <tr>
                            <td>${objetivo.nomeObjetivo}</td>
                            <td class="text-end">${objetivo.descricao}</td>
                            <td class="text-center">${objetivo.valor}</td>
                            <td class="text-center">${objetivo.dataConclusao}</td>
                        </tr>

                    </c:forEach>
                    </tbody>
                </table>
                <a href="cadastro-objetivoFinanceiro.jsp" class="btn btn-primary">Adicione um Investimento </a>
            </div>
        </div>
    </div>
</div>
</div>
<%@include file="footer.jsp" %>
<script src="resources/js/bootstrap.bundle.js"></script>
</body>
</html>