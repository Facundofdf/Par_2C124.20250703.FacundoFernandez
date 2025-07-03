package ar.edu.utn.fra.prog2.persistencia;

import ar.edu.utn.fra.prog2.modelo.Cliente;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Facundo
 */
public class PersistenciaClientes {

    private static final String ARCHIVO_CLIENTES = "clientes.ser";

    public static void guardarClientes(List<Cliente> clientes) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_CLIENTES))) {
            oos.writeObject(clientes);
        } catch (IOException ioe) {
            System.out.println("Error cargando cuenta: " + ioe.getMessage());
        }
    }

    public static List<Cliente> cargarCliente() {
        File archivo = new File(ARCHIVO_CLIENTES);

        if (!archivo.exists()) {
            List<Cliente> clientes = new ArrayList<>();
            clientes.add(new Cliente("Maria", "maria@gmail.com", "1234"));
            clientes.add(new Cliente("Jose", "jose@gmail.com", "1234"));
            clientes.add(new Cliente("Daniel", "daniel@gmail.com", "1234"));
            clientes.add(new Cliente("Ana", "ana@gmail.com", "1234"));
            guardarClientes(clientes);
            return clientes;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (List<Cliente>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error cargando cuenta: " + e.getMessage());
            List<Cliente> clientes = new ArrayList<>();
            clientes.add(new Cliente("Maria", "maria@gmail.com", "1234"));
            clientes.add(new Cliente("Jose", "jose@gmail.com", "1234"));
            clientes.add(new Cliente("Daniel", "daniel@gmail.com", "1234"));
            clientes.add(new Cliente("Ana", "ana@gmail.com", "1234"));
            guardarClientes(clientes);
            return clientes;
        }
    }
}
