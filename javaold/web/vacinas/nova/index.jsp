<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>App</title>
</head>
<body>
<h1>Cadastrar Vacina</h1>
    <form action="salvar" method="post">
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
</body>
</html>