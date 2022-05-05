<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('aplicacoes', function (Blueprint $table) {
            $table->foreignId('idPessoa')->references('id')->on('pessoas');
            $table->foreignId('idVacina')->references('id')->on('vacinas');
            $table->smallInteger('numDose');
            $table->dateTime('dataHora');
            $table->timestamps();
            $table->primary(['idPessoa', 'idVacina', 'numDose']);
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('aplicacoes');
    }
};
