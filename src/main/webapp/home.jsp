


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="pt-BR" data-bs-theme="dark">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login - CenterFin</title>


    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Oxygen&display=swap" rel="stylesheet">


    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.1/css/all.min.css" crossorigin="anonymous" />


    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body, html {
            height: 100%;
            font-family: 'Oxygen', sans-serif;
        }

        .form-container {
            max-width: 400px;
            padding: 2rem;
        }

        h1 {
            text-align: center;
            font-size: 40px;
        }

        :root {
            --icon-size: 24px;
            --icon-color: #555;
            --icon-hover-color: #007bff;
        }

        .icon-personalizado {
            display: flex;
            justify-content: center;
            gap: 20px;
            margin-top: 20px;
        }

        .icon-personalizado i {
            font-size: var(--icon-size);
            color: var(--icon-color);
            transition: transform 0.2s ease, color 0.2s ease;
            cursor: pointer;
        }

        .icon-personalizado i:hover {
            color: var(--icon-hover-color);
            transform: scale(1.2);
        }
    </style>
</head>

<body class="d-flex align-items-center py-4 bg-body-tertiary">

<main class="w-100 m-auto form-container">


    <c:if test="${not empty user}">
        <div class="alert alert-success text-center">
            Bem-vindo, <strong>${user}</strong>!
            <form action="login" method="get" class="mt-2">
                <button type="submit" class="btn btn-outline-light btn-sm">Sair</button>
            </form>
        </div>
    </c:if>


    <c:if test="${empty user}">

        <c:if test="${not empty erro}">
            <div class="alert alert-danger text-center">${erro}</div>
        </c:if>


        <form action="login" method="post">
            <h1 class="fw-normal">CenterFin</h1>

            <div class="form-floating mb-3">
                <input type="text" name="email" class="form-control" id="floatingInput" placeholder="E-mail" required>
                <label for="floatingInput">E-mail</label>
            </div>

            <div class="form-floating mb-3">
                <input type="password" name="senha" class="form-control" id="floatingPassword" placeholder="Senha" required>
                <label for="floatingPassword">Senha</label>
            </div>

            <button type="submit" class="btn btn-primary w-100 mb-3">Entrar</button>

            <div class="text-center text-muted mb-2">Entre com:</div>
            <div class="icon-personalizado">
                <i class="fa-brands fa-facebook"></i>
                <i class="fa-brands fa-tiktok"></i>
                <i class="fa-brands fa-google"></i>
            </div>
        </form>
    </c:if>

</main>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
