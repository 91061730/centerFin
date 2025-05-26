<%@ page isErrorPage="true" contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <title>Erro no Sistema</title>
  <style>
    body {
      background-color: #f8d7da;
      font-family: Arial, sans-serif;
      padding: 40px;
      color: #721c24;
    }
    .container {
      background-color: #f5c6cb;
      padding: 20px;
      border-radius: 8px;
      border: 1px solid #f1aeb5;
      max-width: 600px;
      margin: auto;
    }
    h1 {
      margin-top: 0;
    }
    .stacktrace {
      background-color: #fff;
      color: #333;
      padding: 10px;
      margin-top: 15px;
      border-radius: 6px;
      font-size: 0.9em;
      overflow-x: auto;
    }
  </style>
</head>
<body>
<div class="container">
  <h1>Ocorreu um erro inesperado</h1>
  <p>Sentimos muito! Algo deu errado em nosso sistema.</p>
  <p><strong>Erro:</strong> <%= exception.getClass().getSimpleName() %> - <%= exception.getMessage() %></p>

  <div class="stacktrace">
    <pre><%= exception %></pre>
  </div>
</div>
</body>
</html>
