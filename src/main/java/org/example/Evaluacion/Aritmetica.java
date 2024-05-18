package org.example.Evaluacion;

import org.example.Pilas.PilaLineal;

public class Aritmetica {

    // Método para evaluar una expresión aritmética
    public static int evaluar(String expresion) throws Exception {
        // Se crean dos pilas, una para operandos y otra para operadores
        PilaLineal operandos = new PilaLineal();
        PilaLineal operadores = new PilaLineal();
        int resultado = 0; // Variable que almacenará el resultado de la evaluación
        int operando1, operando2; // Variables temporales para almacenar los operandos
        char operador; // Variable temporal para almacenar los operadores
        int i = 0; // Índice para recorrer la expresión

        // Se recorre la expresión caracter por caracter
        while (i < expresion.length()){
            // Si el caracter es un espacio en blanco, se ignora y se pasa al siguiente caracter
            if (expresion.charAt(i) == ' '){
                i++;
            }
            // Si el caracter es un operador (+, -, *, /), se añade a la pila de operadores
            else if (expresion.charAt(i) == '+' || expresion.charAt(i) == '-' || expresion.charAt(i) == '*' || expresion.charAt(i) == '/'){
                operadores.insertar(expresion.charAt(i));
                i++;
            }
            // Si el caracter es un número, se extrae el número completo y se añade a la pila de operandos
            else {
                String numero = "";
                while (i < expresion.length() && expresion.charAt(i) != ' ' && expresion.charAt(i) != '+' && expresion.charAt(i) != '-' && expresion.charAt(i) != '*' && expresion.charAt(i) != '/'){
                    numero += expresion.charAt(i);
                    i++;
                }
                operandos.insertar(Integer.parseInt(numero));
            }
        }

        // Se realizan las operaciones almacenadas en la pila de operadores y operandos
        while (!operadores.pilaVacia()){
            try {
                operando2 = (int) operandos.quitar();
                operando1 = (int) operandos.quitar();
                operador = (char) operadores.quitar();
                switch (operador){
                    // Se realiza la operación correspondiente según el operador
                    case '+':
                        resultado = operando1 + operando2;
                        break;
                    case '-':
                        resultado = operando1 - operando2;
                        break;
                    case '*':
                        resultado = operando1 * operando2;
                        break;
                    case '/':
                        resultado = operando1 / operando2;
                        break;
                }
                // Se agrega el resultado de la operación a la pila de operandos para su posterior evaluación
                operandos.insertar(resultado);
            }
            // Se maneja una excepción en caso de que ocurra algún error durante la evaluación
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        // Se devuelve el resultado final de la evaluación
        return resultado;
    }
}
