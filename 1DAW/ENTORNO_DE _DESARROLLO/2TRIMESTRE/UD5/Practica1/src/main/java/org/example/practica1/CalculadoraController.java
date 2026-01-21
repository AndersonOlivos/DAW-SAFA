package org.example.practica1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalculadoraController {
    @FXML
    private Label label_resultado;
    @FXML
    private TextField inp_numero_1;
    @FXML
    private TextField inp_numero_2;
    @FXML
    private Button btn_sumar;
    @FXML
    private Button btn_restar;
    @FXML
    private Button btn_multiplicar;
    @FXML
    private Button btn_dividir;


    public void onHandleSumar(ActionEvent actionEvent) {
        try {
            Double numero1 = Double.parseDouble(this.inp_numero_1.getText());
            Double numero2 = Double.parseDouble(this.inp_numero_2.getText());
            Double resultado = numero1 + numero2;
            label_resultado.setText(resultado.toString());

            restartColorButtons();
            btn_sumar.setStyle("-fx-background-color: #f1a874");

        } catch (NumberFormatException e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText(null);
            alerta.setContentText("Números inválido. Por favor. revise los números.");
            alerta.showAndWait();
        }
    }

    public void onHandleMultiplicar(ActionEvent actionEvent) {
        try {
            Double numero1 = Double.parseDouble(this.inp_numero_1.getText());
            Double numero2 = Double.parseDouble(this.inp_numero_2.getText());
            Double resultado = numero1 * numero2;
            label_resultado.setText(resultado.toString());

            restartColorButtons();
            btn_multiplicar.setStyle("-fx-background-color: #f1a874");

        } catch (NumberFormatException e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText(null);
            alerta.setContentText("Números inválido. Por favor. reviste los números.");
            alerta.showAndWait();
        }
    }

    public void onHandleDividir(ActionEvent actionEvent) {
        try {
            Double numero1 = Double.parseDouble(this.inp_numero_1.getText());
            Double numero2 = Double.parseDouble(this.inp_numero_2.getText());

            if (numero2 == 0.0) {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Error");
                alerta.setHeaderText(null);
                alerta.setContentText("No es posible dividir entre 0.");
                alerta.showAndWait();
                return;
            }
            Double resultado = numero1 / numero2;
            label_resultado.setText(resultado.toString());

            restartColorButtons();
            btn_dividir.setStyle("-fx-background-color: #f1a874");

        } catch (NumberFormatException e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText(null);
            alerta.setContentText("Números inválido. Por favor. reviste los números.");
            alerta.showAndWait();
        }
    }

    public void onHandleRestar(ActionEvent actionEvent) {
        try {
            Double numero1 = Double.parseDouble(this.inp_numero_1.getText());
            Double numero2 = Double.parseDouble(this.inp_numero_2.getText());
            Double resultado = numero1 - numero2;
            label_resultado.setText(resultado.toString());

            restartColorButtons();
            btn_restar.setStyle("-fx-background-color: #f1a874");

        } catch (NumberFormatException e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText(null);
            alerta.setContentText("Números inválido. Por favor. reviste los números.");
            alerta.showAndWait();
        }
    }

    private void restartColorButtons() {
        if (btn_sumar != null) btn_sumar.setStyle("-fx-background-color: #f97316");
        if (btn_dividir != null) btn_dividir.setStyle("-fx-background-color: #f97316");
        if (btn_multiplicar != null) btn_multiplicar.setStyle("-fx-background-color: #f97316");
        if (btn_restar != null) btn_restar.setStyle("-fx-background-color: #f97316");
    }
}