import java.util.Scanner;

public class Main {
    private static char solve(String number) {
        if(number.length() == 1)
            return 'S';

        // flag que verifica se existe inicialmente um dígito não divisível por 3 que possa ser removido (isto é, se removido resulta em uma soma de dígitos divisível por 3)
        // ex: 777369 -> flag = false
        //     7369 -> flag = true
        boolean removable_non_divisible_first_play = false;

        int sum = 0;
        int divisible_total = 0;
        // verifica a qtd total de dígitos divisíveis e soma todos os dígitos
        for(int i = 0; i < number.length(); i++) {
            int num = Character.getNumericValue(number.charAt(i));
            if(num % 3 == 0) {
                divisible_total++;
            }
            sum += num;
        }
        // verifica se a soma na primeira jogada não é divisível por 3
        for(int i = 0; i < number.length(); i++) {
            int non_divisible_candidate = Character.getNumericValue(number.charAt(i));
            if(non_divisible_candidate % 3 == 0)
                continue;
            if((sum - non_divisible_candidate) % 3 == 0) {
                removable_non_divisible_first_play = true;
                break;
            }
        }

        // se tivermos um não divisível retirável na primeira jogada
        if(removable_non_divisible_first_play)
            // se total de divisíveis for par
            if(divisible_total % 2 == 0)
                return 'S';
            else {
                return 'T';
            }
        // se não tivermos um não divisível retirável na primeira jogada
        else
            // se a soma for divisível
            if(sum % 3 == 0)
                // se o total de divisíveis for par
                if(divisible_total % 2 == 0)
                    return 'T';
                // se o total de divisíveis for ímpar
                else {
                    return 'S';
                }
            // se a soma não for divisível
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
        // n m -> O(n*m)
    }
}
