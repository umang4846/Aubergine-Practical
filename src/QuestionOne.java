
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This Program is used to perform Coin Change problem
 * need to pass coin Amount first
 * then, need to pass total no. of coins
 * then, need to pass the coins
 * Program will return the all the possible combinations of coins for the Entered amount
 * Also return total no. of possible combinations
 */
class QuestionOne {

    //List to store temp
    private static List<Integer> temp = new ArrayList<>();

    //Static method used to prevent make copy in the memory
    private static int count(int[] arr, int coinsCount, int target, List<Integer> t) {
        if (target == 0) {
            System.out.print("{ ");
            for (int l = 0; l < t.size(); l++) {
                System.out.print(t.get(l));
                //if not a last iteration, then print ( , )
                if (!(l == t.size() - 1))
                    System.out.print(", ");
            }
            System.out.print(" }");
            System.out.println();
            return 1;
        }
        if (target < 0) {
            // t.remove(t.size()-1);
            return 0;
        }
       // if (coinsCount <= 0 && target >= 1) {
        if (coinsCount <= 0) {
            return 0;
        }

        int i = count(arr, coinsCount - 1, target, t);
        t.add(arr[coinsCount - 1]);
        int j = count(arr, coinsCount, target - arr[coinsCount - 1], t);
        t.remove(t.indexOf(arr[coinsCount - 1]));

        return i + j;
    }

    public static void main(String[] args) {
        // int arr[] = {1, 2, 3, 4};
        // int m = arr.length;
        // System.out.println("No of ways are : "+ count(arr,m,4, temp));

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

        System.out.println("No of total Combinations are : " + count(arr, c, n, temp));
    }
}




