package com.library.libraryapi.service.media;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class ImageService {

    @Value("https://picsum.photos/200")
    private static String imagesApiUrl;

    private static byte[] findImage() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(imagesApiUrl)).build();
        HttpResponse<byte[]> response = client.send(request, HttpResponse.BodyHandlers.ofByteArray());
        return response.body();
    }

    public static byte[] getImage(){
        try {
            byte[] imageBytes = findImage();
            generatePDF(imageBytes);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private static void generatePDF(byte[] data) throws IOException {
        PdfDocument pdfDocument = new PdfDocument(new PdfReader("document.pdf"));
        Document doc = new Document(pdfDocument);

        ImageData imageData = ImageDataFactory.create(data);
        Image image = new Image(imageData);

        doc.add(image);
        doc.close();
    }


}
