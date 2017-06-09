package pdf;

import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zinoviyzubko on 31.05.17.
 */
public class PdfParser {

    // Функція отримує на вхід файл пдф та генерує список PdfData розмірок в кількість сторінок пдф файла.
    public List<PdfData> parse(File file) {

        List<PdfData> dataList = new ArrayList<>();
        Splitter splitter = new Splitter();
        Parser parser = new Parser();
        try(PDDocument pdDocument = PDDocument.load(new FileInputStream(file))) {
            String content = new String();
            PDFTextStripper textStripper = new PDFTextStripper();
            // Розділяє пдф на сторінки
            for (PDDocument document : splitter.split(pdDocument)) {
                // Витягує весь текст з пдф сторінки
                content = content + textStripper.getText(document);
                if (!isOnePageContaineFullVoting(content))
                    continue;
                // Парсить текст
                PdfData data = parser.parseContent(content);
                dataList.add(data);
                content = new String();
                document.close();
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return dataList;
    }

    private boolean isOnePageContaineFullVoting(String content) {
        if (content.contains("Рішення: ")) return true;
        return false;
    }
}
