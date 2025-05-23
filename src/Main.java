public class Main {
    public static void main(String[] args) {
        Arvore arvore = new Arvore();
        ArvoreSemRecursividade arvoreSR = new ArvoreSemRecursividade();

        arvore.raiz = new No("A");
        arvore.raiz.esquerdo = new No("B");
        arvore.raiz.direito = new No("C");
        arvore.raiz.esquerdo.esquerdo = new No("D");
        arvore.raiz.esquerdo.direito = new No("E");
        arvore.raiz.direito.direito = new No("F");

        arvoreSR.raiz = new No("1");
        arvoreSR.raiz.esquerdo = new No("2");
        arvoreSR.raiz.direito = new No("3");
        arvoreSR.raiz.esquerdo.esquerdo = new No("4");
        arvoreSR.raiz.esquerdo.direito = new No("5");
        arvoreSR.raiz.direito.direito = new No("6");

        int totalNos = arvore.contarNos();
        System.out.println("Total de nós: " + totalNos);

        System.out.println("Travessia em pré-ordem: ");
        arvore.percorrerEmPreOrdem();

        System.out.println();

        System.out.println("Travessia em ordem: ");
        arvore.percorrerEmOrdem();

        System.out.println();

        System.out.println("Travessia em pós-ordem: ");
        arvore.percorrerEmPosOrdem();

        System.out.println();

        System.out.println("Travessia em nível: ");
        arvore.percorrerEmNivel();

        System.out.println();

        int totalNosIterativo = arvoreSR.contarNosIterativo();
        System.out.println("Total de nós: (iterativo)" + totalNosIterativo);
    }
}