<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Lista de vacinas</title>
  </head>
  <body>
    <table>
      <tr>
        <th>Nome</th>
        <th>Nascimento</th>
        <th></th>
        <th></th>
      </tr>
      @foreach ($vacinas as $vacina)
        <tr>
          <th>{{$vacina->nome}}</th>
          <th>{{$vacina->doses}}</th>
          <th>
            <a 
              href="{{ route('editar_vacina', ['id'=>$vacina->id]) }}"
              title="Editar vacina {{ $vacina->nome }}"
            >Editar</a>
          </th>
          <th>
            <a 
              href="{{ route('excluir_vacina', ['id'=>$vacina->id]) }}"
              title="Excluir vacina {{ $vacina->nome }}"
            >Excluir</a>
          </th>
        </tr>
      @endforeach
    </table>
  </body>
</html>