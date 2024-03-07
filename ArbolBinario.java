import java.util.LinkedList;
import java.util.Queue;

class ArbolBinario {
    Nodo raiz;

    ArbolBinario() {
        raiz = null;
    }

    void insertar(int valor) {
        raiz = insertarRec(raiz, valor);
    }

    Nodo insertarRec(Nodo raiz, int valor) {
        if (raiz == null) {
            raiz = new Nodo(valor);
            return raiz;
        }

        if (valor < raiz.valor)
            raiz.izquierda = insertarRec(raiz.izquierda, valor);
        else if (valor > raiz.valor)
            raiz.derecha = insertarRec(raiz.derecha, valor);

        return raiz;
    }

    void balancear() {
        raiz = balancearRec(raiz);
    }

    Nodo balancearRec(Nodo raiz) {
        int factorEquilibrio = obtenerFactorEquilibrio(raiz);

        if (factorEquilibrio > 1) {
            if (obtenerFactorEquilibrio(raiz.izquierda) >= 0) {
                return rotacionDerecha(raiz);
            } else {
                raiz.izquierda = rotacionIzquierda(raiz.izquierda);
                return rotacionDerecha(raiz);
            }
        } else if (factorEquilibrio < -1) {
            if (obtenerFactorEquilibrio(raiz.derecha) <= 0) {
                return rotacionIzquierda(raiz);
            } else {
                raiz.derecha = rotacionDerecha(raiz.derecha);
                return rotacionIzquierda(raiz);
            }
        }

        return raiz;
    }

    int obtenerAltura(Nodo nodo) {
        if (nodo == null) return 0;
        return Math.max(obtenerAltura(nodo.izquierda), obtenerAltura(nodo.derecha)) + 1;
    }

    int obtenerFactorEquilibrio(Nodo nodo) {
        if (nodo == null) return 0;
        return obtenerAltura(nodo.izquierda) - obtenerAltura(nodo.derecha);
    }

    Nodo rotacionDerecha(Nodo y) {
        Nodo x = y.izquierda;
        Nodo T2 = x.derecha;

        x.derecha = y;
        y.izquierda = T2;

        return x;
    }

    Nodo rotacionIzquierda(Nodo x) {
        Nodo y = x.derecha;
        Nodo T2 = y.izquierda;

        y.izquierda = x;
        x.derecha = T2;

        return y;
    }

    void imprimirPorNiveles() {
        if (raiz == null) {
            System.out.println("El árbol está vacío.");
            return;
        }
    
        Queue<Nodo> cola = new LinkedList<>();
        cola.add(raiz);
    
        while (!cola.isEmpty()) {
            Nodo temp = cola.poll();
            System.out.print(temp.valor + " ");
    
            if (temp.izquierda != null)
                cola.add(temp.izquierda);
    
            if (temp.derecha != null)
                cola.add(temp.derecha);
        }
    }
}