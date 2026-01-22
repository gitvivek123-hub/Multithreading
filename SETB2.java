/*b) Write a program for a simple search engine. Accept a string to be searched. Search for
the string in all text files in the current folder. Use a separate thread for each file. The
result should display the filename, line number where the string is found.*/
import java.io.*;

class FileSearch extends Thread {
    File file;
    String word;

    FileSearch(File file, String word) {
        this.file = file;
        this.word = word;
    }

    public void run() {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int lineNo = 1;
            while ((line = br.readLine()) != null) {
                if (line.contains(word))
                    System.out.println(file.getName() + " : Line " + lineNo);
                lineNo++;
            }
        } catch (Exception e) {}
    }
}

public class SearchEngine {
    public static void main(String[] args) {
        File folder = new File(".");
        String word = "java";

        for (File file : folder.listFiles()) {
            if (file.getName().endsWith(".txt"))
                new FileSearch(file, word).start();
        }
    }
}
