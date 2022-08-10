<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>App</title>
</head>
<body>
    <h1>Cadastrar Vacina</h1>
    <form action="vacina/salvar" method="post">
        <div>
            <label for="nome">Nome</label>
            <input type="text" name="nome" id="nome" required />
        </div>
        <div>
            <label for="doses">Doses</label>
            <input type="number" name="doses" id="doses" required />
        </div>
        <button type="submit">Salvar</button>
    </form>
<%--    <ul>--%>
<%--        <li>--%>
<%--            <a href="aplicacoes">Listar aplicações</a>--%>
<%--        </li>--%>
<%--        <li>--%>
<%--            <a href="aplicacoes/nova">Criar nova aplicação</a>--%>
<%--        </li>--%>
<%--        <li>--%>
<%--            <a href="vacinas">Listar vacinas</a>--%>
<%--        </li>--%>
<%--        <li>--%>
<%--            <a href="vacinas/nova">Criar nova vacina</a>--%>
<%--        </li>--%>
<%--        <li>--%>
<%--            <a href="pessoas">Listar pessoas</a>--%>
<%--        </li>--%>
<%--        <li>--%>
<%--            <a href="pessoas/nova">Criar nova pessoa</a>--%>
<%--        </li>--%>
<%--    </ul>--%>
</body>
</html>