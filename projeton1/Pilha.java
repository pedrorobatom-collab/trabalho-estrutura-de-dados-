public class Pilha {

    private String[] itens;
    private int topo;

    public Pilha(int tamanho) {
        itens = new String[tamanho];
        topo = -1;
    }

    public boolean empilhar(String item) {
        if (topo == itens.length - 1) {
            return false;
        }

        itens[++topo] = item;
        return true;
    }

    public String desempilhar() {
        if (topo == -1) {
            return null;
        }

        return itens[topo--];
    }

    public String topo() {
        if (topo == -1) {
            return null;
        }

        return itens[topo];
    }

    public boolean vazio() {
        return topo == -1;
    }
}