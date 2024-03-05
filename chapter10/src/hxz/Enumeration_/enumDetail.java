package hxz.Enumeration_;

/**
 * @author hxz
 */
public class enumDetail {
    public static void main(String[] args) {
        Music.CLASSICMUSIC.playing();
    }
}

interface IPlaying {
    public void playing();
}
enum Music implements IPlaying {
    CLASSICMUSIC;

    @Override
    public void playing() {
        System.out.println("播放好听的音乐...");
    }
}