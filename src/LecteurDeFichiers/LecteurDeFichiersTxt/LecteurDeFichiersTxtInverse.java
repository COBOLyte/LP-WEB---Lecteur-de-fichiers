package LecteurDeFichiers.LecteurDeFichiersTxt;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class LecteurDeFichiersTxtInverse extends LecteurDeFichiersTxt {

    public LecteurDeFichiersTxtInverse(File file) { super(file); }

    public void display() throws IOException {
        super.read();

        if (super.isCorrectFileExtension()) {
            System.out.println("[ Affichage INVERSÉ ] : \n");

            try {
                ArrayList<String> content = new ArrayList<>();
                String line = super.bufferedReader.readLine();

                while (line != null) {
                    content.add(line);
                    line = super.bufferedReader.readLine();
                }

                for (int i = content.size() - 1; i >= 0 ; i--) {
                    System.out.println(content.get(i));
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
