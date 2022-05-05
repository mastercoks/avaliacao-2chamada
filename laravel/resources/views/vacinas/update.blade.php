<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Atualizar {{ $vacina->nome }}</title>
  </head>
  <body>
    <form action="{{ route('atualizar_vacina', ['id' => $vacina->id]) }}" method="post">
      @csrf
        <div>
          <label for="nome">Nome</label>
          <input type="text" name="nome" id="nome" value="{{ $vacina->nome }}" required />
        </div>
        <div>
          <label for="doses">Doses</label>
          <input type="number" name="doses" id="doses" value="{{ $vacina->doses }}" required />
        </div>
        <button type="submit">Salvar</button>
    </form>
  </body>
</html>