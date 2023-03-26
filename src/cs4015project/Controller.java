package cs4015project;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Controller {

    private static Controller instance;

    private Controller(){}

    public static Controller getInstance(){
        if(instance == null){
            instance = new Controller();
        }
        return instance;
    }

    public static void addSong(String title, Album album, String length, Label error, Stage popup){
        Song newSong = new Song(title, album.artistObjectProperty().get(), album.publishDateProperty.get(), length, album);
        Command commandAddSong = new CommandAddSong(newSong);
        commandAddSong.execute();
        HelloApplication.commandHistory.push(commandAddSong);
        if(HelloApplication.model.result == -1){
            error.setTextFill(Color.color(1,0,0));
            error.setText("ERROR: Duplicate");
        }
        else{
            error.setText("");
            popup.close();
        }
    }

    public static void addAlbum(Artist artist, String albumTitle, String albumDate, String songTitle, String songDate, String songLength, Label error, Stage popup){

        Album album = new Album(albumTitle, albumDate, artist);
        HelloApplication.model.addAlbum(album);
        if(HelloApplication.model.result == -1){
            error.setText("ERROR: Duplicate");
        }
        else{
            error.setText("");
            popup.close();
        }

        Song song = new Song(songTitle, artist, songDate, songLength, album);
        Command commandAddSong = new CommandAddSong(song);
        commandAddSong.execute();
        HelloApplication.commandHistory.push(commandAddSong);
        if(HelloApplication.model.result == -1){
            error.setText("ERROR: Duplicate");
        }
        else{
            error.setText("");
            popup.close();
        }
    }

    public static void addArtist(String name, String albumTitle, String albumDate, String songTitle, String songDate, String songLength, Label error, Stage popup){
        Artist artist = new Artist(name);
        CommandAddArtist addArtist = new CommandAddArtist(artist);
        addArtist.execute();
        HelloApplication.commandHistory.push(addArtist);
        if(HelloApplication.model.result == -1){
            error.setText("ERROR: Duplicate");
        }
        else{
            error.setText("");
            popup.close();
        }

        Album album = new Album(albumTitle, albumDate, artist);
        HelloApplication.model.addAlbum(album);
        if(HelloApplication.model.result == -1){
            error.setText("ERROR: Duplicate");
        }
        else{
            error.setText("");
            popup.close();
        }

        Song song = new Song(songTitle, artist, songDate, songLength, album);
        Command commandAddSong = new CommandAddSong(song);
        commandAddSong.execute();
        HelloApplication.commandHistory.push(commandAddSong);
        if(HelloApplication.model.result == -1){
            error.setText("ERROR: Duplicate");
        }
        else{
            error.setText("");
            popup.close();
        }
    }

    public static void editSong(Song song, String newTitle, String newDate, String newLength, Label error, Stage popup){
        HelloApplication.model.getSongCollection().EditSong(song, newTitle,newDate,newLength);
        if(HelloApplication.model.result == -1){
            error.setText("ERROR: Duplicate");
        }
        else{
            error.setText("");
            popup.close();
        }
    }

    public static void undo()
    {
        if (!HelloApplication.commandHistory.isEmpty())
            HelloApplication.commandHistory.pop().undo();
    }

}
