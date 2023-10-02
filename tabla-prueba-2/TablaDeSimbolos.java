import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TablaDeSimbolos {
    private Map<String, Nodo> nodos;
    private Map<String, Arista> aristas;

    public TablaDeSimbolos() {
        nodos = new HashMap<>();
        aristas = new HashMap<>();
    }

    public void agregarNodo(String nombre, Nodo nodo) {
        nodos.put(nombre, nodo);
    }

    public Nodo obtenerNodo(String nombre) {
        return nodos.get(nombre);
    }

    public boolean existeNodo(String nombre) {
        return nodos.containsKey(nombre);
    }

    public void agregarArista(Nodo origen, Nodo destino, String etiqueta) {
        Arista arista = new Arista(origen, destino, etiqueta);
        aristas.put(origen.nombre + "-" + destino.nombre, arista);
    }
    

    public Arista obtenerArista(String nombreOrigen, String nombreDestino) {
        return aristas.get(nombreOrigen + "-" + nombreDestino);
    }

    public Map<String, Nodo> obtenerNodos() {
        return nodos;
    }

    public Map<String, Arista> obtenerAristas() {
        return aristas;
    }

    // Método para procesar un grafo en formato DOT desde un archivo
    public void procesarGrafoDesdeArchivo(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            Pattern nodoPattern = Pattern.compile("\\s*(\\w+)\\s*\\[label=\"(.*?)\",\\s*shape=(\\w+)]\\s*;");
            Pattern aristaPattern = Pattern.compile("\\s*(\\w+)\\s*->\\s*(\\w+)\\s*\\[label=\"(.*?)\"]\\s*;");

            while ((linea = br.readLine()) != null) {
                Matcher nodoMatcher = nodoPattern.matcher(linea);
                Matcher aristaMatcher = aristaPattern.matcher(linea);
 
                
                System.out.println("Línea procesada: " + linea);

                if (nodoMatcher.matches()) {
                    String nombreNodo = nodoMatcher.group(1);
                    String etiquetaNodo = nodoMatcher.group(2);
                    Nodo nodo = new Nodo(etiquetaNodo);
                    agregarNodo(nombreNodo, nodo);
                    System.out.println("Nodo encontrado: " + nombreNodo);
                } else if (aristaMatcher.matches()) {
                    String nodoOrigen = aristaMatcher.group(1);
                    String nodoDestino = aristaMatcher.group(2);
                    String etiquetaArista = aristaMatcher.group(3);
                    
                    Nodo origen = obtenerNodo(nodoOrigen);
                    Nodo destino = obtenerNodo(nodoDestino);
                    
                    if (origen != null && destino != null) {
                        agregarArista(origen, destino, etiquetaArista);
                    }
                    System.out.println("Arista encontrada: " + nodoOrigen + " -> " + nodoDestino);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
