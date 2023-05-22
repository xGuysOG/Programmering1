package presentation;

import application.controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class StartWindow extends Application {


    @Override
    public void init() {
        Controller.initStorage();
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Konference Administration");
        BorderPane pane = new BorderPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private void initContent(BorderPane pane) {
        TabPane tabPane = new TabPane();
        this.initTabPane(tabPane);
        pane.setCenter(tabPane);
    }

    private void initTabPane(TabPane tabPane) {
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

//        Tab tabCreate = new Tab("Opret");
//        tabPane.getTabs().add(tabCreate);
//
//        CreateParticipantPane createParticipantPane = new CreateParticipantPane(tabPane);
//        tabCreate.setContent(createParticipantPane);

        Tab tabRegister = new Tab("Tilmeld");
        tabPane.getTabs().add(tabRegister);
//        tabRegister.setDisable(true);
        tabRegister.setContent(new SignupPane(tabPane));

        Tab tabOverview = new Tab("Konference Oversigt");
        tabPane.getTabs().add(tabOverview);

        OverviewPane overviewPane = new OverviewPane();
        tabOverview.setContent(overviewPane);
    }
}
