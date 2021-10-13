package LecteurDeFichiers.LecteurDeFichiersAudio.LecteurDeFichiersWav;

import LecteurDeFichiers.LecteurdeFichiers;

import java.io.File;
import java.io.FileNotFoundException;

public class LecteurDeFichiersWav extends LecteurdeFichiers {

    public LecteurDeFichiersWav(File file) { super(file); }

    public boolean isCorrectFileExtension() {
        String fileExtension = super.file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf('.') + 1);
        return fileExtension.equals("wav");
    }

    public void read() { }
}
