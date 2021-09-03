package com.example.aula04.controller;

import com.example.aula04.model.Contato;

import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {

    private static List<Contato> agenda= new ArrayList<>();

    public void salvar(Contato contato){
        agenda.add(contato);
    }

    public void excluir(int position){
        agenda.remove(position);
    }

    public Contato getContato(int position){
        return agenda.get(position);
    }

    //retornar ArrayList
    public List<Contato> getAgenda(){
        return agenda;
    }
}

