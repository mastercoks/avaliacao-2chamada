<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Pessoa extends Model
{
    use HasFactory;
    protected $fillable = ['nome', 'nascimento'];

    public function aplicacoes() {
        return $this->hasMany(Aplicacao::class, 'idPessoa');
    }
}
