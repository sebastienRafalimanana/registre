package org.registre.mg.config;
import org.opencv.core.Core;

public class OpenCVConfig {

    public void init(){
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }
}
