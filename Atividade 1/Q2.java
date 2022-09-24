/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividade1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 *
 * @author Dudu
 */
public class Q2 {
    public static void main(String[] args)throws FileNotFoundException, IOException  {
        Scanner input = new Scanner(System.in);

        System.out.println("Insira o nome do arquivo de leitura: ");
        String arq1 = input.next();

        System.out.println("Insira o nome do arquivo de escrita: ");
        String arq2 = input.next();

        InputStream is = new FileInputStream(arq1);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        OutputStream os = new FileOutputStream(arq2);
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(osw);

        
        String str = "";

        while( str != null){
            bw.write(str + "\n");
            str = br.readLine();

        }

        bw.newLine();
        bw.close();
        br.close();
        input.close();
    }
}
