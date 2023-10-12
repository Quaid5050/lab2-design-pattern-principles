package DesignPatterns.Adapter.interfaces;

public interface AdvanceMediaPlayer {
    public void playVlc(String fileName);
    public void playMp4(String fileName);
    public void playMp3(String fileName);

    public void playWma(String fileName);
}
