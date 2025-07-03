package ar.edu.utn.fra.prog2.persistencia;

import ar.edu.utn.fra.prog2.modelo.Cine;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Facundo
 */
public class PersistenciaCine {

    private static final String ARCHIVO_CINE = "cine.ser";

    public static void guardarCine(Cine cine) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_CINE))) {
            oos.writeObject(cine);
        } catch (IOException ioe) {
            System.out.println("Error guardando el estado de cuenta: " + ioe.getMessage());
        }
    }

    public static Cine cargarCine() {
        File archivo = new File(ARCHIVO_CINE);

        if (!archivo.exists()) {
            Cine cine = new Cine();
            guardarCine(cine);
            return cine;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (Cine) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            Cine cine = new Cine();
            guardarCine(cine);
            return cine;
        }
    }
}
