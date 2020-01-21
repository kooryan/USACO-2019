package com.company; /*
ID: kooryan
TASK:
LANG: JAVA
*/

import java.io.*;
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
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            size += words.get(i).length();
            if (size <= K) {
                word.append(words.get(i)).append(" ");
            } else {
                size = 0;
                word = new StringBuilder(word.substring(0, word.length() - 1));
                pw.println(word);
                word = new StringBuilder();
                i--;
            }
        }

        pw.close();
        System.out.println("Time: " + (System.currentTimeMillis() - time));
        System.exit(0);
    }
}
