package app.Kap10;

import java.util.ArrayList;

public class Playlist extends SongCollection{

    public Playlist() {
        //Durch die Liste als zu Grunde liegende Collections sind mehrfache Vorkommen möglich.
        super(new ArrayList<>());
    }
    
}
