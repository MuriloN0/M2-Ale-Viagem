package com.gamu.Viagem.decorator;


import com.gamu.Viagem.decorator.interfce.EmailContent;


public class SignatureDecorator extends EmailContentDecorator{

    public SignatureDecorator(EmailContent wrapped) {
        super(wrapped);
    }

    @Override
    public String generateContent(String nome) {
        return wrapped.generateContent(nome) + "\n\nAtenciosamente,\nEquipe Viagem";
    }

}
