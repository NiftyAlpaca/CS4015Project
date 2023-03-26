package cs4015project;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Facade {

    private TableView<Song> table;
    private MenuBar menu;

    private boolean isSplashLoaded = false;

    public Facade(){
        table = new TableView<Song>();
        menu = new MenuBar();
    }


    public void SetupMainTable(){
        table.setEditable(false);
        TableColumn titleCol = new TableColumn("TITLE");
        titleCol.setMinWidth(300);
        titleCol.setCellValueFactory(
                new PropertyValueFactory<>("titleProperty"));
        TableColumn artistCol = new TableColumn("ARTIST");
        artistCol.setMinWidth(100);
        artistCol.setCellValueFactory(
                new PropertyValueFactory<>("artistLinkProperty"));
        TableColumn albumCol = new TableColumn("ALBUM");
        albumCol.setMinWidth(300);
        albumCol.setCellValueFactory(
                new PropertyValueFactory<>("albumLinkProperty"));
        TableColumn lengthCol = new TableColumn("LENGTH");
        lengthCol.setMinWidth(100);
        lengthCol.setCellValueFactory(
                new PropertyValueFactory<>("lengthProperty"));

        table.getColumns().addAll(titleCol,artistCol, albumCol,lengthCol);
        table.setItems(HelloApplication.model.songCollection().get());
    }

    public void SetupMenu(){
        Menu file = new Menu("File");
        Menu help = new Menu("Help");
        Menu edit = new Menu("Edit");
        MenuItem about = new MenuItem("About");
        MenuItem helpWindow = new MenuItem("Help");
        MenuItem play = new MenuItem("Play");
        MenuItem addArtist = new MenuItem("Add Artist");
        MenuItem refresh = new MenuItem("Refresh Table");
        MenuItem undo = new MenuItem("Undo");
        edit.getItems().addAll(undo);
        help.getItems().addAll(about, helpWindow);
        file.getItems().addAll(play, addArtist,refresh);
        about.setOnAction(e-> AboutView.display());
        play.setOnAction(e -> PlayView.display());
        addArtist.setOnAction(e -> AddArtistView.display());
        helpWindow.setOnAction(e -> HelpView.display());
        refresh.setOnAction(e -> table.refresh());
        undo.setOnAction(e -> Controller.undo());
        menu.getMenus().addAll(file,edit,help);
    }

    public void LoadSplash() throws IOException{
        if(!isSplashLoaded){
            loadSplash(menu, table);
        }
    }

    private void loadSplash(Node... nodes) throws IOException {
        isSplashLoaded = true;
        Pane pane = FXMLLoader.load(getClass().getResource("hello-view.FXML"));
        HelloApplication.view.getChildren().setAll(pane);

        FadeTransition fadeIn = new FadeTransition(Duration.seconds(3), pane);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.setCycleCount(1);

        FadeTransition fadeOut = new FadeTransition(Duration.seconds(3), pane);
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);
        fadeOut.setCycleCount(1);

        fadeIn.play();

        //After fade in, start fade out
        fadeIn.setOnFinished((e) -> {
            fadeOut.play();
        });

        //After fade out, load actual content
        fadeOut.setOnFinished((e) -> {
            HelloApplication.view.getChildren().setAll(nodes);
        });
    }


}
