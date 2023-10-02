import java.util.Map;

public class EjemploTablaDeSimbolos {
     public static void main(String[] args) {
        TablaDeSimbolos tabla = new TablaDeSimbolos();

        // Procesar el grafo DOT desde el archivo "input.dot"
        tabla.procesarGrafoDesdeArchivo("tabla\\input.dot");
    
        // Obtener nodos y aristas del grafo
        Map<String, Nodo> nodos = tabla.obtenerNodos();
        Map<String, Arista> aristas = tabla.obtenerAristas();
    
        System.out.println("Nodos:");
        for (Map.Entry<String, Nodo> entry : nodos.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().nombre);
        }
        System.out.println("\nAristas:");
        for (Map.Entry<String, Arista> entry : aristas.entrySet()) {
            Arista arista = entry.getValue();
            System.out.println(arista.origen.nombre + " -> " + arista.destino.nombre + ": " + arista.etiqueta);
        }
        
    }
}