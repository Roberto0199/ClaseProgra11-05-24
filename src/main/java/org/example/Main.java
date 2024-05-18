package org.example;

import org.example.Pilas.PilaLineal;
import org.example.Pilas.TransformadorPalabra;
import org.example.Pilas.Cola;

import java.util.Scanner;

public class Main {

    public static void verificarPalindromo(String palabra) {
        String palabraTransformada = TransformadorPalabra.transformar(palabra);
        StringBuilder palabraInvertida = new StringBuilder();

        PilaLineal pila = new PilaLineal();

        for (int i = 0; i < palabraTransformada.length(); i++) {
            try {
                pila.insertar(palabraTransformada.charAt(i));
            } catch (Exception ex) {
                System.out.println("Problema al insertar: " + ex.getMessage());
            }
        }

        while (!pila.pilaVacia()) {
            try {
                palabraInvertida.append(pila.quitar());
            } catch (Exception ex) {
                System.out.println("Error comprobando!");
            }
        }

        if (palabraTransformada.equals(palabraInvertida.toString())) {
            System.out.println("La palabra '" + palabra + "' es un palíndromo.");
        } else {
            System.out.println("La palabra '" + palabra + "' no es un palíndromo.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cola cola = new Cola();

        System.out.println("Ingrese 15 palabras:");

        for (int i = 0; i < 15; i++) {
            System.out.print("Palabra " + (i + 1) + ": ");
            String palabra = scanner.nextLine().trim();
            cola.encolar(palabra);
        }

        System.out.println("\nVerificando si las palabras son palíndromos:");

        while (!cola.colaVacia()) {
            try {
                String palabra = (String) cola.desencolar();
                verificarPalindromo(palabra);
            } catch (Exception ex) {
                System.out.println("Error al desencolar: " + ex.getMessage());
            }
        }
    }
}
