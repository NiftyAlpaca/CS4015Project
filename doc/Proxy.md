## <ins> Proxy Pattern

We use the Proxy Pattern to provide a placeholder for the master list of songs songCollection. The proxy 
controls access to the list which acts like a database for the entire application.

To implement the Proxy Pattern, we created a new object called SongCollection() that holds an instance of the list songCollection.
The client interacts with the list through the Model class which holds a reference to a SongCollection() object.

Below is some pseudocode to show the interactions. 

```
    public class Client{
        main(){
            model.addSong(Song song);
        }
    }
    
    public interface SongCollection{
        addSong(Song song);
    }
    
    public class Model{
        SongCollection songCollection;
        
        addSong(Song song){
            songCollection.addSong(Song song);
        }
    }
    
    public class ProxySongCollection{
       SongCollection songCollection = new RealSongCollection();
       
       addSong(Song song){
            songCollection.addSong(Song song)
       }
    }
    
    public class RealSongCollection{
        SimpleListProperty<Song> songCollection;
        
        addSong(Song song){
            //Complete steps to actually add the song to the list.
        }
    }
```

Here is the UML representation: 

