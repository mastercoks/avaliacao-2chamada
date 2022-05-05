<!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Laravel</title>
    </head>
    <body class="antialiased">
        <ul>
            <li>
                <a href="{{ route('listar_aplicacao') }}">Listar aplicações</a>
            </li>
            <li>
                <a href="{{ route('nova_aplicacao') }}">Criar nova aplicação</a>
            </li>
            <li>
                <a href="{{ route('listar_vacina') }}">Listar vacinas</a>
            </li>
            <li>
                <a href="{{ route('nova_vacina') }}">Criar nova vacina</a>
            </li>
            <li>
                <a href="{{ route('listar_pessoa') }}">Listar pessoas</a>
            </li>
            <li>
                <a href="{{ route('nova_pessoa') }}">Criar nova pessoa</a>
            </li>
        </ul>
    </body>
</html>
