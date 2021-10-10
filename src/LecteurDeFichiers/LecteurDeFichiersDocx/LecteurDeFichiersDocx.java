package LecteurDeFichiers.LecteurDeFichiersDocx;

import LecteurDeFichiers.LecteurdeFichiers;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Objects;

public class LecteurDeFichiersDocx extends LecteurdeFichiers {
    protected List<XWPFParagraph> paragraphs;

    public LecteurDeFichiersDocx(File file) { super(file); }

    public boolean isCorrectFileExtension() {
        String fileExtension = super.file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf('.') + 1);
        return fileExtension.equals("doc") || fileExtension.equals("docx");
    }

    public void read() {
        try {
            FileInputStream fis = new FileInputStream(super.file.getAbsolutePath());
            XWPFDocument document = new XWPFDocument(fis);
            this.paragraphs = List.of(document.getParagraphs());
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void diff(File file2) {
        String fileExtension2 = file2.getAbsolutePath().substring(file2.getAbsolutePath().lastIndexOf('.') + 1);

        if (this.isCorrectFileExtension() && (fileExtension2.equals("doc") || fileExtension2.equals("docx"))) {
            System.out.println("[ Affichage des DIFFÉRENCES ] : \n");
            this.read();

            try {
                FileInputStream fis2 = new FileInputStream(file2.getAbsolutePath());
                XWPFDocument document2 = new XWPFDocument(fis2);
                List<XWPFParagraph> paragraphs2 = List.of(document2.getParagraphs());
                fis2.close();

                int linesNumber = Math.max(this.paragraphs.size(), paragraphs2.size());
                for (int i = 0; i <= linesNumber; i++) {
                    String lineFile1;
                    String lineFile2;

                    if (i >= this.paragraphs.size()) lineFile1 = "";
                    else lineFile1 = this.paragraphs.get(i).getText();

                    if (i >= paragraphs2.size()) lineFile2 = "";
                    else lineFile2 = paragraphs2.get(i).getText();

                    if (!Objects.equals(lineFile1, lineFile2)) {
                        System.out.println("\u001B[30m" + "\u001B[41m" + (i+1) + "     " + "-" + "  " + lineFile1 + "\u001B[0m");
                        System.out.println("\u001B[30m" + "\u001B[42m" + (i+1) + "     " + "+" + "  " + lineFile2 + "\u001B[0m");
                    } else {
                        System.out.println((i+1) + "        " + lineFile1);
                        System.out.println((i+1) + "        " + lineFile2);
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Mauvaise extension sur l'un des 2 fichiers !");
        }
    }
}
