public class MainAVL2 {
    public static void main(String[] args) {

        ArvoreAVL arvoreAVL = new ArvoreAVL();

        int[] chaves = {10, 20, 30, 40, 50, 25};

        for (int chave : chaves) {
            arvoreAVL.raiz = arvoreAVL.inserir(arvoreAVL.raiz, chave);
        }

        System.out.print("Percurso em ordem da árvore AVL: ");
        arvoreAVL.percursoEmOrdem(arvoreAVL.raiz);
    }
}
