package com.apirest_ude.api_rest.utils;

public enum Orders_status {
    WAITTTING_PAYMENT(1),PAID(2), SHIPPED(3), DELIVEED(4), CANCELED(5);
    private int cod;

    //metodo contrutor de enuns e private
    private Orders_status(int num){
        this.cod = num;
    }

    public int getCod(){
        return cod;
    }

    public static Orders_status valueOf(int cod) throws IllegalAccessException {
        for (Orders_status value: Orders_status.values()){//percorre todos os valores possiveis do enum
            if(value.getCod() == cod){//testa se o primeiro valor e igual ao codigo que estou pedindo
                return value;
            }
        }
        throw new IllegalAccessException("Codigo_invalido_order_status");
    }

}
