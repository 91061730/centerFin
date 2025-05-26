<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Editar Objetivo Financeiro</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./resources/css/bootstrap.css">
</head>
<body class="d-flex flex-column min-vh-100">


<%@ include file="header.jsp" %>

<main class="flex-fill container my-4">
    <div class="mt-5 ms-5 me-5">
        <div class="card mb-3">
            <div class="card-header">
                ATUALIZAR OBJETIVO FINANCEIRO
            </div>

            <c:if test="${not empty mensagem}">
                <div class="alert alert-success ms-2 me-2 mt-2">${mensagem}</div>
            </c:if>

            <c:if test="${not empty erro}">
                <div class="alert alert-danger ms-2 me-2 mt-2">${erro}</div>
            </c:if>

            <div class="card-body">

                <form action="objetivo?acao=editar" method="post">

                    <input type="hidden" name="codigo" value="${objetivo.id}">

                    <div class="form-group">
                        <label for="id-descricao">Descrição</label>
                        <input type="text" name="descricao" id="id-descricao" class="form-control"
                               value="${objetivo.descricao}">
                    </div>
                    <div class="form-group">
                        <label for="id-nomeObjetivo">Nome do Objetivo</label>
                        <input type="text" name="nomeObjetivo" id="id-nomeObjetivo" class="form-control"
                               value="${objetivo.nomeObjetivo}">
                    </div>
                    <div class="form-group">
                        <label for="id-valor">Valor</label>
                        <input type="text" name="valor" id="id-valor" class="form-control" value="${objetivo.valor}">
                    </div>
                    <div class="form-group">
                        <label for="id-data">Data de Conclusão</label>
                        <input type="date" name="data" id="id-data" class="form-control"
                               value="${objetivo.dataConclusao}">
                    </div>

                    <input type="submit" value="Salvar" class="btn btn-dark mt-3">

                </form>
            </div>
        </div>
    </div>
    </div>
</main>
<%@ include file="footer.jsp" %>
<script src="resources/js/bootstrap.bundle.js"></script>
</body>
</html>
