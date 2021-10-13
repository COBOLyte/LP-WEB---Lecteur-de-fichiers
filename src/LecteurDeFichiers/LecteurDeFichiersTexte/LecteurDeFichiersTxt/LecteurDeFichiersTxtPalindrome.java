package LecteurDeFichiers.LecteurDeFichiersTexte.LecteurDeFichiersTxt;

import LecteurDeFichiers.LecteurDeFichiersTexte.LecteurDeFichiersTxt.LecteurDeFichiersTxt;

import java.io.File;
import java.io.IOException;

public class LecteurDeFichiersTxtPalindrome extends LecteurDeFichiersTxt {

    public LecteurDeFichiersTxtPalindrome(File file) { super(file); }

    public void display() throws IOException {
        super.read();

        if (super.isCorrectFileExtension()) {
            System.out.println("[ Affichage PALINDROMIQUE ] : \n");

            try {
                String line = super.bufferedReader.readLine();

                while (line != null) {
                    System.out.println(new StringBuilder(line).reverse());
                    line = super.bufferedReader.readLine();
                }
            } finally {
                super.bufferedReader.close();
            }
        } else {
            System.out.println("Mauvaise extension de fichier !");
        }

        System.out.println("\n");
    }
}
