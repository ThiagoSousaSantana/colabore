package br.com.colabore.models.constantes;

public enum StatusDemanda {
    CONCLUIDO,
    PENDENTE,
    BLOQUEADO;

    @Override
    public String toString() {
        return this.name();
    }
}
