package br.com.colabore.models.constantes;

public enum StatusDemanda {
    EM_ABERTO,
    PENDENTE,
    BLOQUEADO;

    @Override
    public String toString() {
        return this.name();
    }
}
