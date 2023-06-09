package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

class ConvertUtil {

	/**
	 * The PDF file is rendered and the image file list object is obtained.
	 *
	 * @param file
	 * @return
	 * @throws Exception
	 * @author l2jong
	 * @since 2017. 02. 20.
	 */
	static List<File> convertPdfToImage(File file) throws Exception {
		PDDocument doc = PDDocument.load(file);
		PDFRenderer renderer = new PDFRenderer(doc);
		List<File> fileList = new ArrayList<File>();

		for (int i = 0; i < doc.getNumberOfPages(); i++) {
			// default image files path: original file path
			// if necessary, file.getParent() + "/" => another path
			File fileTemp = new File(file.getParent() + "/" + (i) + ".png"); // jpg or png
			BufferedImage image = renderer.renderImageWithDPI(i, 220);
			// 200 is sample dots per inch.
			// if necessary, change 200 into another integer.
			ImageIO.write(image, "PNG", fileTemp); // JPEG or PNG
			fileList.add(fileTemp);

			System.out.println("New file created for page number: "+ i +" = " + fileTemp.getAbsolutePath());
		}
		doc.close();

		return fileList;
	}
}