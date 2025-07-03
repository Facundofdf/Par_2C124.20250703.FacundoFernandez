package ar.edu.utn.fra.prog2.vista;

import ar.edu.utn.fra.prog2.modelo.Cine;
import ar.edu.utn.fra.prog2.modelo.Cliente;
import ar.edu.utn.fra.prog2.modelo.Sala;
import java.util.List;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Facundo
 */
public class SalaView extends VBox {

    public SalaView(Stage stage, List<Cliente> clientes, Cine cine) {
        Label lblSeleccion = new Label("Seleccione una sala porfavor");
        Label lblSalas = new Label(cine.toString());
        TextField campoNumeroSala = new TextField();
        Button btnAceptar = new Button("Aceptar");
        Button btnCancelar = new Button("Cancelar");
        Label mensaje = new Label();

        btnAceptar.setOnAction(e -> {
            try {
                int numero = Integer.parseInt(campoNumeroSala.getText());
                Sala salaSeleccionada = cine.buscarSalaPorNumero(numero);
                if (salaSeleccionada != null) {
                    ButacasView butacas = new ButacasView(stage, clientes, cine, salaSeleccionada);
                    stage.setScene(new Scene(butacas, 500, 500));
                } else {
                    mensaje.setText("La sala no existe");
                }
            } catch (NumberFormatException nfe) {
                mensaje.setText("Ingrese el NUMERO de la sala porfavor");
            }
        });

        btnCancelar.setOnAction(e -> {
            OperacionesView operaciones = new OperacionesView(stage, clientes, cine);
            stage.setScene(new Scene(operaciones, 300, 300));
        });

        setSpacing(10);
        getChildren().addAll(lblSalas, lblSeleccion,
                campoNumeroSala, btnAceptar,
                btnCancelar, mensaje);
    }
}
