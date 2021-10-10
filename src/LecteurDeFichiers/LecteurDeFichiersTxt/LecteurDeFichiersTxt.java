package LecteurDeFichiers.LecteurDeFichiersTxt;

import LecteurDeFichiers.LecteurdeFichiers;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class LecteurDeFichiersTxt extends LecteurdeFichiers {
    protected BufferedReader bufferedReader;

    public LecteurDeFichiersTxt(File file) {
        super(file);
    }

    public boolean isCorrectFileExtension() {
        String fileExtension = super.file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf('.') + 1);
        return fileExtension.equals("txt");
    }

    public void read() throws FileNotFoundException { this.bufferedReader = new BufferedReader(new FileReader(file.getAbsolutePath())); }

    public void diff(File file2) throws IOException {
        String fileExtension2 = file2.getAbsolutePath().substring(file2.getAbsolutePath().lastIndexOf('.') + 1);

        if (this.isCorrectFileExtension() && (fileExtension2.equals("txt"))) {
            System.out.println("[ Affichage des DIFFÉRENCES ] : \n");
            this.read();
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file2.getAbsolutePath()));

            try {
                ArrayList<String> content1 = new ArrayList<>();
                String line1 = this.bufferedReader.readLine();
                try {
                    ArrayList<String> content2 = new ArrayList<>();
                    String line2 = bufferedReader2.readLine();

                    while (line1 != null) {
                        content1.add(line1);
                        line1 = this.bufferedReader.readLine();
                    }

                    while (line2 != null) {
                        content2.add(line2);
                        line2 = bufferedReader2.readLine();
                    }

                    int linesNumber = Math.max(content1.size(), content2.size());
                    for (int i = 0; i <= linesNumber; i++) {
                        String lineFile1;
                        String lineFile2;

                        if (i >= content1.size()) lineFile1 = "";
                        else lineFile1 = content1.get(i);

                        if (i >= content2.size()) lineFile2 = "";
                        else lineFile2 = content2.get(i);

                        if (!Objects.equals(lineFile1, lineFile2)) {
                            System.out.println("\u001B[30m" + "\u001B[41m" + (i+1) + "     " + "-" + "  " + lineFile1 + "\u001B[0m");
                            System.out.println("\u001B[30m" + "\u001B[42m" + (i+1) + "     " + "+" + "  " + lineFile2 + "\u001B[0m");
                        } else {
                            System.out.println((i+1) + "        " + lineFile1);
                            System.out.println((i+1) + "        " + lineFile2);
                        }
                    }
                } finally {
                    this.bufferedReader.close();
                }
            } finally {
                this.bufferedReader.close();
            }

        } else {
            System.out.println("Mauvaise extension sur l'un des 2 fichiers !");
        }
    }
}
