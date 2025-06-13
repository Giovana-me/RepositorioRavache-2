public class MainRB {
    public static void main(String[] args) {
        ArvoreRB arvoreRB = new ArvoreRB();

        arvoreRB.inserir(10);
        arvoreRB.inserir(5);
        arvoreRB.inserir(15);
        arvoreRB.inserir(3);
        arvoreRB.inserir(7);

        System.out.println("Árvore Rubro-Negra:");
        arvoreRB.exibirArvore();

        System.out.println("\nRemovendo 5...");
        arvoreRB.remover(5);

        System.out.println("Árvore após remoção:");
        arvoreRB.exibirArvore();
    }
}
