# Generated by Django 3.1.7 on 2022-05-06 07:08

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('app', '0002_auto_20220506_0638'),
    ]

    operations = [
        migrations.RenameField(
            model_name='aplicacao',
            old_name='idPessoa',
            new_name='pessoa',
        ),
        migrations.RenameField(
            model_name='aplicacao',
            old_name='idVacina',
            new_name='vacina',
        ),
    ]
