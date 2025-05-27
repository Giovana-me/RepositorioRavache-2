import java.util.LinkedList;
import java.util.Queue;

public class Arvore {
    No raiz;

    public int contarNos() {
        return contarNosRecursivo(raiz);
    }

    private int contarNosRecursivo(No no) {
        if (no == null) {
            return 0;
        }
        return 1 + contarNosRecursivo(no.esquerdo) + contarNosRecursivo(no.direito);
    }

    public void percorrerEmPreOrdem() {
        percorrerEmPreOrdemRecursivo(raiz);
    }

    private void percorrerEmPreOrdemRecursivo(No no) {
        if (no != null) {
            System.out.print(no.valor + " ");
            percorrerEmPreOrdemRecursivo(no.esquerdo);
            percorrerEmPreOrdemRecursivo(no.direito);
        }
    }

    public void percorrerEmOrdem() {
        percorrerEmOrdemRecursivo(raiz);
    }

    private void percorrerEmOrdemRecursivo(No no) {
        if (no != null) {
            percorrerEmOrdemRecursivo(no.esquerdo);
            System.out.print(no.valor + " ");
            percorrerEmOrdemRecursivo(no.direito);
        }
    }

    public void percorrerEmPosOrdem() {
        percorrerEmPosOrdemRecursivo(raiz);
    }

    private void percorrerEmPosOrdemRecursivo(No no) {
        if (no != null) {
            percorrerEmPosOrdemRecursivo(no.esquerdo);
            percorrerEmPosOrdemRecursivo(no.direito);
            System.out.print(no.valor + " ");
        }
    }

    public void percorrerEmNivel() {
        if (raiz == null) {
            return;
        }

        Queue<No> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            No noAtual = fila.poll();
            System.out.print(noAtual.valor + " ");

            if (noAtual.esquerdo != null) {
                fila.add(noAtual.esquerdo);
            }
            if (noAtual.direito != null) {
                fila.add(noAtual.direito);
            }
        }
    }

    public int contarNosFolha() {
        return contarNosFolhaRecursivo(raiz);
    }

    private int contarNosFolhaRecursivo(No no) {
        if (no == null) {
            return 0;
        }
        if (no.esquerdo == null && no.direito == null) {
            return 1;
        }
        return contarNosFolhaRecursivo(no.esquerdo) + contarNosFolhaRecursivo(no.direito);
    }
}
