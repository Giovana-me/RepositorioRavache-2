import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

    public void percorrerEmPreOrdemIterativo() {
        if (raiz == null) {
            return;
        }

        Stack<No> pilha = new Stack<>();
        pilha.push(raiz);

        while (!pilha.isEmpty()) {
            No noAtual = pilha.pop();
            System.out.print(noAtual.valor + " ");

            if (noAtual.direito != null) {
                pilha.push(noAtual.direito);
            }
            if (noAtual.esquerdo != null) {
                pilha.push(noAtual.esquerdo);
            }
        }
    }

    public void percorrerEmOrdemIterativo() {
        if (raiz == null) {
            return;
        }

        Stack<No> pilha = new Stack<>();
        No atual = raiz;

        while (atual != null || !pilha.isEmpty()) {
            while (atual != null) {
                pilha.push(atual);
                atual = atual.esquerdo;
            }
            atual = pilha.pop();
            System.out.print(atual.valor + " ");

            atual = atual.direito;
        }
    }

    public void percorrerEmPosOrdemIterativo() {
        if (raiz == null) {
            return;
        }

        Stack<No> pilha1 = new Stack<>();
        Stack<No> pilha2 = new Stack<>();
        pilha1.push(raiz);

        while (!pilha1.isEmpty()) {
            No noAtual = pilha1.pop();
            pilha2.push(noAtual);

            if (noAtual.esquerdo != null) {
                pilha1.push(noAtual.esquerdo);
            }
            if (noAtual.direito != null) {
                pilha1.push(noAtual.direito);
            }
        }
        while (!pilha2.isEmpty()) {
            System.out.print(pilha2.pop().valor + " ");
        }
    }

    public int contarNosFolhaIterativo() {
        if (raiz == null) {
            return 0;
        }

        Queue<No> fila = new LinkedList<>();
        fila.add(raiz);
        int contador = 0;

        while (!fila.isEmpty()) {
            No noAtual = fila.poll();

            if (noAtual.esquerdo == null && noAtual.direito == null) {
                contador++;
            }
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
