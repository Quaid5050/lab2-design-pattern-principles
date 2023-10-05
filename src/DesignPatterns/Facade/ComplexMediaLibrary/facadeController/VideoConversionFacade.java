package DesignPatterns.Facade.ComplexMediaLibrary.facadeController;

import DesignPatterns.Facade.ComplexMediaLibrary.classes.*;
import DesignPatterns.Facade.ComplexMediaLibrary.interfaces.Codec;

import java.io.File;

public class VideoConversionFacade {
    public File convertVideo(String fileName, String format) {
        System.out.println("VideoConversionFacade: conversion started.");
////        VideoFile file = new diaVideoFile(fileName);
//        Codec sourceCodec = CodecFactory.extract(file);
//        Codec destinationCodec;
//        if (format.equals("mp4")) {
//            destinationCodec = new MPEG4CompressionCodec();
//        } else {
//            destinationCodec = new OggCompressionCodec();
//        }
//        VideoFile buffer = BitrateReader.read(file, sourceCodec);
//        VideoFile intermediateResult = BitrateReader.convert(buffer, destinationCodec);
//        File result = (new AudioMixer()).fix(intermediateResult);
//        System.out.println("VideoConversionFacade: conversion completed.");
//        return result;
        return null;
    }
}
