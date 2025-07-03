package ar.edu.utn.fra.prog2.vista;

import ar.edu.utn.fra.prog2.modelo.Cine;
import ar.edu.utn.fra.prog2.modelo.Cliente;
import java.util.List;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Facundo
 */
public class OperacionesView extends VBox {

    public OperacionesView(Stage stage, List<Cliente> clientes, Cine cine) {
        Label bienvenida = new Label("Bienvenido/a ");
        Button btnSala = new Button("Seleccionar sala");
        Button btnSalir = new Button("Salir");

        btnSala.setOnAction(e -> {
            SalaView sala = new SalaView(stage, clientes, cine);
            stage.setScene(new Scene(sala, 300, 300));
        });

        btnSalir.setOnAction(e -> {
            LoginView login = new LoginView(stage, clientes, cine);
            stage.setScene(new Scene(login, 300, 300));
        });

        setSpacing(10);
        getChildren().addAll(bienvenida, btnSala, btnSalir);
    }
}
