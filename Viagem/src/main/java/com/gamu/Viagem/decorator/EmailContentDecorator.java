package com.gamu.Viagem.decorator;


import com.gamu.Viagem.decorator.interfce.EmailContent;


public abstract class EmailContentDecorator implements EmailContent{

    protected EmailContent wrapped;

    public EmailContentDecorator(EmailContent wrapped) {
        this.wrapped = wrapped;
    }

}
