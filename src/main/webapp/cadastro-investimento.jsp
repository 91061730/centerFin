<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cadastro de Investimento</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./resources/css/bootstrap.css">
</head>
<body class="d-flex flex-column min-vh-100">

<%@ include file="header.jsp" %>

<main class="flex-fill container my-4">
    <div class="mt-5 ms-5 me-5">
        <div class="card mb-3">
            <div class="card-header">
                CADASTRO DE INVESTIMENTO
            </div>

            <c:if test="${not empty mensagem}">
                <div class="alert alert-success ms-2 me-2 mt-2">${mensagem}</div>
            </c:if>

            <c:if test="${not empty erro}">
                <div class="alert alert-danger ms-2 me-2 mt-2">${erro}</div>
            </c:if>

            <div class="card-body">
                <form action="investimento" method="post">
                    <input type="hidden" name="acao" value="cadastrar">

                    <div class="form-group">
                        <label for="id-aplicacao">Nome da Aplicação</label>
                        <input type="text" name="aplicacao" id="id-aplicacao" class="form-control">
                    </div>

                    <div class="form-group">
                        <label for="id-valor">Valor Investido</label>
                        <input type="text" name="valor" id="id-valor" class="form-control">
                    </div>

                    <div class="form-group">
                        <label for="id-instituicao">Instituição</label>
                        <input type="text" name="instituicao" id="id-instituicao" class="form-control">
                    </div>

                    <div class="form-group">
                        <label for="id-dataAplicacao">Data do Investimento</label>
                        <input type="date" name="dataAplicacao" id="id-dataAplicacao" class="form-control">
                    </div>

                    <div class="form-group">
                        <label for="id-dataVencimento">Data do Vencimento</label>
                        <input type="date" name="dataVencimento" id="id-dataVencimento" class="form-control">
                    </div>

                    <input type="submit" value="Salvar" class="btn btn-dark mt-3">
                </form>
            </div>
        </div>
    </div>
</main>

<%@ include file="footer.jsp" %>
<script src="resources/js/bootstrap.bundle.js"></script>
</body>
</html>
