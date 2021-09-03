package com.example.aula04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.controls.actions.FloatAction;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.aula04.controller.ContatoDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    ListView lvContatos;
    FloatingActionButton fabNovo;

    ContatoDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvContatos = findViewById(R.id.lvContatos);
        fabNovo    = findViewById(R.id.fabNovo);

        dao = new ContatoDAO();

        //Ação de click do button
        fabNovo.setOnClickListener(v -> {
            startActivity(new Intent(this, CadastroActivity.class));
        });

        //A ação de click dos elementos da lista
        lvContatos.setOnItemClickListener((parent, view, position, id) -> { //(qual é o lemento pai, view, position, id )
            Intent intent = new Intent(this, DetalhesActivity.class); //criar um Intent
            intent.putExtra("position", position); //pegar a posição da lista e guardar dentro da posição com um extra
            startActivity(intent); // ai ultiliza a intent para iniciar nossa DetalhesActivity
        });

        //Ação de click longo dos elementos da lista
        lvContatos.setOnItemLongClickListener((parent, view, position, id) ->{
            dao.excluir(position);
            Toast.makeText(this, "Contato Excluido!", Toast.LENGTH_SHORT).show();
            onResume();
            return false;
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        //Setando um adaptador pare a nossa lvContatos, ele serve para adaptar os dados que estamos inserindo dentro dessa List
        lvContatos.setAdapter(new ArrayAdapter<>(
                this,                          //inserindo nessa activity
                android.R.layout.simple_list_item_1, //Qual é o layout, simple_list_item_1 = Formato mais simples de lista q nosso plicativo pode ter
                dao.getAgenda()                     //Nossa fonte de dados, nossa ArrayList para nos retornar todos nosso contatos
        ));

    }

}