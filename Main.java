public class Main {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();

        arbol.insertar(40);
        arbol.insertar(20);
        arbol.insertar(30);
        arbol.insertar(40);
        arbol.insertar(50);
        arbol.insertar(60);
        arbol.insertar(70);

        System.out.println("Árbol antes de balancear:");
        arbol.imprimirPorNiveles();

        arbol.balancear();

        System.out.println("\nÁrbol después de balancear:");
        arbol.imprimirPorNiveles();
    }
}