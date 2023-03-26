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

public class HelloApplication extends Application {
    public static  Model model = Model.getInstance();
    public static final MainView view = MainView.getInstance();

    public static final Controller controller = Controller.getInstance();


    @Override
    public void start(Stage stage) throws IOException {
        Facade facade = new Facade();
        //All creations below are to prefill the table with examples
        Artist queen = new Artist("Queen");
        Artist joji = new Artist("Joji");

        Album newsOfTheWorld = new Album("News of the World","1997",queen);
        Album nectar = new Album("Nectar","2020", joji);
        Album theGame = new Album("The Game", "1980", queen);
        Song song1 = new Song("We Will Rock You",queen,"1997","2:02",newsOfTheWorld);
        Song song3 = new Song("We Are The Champions", queen, "1997", "2:59",newsOfTheWorld);
        Song song4 = new Song("Sanctuary",joji,"2020","3:27",nectar);
        Song song5 = new Song("Crazy Little Thing Called Love", queen, "1980","2:43", theGame);

        model.addArtist(queen);
        model.addAlbum(newsOfTheWorld);
        model.addSong(song1);
        model.addArtist(joji);
        model.addAlbum(nectar);
        model.addSong(song3);
        model.addSong(song4);
        model.addAlbum(theGame);
        model.addSong(song5);

        facade.SetupMainTable();
        facade.SetupMenu();

        facade.LoadSplash();

        Scene scene = new Scene(view, 1000, 600);
        stage.setTitle("Song Collection");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}