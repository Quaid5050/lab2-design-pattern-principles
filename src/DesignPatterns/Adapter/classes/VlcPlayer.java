package DesignPatterns.Adapter.classes;

import DesignPatterns.Adapter.interfaces.AdvanceMediaPlayer;

public class VlcPlayer implements AdvanceMediaPlayer {
            @Override
            public void playVlc(String fileName) {
                System.out.println("Playing vlc file. Name: " + fileName);
            }

            @Override
            public void playMp4(String fileName) {
                // do nothing just for the sake of implementations
            }

            @Override
            public void playMp3(String fileName) {

            }

            @Override
            public void playWma(String fileName) {

            }
}
