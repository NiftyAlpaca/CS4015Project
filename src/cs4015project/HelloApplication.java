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
    public static final Model model = Model.getInstance();
    public static final MainView view = MainView.getInstance();

    public static final Controller controller = Controller.getInstance();

    private boolean isSplashLoaded = false;

    private void loadSplash(Node... nodes) throws IOException {
        isSplashLoaded = true;
        Pane pane = FXMLLoader.load(getClass().getResource("hello-view.FXML"));
        view.getChildren().setAll(pane);

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
            view.getChildren().setAll(nodes);
        });
    }

    @Override
    public void start(Stage stage) throws IOException {
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

        TableView<Song> table = new TableView<Song>();
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

        MenuBar menu = new MenuBar();
        Menu file = new Menu("File");
        Menu help = new Menu("Help");
        MenuItem about = new MenuItem("About");
        MenuItem helpWindow = new MenuItem("Help");
        MenuItem addArtist = new MenuItem("Add Artist");
        MenuItem refresh = new MenuItem("Refresh Table");
        help.getItems().addAll(about, helpWindow);
        file.getItems().addAll(addArtist,refresh);
        about.setOnAction(e-> AboutView.display());
        addArtist.setOnAction(e -> AddArtistView.display());
        helpWindow.setOnAction(e -> HelpView.display());
        refresh.setOnAction(e -> table.refresh());
        menu.getMenus().addAll(file,help);

        if(!isSplashLoaded){
            loadSplash(menu, table);
        }

        Scene scene = new Scene(view, 1000, 600);
        stage.setTitle("Song Collection");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}