/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.atividade1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author Dudu
 */
public class Q1 {

     public static void main(String[] args) throws FileNotFoundException, IOException {

        int n1;
        int n2;
        Scanner input = new Scanner(System.in);

        System.out.println("Insira o nome do arquivo de texto: ");
        String arquivo = input.next();

        System.out.println("Insira o primeiro número: ");
        n1 = input.nextInt();

        System.out.println("Insira o segundo número: ");
        n2 = input.nextInt();

        InputStream is = new FileInputStream(arquivo);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        String str = "";

        if (n2 == 0) {
            for (int i = 0; str != null; i++) {
                if (i >= (n1))
                    System.out.println(str);
                str = br.readLine();
            }
        }

        else if (n1 > n2)
            System.out.println("Operação invalida!!! Atenção com os valores inseridos");

        else if (n1 < n2) {
            for (int i = 0; i <= (n2); i++) {
                if (i >= (n1))
                    System.out.println(str);
                str = br.readLine();
            }
        }

        br.close();
        input.close();
    }
}
