<?php
 
namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
 
class Vacina extends Model
{
    use HasFactory;
    protected $fillable = ['nome', 'doses'];

    public function aplicacoes() {
        return $this->hasMany(Aplicacao::class, 'idVacina');
    }
}
