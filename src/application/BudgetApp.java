package application;

import java.time.LocalDate;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BudgetApp extends Application {
	Budget budget = new Budget();
	
	public void start (Stage primaryStage) {
		TextField amountField = new TextField();
        amountField.setPromptText("Amount");

        DatePicker datePicker = new DatePicker();
        ChoiceBox<String> gainBox = new ChoiceBox<>();
        gainBox.getItems().addAll("+", "-");

        TextField typeField = new TextField();
        typeField.setPromptText("Type");

        Button addButton = new Button("Add Transaction");

        ListView<Transaction> transactionList = new ListView<>();

        addButton.setOnAction(e -> {
            char gain = gainBox.getValue().charAt(0);
            double amount = Double.parseDouble(amountField.getText());
            LocalDate date = datePicker.getValue();
            String type = typeField.getText();

            Transaction transaction = new Transaction(gain, amount, date, type);
            budget.addTransaction(transaction);
            transactionList.getItems().setAll(budget.getTransactions());
        });

        VBox layout = new VBox(10, amountField, datePicker, gainBox, typeField, addButton, transactionList);
        Scene scene = new Scene(layout, 1000, 700);

        primaryStage.setTitle("Budget Tracker");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
