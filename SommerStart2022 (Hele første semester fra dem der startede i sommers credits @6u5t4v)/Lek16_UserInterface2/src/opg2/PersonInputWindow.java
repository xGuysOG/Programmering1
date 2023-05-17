package opg2;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PersonInputWindow extends Stage {

    public PersonInputWindow(String title, Stage owner) {
        this.initOwner(owner);
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setMinHeight(100);
        this.setMinWidth(200);
        this.setResizable(false);

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    // -------------------------------------------------------------------------

    private final TextField txfName = new TextField();
    private final TextField txfTitle = new TextField();
    private final CheckBox chbSenior = new CheckBox("Senior");

    private Person actualPerson = null;

    private void initContent(GridPane pane) {
        // pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label labelName = new Label("Name:");
        pane.add(labelName, 0, 0);
        pane.add(txfName, 1, 0);
        Label labelTitle = new Label("Title:");
        pane.add(labelTitle, 0, 1);
        pane.add(txfTitle, 1, 1);
        pane.add(chbSenior, 0, 2);

        HBox buttonBox = new HBox(20);
        pane.add(buttonBox, 0, 3);
        buttonBox.setPadding(new Insets(10, 10, 0, 10));
        buttonBox.setAlignment(Pos.BOTTOM_CENTER);

        Button btnCancel = new Button("Cancel");
        buttonBox.getChildren().add(btnCancel);
        btnCancel.setOnAction(event -> this.cancelAction());

        Button btnOK = new Button("OK");
        buttonBox.getChildren().add(btnOK);
        btnOK.setOnAction(event -> this.okAction());
    }

    // -------------------------------------------------------------------------
    // Button actions

    private void cancelAction() {
        txfTitle.clear();
        txfTitle.requestFocus();
        txfName.clear();
        actualPerson = null;
        PersonInputWindow.this.hide();
    }

    private void okAction() {
        String name = txfName.getText().trim();
        String title = txfTitle.getText().trim();

        if (title.length() > 0 && name.length() > 0) {
            actualPerson = new Person(name, title, chbSenior.isSelected());
            txfTitle.clear();
            txfName.clear();
            chbSenior.setSelected(false);
            txfTitle.requestFocus();
            PersonInputWindow.this.hide();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Create person");
            alert.setHeaderText("Information missing");
            alert.setContentText("Type name and title");
            alert.show();
        }
    }

    // -------------------------------------------------------------------------

    public Person getActualPerson() {
        return actualPerson;
    }

    public void clearActualPerson() {
        actualPerson = null;
    }
}
