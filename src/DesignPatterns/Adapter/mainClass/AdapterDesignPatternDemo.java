package DesignPatterns.Adapter.mainClass;

import DesignPatterns.Adapter.adapterClasses.AudioPlayer;

public class AdapterDesignPatternDemo {
    public static void main(String[] args){
        System.out.println("Adapter Design Pattern Demo");
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");
        audioPlayer.play("wma", "wma file.wma");




    }
}
