package ar.edu.utn.fra.prog2.app;

import ar.edu.utn.fra.prog2.modelo.Cine;
import ar.edu.utn.fra.prog2.modelo.Cliente;
import ar.edu.utn.fra.prog2.persistencia.PersistenciaCine;
import ar.edu.utn.fra.prog2.persistencia.PersistenciaClientes;
import ar.edu.utn.fra.prog2.vista.LoginView;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Facundo
 */
public class Par2C12420250703 extends Application{

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception{
        Cine cine = PersistenciaCine.cargarCine();
        List<Cliente> clientes = PersistenciaClientes.cargarCliente();
        
        LoginView login = new LoginView(stage, clientes, cine);
        Scene escena = new Scene(login, 300, 300);
        
        stage.setTitle("Cine Atlas");
        stage.setScene(escena);
        stage.show();
    }
}
