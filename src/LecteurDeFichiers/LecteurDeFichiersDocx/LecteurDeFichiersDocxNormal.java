package LecteurDeFichiers.LecteurDeFichiersDocx;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.io.File;

public class LecteurDeFichiersDocxNormal extends LecteurDeFichiersDocx {

    public LecteurDeFichiersDocxNormal(File file) { super(file); }

    public void display() {
        super.read();

        if (super.isCorrectFileExtension()) {
            System.out.println("[ Affichage NORMAL ] : \n");

            try {
                for (XWPFParagraph para : super.paragraphs) {
                    System.out.println(para.getText());
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
