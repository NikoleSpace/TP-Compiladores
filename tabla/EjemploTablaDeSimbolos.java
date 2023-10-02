import java.util.Map;

public class EjemploTablaDeSimbolos {
     public static void main(String[] args) {
        // Crear una tabla de símbolos
        TablaDeSimbolos tabla = new TablaDeSimbolos();

        // Crear nodos y agregarlos a la tabla
        Nodo nodoA = new Nodo("A");
        Nodo nodoB = new Nodo("B");
        Nodo nodoC = new Nodo("C");

        tabla.agregarNodo("A", nodoA);
        tabla.agregarNodo("B", nodoB);
        tabla.agregarNodo("C", nodoC);

        // Obtener un nodo de la tabla y mostrar sus atributos
        Nodo nodoRecuperado = tabla.obtenerNodo("A");
        if (nodoRecuperado != null) {
            System.out.println("Nombre del Nodo A: " + nodoRecuperado.nombre);
        }

        // Obtener la tabla completa y mostrarla
        Map<String, Nodo> tablaCompleta = tabla.obtenerTabla();
        System.out.println("Tabla de Símbolos Completa:");
        for (Map.Entry<String, Nodo> entry : tablaCompleta.entrySet()) {
            System.out.println("Nombre: " + entry.getKey() + ", Nodo: " + entry.getValue().nombre);
        }
    }
}
