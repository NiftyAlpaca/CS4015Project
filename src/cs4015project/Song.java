package cs4015project;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Hyperlink;

public class Song{
    protected SimpleStringProperty titleProperty,releaseDateProperty,lengthProperty;
    public SimpleObjectProperty<Album> albumObjectProperty;
    public SimpleObjectProperty<Artist> artistObjectProperty;

    private SimpleObjectProperty<Hyperlink> artistLinkProperty;
    private SimpleObjectProperty<Hyperlink> albumLinkProperty;

    private SimpleObjectProperty<Hyperlink> removeLinkProperty;

    private SimpleObjectProperty<Hyperlink> editLinkProperty;

    public Song(String title, Artist artist, String releaseDate, String length, Album album){
        this.titleProperty = new SimpleStringProperty(title);
        this.artistObjectProperty = new SimpleObjectProperty<Artist>(artist);
        this.releaseDateProperty = new SimpleStringProperty(releaseDate);
        this.lengthProperty = new SimpleStringProperty(length);
        this.albumObjectProperty = new SimpleObjectProperty<Album>(album);

        artistLinkProperty = new SimpleObjectProperty<Hyperlink>(new Hyperlink(artist.nameProperty.get()));
        albumLinkProperty = new SimpleObjectProperty<Hyperlink>(new Hyperlink(album.titleProperty.get()));
        removeLinkProperty = new SimpleObjectProperty<Hyperlink>(new Hyperlink("Remove"));
        editLinkProperty = new SimpleObjectProperty<Hyperlink>(new Hyperlink("Edit"));


        getAlbumLinkProperty().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                AlbumView.display(albumObjectProperty.get());
            }
        });

        getArtistLinkProperty().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ArtistView.display(artistObjectProperty.get());
            }
        });

        getRemoveLinkProperty().setOnAction(e -> HelloApplication.model.getSongCollection().RemoveSong(this));

        getEditLinkProperty().setOnAction(e -> EditView.display(this));
    }

    public SimpleObjectProperty<Artist> ArtistObjectProperty(){return artistObjectProperty;}

    public SimpleObjectProperty<Album> AlbumObjectProperty(){return albumObjectProperty;}

    public String getTitleProperty(){ return titleProperty.get();}

    public Hyperlink getArtistLinkProperty(){return artistLinkProperty.get();}

    public Hyperlink getAlbumLinkProperty(){return albumLinkProperty.get();}

    public String getAlbumObjectProperty(){
        return albumObjectProperty.get().titleProperty.get();
    }

    public String getArtistObjectProperty(){return artistObjectProperty.get().nameProperty.get();}

    public String getLengthProperty(){
        return lengthProperty.get();
    }

    public Hyperlink getRemoveLinkProperty(){return removeLinkProperty.get();}

    public Hyperlink getEditLinkProperty(){return editLinkProperty.get();}

    public void setTitle(String title){
        titleProperty.set(title);
    }

    public void setDate(String date){
        releaseDateProperty.set(date);
    }

    public void setLength(String length){
        lengthProperty.set(length);
    }



    public String toString(){
        return titleProperty.get() + ", " + artistObjectProperty.get().nameProperty.get() + ", " + releaseDateProperty.get() + ", " + lengthProperty.get() + ", " + albumObjectProperty.get().titleProperty.get();
    }





}
