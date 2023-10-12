package DesignPatterns.Adapter.adapterClasses;
import DesignPatterns.Adapter.interfaces.MediaPlayer;

public class AudioPlayer  implements MediaPlayer {
    private MediaAdapter mediaAdapter;
    @Override
    public void play(String audioType, String fileName) {
        System.out.println("Playing mp3 file. Name: " + fileName);
        if (audioType.equalsIgnoreCase("vlc")) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        } else if (audioType.equalsIgnoreCase("mp4")) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        }
        //add the support of mp3
        else if (audioType.equalsIgnoreCase("mp3")) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        }
        //add the support of wma
        else if (audioType.equalsIgnoreCase("wma")) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        }
        else {
            System.out.println("Invalid media. " + audioType + " format not supported");
        }
    }
}
