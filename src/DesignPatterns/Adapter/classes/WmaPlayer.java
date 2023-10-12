package DesignPatterns.Adapter.classes;

import DesignPatterns.Adapter.interfaces.AdvanceMediaPlayer;

public class WmaPlayer implements AdvanceMediaPlayer {

    @Override
    public void playWma(String fileName) {
        System.out.println("Playing wma file. Name: " + fileName);
    }
    @Override
    public void playVlc(String fileName) {

    }

    @Override
    public void playMp4(String fileName) {

    }

    @Override
    public void playMp3(String fileName) {

    }

}
