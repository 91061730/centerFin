


<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>CenterFin</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./resources/css/bootstrap.css">
</head>
<body class="d-flex flex-column min-vh-100">

<%@ include file="header.jsp" %>

<main class="flex-fill container my-4">
    <div class="container">
        <div class="mt-5 ms-5 me-5">
            <div class="card mb-3">
                <div class="card-header">
                    RESUMO DE OBJETIVOS FINANCEIROS
                </div>
                <div class="card-body">
                    <c:if test="${not empty mensagem}">
                        <div class="alert alert-success" role="alert">
                                ${mensagem}
                        </div>
                    </c:if>

                    <h5 class="card-title">Aqui você acompanha seus últimos objetivos financeiros</h5>
                    <p class="card-text">
                        Mantenha os dados de seus objetivos sempre atualizados para uma melhor gestão das suas finanças.
                    </p>

                    <!-- TABELA RESPONSIVA -->
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered">
                            <thead>
                            <tr>
                                <th class="text-center">Objetivo Financeiro</th>
                                <th class="text-center">Descrição</th>
                                <th class="text-end">Valor</th>
                                <th class="text-center">Data de Conclusão</th>
                                <th class="text-center"></th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${objetivo}" var="objetivo">
                                <tr>
                                    <td class="text-center">${objetivo.descricao}</td>
                                    <td class="text-center">${objetivo.nomeObjetivo}</td>
                                    <td class="text-end">${objetivo.valor}</td>
                                    <td class="text-center">
                                        <fmt:parseDate value="${objetivo.dataConclusao}" pattern="yyyy-MM-dd"
                                                       var="dataObjetivo"/>
                                        <fmt:formatDate value="${dataObjetivo}" pattern="dd/MM/yyyy"/>
                                    </td>
                                    <td class="text-center">
                                        <div class="d-flex gap-2 justify-content-center">
                                            <c:url value="investimento" var="link">
                                                <c:param name="acao" value="abrir-form-edicao"/>
                                                <c:param name="codigo" value="${objetivo.id}"/>
                                            </c:url>
                                            <a href="${link}" class="btn btn-primary btn-sm">Editar</a>
                                            <button
                                                    type="button"
                                                    class="btn btn-danger btn-sm"
                                                    data-bs-toggle="modal"
                                                    data-bs-target="#excluirModal"
                                                    onclick="codigoExcluir.value = ${objetivo.id}">
                                                Excluir
                                            </button>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                            <tfoot>
                            <tr>
                                <th>Total</th>
                                <th class="text-end">
                                    <fmt:formatNumber value="${totalObjetivo}" type="currency"/>
                                </th>
                                <th colspan="3"></th>
                            </tr>
                            </tfoot>
                        </table>
                    </div>

                    <a href="cadastro-objetivoFinanceiro.jsp" class="btn btn-dark mt-3">Adicione um Objetivo</a>
                </div>
            </div>
        </div>
    </div>
</main>

<div class="modal fade" id="excluirModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">Confirmar Exclusão</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <h4>Você confirma a exclusão deste Objetivo?</h4>
                <p><strong>Atenção!</strong> Esta ação é irreversível.</p>
            </div>
            <div class="modal-footer">
                <form action="objetivo" method="post">
                    <input type="hidden" name="acao" value="excluir"/>
                    <input type="hidden" name="codigoExcluir" id="codigoExcluir"/>
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Não</button>
                    <button type="submit" class="btn btn-danger">Sim</button>
                </form>
            </div>
        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>
<script src="resources/js/bootstrap.bundle.js"></script>
</body>
</html>
