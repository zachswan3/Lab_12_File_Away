import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class FileAway {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String line;
        ArrayList<String> lines = new ArrayList<>();

        try {

            File workingDirectory = new File(System.getProperty("user.dir"));

            chooser.setCurrentDirectory(workingDirectory);

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                //if the user selects a file
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();
                Path path = Paths.get(""); //insert full file name inside () ex: c:\\Users\\znswan\\IdeaProjects\\...

                InputStream in = new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                int lineNumber = 0;
                while (reader.ready()){
                    line = reader.readLine();
                    lines.add(line);
                    lineNumber++;

                }
                System.out.printf("\nThe number of lines on this file is %-4d", lineNumber);

                String line4 = lines.get(3);
                String[] wordsInLine4 = line4.split(", ");

                System.out.println("");

                for (String word: wordsInLine4){
                    System.out.println(word);
                }

            } else {
                //if an error occurred or the user canceled
                System.out.println("Failed to choose a file to process");
                System.out.println("Run the program again");
                System.exit(0);
            }
            // opens the File chooser
        } catch (IOException exception) {
            exception.printStackTrace();
        }finally {

        }

    }
}