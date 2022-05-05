<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Cadastrar nova aplicacao</title>
  </head>
  <body>
    <form action="{{ route('salvar_aplicacao') }}" method="post">
      @csrf
        <div>
          <label for="idPessoa">Pessoa</label>
          <select name="idPessoa" id="idPessoa" required >
            @foreach ($pessoas as $pessoa)
              <option value="{{ $pessoa->id }}">{{$pessoa->nome}}</option>
            @endforeach
          </select>
        </div>
        <div>
          <label for="idVacina">Vacina</label>
          <select name="idVacina" id="idVacina" required >
            @foreach ($vacinas as $vacina)
              <option value="{{ $vacina->id }}">{{$vacina->nome}}</option>
            @endforeach
          </select>
        </div>
        <div>
          <label for="numDose">Nº de Dose</label>
          <input type="number" name="numDose" id="numDose" required min="1"/>
        </div>
        <div>
          <label for="dataHora">Data e Hora de Aplicação</label>
          <input type="datetime-local" name="dataHora" id="dataHora" required />
        </div>
        <button type="submit">Salvar</button>
    </form>
  </body>
</html>