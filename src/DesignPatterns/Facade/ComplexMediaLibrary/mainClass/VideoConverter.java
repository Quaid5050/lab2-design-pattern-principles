package DesignPatterns.Facade.ComplexMediaLibrary.mainClass;

import DesignPatterns.Facade.ComplexMediaLibrary.facadeController.VideoConversionFacade;

import java.io.File;

public class VideoConverter {
    public static void main(String[] args) {
        VideoConversionFacade converter = new VideoConversionFacade();
        File mp4Video = converter.convertVideo("youtubevideo.ogg", "mp4");
  }
}
