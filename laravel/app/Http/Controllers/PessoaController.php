<?php

namespace App\Http\Controllers;

use App\Models\Pessoa;
use Illuminate\Http\Request;

class PessoaController extends Controller
{
    public function create() {
        return view('pessoas.create');
    }

    public function store(Request $request) {
        Pessoa::create([
            'nome' => $request->nome,
            'nascimento' => $request->nascimento,
        ]);
        return "Pessoa salva com sucesso";
    }

    public function show() {
        $pessoas = Pessoa::all();
        return view('pessoas.list', ['pessoas' => $pessoas]);
    }

    public function destroy($id) {
        $pessoa = Pessoa::findOrFail($id);
        $pessoa->delete();
        return "Pessoa excluida com sucesso!";
    }

    public function edit($id) {
        $pessoa = Pessoa::findOrFail($id);
        return view('pessoas.update', ['pessoa' => $pessoa]);
    }

    public function update(Request $request, $id) {
        $pessoa = Pessoa::findOrFail($id);
        $pessoa->update([
            'nome' => $request->nome,
            'nascimento' => $request->nascimento,
        ]);
        return "Pessoa atualizada com sucesso";
    }
}
