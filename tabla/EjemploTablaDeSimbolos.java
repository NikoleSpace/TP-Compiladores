import java.util.List;
import java.util.Map;

public class EjemploTablaDeSimbolos {
     public static void main(String[] args) {
        // Crear una tabla de símbolos para el grafo
        TablaDeSimbolos tabla = new TablaDeSimbolos();

        // Agregar nodos al grafo
        Nodo nodoA = new Nodo("A");
        Nodo nodoB = new Nodo("B");
        Nodo nodoC = new Nodo("C");

        tabla.agregarNodo("A", nodoA);
        tabla.agregarNodo("B", nodoB);
        tabla.agregarNodo("C", nodoC);

        // Agregar aristas al grafo
        tabla.agregarArista(nodoA, nodoB);
        tabla.agregarArista(nodoB, nodoC);
        tabla.agregarArista(nodoC, nodoA);

        // Obtener nodos y aristas del grafo
        System.out.println("Nodos:");
        Map<String, Nodo> nodos = tabla.obtenerNodos();
        for (Map.Entry<String, Nodo> entry : nodos.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().nombre);
        }

        System.out.println("\nAristas:");
        List<Arista> aristas = tabla.obtenerAristas();
        for (Arista arista : aristas) {
            System.out.println(arista.origen.nombre + " -> " + arista.destino.nombre);
        }
    }
}
