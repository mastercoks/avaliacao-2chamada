<?php

use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Route::get('/', function () {
    return view('welcome');
});

Route::get('/aplicacao/nova', 'App\Http\Controllers\AplicacaoController@create')->name('nova_aplicacao');
Route::post('/aplicacao/nova', 'App\Http\Controllers\AplicacaoController@store')->name('salvar_aplicacao');
Route::get('/aplicacao/listar', 'App\Http\Controllers\AplicacaoController@show')->name('listar_aplicacao');

Route::get('/pessoa/nova', 'App\Http\Controllers\PessoaController@create')->name('nova_pessoa');
Route::post('/pessoa/nova', 'App\Http\Controllers\PessoaController@store')->name('salvar_pessoa');
Route::get('/pessoa/listar', 'App\Http\Controllers\PessoaController@show')->name('listar_pessoa');
Route::get('/pessoa/excluir/{id}', 'App\Http\Controllers\PessoaController@destroy')->name('excluir_pessoa');
Route::get('/pessoa/editar/{id}', 'App\Http\Controllers\PessoaController@edit')->name('editar_pessoa');
Route::post('/pessoa/editar/{id}', 'App\Http\Controllers\PessoaController@update')->name('atualizar_pessoa');

Route::get('/vacina/nova', 'App\Http\Controllers\VacinaController@create')->name('nova_vacina');
Route::post('/vacina/nova', 'App\Http\Controllers\VacinaController@store')->name('salvar_vacina');
Route::get('/vacina/listar', 'App\Http\Controllers\VacinaController@show')->name('listar_vacina');
Route::get('/vacina/excluir/{id}', 'App\Http\Controllers\VacinaController@destroy')->name('excluir_vacina');
Route::get('/vacina/editar/{id}', 'App\Http\Controllers\VacinaController@edit')->name('editar_vacina');
Route::post('/vacina/editar/{id}', 'App\Http\Controllers\VacinaController@update')->name('atualizar_vacina');