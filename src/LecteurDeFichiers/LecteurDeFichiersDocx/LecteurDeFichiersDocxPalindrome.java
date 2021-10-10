package LecteurDeFichiers.LecteurDeFichiersDocx;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.io.File;

public class LecteurDeFichiersDocxPalindrome extends LecteurDeFichiersDocx {

    public LecteurDeFichiersDocxPalindrome(File file) { super(file); }

    public void display() {
        super.read();

        if (super.isCorrectFileExtension()) {
            System.out.println("[ Affichage PALINDROMIQUE ] : \n");

            try {
                for (XWPFParagraph para : super.paragraphs) {
                    System.out.println(new StringBuilder(para.getText()).reverse());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Mauvaise extension de fichier !");
        }

        System.out.println();
    }
}
