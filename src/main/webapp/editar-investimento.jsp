<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edição de Investimento</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./resources/css/bootstrap.css">
</head>
<body class="d-flex flex-column min-vh-100">

<%@ include file="header.jsp" %>

<main class="flex-fill container my-4">
    <div class="mt-5 ms-5 me-5">
        <div class="card mb-3">
            <div class="card-header">
                ATUALIZAR INVESTIMENTO
            </div>

            <c:if test="${not empty mensagem}">
            <div class="alert alert-success ms-2 me-2 mt-2">${mensagem}</div>
            </c:if>

            <c:if test="${not empty erro}">
            <div class="alert alert-danger ms-2 me-2 mt-2">${erro}</div>
            </c:if>

            <div class="card-body">
                <form action="investimento?acao=editar" method="post">
                    <input type="hidden" name="codigo" value="${investimento.id}">

                    <div class="form-group">
                        <label for="id-aplicacao">Nome da Aplicação</label>
                        <input type="text" name="aplicacao" id="id-aplicacao" class="form-control" value="${investimento.nomeAplicacao}">
                    </div>

                    <div class="form-group">
                        <label for="id-valor">Valor Investido</label>
                        <input type="text" name="valor" id="id-valor" class="form-control" value="${investimento.valor}">
                    </div>

                    <div class="form-group">
                        <label for="id-instituicao">Instituição</label>
                        <input type="text" name="instituicao" id="id-instituicao" class="form-control" value="${investimento.instituicao}">
                    </div>

                    <div class="form-group">
                        <label for="id-data-aplicacao">Data do Investimento</label>
                        <input type="date" name="dataAplicacao" id="id-data-aplicacao" class=
