import java.util.Scanner;
import java.util.ArrayList;

class Main {
    static void findOrder(ArrayList<Integer> seq, int H, int left_smaller_node, int right_bigger_node) {
        if(H == 0 || left_smaller_node > right_bigger_node) return; // se chegar numa folha ou se a subárvore for vazia, retorna
        int right_total_nodes = (int)Math.pow(2, H - 1) - 1; // calcula total (máximo) de nós na subárvore à direita
        int root = right_bigger_node - right_total_nodes; // descobre índice da raíz
        if(root < left_smaller_node) root = left_smaller_node; // se a raíz for menor que o menor nó da subárvore à esquerda, então ajusta a raíz para esse limite
        seq.add(root); // adiciona raíz
        /*
            H -> H - 1 porque desce um nível na árvore
            para subárvore à esquerda:
                limite esquerdo se mantém
                limite direito é a raíz - 1
            para subárvore à direita:
                limite direito se mantém
                limite esquerdo é a raíz + 1
        */
        findOrder(seq, H - 1, left_smaller_node, root - 1); // recursão na subárvore à esquerda
        findOrder(seq, H - 1, root + 1, right_bigger_node); // recursão na subárvore à direita
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int case_num = 1;
        ArrayList<Integer> seq = new ArrayList<>();
        while(true) {
            int N = sc.nextInt();
            int H = sc.nextInt();
            if(N == 0 && H == 0) break;
            if((int)Math.pow(2, H) - 1 < N) { // 2^H - 1 é o número máximo de nós de uma árvore de altura H
                System.out.println("Case " + case_num++ + ": Impossible.");
                continue;
            }
            if(H > N) // sim, é possível, por incrível que pareça
                H = N;
            seq.clear();
            findOrder(seq, H, 1, N);
            System.out.print("Case " + case_num++ + ": ");
            for (int i = 0; i < seq.size(); i++) {
                System.out.print(seq.get(i));
                if(i == seq.size() - 1)
                    System.out.println();
                else
                    System.out.print(" ");
            }
        }
    }
}