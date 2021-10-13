package LecteurDeFichiers.LecteurDeFichiersTexte.LecteurDeFichiersTxt;

import LecteurDeFichiers.LecteurDeFichiersTexte.LecteurDeFichiersTxt.LecteurDeFichiersTxt;

import java.io.File;
import java.io.IOException;

public class LecteurDeFichiersTxtNormal extends LecteurDeFichiersTxt {

    public LecteurDeFichiersTxtNormal(File file) { super(file); }

    public void display() throws IOException {
        super.read();

        if (super.isCorrectFileExtension()) {
            System.out.println("[ Affichage NORMAL ] : \n");

            try {
                StringBuilder stringBuilder = new StringBuilder();
                String line = super.bufferedReader.readLine();

                while (line != null) {
                    stringBuilder.append(line);
                    stringBuilder.append(System.lineSeparator());
                    line = super.bufferedReader.readLine();
                }
                System.out.println(stringBuilder);
            } finally {
                super.bufferedReader.close();
            }
        } else {
            System.out.println("Mauvaise extension de fichier !");
        }

        System.out.println("\n");
    }
}
