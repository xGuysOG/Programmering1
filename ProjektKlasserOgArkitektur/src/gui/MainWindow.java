package gui;

import com.sun.javafx.scene.layout.PaneHelper;
import controller.Controller;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.*;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class MainWindow extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Theater booking");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private final ListView<Show> lvwShows = new ListView<>();
    private final ListView<Customer> lvwCustomers = new ListView<>();
    private final ListView<Seat> lvwSeats = new ListView<>();
    private final TextField txfShowName = new TextField();
    private final TextField txfShowStartDate = new TextField();
    private final TextField txfShowEndDate = new TextField();
    private final TextField txfCustomerName = new TextField();
    private final TextField txfCustomerPhone = new TextField();
    private final TextField txfOrderDate = new TextField();
    private final Button btnCreateShow = new Button("Create show");
    private final Button btnCreateCustomer = new Button("Create customer");
    private final Button btnCreateOrder = new Button("Create order");
    private final Label lblError = new Label();


    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);
        pane.setGridLinesVisible(true);

        Label lblShows = new Label("Shows");
        pane.add(lblShows,0 ,0);

        Label lblCustomers = new Label("Customers");
        pane.add(lblCustomers,2, 0);

        lvwCustomers.setPrefHeight(250);
        lvwShows.setPrefHeight(250);
        pane.add(lvwShows, 0, 1, 2, 1);
        pane.add(lvwCustomers, 2, 1, 2, 1);

        Label lblShowName = new Label("Name: ");
        Label lblShowStartDate = new Label("Start date: ");
        Label lblShowEndDate = new Label("End date: ");

        pane.add(lblShowName, 0, 2);
        pane.add(lblShowStartDate, 0, 3);
        pane.add(lblShowEndDate, 0, 4);

        pane.add(txfShowName, 1, 2);
        pane.add(txfShowStartDate, 1, 3);
        pane.add(txfShowEndDate, 1, 4);
        pane.add(btnCreateShow, 1, 5);


        Label lblCustomerName = new Label("Customer name:");
        Label lblCustomerPhone = new Label("Customer mobile: ");
        pane.add(lblCustomerName, 2, 2);
        pane.add(lblCustomerPhone, 2, 3);
        pane.add(txfCustomerName, 3, 2);
        pane.add(txfCustomerPhone, 3, 3);
        pane.add(btnCreateCustomer, 3, 4);

        Label lblSeats = new Label("Seats");
        Label lblDate = new Label("Date:");
        pane.add(lblSeats, 4, 0);
        pane.add(lvwSeats, 4, 1, 2, 1);
        lvwSeats.setPrefHeight(250);
        pane.add(lblDate, 4, 2);
        pane.add(txfOrderDate, 5, 2);
        pane.add(btnCreateOrder, 5, 3);

        txfOrderDate.setPromptText("YYYY-MM-DD");
        lvwSeats.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        lvwShows.getItems().setAll(Storage.getShows());
        lvwCustomers.getItems().setAll(Storage.getCustomers());
        lvwSeats.getItems().setAll(Storage.getSeats());

        btnCreateCustomer.setOnAction(event -> btnCreateCustomerAction());
        btnCreateShow.setOnAction(event -> btnCreateShowAction());
        btnCreateOrder.setOnAction(event -> btnCreateOrderAction());

        pane.add(lblError,0 ,6, 4, 1);
        lblError.setVisible(false);
    }

    private void btnCreateShowAction(){
        String name = txfShowName.getText();
        if(name.length()==0){
            errorText("Error: enter name");
            return;}
        LocalDate startDate;
        LocalDate endDate;
        try {
            startDate = LocalDate.parse(txfShowStartDate.getText());
            endDate = LocalDate.parse(txfShowStartDate.getText());
        } catch (Exception e) {
            errorText("Error: date format must be: YYYY-MM-DD");


            return;
        }


        txfShowName.clear();
        txfShowStartDate.clear();
        txfShowEndDate.clear();

        Controller.createShow(name, startDate, endDate);
        updateWindow();
    }


    private void btnCreateCustomerAction(){
        String name = txfCustomerName.getText();
        if(name.length()==0){
            errorText("Error: enter name");
        return;}
        int phone = 0;
        try {
            phone = Integer.parseInt(txfCustomerPhone.getText());
        } catch (Exception e) {
            errorText("Invalid mobile");
            return;
        }


        txfCustomerPhone.clear();
        txfCustomerName.clear();

        Controller.createCustomer(name, phone);
        updateWindow();
    }

    private void btnCreateOrderAction(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Order");
        if(lvwShows.getSelectionModel().getSelectedItems().size() != 1){
            errorText("Select 1 show");
            return;
        }
        if(lvwCustomers.getSelectionModel().getSelectedItems().size() != 1){
            errorText("Select 1 customer");
            return;
        }

        if(lvwSeats.getSelectionModel().getSelectedItems().size() == 0){
            errorText("Select at least one seat");
            return;
        }

        LocalDate orderDate = null;
        try {
            orderDate = LocalDate.parse(txfOrderDate.getText());
        } catch(Exception ex) {
            errorText("date formatting error");
            alert.setHeaderText("Date formatting error");
            alert.setContentText("The date you have input is wrongly formatted");
            alert.show();
            return;
        }
        Show show = lvwShows.getSelectionModel().getSelectedItem();
        boolean validDate = orderDate.isAfter(show.getStartDate().minusDays(1)) && orderDate.isBefore(show.getEndDate().plusDays(1));
        if(!validDate)
        {
            errorText("The selected date is not within the shows range of dates");
            alert.setHeaderText("please try again");
            alert.setContentText("The selected date is not within the available dates of the selected show");
            alert.show();
            return;
        }

        Customer customer = lvwCustomers.getSelectionModel().getSelectedItem();
        ArrayList<Seat> seats = new ArrayList<>(lvwSeats.getSelectionModel().getSelectedItems());
        Order order = Controller.createOrderWithSeats(show,customer,orderDate,seats);
        if(order != null) {
            errorText("Order created");
            alert.setHeaderText("Order for " + customer.getName() + " at " + show.toString());
            alert.setContentText("contains: " + seats.toString());
            alert.show();
            updateWindow();

        } else {
            errorText("Order not created");
            alert.setHeaderText("Order for " + customer.getName() + " at " + show.toString());
            alert.setContentText("was not created as seats are not avaialble");
            alert.show();
        }

        //aight now we need to get what we have clicked on as objects.
        //aight seat selected.


    }

    private void updateWindow(){
        lvwShows.getItems().setAll(Storage.getShows());
        lvwCustomers.getItems().setAll(Storage.getCustomers());
        lblError.setVisible(false);
    }

    private void errorText(String error){
        lblError.setText(error);
        lblError.setTextFill(Color.RED);
        lblError.setVisible(true);
    }
}
