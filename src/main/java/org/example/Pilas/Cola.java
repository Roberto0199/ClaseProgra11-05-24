package org.example.Pilas;

import java.util.LinkedList;
import java.util.Queue;

public class Cola {
    private Queue<Object> cola;

    public Cola() {
        cola = new LinkedList<>();
    }

    public void encolar(Object elemento) {
        cola.add(elemento);
    }

    public Object desencolar() throws Exception {
        if (colaVacia()) {
            throw new Exception("Cola vacía (UnderFlow)");
        }
        return cola.poll();
    }

    public boolean colaVacia() {
        return cola.isEmpty();
    }

    public int tamano() {
        return cola.size();
    }
}
