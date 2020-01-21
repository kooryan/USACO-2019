import java.io.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class word {
    public static void main(String[] args) throws IOException {
        double time = System.currentTimeMillis();
        Scanner sc = new Scanner(new BufferedReader (new FileReader("word.in")));
        PrintWriter pw = new PrintWriter(new BufferedWriter (new FileWriter("word.out")));

        int N = sc.nextInt();
        int K = sc.nextInt();

        ArrayList<String> words = new ArrayList<>();
        while (sc.hasNext()) {
            words.add(sc.next());
        }

        int size = 0;
        int i = 0;
        StringBuilder word = new StringBuilder();

        while (i < words.size()) {
            size += words.get(i).length();

            if (size <= K) {
                word.append(words.get(i)).append(" ");
                i++;
            } else {
                size = 0;
                word = new StringBuilder(word.substring(0, word.length() - 1));

                pw.println(word);
                word = new StringBuilder();

                if (((i + 1) == words.size())) {
                    pw.print(words.get(i));
                }
            }
        }

        pw.close();
        System.out.println("Time: " + (System.currentTimeMillis() - time));
        System.exit(0);
    }
}
