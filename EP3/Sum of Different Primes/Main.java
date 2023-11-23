import java.util.Scanner;

class Main {
    private static int count = 0;
    private static int solve(int n, int k, int sum, int start) {
        if (k > 0)
            for (int i = start; i <= n-sum; i++) {
                if (isPrime(i)) {
                    System.out.println("n="+n+" k="+k+" sum="+sum+" i="+i);
                    if (sum+i == n && k == 1) {
                        count++;
                        System.out.println("contou!");
                    }
                    solve(n, k - 1, sum+i, i + 1);
                }
            }
        return count;
    }

    private static boolean isPrime(int i) {
        for (int j = 2; j < i; j++) {
            if (i % j == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            if(n == 0 && k == 0) break;
            count = 0;
            System.out.println(solve(n, k, 0, 2));
        }
    }

}
