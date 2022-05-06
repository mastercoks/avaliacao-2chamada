from django.shortcuts import render
from django.urls import reverse_lazy
from django.views.generic import ListView, CreateView, UpdateView, DeleteView

from app.models import Pessoa, Vacina, Aplicacao

def index(request):
    return render(request, 'home.html')

class PessoaList(ListView):
    model = Pessoa
    queryset = Pessoa.objects.all()
 
class PessoaCreate(CreateView):
    model = Pessoa
    fields = '__all__'
    success_url = reverse_lazy('app:pessoa_list')

class PessoaUpdate(UpdateView):
    model = Pessoa
    fields = '__all__'
    success_url = reverse_lazy('app:pessoa_list')

class PessoaDelete(DeleteView):
    queryset = Pessoa.objects.all()
    success_url = reverse_lazy('app:pessoa_list')
    
class VacinaList(ListView):
    model = Vacina
    queryset = Vacina.objects.all()
 
class VacinaCreate(CreateView):
    model = Vacina
    fields = '__all__'
    success_url = reverse_lazy('app:vacina_list')

class VacinaUpdate(UpdateView):
    model = Vacina
    fields = '__all__'
    success_url = reverse_lazy('app:vacina_list')

class VacinaDelete(DeleteView):
    queryset = Vacina.objects.all()
    success_url = reverse_lazy('app:vacina_list')

class AplicacaoList(ListView):
    model = Aplicacao
    queryset = Aplicacao.objects.all()
 
class AplicacaoCreate(CreateView):
    model = Aplicacao
    fields = '__all__'
    success_url = reverse_lazy('app:aplicacao_list')