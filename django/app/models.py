from django.core.validators import MinValueValidator
from django.db import models

class Pessoa(models.Model):
  nome = models.CharField(max_length=100)
  nascimento = models.DateField()

  def __str__(self):
      return self.nome

class Vacina(models.Model):
  nome = models.CharField(max_length=100) 
  doses = models.SmallIntegerField(validators=[MinValueValidator(1)])

  def __str__(self):
      return self.nome

class Aplicacao(models.Model):
  pessoa = models.ForeignKey(Pessoa, db_column='idPessoa', on_delete=models.CASCADE)
  vacina = models.ForeignKey(Vacina, db_column='idVacina', on_delete=models.CASCADE)
  numDose = models.SmallIntegerField(validators=[MinValueValidator(1)])
  dataHora = models.DateTimeField()

  class Meta:
        constraints = [
            models.UniqueConstraint(fields=['pessoa', 'vacina', 'numDose'], name='unique_pk')
        ]

  def __str__(self):
      return self.numDose