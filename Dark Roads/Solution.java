import java.util.Scanner;

class Solution {
    static int[] receiveNextLine() {
        Scanner sc = new Scanner(System.in);
        String[] current_strings = sc.nextLine().split(" ");
        int[] current_nums = new int[3];
        for (int i = 0; i < current_strings.length; i++) {
            current_nums[i] = Integer.parseInt(current_strings[i]);
        }
        sc.close();
        return current_nums;
    }
    
    public static void main(String[] args) {
        int[] current_nums = receiveNextLine();
        int num_junctions = current_nums[0];
        int num_roads = current_nums[1];

        do {
            // assume-se que há apenas um caminho entre dois nós
            int[][] matriz_adjacencia = new int[200000][200000];
            current_nums = receiveNextLine();
            matriz_adjacencia[current_nums[0]][current_nums[1]] = current_nums[2];
                matriz_adjacencia[current_nums[1]][current_nums[0]] = current_nums[2];

        } while(current_nums.length == 3);

        while(num_junctions != 0 && num_roads != 0) {

        }
    }
}
