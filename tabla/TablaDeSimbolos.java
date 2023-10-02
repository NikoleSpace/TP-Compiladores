import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TablaDeSimbolos {
     private Map<String, Nodo> nodos;
    private List<Arista> aristas;

    public TablaDeSimbolos() {
        nodos = new HashMap<>();
        aristas = new ArrayList<>();
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

    public void agregarArista(Nodo origen, Nodo destino) {
        Arista arista = new Arista(origen, destino);
        aristas.add(arista);
    }

    public List<Arista> obtenerAristas() {
        return aristas;
    }

    public Map<String, Nodo> obtenerNodos() {
        return nodos;
    }
}
