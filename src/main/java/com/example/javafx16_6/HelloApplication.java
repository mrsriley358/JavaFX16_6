package com.example.javafx16_6;
//Dev: Justin Fredericks
//Date:2/26/2022
//Class:171
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        TextField tfTextField = new TextField();
        TextField tfPrefColumnSize = new TextField();

        tfTextField.setAlignment(Pos.BOTTOM_RIGHT);
        tfPrefColumnSize.setAlignment(Pos.BOTTOM_RIGHT);

        tfTextField.setPrefColumnCount(15);
        tfPrefColumnSize.setPrefColumnCount(3);

        HBox hbox1 = new HBox();
        hbox1.setAlignment(Pos.CENTER);
        hbox1.getChildren().addAll(new Label("Text Field"),tfTextField);

        RadioButton rbLeft = new RadioButton("left");
        RadioButton rbCenter = new RadioButton("Center");
        RadioButton rbRight = new RadioButton("Right");

        //Toggle Group implemented in order to have other radio buttons aware of each other
        ToggleGroup group = new ToggleGroup();
        rbCenter.setToggleGroup(group);
        rbLeft.setToggleGroup(group);
        rbRight.setToggleGroup(group);

        HBox hbox2 = new HBox(5);
        hbox2.setAlignment(Pos.CENTER);
        hbox2.getChildren().addAll(rbCenter,rbLeft,rbRight);

        HBox hbox3 = new HBox(5);
        hbox3.getChildren().addAll(new Label("Column Size"),tfPrefColumnSize);

        HBox hbox4 = new HBox(15);
        hbox4.setAlignment(Pos.CENTER);
        hbox4.getChildren().addAll(hbox2, hbox3);

        //Vertical box container to house 2 Hbox containers
        VBox vbox = new VBox(5);
        vbox.getChildren().addAll(hbox1,hbox4);

        Scene scene = new Scene(vbox);
        stage.setTitle("Radio test");
        stage.setScene(scene);
        stage.show();

        //get the txt entered in the txField and parse it into a usable parameter to be used to
        //set column size of the txField
        tfPrefColumnSize.setOnAction(e ->{
            tfTextField.setPrefColumnCount(
                    Integer.parseInt(tfPrefColumnSize.getText())
            );
        });

        //while radio button is checked set txtField alignment
        rbLeft.setOnAction(e -> tfTextField.setAlignment(Pos.BASELINE_LEFT));
        rbCenter.setOnAction(e -> tfTextField.setAlignment(Pos.BASELINE_CENTER));
        rbRight.setOnAction(e -> tfTextField.setAlignment(Pos.BASELINE_RIGHT));
    }

    public static void main(String[] args) {
        launch();
    }
}