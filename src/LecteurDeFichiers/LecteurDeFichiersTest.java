package LecteurDeFichiers;

import LecteurDeFichiers.LecteurDeFichiersTexte.LecteurDeFichiersDocx.LecteurDeFichiersDocx;
import LecteurDeFichiers.LecteurDeFichiersTexte.LecteurDeFichiersDocx.LecteurDeFichiersDocxInverse;
import LecteurDeFichiers.LecteurDeFichiersTexte.LecteurDeFichiersDocx.LecteurDeFichiersDocxNormal;
import LecteurDeFichiers.LecteurDeFichiersTexte.LecteurDeFichiersDocx.LecteurDeFichiersDocxPalindrome;
import LecteurDeFichiers.LecteurDeFichiersTexte.LecteurDeFichiersTxt.LecteurDeFichiersTxt;
import LecteurDeFichiers.LecteurDeFichiersTexte.LecteurDeFichiersTxt.LecteurDeFichiersTxtInverse;
import LecteurDeFichiers.LecteurDeFichiersTexte.LecteurDeFichiersTxt.LecteurDeFichiersTxtNormal;
import LecteurDeFichiers.LecteurDeFichiersTexte.LecteurDeFichiersTxt.LecteurDeFichiersTxtPalindrome;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class LecteurDeFichiersTest {
    public static void main(String[] args) throws IOException {

        JFileChooser chooser = new JFileChooser();
        int status = chooser.showOpenDialog(null);
        if (status == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            String fileExtension = file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf('.') + 1);

            JFileChooser chooser2 = new JFileChooser();
            int status2 = chooser2.showOpenDialog(null);
            if (status2 == JFileChooser.APPROVE_OPTION) {
                File file2 = chooser2.getSelectedFile();

                if (Objects.equals(fileExtension, "txt")) {
                    new LecteurDeFichiersTxtNormal(file).display();
                    new LecteurDeFichiersTxtInverse(file).display();
                    new LecteurDeFichiersTxtPalindrome(file).display();
                    new LecteurDeFichiersTxt(file).diff(file2);
                } else {
                    new LecteurDeFichiersDocxNormal(file).display();
                    new LecteurDeFichiersDocxInverse(file).display();
                    new LecteurDeFichiersDocxPalindrome(file).display();
                    new LecteurDeFichiersDocx(file).diff(file2);
                }
            }
        }
    }
}
