package br.com.ruderson.portfolio_restful.services.exceptions;

public class ForbiddenException extends RuntimeException{
    public ForbiddenException(String msg) {
        super(msg);
    }
}
