package com.gamu.Viagem.builder;

import com.gamu.Viagem.entity.Voo;
import jakarta.persistence.Column;

import java.util.Date;

public class VooBuilder {

    private long id;
    private String destino;
    private String localIda;
    private String diaIda;
    private String horaIda;
    private String localVolta;
    private String diaVolta;
    private String horaVolta;

    public VooBuilder() {
    }

        public VooBuilder id(long id) {
            this.id = id;
            return this;
        }

        public VooBuilder destino(String destino) {
            this.destino = destino;
            return this;
        }

        public VooBuilder localIda(String localIda) {
            this.localIda = localIda;
            return this;
        }

        public VooBuilder diaIda(String diaIda) {
            this.diaIda = diaIda;
            return this;
        }

        public VooBuilder horaIda(String horaIda) {
            this.horaIda = horaIda;
            return this;
        }

        public VooBuilder localVolta(String localVolta) {
            this.localVolta = localVolta;
            return this;
        }

        public VooBuilder diaVolta(String diaVolta) {
            this.diaVolta = diaVolta;
            return this;
        }

        public VooBuilder horaVolta(String horaVolta) {
            this.horaVolta = horaVolta;
            return this;
        }



        public Voo build() {
            Voo voo = new Voo();
            voo.setId(this.id);
            voo.setDestino(this.destino);
            voo.setLocalIda(this.localIda);
            voo.setDiaIda(String.valueOf(this.diaIda));
            voo.setHoraIda(String.valueOf(this.horaIda));
            voo.setLocalVolta(this.localVolta);
            voo.setDiaVolta(this.diaVolta);
            voo.setHoraVolta(this.horaVolta);

            return voo;
        }
}
