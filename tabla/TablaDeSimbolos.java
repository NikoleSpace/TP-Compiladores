import java.util.HashMap;
import java.util.Map;

public class TablaDeSimbolos {
    private Map<String, Nodo> tabla;

    public TablaDeSimbolos() {
        tabla = new HashMap<>();
    }

    public void agregarNodo(String nombre, Nodo nodo) {
        tabla.put(nombre, nodo);
    }

    public Nodo obtenerNodo(String nombre) {
        return tabla.get(nombre);
    }

    public boolean existeNodo(String nombre) {
        return tabla.containsKey(nombre);
    }

    public Map<String, Nodo> obtenerTabla() {
        return tabla;
    }
}
