package LecteurDeFichiers.LecteurDeFichiersAudio.LecteurDeFichiersMp3;

import LecteurDeFichiers.LecteurdeFichiers;

import java.io.File;

public class LecteurDeFichiersMp3 extends LecteurdeFichiers {

    public LecteurDeFichiersMp3(File file) { super(file); }

    public boolean isCorrectFileExtension() {
        String fileExtension = super.file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf('.') + 1);
        return fileExtension.equals("mp3");
    }

    public void read() { }
}
