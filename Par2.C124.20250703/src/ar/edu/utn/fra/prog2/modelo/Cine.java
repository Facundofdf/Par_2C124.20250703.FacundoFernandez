package ar.edu.utn.fra.prog2.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Facundo
 */
public class Cine implements Serializable {

    private List<Sala> salas;
    private List<Entrada> entradas;

    public Cine() {
        this.salas = new ArrayList<>();
        this.entradas = new ArrayList<>();
        inicializarSalasPorDefecto();
    }

    private void inicializarSalasPorDefecto() {
        salas.add(new Sala(1, "Matrix"));
        salas.add(new Sala(2, "Titanic"));
        salas.add(new Sala(3, "Avengers"));
        salas.add(new Sala(4, "ET"));
        salas.add(new Sala(5, "Shrek"));
    }

    public List<Sala> getSalas() {
        return salas;
    }

    public List<Entrada> getEntradas() {
        return entradas;
    }

    public Sala buscarSalaPorNumero(int numero) {
        for (Sala sala : salas) {
            if (sala.getNumeroSala() == numero) {
                return sala;
            }
        }
        return null;
    }

    public boolean butacaDisponible(Sala sala, int fila, int columna) {
        Butaca butaca = sala.buscarButaca(fila, columna);
        return butaca != null && !butaca.estaOcupada();
    }

    public boolean registrarCompra(Cliente cliente, Sala sala, int fila, int columna) {
        if (butacaDisponible(sala, fila, columna)) {
            Butaca butaca = sala.buscarButaca(fila, columna);
            butaca.ocupar();
            Entrada entrada = new Entrada(cliente, sala, butaca);
            entradas.add(entrada);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return salas.get(0).toString() + "\n"
                + salas.get(1).toString() + "\n"
                + salas.get(2).toString() + "\n"
                + salas.get(3).toString() + "\n"
                + salas.get(4).toString();
    }
}
