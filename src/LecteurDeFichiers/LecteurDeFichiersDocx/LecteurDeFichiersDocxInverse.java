package LecteurDeFichiers.LecteurDeFichiersDocx;

import java.io.File;

public class LecteurDeFichiersDocxInverse extends LecteurDeFichiersDocx {

    public LecteurDeFichiersDocxInverse(File file) { super(file); }

    public void display() {
        super.read();

        if (super.isCorrectFileExtension()) {
            System.out.println("[ Affichage INVERSÉ ] : \n");

                try {
                    for (int i = super.paragraphs.size() - 1; i >= 0; i--) {
                        System.out.println(super.paragraphs.get(i).getText());
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
