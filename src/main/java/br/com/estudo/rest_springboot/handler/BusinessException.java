package br.com.estudo.rest_springboot.handler;

public class BusinessException extends RuntimeException {

    public BusinessException(String mesagem){
        super(mesagem);
    }

    public BusinessException(String mensagem, Object ... params){
        super(String.format(mensagem, params));
    }

}
