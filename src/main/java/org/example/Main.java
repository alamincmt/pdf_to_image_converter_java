package org.example;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        File pdf = new File("/Users/alamin/Downloads/pdf converter/src/main/java/org/example/ez_quran.pdf");
        List<File> imageList = ConvertUtil.convertPdfToImage(pdf); // images files
        System.out.println("Size is: "+imageList.size());
    }
}