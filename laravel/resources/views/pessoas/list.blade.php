<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Lista de pessoas</title>
  </head>
  <body>
    <table>
      <tr>
        <th>Nome</th>
        <th>Nascimento</th>
        <th></th>
        <th></th>
      </tr>
      @foreach ($pessoas as $pessoa)
        <tr>
          <th>{{$pessoa->nome}}</th>
          <th>{{$pessoa->nascimento}}</th>
          <th>
            <a 
              href="{{ route('editar_pessoa', ['id'=>$pessoa->id]) }}"
              title="Editar pessoa {{ $pessoa->nome }}"
            >Editar</a>
          </th>
          <th>
            <a 
              href="{{ route('excluir_pessoa', ['id'=>$pessoa->id]) }}"
              title="Excluir pessoa {{ $pessoa->nome }}"
            >Excluir</a>
          </th>
        </tr>
      @endforeach
    </table>
  </body>
</html>