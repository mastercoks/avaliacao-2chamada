<?php

namespace App\Http\Controllers;

use App\Models\Aplicacao;
use App\Models\Pessoa;
use App\Models\Vacina;
use Illuminate\Http\Request;

class AplicacaoController extends Controller
{
    public function create() {
        $pessoas = Pessoa::all();
        $vacinas = Vacina::all();
        return view('aplicacoes.create', ['pessoas' => $pessoas, 'vacinas' => $vacinas]);
    }

    public function store(Request $request) {
        $aplicacao = Aplicacao::where('idPessoa', $request->idPessoa)
            ->where('idVacina', $request->idVacina)
            ->where('numDose', $request->numDose)
            ->exists();

        if ($aplicacao) {
            return "Já existe uma aplicação desta dose para esta vacina para esta pessoa ";
        }

        $vacina = Vacina::findOrFail($request->idVacina);

        if ($request->numDose <= 0) {
            return "Numero de dose não pode ser menor que zero";
        }

        if ($request->numDose > $vacina->doses) {
            return "Numero de dose acima do maximo permitido da vacina";
        }

        Aplicacao::create([
            'idPessoa' => $request->idPessoa,
            'idVacina' => $request->idVacina,
            'numDose' => $request->numDose,
            'dataHora' => $request->dataHora,
        ]);
        return "Aplicacao salva com sucesso";
    }

    public function show() {
        $aplicacoes = Aplicacao::all();
        return view('aplicacoes.list', ['aplicacoes' => $aplicacoes]);
    }
}
