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
}