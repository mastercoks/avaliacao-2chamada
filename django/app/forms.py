from django import forms
from django.conf import settings

from app.models import Pessoa, Vacina, Aplicacao
class PessoaForm(forms.ModelForm):    
    class Meta: 
        model = Pessoa
        fields = '__all__'

class VacinaForm(forms.ModelForm):    
    class Meta:
        model = Vacina
        fields = '__all__'

class AplicacaoForm(forms.ModelForm):    
    class Meta:
        model = Aplicacao
        fields = '__all__'