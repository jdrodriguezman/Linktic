package com.linktic.settlement.exception;
public class ExcepcionSettlement extends RuntimeException {

    // Constructor sin argumentos
    public ExcepcionSettlement() {
        super();
    }

    // Constructor que acepta un mensaje
    public ExcepcionSettlement(String mensaje) {
        super(mensaje);
    }

    // Constructor que acepta un mensaje y una causa
    public ExcepcionSettlement(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }


}