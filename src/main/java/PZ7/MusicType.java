package PZ7;

/**
 * Created by gaara on 4/24/17.
 */
public class MusicType extends Entity {
    private String musicType;

    public MusicType() {
    }


    public MusicType(String musicType) {
        this.musicType = musicType;
    }

    public String getMusicType() {
        return musicType;
    }

    public void setMusicType(String musicType) {
        this.musicType = musicType;
    }
}
