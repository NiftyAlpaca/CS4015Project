package cs4015project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class MainView extends VBox{

    private static MainView instance;
    private MainView(Node... children){

    }

    public static MainView getInstance(){
        if(instance == null){
            instance = new MainView();
        }
        return instance;
    }

}
