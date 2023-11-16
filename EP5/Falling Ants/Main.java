import java.util.Scanner;

class Ant {
    int length;
    int weight;
    int height;
    int volume;

    public Ant(int length, int weight, int height) {
        this.length = length;
        this.weight = weight;
        this.height = height;
        this.volume = length * weight * height;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num_cases = sc.nextInt();
        while(num_cases != 0) {
            Ant taller_ant = new Ant(0, 0, 0);
            for(int i = 0; i < num_cases; i++) {
                int length = sc.nextInt();
                int weight = sc.nextInt();
                int height = sc.nextInt();
                Ant currentAnt = new Ant(length, weight, height);
                if(height > taller_ant.height || (height == taller_ant.height && currentAnt.volume > taller_ant.volume))
                    taller_ant = currentAnt;
            }
            System.out.println(taller_ant.volume);
            num_cases = sc.nextInt();
        }
        // m n
        // O(m*n)
    }
}
