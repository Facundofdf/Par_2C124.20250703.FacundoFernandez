package ar.edu.utn.fra.prog2.vista;

import ar.edu.utn.fra.prog2.modelo.Cine;
import ar.edu.utn.fra.prog2.modelo.Cliente;
import java.util.List;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Facundo
 */
public class LoginView extends VBox {

    public LoginView(Stage stage, List<Cliente> clientes, Cine cine) {
        Label lblUser = new Label("Nombre de usuario");
        TextField campoUsuario = new TextField();

        Label lblEmail = new Label("Email");
        TextField campoEmail = new TextField();

        Label lblContraseña = new Label("Contraseña");
        PasswordField campoContraseña = new PasswordField();

        Label mensaje = new Label();
        Button btnIngresar = new Button("Ingresar");

        btnIngresar.setOnAction(e -> {
            String nombre = campoUsuario.getText();
            String email = campoEmail.getText();
            String contraseña = campoContraseña.getText();
            Cliente cliente = clientes.getFirst();

            if (nombre.isEmpty() || email.isEmpty() || contraseña.isEmpty()) {
                mensaje.setText("Todos los campos son obligatorios.");
                return;
            }

            if (cliente != null && cliente.validarContrseña(contraseña) && cliente.validarEmail(email)) {
                OperacionesView operaciones = new OperacionesView(stage, clientes, cine);
                stage.setScene(new Scene(operaciones, 300, 300));
            } else {
                mensaje.setText("Mail o contraseña incorrecta");
            }
        });

        setSpacing(10);
        getChildren().addAll(lblUser, campoUsuario,
                lblEmail, campoEmail,
                lblContraseña, campoContraseña,
                mensaje, btnIngresar);
    }
}
