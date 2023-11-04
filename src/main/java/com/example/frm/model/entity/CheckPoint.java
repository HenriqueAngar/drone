package com.example.frm.model.entity;

public class CheckPoint extends Location{

    private int ordem;

    private boolean ultrapassado;

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    public boolean isUltrapassado() {
        return ultrapassado;
    }

    public void setUltrapassado(boolean ultrapassado) {
        this.ultrapassado = ultrapassado;
    }
}
