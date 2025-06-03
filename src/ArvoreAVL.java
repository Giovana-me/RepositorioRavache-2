public class ArvoreAVL {
    NoAVL raiz;

    private int altura(NoAVL noAVL) {
        if (noAVL == null) {
            return 0;
        } else {
            return noAVL.altura;
        }
    }

    private int fatorBalanceamento(NoAVL noAVL) {
        if (noAVL == null) {
            return 0;
        } else {
            return altura(noAVL.esquerda) - altura(noAVL.direita);
        }
    }

    private NoAVL rotacaoEsquerda(NoAVL x) {
        NoAVL y = x.direita;
        NoAVL T2 = y.direita;

        y.esquerda = x;
        x.direita = T2;

        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;
        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;

        return y;
    }

    private NoAVL rotacaoDireita(NoAVL y) {
        NoAVL x = y.esquerda;
        NoAVL T2 = x.direita;

        x.direita = y;
        y.esquerda = T2;

        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;
        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;

        return x;
    }

    public NoAVL inserir(NoAVL noAVL, int chave) {
        if (noAVL == null) {
            return new NoAVL(chave);
        }

        if (chave < noAVL.chave) {
            noAVL.esquerda = inserir(noAVL.esquerda, chave);
        } else if (chave > noAVL.chave) {
            noAVL.direita = inserir(noAVL.direita, chave);
        } else {
            return noAVL;
        }

        noAVL.altura = 1 + Math.max(altura(noAVL.esquerda), altura(noAVL.direita));

        int balanceamento = fatorBalanceamento(noAVL);

        if (balanceamento > 1) {
            if (chave < noAVL.esquerda.chave) {
                return rotacaoDireita(noAVL);
            } else {
                noAVL.esquerda = rotacaoEsquerda(noAVL.esquerda);
                return rotacaoDireita(noAVL);
            }
        }

        if (balanceamento < -1) {
            if (chave > noAVL.direita.chave) {
                return rotacaoEsquerda(noAVL);
            } else {
                noAVL.direita = rotacaoDireita(noAVL.direita);
                return rotacaoEsquerda(noAVL);
            }
        }

        return noAVL;
    }

    public NoAVL remover(NoAVL noAVL, int chave) {
        if (noAVL == null) {
            return null;
        }

        if (chave < noAVL.chave) {
            noAVL.esquerda = remover(noAVL.esquerda, chave);
        } else if (chave > noAVL.chave) {
            noAVL.direita = remover(noAVL.direita, chave);
        } else {
            if (noAVL.esquerda == null && noAVL.direita == null) {
                return null;
            }
            else if (noAVL.esquerda == null) {
                return noAVL.direita;
            } else if (noAVL.direita == null) {
                return noAVL.esquerda;
            }
            else {
                NoAVL substituto = encontrarValorMenor(noAVL.direita);
                noAVL.chave = substituto.chave;
                noAVL.direita = remover(noAVL.direita, substituto.chave);
            }
        }

        noAVL.altura = 1 + Math.max(altura(noAVL.esquerda), altura(noAVL.direita));

        int balanceamento = fatorBalanceamento(noAVL);

        if (balanceamento > 1) {
            if (fatorBalanceamento(noAVL.esquerda) >= 0) {
                return rotacaoDireita(noAVL);
            } else {
                noAVL.esquerda = rotacaoEsquerda(noAVL.esquerda);
                return rotacaoDireita(noAVL);
            }
        }

        if (balanceamento < -1) {
            if (fatorBalanceamento(noAVL.direita) <= 0) {
                return rotacaoEsquerda(noAVL);
            } else {
                noAVL.direita = rotacaoDireita(noAVL.direita);
                return rotacaoEsquerda(noAVL);
            }
        }

        return noAVL;
    }

    private NoAVL encontrarValorMenor(NoAVL noAVL) {
        while (noAVL.esquerda != null) {
            noAVL = noAVL.esquerda;
        }
        return noAVL;
    }

    public NoAVL buscar(NoAVL noAVL, int chave) {
        if (noAVL == null) {
            return null;
        }

        if (noAVL.chave == chave) {
            return noAVL;
        }

        if (chave < noAVL.chave) {
            return buscar(noAVL.esquerda, chave);
        } else {
            return buscar(noAVL.direita, chave);
        }
    }
}
