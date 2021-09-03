package com.example.aula04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.aula04.controller.ContatoDAO;
import com.example.aula04.model.Contato;

public class DetalhesActivity extends AppCompatActivity {

    TextView tvNome;
    TextView tvFone;
    TextView tvEmail;

    ContatoDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        tvNome  = findViewById(R.id.tvNome);
        tvFone  = findViewById(R.id.tvFone);
        tvEmail = findViewById(R.id.tvEmail);

        dao = new ContatoDAO();

        Intent intent = getIntent();

        int position = intent.getIntExtra("position", -1); //variavel que vai receber a posição , -1 caso o array esteja vazio "Tratar"

        if (position == -1){finish(); }

        Contato contato = dao.getContato(position); //buscar um contato especifico na ArrayList nessa position

        //Alimentar nossos TextViews
        tvNome.setText(contato.getNome());
        tvFone.setText(contato.getFone());
        tvEmail.setText(contato.getEmail());
    }
}