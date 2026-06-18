package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Grafo {

    // ID Deposito -> Lista de depósitos conectados
    private Map<Integer, List<Integer>> conexiones;

    public Grafo() {
        conexiones = new HashMap<>();
    }

    // Agrega un depósito al grafo
    public void agregarDeposito(int id) {
        conexiones.putIfAbsent(id, new ArrayList<>());
    }

    // Conexión bidireccional entre depósitos
    public void conectar(int origen, int destino) {

        if (!conexiones.containsKey(origen)) {
            agregarDeposito(origen);
        }

        if (!conexiones.containsKey(destino)) {
            agregarDeposito(destino);
        }

        conexiones.get(origen).add(destino);
        conexiones.get(destino).add(origen);
    }

    // Muestra todas las conexiones (para probar)
    public void mostrarConexiones() {

        for (Integer deposito : conexiones.keySet()) {

            System.out.print("Deposito " + deposito + " -> ");

            for (Integer vecino : conexiones.get(deposito)) {
                System.out.print(vecino + " ");
            }

            System.out.println();
        }
    }

    // BFS: cantidad mínima de saltos entre dos depósitos
    public int cantidadSaltos(int origen, int destino) {

        Queue<Integer> cola = new LinkedList<>();

        Map<Integer, Integer> distancia = new HashMap<>();

        cola.add(origen);
        distancia.put(origen, 0);

        while (!cola.isEmpty()) {

            int actual = cola.poll();

            if (actual == destino) {
                return distancia.get(actual);
            }

            for (Integer vecino : conexiones.get(actual)) {

                if (!distancia.containsKey(vecino)) {

                    distancia.put(
                            vecino,
                            distancia.get(actual) + 1);

                    cola.add(vecino);
                }
            }
        }

        return -1; // no existe camino
    }
}