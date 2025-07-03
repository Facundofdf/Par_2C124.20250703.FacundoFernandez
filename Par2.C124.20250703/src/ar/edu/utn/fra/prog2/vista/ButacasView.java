package ar.edu.utn.fra.prog2.vista;

import ar.edu.utn.fra.prog2.modelo.Butaca;
import ar.edu.utn.fra.prog2.modelo.Cine;
import ar.edu.utn.fra.prog2.modelo.Cliente;
import ar.edu.utn.fra.prog2.modelo.Sala;
import ar.edu.utn.fra.prog2.persistencia.PersistenciaCine;
import java.util.List;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Facundo
 */
public class ButacasView extends VBox {

    public ButacasView(Stage stage, List<Cliente> clientes, Cine cine, Sala sala) {
        Label lblButacas = new Label(sala.mostrarMatriz());
        Label lblFila = new Label("Seleccione una fila: ");
        TextField campoFila = new TextField();
        Label lblColumna = new Label("Seleccione una columna: ");
        TextField campoColumna = new TextField();
        Button btnAceptar = new Button("Confirmar compra");
        Button btnCancelar = new Button("Cancelar");
        Label mensaje = new Label();

        btnAceptar.setOnAction(e -> {
            try {
                int fila = Integer.parseInt(campoFila.getText()) - 1;
                int columna = Integer.parseInt(campoColumna.getText()) - 1;

                if (fila < 0 || fila >= 5 || columna < 0 || columna >= 10) {
                    mensaje.setText("Fila o columna fuera de rango");
                    return;
                }

                Butaca butaca = sala.buscarButaca(fila, columna);

                if (butaca.estaOcupada()) {
                    mensaje.setText("Butaca ocupada, seleccione otra butaca porfavor");
                } else {
                    butaca.ocupar();
                    PersistenciaCine.guardarCine(cine);
                    cine.agregarVenta();
                    Alert alerta = new Alert(AlertType.INFORMATION);
                    alerta.setContentText("Compra realizada con exito");
                    alerta.showAndWait();
                    OperacionesView operaciones = new OperacionesView(stage, clientes, cine);
                    stage.setScene(new Scene(operaciones, 300, 300));
                }
            } catch (NumberFormatException nfe) {
                mensaje.setText("Ingrese valores validos porfavor");
            }
        });

        btnCancelar.setOnAction(e -> {
            SalaView salaView = new SalaView(stage, clientes, cine);
            stage.setScene(new Scene(salaView, 300, 300));
        });

        setSpacing(10);
        getChildren().addAll(lblButacas, lblFila, campoFila,
                lblColumna, campoColumna, btnAceptar,
                btnCancelar, mensaje);
    }
}
