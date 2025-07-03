package ar.edu.utn.fra.prog2.modelo;

import java.io.Serializable;

/**
 *
 * @author Facundo
 */
public class Sala implements Serializable {

    private int numeroSala;
    private String pelicula;
    private Butaca[][] butacas;

    private static final int FILAS = 5;
    private static final int COLUMNAS = 10;

    public Sala(int numeroSala, String pelicula) {
        this.numeroSala = numeroSala;
        this.pelicula = pelicula;
        this.butacas = new Butaca[FILAS][COLUMNAS];

        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                butacas[i][j] = new Butaca(j + 1, i + 1);
            }
        }
    }

    public Butaca[][] getButacas() {
        return butacas;
    }

    public int getNumeroSala() {
        return numeroSala;
    }

    public String getPelicula() {
        return pelicula;
    }

    public Butaca buscarButaca(int fila, int columna) {
        if (fila >= 0 && fila < FILAS && columna >= 0 && columna < COLUMNAS) {
            return butacas[fila][columna];
        }
        return null;
    }

    @Override
    public String toString() {
        return "Sala: " + numeroSala + " - " + pelicula;
    }

    public String mostrarMatriz() {
        String matriz = "Matriz de butacas (\"[*]\" = Ocupada, \"[ ]\" = Libre)\n\n";

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                matriz += butacas[i][j].estaOcupada() ? "[*]" : "[]";
            }
            matriz += "\n";
        }
        return matriz;
    }
}
