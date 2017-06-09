import mpi.MPI;
import pdf.PdfData;
import pdf.PdfParser;

import java.io.File;
import java.util.List;

/**
 * Created by zinoviyzubko on 10.05.17.
 */
public class Lab2 {

    private static final String fileName = "votings/{name}.pdf";

    public static void main(String[] args) {

        MPI.Init(args);
        int me = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();
        File file = new File(fileName.replace("{name}", String.valueOf(me)));
        PdfParser pdfParser = new PdfParser();
        long time = System.nanoTime();
        List<PdfData> pdfDatas = pdfParser.parse(file);
        System.out.println("Page " + me + " parsed " + (System.nanoTime() - time) + " nanosec");
        MPI.Finalize();
    }
}
