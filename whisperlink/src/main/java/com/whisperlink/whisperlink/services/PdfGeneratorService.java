package com.whisperlink.whisperlink.services;

import com.whisperlink.whisperlink.models.Post;
import org.springframework.stereotype.Service;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
@Service
public class PdfGeneratorService {
    public void generatePdf(Post post) throws DocumentException, IOException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("Post.pdf"));

        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        Chunk chunk = new Chunk("Post Details", font);

        Paragraph postDetails = new Paragraph(chunk);
        postDetails.add(new Paragraph(" "));
        postDetails.add(new Paragraph("ID: " + post.getId()));
        postDetails.add(new Paragraph("User: " + post.getUser().getUsername()));
        postDetails.add(new Paragraph("Text: " + post.getText()));
        postDetails.add(new Paragraph("Date: " + post.getDate().toString()));
        postDetails.add(new Paragraph("Time: " + post.getTime()));
        postDetails.add(new Paragraph("Location: " + post.getLocation().getCity()));

        document.add(postDetails);
        document.close();
    }
}
