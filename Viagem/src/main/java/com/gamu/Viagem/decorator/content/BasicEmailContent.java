package com.gamu.Viagem.decorator.content;


import com.gamu.Viagem.decorator.interfce.EmailContent;

public class BasicEmailContent implements EmailContent {

    @Override
    public String generateContent(String nome) {
        return "Voo para " + nome + " Cadastrado." + "\n\nSeu cadastro foi realizado com sucesso!";
    }

}
