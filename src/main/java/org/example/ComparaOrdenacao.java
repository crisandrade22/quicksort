package org.example;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;
public class ComparaOrdenacao {
    static Scanner scanner;
    static Random random;
    static void geraVetor(int v[]) {
        for (int i =0; i<v.length; i++) {
            v[i] = random.nextInt(10*v.length);
        }
    }
    static void exibeVetor(int v[], String msg) {
        System.out.println("\n" + msg);
        for (int i =0; i<v.length; i++) {
            System.out.print(v[i] + " | " );
        }
        System.out.println();
    }
    static void bubble(int v[]) {
        for (int i= 0 ; i <v.length; i++) {
            for(int j= 0 ; j<v.length-1; j++) {
                if(v[j] > v[j+1]) {
                    int aux = v[j];
                    v[j] = v[j+1];
                    v[j+1] = aux;
                }
            }
        }
    }
    static int partition (int[] vetor, int primeiro, int ultimo) {
        int x = vetor[ultimo];
        int i = primeiro-1;
        for(int j = primeiro; j <= ultimo-1; j++)
            if (vetor[j] <= x) {
                i = i + 1;
                int aux = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = aux;
            }
        i = i + 1;
        int aux = vetor[ultimo];
        vetor[ultimo] = vetor[i];
        vetor[i] = aux;
        return i;
    }

    static void quick (int[] vetor, int primeiro, int ultimo) {
//        System.out.print("\np = " + primeiro + ", r = " + ultimo);
        if (primeiro < ultimo) {
            int q = partition(vetor, primeiro, ultimo);
//            System.out.print(", q = " + q);
            quick(vetor, primeiro, q-1);
            quick(vetor, q+1, ultimo);
        }
    }

    public static void main(String[] args) {
        random = new Random();
        scanner = new Scanner(System.in);
        int v1[] = new int [1600000];
        geraVetor(v1);
//        exibeVetor(v1, "vetor gerado");
//        long inicio = new Date().getTime();
//        bubble(v1);
//        long fim = new Date().getTime();
//        exibeVetor(v1, "vetor ordenado bubble");
//        System.out.println("Demorou: " + (fim - inicio));
//        geraVetor(v1);
//        exibeVetor(v1, "vetor gerado");
       long inicio = new Date().getTime();
        quick(v1, 0, v1.length-1);
       long fim = new Date().getTime();
//        exibeVetor(v1, "vetor ordenado quick");
        System.out.println("\nDemorou: " + (fim - inicio));
        scanner.close();
    }
}

