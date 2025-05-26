


<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>CenterFin</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- CSS -->
    <link rel="stylesheet" href="resources/css/fonts.css">
    <link rel="stylesheet" href="resources/css/bootstrap.css">
    <link rel="stylesheet" href="resources/css/style.css">
</head>
<body class="d-flex flex-column min-vh-100">

<%@include file="header.jsp"%>

<main class="flex-fill d-flex justify-content-center align-items-center" style="min-height: 80vh;">
    <div class="container">
        <div class="row justify-content-center mb-4 gy-4">
            <div class="col-12 col-md-6 col-lg-5">
                <div class="card p-0">
                    <div class="card-body">
                        <h5 class="card-title">📄 Receitas</h5>
                        <p class="card-text">Acompanhe suas receitas de forma clara e simples.</p>
                        <a href="receita?acao=listar" class="btn btn-dark w-100">Ver Receitas</a>
                    </div>
                </div>
            </div>

            <div class="col-12 col-md-6 col-lg-5">
                <div class="card p-0">
                    <div class="card-body">
                        <h5 class="card-title">💳 Despesas</h5>
                        <p class="card-text">Gerencie suas despesas de forma prática.</p>
                        <a href="despesa?acao=listar" class="btn btn-dark w-100">Ver Despesas</a>
                    </div>
                </div>
            </div>
        </div>

        <div class="row justify-content-center gy-4">
            <div class="col-12 col-md-6 col-lg-5">
                <div class="card p-0">
                    <div class="card-body">
                        <h5 class="card-title">📈 Investimentos</h5>
                        <p class="card-text">Visualize seus investimentos de forma fácil.</p>
                        <a href="investimento?acao=listar" class="btn btn-dark w-100">Ver Investimentos</a>
                    </div>
                </div>
            </div>

            <div class="col-12 col-md-6 col-lg-5">
                <div class="card p-0">
                    <div class="card-body">
                        <h5 class="card-title">🎯 Objetivos</h5>
                        <p class="card-text">Defina e acompanhe seus objetivos financeiros com facilidade.</p>
                        <a href="objetivo?acao=listar" class="btn btn-dark w-100">Ver Objetivos</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>



<%@include file="footer.jsp"%>


<script src="resources/js/bootstrap.bundle.js"></script>
</body>
</html>
