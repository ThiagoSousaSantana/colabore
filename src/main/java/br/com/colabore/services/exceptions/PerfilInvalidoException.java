package br.com.colabore.services.exceptions;

public class PerfilInvalidoException extends RuntimeException {
    public PerfilInvalidoException(String mensagem) {
        super(mensagem);
    }
}
