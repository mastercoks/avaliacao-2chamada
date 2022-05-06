from django.urls import path

from app import views

app_name = 'app'

urlpatterns = [
    path('', views.index, name='index'),
    path('pessoas/', views.PessoaList.as_view(), name='pessoa_list'),
    path('pessoas/create/', views.PessoaCreate.as_view(), name='pessoa_create'),
    path('pessoas/update/<int:pk>/', views.PessoaUpdate.as_view(), name='pessoa_update'),
    path('pessoas/delete/<int:pk>/', views.PessoaDelete.as_view(), name='pessoa_delete'),
    path('vacinas/', views.VacinaList.as_view(), name='vacina_list'),
    path('vacinas/create/', views.VacinaCreate.as_view(), name='vacina_create'),
    path('vacinas/update/<int:pk>/', views.VacinaUpdate.as_view(), name='vacina_update'),
    path('vacinas/delete/<int:pk>/', views.VacinaDelete.as_view(), name='vacina_delete'),
    path('aplicacoes/', views.AplicacaoList.as_view(), name='aplicacao_list'),
    path('aplicacoes/create/', views.AplicacaoCreate.as_view(), name='aplicacao_create')
]
 