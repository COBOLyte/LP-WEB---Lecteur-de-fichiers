package LecteurDeFichiers;

import java.io.FileNotFoundException;

public interface LecteurDeFichiersInterface {
    boolean isCorrectFileExtension();
    void read() throws FileNotFoundException;
}
