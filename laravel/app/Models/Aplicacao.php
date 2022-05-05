<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Aplicacao extends Model
{
    use HasFactory;
    protected $table = 'aplicacoes';
    protected $fillable = ['idPessoa', 'idVacina', 'numDose', 'dataHora'];

    public function pessoa() {
        return $this->belongsTo(Pessoa::class, 'idPessoa');
    }

    public function vacina() {
        return $this->belongsTo(Vacina::class, 'idVacina');
    }
}
