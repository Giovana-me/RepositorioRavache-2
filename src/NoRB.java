public class NoRB {
    int valor;
    Cor cor;
    NoRB esquerdo, direito, pai;

    public NoRB(int valor) {
        this.valor = valor;
        this.cor = Cor.VERMELHO;
        this.esquerdo = null;
        this.direito = null;
        this.pai = null;
    }
}
