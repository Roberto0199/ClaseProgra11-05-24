package org.example.Pilas;

import java.text.Normalizer;

public class TransformadorPalabra {
    public static String transformar(String palabra) {
        // Convertir a minúsculas
        palabra = palabra.toLowerCase();

        // Eliminar espacios en blanco
        palabra = palabra.replaceAll("\\s+", "");

        // Eliminar signos de puntuación
        palabra = palabra.replaceAll("[^\\p{L}\\p{Nd}]+", "");

        // Eliminar acentos y tildes
        palabra = Normalizer.normalize(palabra, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "");

        // Eliminar números
        palabra = palabra.replaceAll("[\\d]", "");

        // Eliminar símbolos
        palabra = palabra.replaceAll("[^a-zA-Z]", "");

        return palabra;
    }
}
