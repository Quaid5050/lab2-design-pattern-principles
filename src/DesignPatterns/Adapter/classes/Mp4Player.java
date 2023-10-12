package DesignPatterns.Adapter.classes;

import DesignPatterns.Adapter.interfaces.AdvanceMediaPlayer;

public class Mp4Player implements AdvanceMediaPlayer {

        @Override
        public void playVlc(String fileName) {
            // do nothing just for the sake of implementations
        }

        @Override
        public void playMp4(String fileName) {
            System.out.println("Playing mp4 file. Name: " + fileName);
        }

        @Override
        public void playMp3(String fileName) {

        }

        @Override
        public void playWma(String fileName) {

        }

}
