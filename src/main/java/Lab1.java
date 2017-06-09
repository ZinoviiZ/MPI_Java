import pdf.PdfData;
import pdf.PdfParser;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zinoviyzubko on 31.05.17.
 */
public class Lab1 {

    private static final String fileName = "votings/{name}.pdf";

    public static void main(String[] args) {

        PdfParser pdfParser = new PdfParser();

        long time = 0L;
        for (int i = 0; i < 11; i++) {
            File file = new File(fileName.replace("{name}", String.valueOf(i)));
            time = System.nanoTime();
            List<PdfData> parsed = pdfParser.parse(file);
            System.out.println("page " + i + " parsed " + (System.nanoTime() - time) + " nanosec");
        }
        System.out.println("all pages parsed " + System.nanoTime() + " nanosec");
    }
}
