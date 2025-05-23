import java.util.LinkedList;
import java.util.Queue;

public class ArvoreSemRecursividade {
    No raiz;

    public int contarNosIterativo() {
        if (raiz == null) {
            return 0;
        }

        Queue<No> fila = new LinkedList<>();
        fila.add(raiz);
        int contador = 0;

        while (!fila.isEmpty()) {
            No noAtual = fila.poll();
            contador++;

            if (noAtual.esquerdo != null) {
                fila.add(noAtual.esquerdo);
            }
            if (noAtual.direito != null) {
                fila.add(noAtual.direito);
            }
        }
        return contador;
    }
}
