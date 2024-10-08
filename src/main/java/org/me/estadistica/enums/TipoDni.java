package org.me.estadistica.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoDni {
    LIBRETA_DE_ENROLAMIENTO(25, "LIBRETA DE ENROLAMIENTO"),
    LIBRETA_CIVICA(26, "LIBRETA CÍVICA"),
    DOCUMENTO_UNICO(29, "DOCUMENTO UNICO");

    private final int codigo;
    private final String tipo;

    public String getCodigoString(){
        return String.valueOf(this.codigo);
    }

}
