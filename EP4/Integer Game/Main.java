import java.util.Scanner;

public class Main {
    private static char solve(String number) {
        if(number.length() == 1)
            return 'S';

        // 1) verificar se tem como retirar um não divisor na primeira jogada
        boolean non_divisible_first_play = false;

        int sum = 0;
        int divisible_total = 0;
        for(int i = 0; i < number.length(); i++) {
            int num = Character.getNumericValue(number.charAt(i));
            if(num % 3 == 0) {
                divisible_total++;
            }
            sum += num;
        }
        for(int i = 0; i < number.length(); i++) {
            int non_divisible_candidate = Character.getNumericValue(number.charAt(i));
            if(non_divisible_candidate % 3 == 0)
                continue;
            if((sum - non_divisible_candidate) % 3 == 0) {
                non_divisible_first_play = true;
                break;
            }
        }

        // se tem não divisível para a primeira jogada
        if(non_divisible_first_play)
            // já sabemos que o total da soma não é divisível
            // se total de divisíveis for par
            if(divisible_total % 2 == 0)
                return 'S';
            else {
                return 'T';
            }
        // se não tem não divisível para a primeira jogada
        else
            if(sum % 3 == 0)
                if(divisible_total % 2 == 0)
                    return 'T';
                else {
                    return 'S';
                }
            else
                return 'T';
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num_cases = sc.nextInt();
        for (int i = 0; i < num_cases; i++) {
            String number = sc.next();
            System.out.println("Case " + (i + 1) + ": " + solve(number));
        }
    }
}
