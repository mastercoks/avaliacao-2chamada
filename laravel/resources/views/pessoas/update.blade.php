<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Atualizar {{ $pessoa->nome }}</title>
  </head>
  <body>
    <form action="{{ route('atualizar_pessoa', ['id' => $pessoa->id]) }}" method="post">
      @csrf
        <div>
          <label for="nome">Nome</label>
          <input type="text" name="nome" id="nome" value="{{ $pessoa->nome }}" required />
        </div>
        <div>
          <label for="nascimento">Data de nascimento</label>
          <input type="date" name="nascimento" id="nascimento" value="{{ $pessoa->nascimento }}" required />
        </div>
        <button type="submit">Salvar</button>
    </form>
  </body>
</html>