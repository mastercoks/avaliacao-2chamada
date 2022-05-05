<?php

namespace App\Http\Controllers;

use App\Models\Vacina;
use Illuminate\Http\Request;

class VacinaController extends Controller
{
    public function create() {
        return view('vacinas.create');
    }

    public function store(Request $request) {
        Vacina::create([
            'nome' => $request->nome,
            'doses' => $request->doses,
        ]);
        return "Vacina salva com sucesso!";
    }

    public function show() {
        $vacinas = Vacina::all();
        return view('vacinas.list', ['vacinas' => $vacinas]);
    }

    public function destroy($id) {
        $vacina = Vacina::findOrFail($id);
        $vacina->delete();
        return "Vacina excluida com sucesso!";
    }

    public function edit($id) {
        $vacina = Vacina::findOrFail($id);
        return view('vacinas.update', ['vacina' => $vacina]);
    }

    public function update(Request $request, $id) {
        $vacina = Vacina::findOrFail($id);
        $vacina->update([
            'nome' => $request->nome,
            'doses' => $request->doses,
        ]);
        return "Vacina atualizada com sucesso";
    }
}
