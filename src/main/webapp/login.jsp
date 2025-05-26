<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Login - CenterFin</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>


<nav class="navbar navbar-dark navbar-expand-lg bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">CenterFin</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">

            </ul>

            <c:if test="${empty user}">
                <form class="d-flex" action="login" method="post">
                    <input class="form-control me-2" type="text" name="email" placeholder="E-mail">
                    <input class="form-control me-2" type="password" name="senha" placeholder="Senha">
                    <button class="btn btn-outline-success" type="submit">Entrar</button>
                </form>
            </c:if>

            <c:if test="${not empty user}">
                <span class="navbar-text text-white me-3">
                        ${user}
                </span>
                <a href="login" class="btn btn-outline-primary">Entrar</a>
            </c:if>
        </div>
    </div>
</nav>


<div class="d-flex justify-content-center align-items-center" style="height: calc(100vh - 70px);">
    <div class="login-container">
        <h2 class="text-center text-white mb-4">Login</h2>

        <c:if test="${not empty erro}">
            <div class="alert alert-danger text-center">${erro}</div>
        </c:if>

        <form action="login" method="post">
            <div class="mb-3">
                <label for="email" class="form-label">E-mail</label>
                <input type="text" class="form-control bg-dark text-white" id="email" name="email" required>
            </div>
            <div class="mb-3">
                <label for="senha" class="form-label">Senha</label>
                <input type="password" class="form-control bg-dark text-white" id="senha" name="senha" required>
            </div>
            <div class="d-grid">
                <button type="submit" class="btn btn-primary">Entrar</button>
            </div>
        </form>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

