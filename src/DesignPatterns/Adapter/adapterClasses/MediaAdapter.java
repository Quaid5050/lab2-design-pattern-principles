package DesignPatterns.Adapter.adapterClasses;

import DesignPatterns.Adapter.classes.Mp4Player;
import DesignPatterns.Adapter.classes.VlcPlayer;
import DesignPatterns.Adapter.interfaces.AdvanceMediaPlayer;
import DesignPatterns.Adapter.interfaces.MediaPlayer;

public class MediaAdapter implements MediaPlayer {
    private AdvanceMediaPlayer advanceMediaPlayer;

    public  MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advanceMediaPlayer = new VlcPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advanceMediaPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        System.out.println("Playing mp3 file. Name: " + fileName);
        if (audioType.equalsIgnoreCase("vlc")) {
            advanceMediaPlayer.playVlc(fileName);
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advanceMediaPlayer.playMp4(fileName);
        }
    }

}
