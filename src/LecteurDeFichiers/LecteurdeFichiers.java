package LecteurDeFichiers;

import java.io.File;
import java.io.FileNotFoundException;

public abstract class LecteurdeFichiers implements LecteurDeFichiersInterface {
    protected File file;

    public LecteurdeFichiers(File file) { this.file = file; }

    public abstract boolean isCorrectFileExtension();

    public abstract void read() throws FileNotFoundException;
}
