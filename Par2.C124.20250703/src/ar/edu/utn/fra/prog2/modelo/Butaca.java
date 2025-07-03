package ar.edu.utn.fra.prog2.modelo;

import java.io.Serializable;

/**
 *
 * @author Facundo
 */
public class Butaca implements Serializable {

    private int numeroButaca;
    private int numeroFila;
    private boolean ocupada;

    public Butaca(int numeroButaca, int numeroFila) {
        this.numeroButaca = numeroButaca;
        this.numeroFila = numeroFila;
        this.ocupada = false;
    }

    public int getNumeroButaca() {
        return numeroButaca;
    }

    public int getNumeroFila() {
        return numeroFila;
    }

    public boolean estaOcupada() {
        return ocupada;
    }

    public void ocupar() {
        this.ocupada = true;
    }

    public void liberar() {
        this.ocupada = false;
    }
}
