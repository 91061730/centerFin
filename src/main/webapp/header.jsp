


<nav class="navbar navbar-dark navbar-expand-lg bg-dark">
    <div class="container-fluid">

        <a class="navbar-brand text-white fw-bold fs-3" href="index.jsp">CenterFin</a>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarContent" aria-controls="navbarContent"
                aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarContent">

            <ul class="navbar-nav nav-underline mx-auto mb-2 mb-lg-0">

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="receitaDropdown" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">Receita</a>
                    <ul class="dropdown-menu" aria-labelledby="receitaDropdown">
                        <li><a class="dropdown-item" href="receita?acao=listar">Resumo das Receita</a></li>
                        <li><a class="dropdown-item" href="cadastro-receita.jsp">Cadastro Receita</a></li>
                    </ul>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="despesaDropdown" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">Despesa</a>
                    <ul class="dropdown-menu" aria-labelledby="despesaDropdown">
                        <li><a class="dropdown-item" href="despesa?acao=listar">Resumo das Despesas</a></li>
                        <li><a class="dropdown-item" href="cadastro-despesa.jsp">Cadastro Despesa</a></li>
                    </ul>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="investimentoDropdown" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">Investimentos</a>
                    <ul class="dropdown-menu" aria-labelledby="investimentoDropdown">
                        <li><a class="dropdown-item" href="investimento?acao=listar">Resumo dos Investimentos</a></li>
                        <li><a class="dropdown-item" href="cadastro-investimento.jsp">Cadastro dos Investimento</a></li>
                    </ul>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="objetivoDropdown" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">Objetivo Financeiro</a>
                    <ul class="dropdown-menu" aria-labelledby="objetivoDropdown">
                        <li><a class="dropdown-item" href="objetivo?acao=listar">Resumo dos Objetivo Financeiro</a></li>
                        <li><a class="dropdown-item" href="cadastro-objetivoFinanceiro.jsp">Cadastro dos Objetivo Financeiro</a></li>
                    </ul>
                </li>

            </ul>

            <div class="d-flex align-items-center">

                <c:if test="${empty sessionScope.user}">
                    <span class="navbar-text text-danger me-3">${erro}</span>
                    <form class="d-flex" action="login" method="post">
                        <input class="form-control me-2" type="text" name="email" placeholder="E-mail" />
                        <input class="form-control me-2" type="password" name="senha" placeholder="Senha" />
                        <button class="btn btn-outline-success" type="submit">Entrar</button>
                    </form>
                </c:if>

                <c:if test="${not empty sessionScope.user}">
                    <span class="navbar-text text-white me-3">${sessionScope.user}</span>
                    <a href="login?acao=logout" class="btn btn-outline-primary">Sair</a>
                </c:if>

            </div>

        </div>
    </div>
</nav>
