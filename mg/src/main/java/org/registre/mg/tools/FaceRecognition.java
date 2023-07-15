package org.registre.mg.tools;

import lombok.NoArgsConstructor;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfRect;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.objdetect.CascadeClassifier;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;

@NoArgsConstructor
public class FaceRecognition {
    private Resource facePreprocessing = new ClassPathResource("haarcascades/haarcascade_frontalface_alt.xml");;
    private CascadeClassifier faceDetector;
    {
        try {
            faceDetector = new CascadeClassifier(facePreprocessing.getFile().getAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private Mat image;

    public boolean faceDetection(String imageB64) throws IOException {
        //TODO: Preparation de l'image
        byte [] imageTodetect = Base64ToImage.convertBase64ToImage(imageB64);
        image = Imgcodecs.imdecode(new MatOfByte(imageTodetect),Imgcodecs.IMREAD_UNCHANGED);
        MatOfRect face = new MatOfRect();//TODO: Stockage des visages

        //TODO: Faire la reconnaissance
        faceDetector.detectMultiScale(image,face);
        if (face.empty()){
            System.out.println("aucune face detecté ou cette image contient plusieur face");
            return false;
        }
        else {
            System.out.println("Une visage detecté");
            return true;
        }

    }
}
