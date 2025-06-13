public class ArvoreRB {
    private NoRB raiz;

    public ArvoreRB() {
        raiz = null;
    }

    public void inserir(int valor) {
        NoRB novo = new NoRB(valor);
        raiz = inserirRec(raiz, novo);
        ajustarInsercao(novo);
    }

    private NoRB inserirRec(NoRB raiz, NoRB no) {
        if (raiz == null) return no;
        if (no.valor < raiz.valor) {
            raiz.esquerdo = inserirRec(raiz.esquerdo, no);
            raiz.esquerdo.pai = raiz;
        } else {
            raiz.direito = inserirRec(raiz.direito, no);
            raiz.direito.pai = raiz;
        }
        return raiz;
    }

    private void ajustarInsercao(NoRB no) {
        while (no != raiz && no.pai.cor == Cor.VERMELHO) {
            NoRB avo = no.pai.pai;
            if (no.pai == avo.esquerdo) {
                NoRB tio = avo.direito;
                if (cor(tio) == Cor.VERMELHO) {
                    no.pai.cor = Cor.PRETO;
                    tio.cor = Cor.PRETO;
                    avo.cor = Cor.VERMELHO;
                    no = avo;
                } else {
                    if (no == no.pai.direito) {
                        no = no.pai;
                        rotacaoEsquerda(no);
                    }
                    no.pai.cor = Cor.PRETO;
                    avo.cor = Cor.VERMELHO;
                    rotacaoDireita(avo);
                }
            } else {
                NoRB tio = avo.esquerdo;
                if (cor(tio) == Cor.VERMELHO) {
                    no.pai.cor = Cor.PRETO;
                    tio.cor = Cor.PRETO;
                    avo.cor = Cor.VERMELHO;
                    no = avo;
                } else {
                    if (no == no.pai.esquerdo) {
                        no = no.pai;
                        rotacaoDireita(no);
                    }
                    no.pai.cor = Cor.PRETO;
                    avo.cor = Cor.VERMELHO;
                    rotacaoEsquerda(avo);
                }
            }
        }
        raiz.cor = Cor.PRETO;
    }

    public void remover(int valor) {
        NoRB no = buscarNo(raiz, valor);
        if (no == null) return;

        NoRB y = no;
        Cor corOriginal = y.cor;
        NoRB x;

        if (no.esquerdo == null) {
            x = no.direito;
            transplantar(no, no.direito);
        } else if (no.direito == null) {
            x = no.esquerdo;
            transplantar(no, no.esquerdo);
        } else {
            y = minimo(no.direito);
            corOriginal = y.cor;
            x = y.direito;
            if (y.pai == no) {
                if (x != null) x.pai = y;
            } else {
                transplantar(y, y.direito);
                y.direito = no.direito;
                y.direito.pai = y;
            }
            transplantar(no, y);
            y.esquerdo = no.esquerdo;
            y.esquerdo.pai = y;
            y.cor = no.cor;
        }

        if (corOriginal == Cor.PRETO) {
            ajustarRemocao(x);
        }
    }

    private void ajustarRemocao(NoRB x) {
        while (x != raiz && cor(x) == Cor.PRETO) {
            if (x == x.pai.esquerdo) {
                NoRB w = x.pai.direito;
                if (cor(w) == Cor.VERMELHO) {
                    w.cor = Cor.PRETO;
                    x.pai.cor = Cor.VERMELHO;
                    rotacaoEsquerda(x.pai);
                    w = x.pai.direito;
                }
                if (cor(w.esquerdo) == Cor.PRETO && cor(w.direito) == Cor.PRETO) {
                    w.cor = Cor.VERMELHO;
                    x = x.pai;
                } else {
                    if (cor(w.direito) == Cor.PRETO) {
                        if (w.esquerdo != null) w.esquerdo.cor = Cor.PRETO;
                        w.cor = Cor.VERMELHO;
                        rotacaoDireita(w);
                        w = x.pai.direito;
                    }
                    w.cor = x.pai.cor;
                    x.pai.cor = Cor.PRETO;
                    if (w.direito != null) w.direito.cor = Cor.PRETO;
                    rotacaoEsquerda(x.pai);
                    x = raiz;
                }
            } else {
                NoRB w = x.pai.esquerdo;
                if (cor(w) == Cor.VERMELHO) {
                    w.cor = Cor.PRETO;
                    x.pai.cor = Cor.VERMELHO;
                    rotacaoDireita(x.pai);
                    w = x.pai.esquerdo;
                }
                if (cor(w.direito) == Cor.PRETO && cor(w.esquerdo) == Cor.PRETO) {
                    w.cor = Cor.VERMELHO;
                    x = x.pai;
                } else {
                    if (cor(w.esquerdo) == Cor.PRETO) {
                        if (w.direito != null) w.direito.cor = Cor.PRETO;
                        w.cor = Cor.VERMELHO;
                        rotacaoEsquerda(w);
                        w = x.pai.esquerdo;
                    }
                    w.cor = x.pai.cor;
                    x.pai.cor = Cor.PRETO;
                    if (w.esquerdo != null) w.esquerdo.cor = Cor.PRETO;
                    rotacaoDireita(x.pai);
                    x = raiz;
                }
            }
        }
        if (x != null) x.cor = Cor.PRETO;
    }

    public boolean buscar(int valor) {
        return buscarRec(raiz, valor);
    }

    private boolean buscarRec(NoRB no, int valor) {
        if (no == null) return false;
        if (valor == no.valor) return true;
        return valor < no.valor ? buscarRec(no.esquerdo, valor) : buscarRec(no.direito, valor);
    }

    private NoRB buscarNo(NoRB no, int valor) {
        while (no != null && valor != no.valor) {
            if (valor < no.valor) no = no.esquerdo;
            else no = no.direito;
        }
        return no;
    }

    private void rotacaoEsquerda(NoRB x) {
        NoRB y = x.direito;
        x.direito = y.esquerdo;
        if (y.esquerdo != null) y.esquerdo.pai = x;
        y.pai = x.pai;
        if (x.pai == null) raiz = y;
        else if (x == x.pai.esquerdo) x.pai.esquerdo = y;
        else x.pai.direito = y;
        y.esquerdo = x;
        x.pai = y;
    }

    private void rotacaoDireita(NoRB x) {
        NoRB y = x.esquerdo;
        x.esquerdo = y.direito;
        if (y.direito != null) y.direito.pai = x;
        y.pai = x.pai;
        if (x.pai == null) raiz = y;
        else if (x == x.pai.direito) x.pai.direito = y;
        else x.pai.esquerdo = y;
        y.direito = x;
        x.pai = y;
    }

    private void transplantar(NoRB u, NoRB v) {
        if (u.pai == null) raiz = v;
        else if (u == u.pai.esquerdo) u.pai.esquerdo = v;
        else u.pai.direito = v;
        if (v != null) v.pai = u.pai;
    }

    private NoRB minimo(NoRB no) {
        while (no.esquerdo != null) no = no.esquerdo;
        return no;
    }

    private Cor cor(NoRB no) {
        return (no == null) ? Cor.PRETO : no.cor;
    }

    public void exibirArvore() {
        exibirArvore(raiz, "", true);
    }

    private void exibirArvore(NoRB no, String prefixo, boolean ehUltimo) {
        if (no != null) {
            System.out.println(prefixo + (ehUltimo ? "└── " : "├── ") +
                    no.valor + " (" + no.cor + ")");
            exibirArvore(no.esquerdo, prefixo + (ehUltimo ? "    " : "│   "), false);
            exibirArvore(no.direito, prefixo + (ehUltimo ? "    " : "│   "), true);
        }
    }
}