public class MainAVL {
    public static void main(String[] args) {
        ArvoreAVL arvoreAVL = new ArvoreAVL();

        arvoreAVL.raiz = arvoreAVL.inserir(arvoreAVL.raiz, 30);
        arvoreAVL.raiz = arvoreAVL.inserir(arvoreAVL.raiz, 20);
        arvoreAVL.raiz = arvoreAVL.inserir(arvoreAVL.raiz, 40);
        arvoreAVL.raiz = arvoreAVL.inserir(arvoreAVL.raiz, 10);
        arvoreAVL.raiz = arvoreAVL.inserir(arvoreAVL.raiz, 25);
        arvoreAVL.raiz = arvoreAVL.inserir(arvoreAVL.raiz, 35);
        arvoreAVL.raiz = arvoreAVL.inserir(arvoreAVL.raiz, 50);

        System.out.println("Árvore AVL após inserções.");

        int chaveBusca = 25;
        NoAVL encontrado = arvoreAVL.buscar(arvoreAVL.raiz, chaveBusca);
        if (encontrado != null) {
            System.out.println("Valor encontrado antes da remoção: " + encontrado.chave);
        } else {
            System.out.println("Valor não encontrado antes da remoção.");
        }

        int chaveRemover = 20;
        arvoreAVL.raiz = arvoreAVL.remover(arvoreAVL.raiz, chaveRemover);
        System.out.println("Valor " + chaveRemover + " removido da árvore.");

        encontrado = arvoreAVL.buscar(arvoreAVL.raiz, chaveRemover);
        if (encontrado != null) {
            System.out.println("Valor ainda presente na árvore: " + encontrado.chave);
        } else {
            System.out.println("Valor " + chaveRemover + " não está mais na árvore.");
        }

        System.out.println("Árvore AVL após remoção.");
    }

}
