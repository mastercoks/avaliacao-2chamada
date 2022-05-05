<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Lista de aplicacoes</title>
  </head>
  <body>
    <table>
      <tr>
        <th>Pessoa</th>
        <th>Vacina</th>
        <th>Nª de Dose</th>
        <th>Data e Hora da Aplicação</th>
        {{-- <th></th>
        <th></th> --}}
      </tr>
      @foreach ($aplicacoes as $aplicacao)
        <tr>
          <th>{{$aplicacao->pessoa->nome}}</th>
          <th>{{$aplicacao->vacina->nome}}</th>
          <th>{{$aplicacao->numDose}}</th>
          <th>{{$aplicacao->dataHora}}</th>
          {{-- <th>
            <a 
              href="{{ route('editar_aplicacao', ['id'=>$aplicacao->id]) }}"
              title="Editar aplicacao"
            >Editar</a>
          </th>
          <th>
            <a 
              href="{{ route('excluir_aplicacao', ['id'=>$aplicacao->id]) }}"
              title="Excluir aplicacao"
            >Excluir</a>
          </th>
        </tr> --}}
      @endforeach
    </table>
  </body>
</html>