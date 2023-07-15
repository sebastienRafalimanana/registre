package org.registre.mg.business.implementation;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import nu.pattern.OpenCV;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfRect;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.objdetect.CascadeClassifier;
import org.registre.mg.business.service.ValidationService;
import org.registre.mg.tools.Base64ToImage;
import org.registre.mg.tools.FaceRecognition;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ValidationServiceImpl implements ValidationService{
    FaceRecognition faceRecognition;
    @Override
    public boolean faceDetection(String imageB64) {
        faceRecognition = new FaceRecognition();
        try {
            faceRecognition.faceDetection(imageB64);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
