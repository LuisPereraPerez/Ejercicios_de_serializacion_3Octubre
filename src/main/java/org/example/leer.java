package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class leer {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("prueba.txt"));
            String text;
            while ((text = br.readLine()) != null) {
                System.out.println(text);
            }
            br.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
