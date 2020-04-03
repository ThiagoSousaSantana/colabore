package br.com.colabore.models.constantes;

public enum Perfil {
    AMDIN("ADMIN"),
    USER("USER");

    private String perfil;

    Perfil(String perfil) {
        this.perfil = perfil;
    }

    public static Perfil toEnum(String perfil) {
        for (var perfilEnum : Perfil.values()) {
            if (perfilEnum.perfil.equals(perfil)) return perfilEnum;
        }
        return null;
    }

    public String getPerfil() {
        return perfil;
    }
}
