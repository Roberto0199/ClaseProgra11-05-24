package org.example.Evaluacion;

import java.util.Stack;

public class EvaluadorExpresiones {

    public static int evaluarExpresion(String expresion) {
        Stack<Integer> pila = new Stack<>();
        char[] caracteres = expresion.toCharArray();

        for (char c : caracteres) {
            if (Character.isDigit(c)) {
                pila.push(Integer.parseInt(String.valueOf(c)));
            } else {
                int b = pila.pop();
                int a = pila.pop();
                int resultado;

                switch (c) {
                    case '+':
                        resultado = a + b;
                        break;
                    case '-':
                        resultado = a - b;
                        break;
                    case '*':
                        resultado = a * b;
                        break;
                    case '/':
                        resultado = a / b;
                        break;
                    default:
                        throw new IllegalArgumentException("Operador inválido: " + c);
                }

                pila.push(resultado);
            }
        }

        return pila.pop();
    }



    public static void main(String[] args) {
        try {
            System.out.println(evaluarExpresion("2+3*5"));
        } catch (Exception e) {
            System.out.println("Error!!!="+e.getMessage());
        }
    }
}//end EvaluadorExpresiones
