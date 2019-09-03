
import java.util.Scanner;

class QuestionOne {

    private static int count(int[] S, int m, int n) {
        // If n is 0 then there is 1 solution
        // (do not include any coin)
        if (n == 0)
            return 1;

        // If n is less than 0 then no solution exists
        if (n < 0)
            return 0;

        // If there are no coins and n
        // is greater than 0, then no solution exist
        if (m <= 0 && n >= 1)
            return 0;

        // count is sum of solutions (i) including S[m-1] (ii) excluding S[m-1]
        return count(S, m - 1, n) +
                count(S, m, n - S[m - 1]);
    }


    public static void main(String[] args) {
        int sum = 0;
        //Get the Value from user for Amount
        System.out.println("Enter the Amount :");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        //Get the Value from user for total Coins
        System.out.println("Enter the MAX Coins number :");
        int c = in.nextInt();

        int size = 100;
        int[] arr = new int[size];
        //Get the Value from user for coins
        System.out.println("Enter the Coins :");

        //To Store value of Coins in Array
        for (int i = 0; i < c; i++) {
            arr[i] = in.nextInt();
            sum = sum + arr[i];
        }

        System.out.println("Possoble Combinations are :" + count(arr, c, n));
    }
}




