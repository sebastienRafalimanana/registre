package org.registre.mg.business.service;

import java.io.IOException;

public interface ValidationService {

    public boolean faceDetection(String imageB64) throws IOException;
}
