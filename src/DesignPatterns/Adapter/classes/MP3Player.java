package DesignPatterns.Adapter.classes;

import DesignPatterns.Adapter.interfaces.AdvanceMediaPlayer;
import DesignPatterns.Adapter.interfaces.MediaPlayer;

public class MP3Player implements AdvanceMediaPlayer {
    @Override
    public void playMp3(String fileName) {
        System.out.println("Playing mp3 file. Name: " + fileName);
    }

    @Override
    public void playVlc(String fileName) {
        // do nothing just for the sake of implementations
    }

    @Override
    public void playMp4(String fileName) {
      // do nothing just for the sake of implementations
    }

    @Override
    public void playWma(String fileName) {
        // do nothing just for the sake of implementations
    }
}
