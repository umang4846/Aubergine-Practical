import java.util.Scanner;

public class QuestionTwo {

    // Static class variable
    private static int maxCount = 0, count = 0, iLen = 0, jLen = 0;

    private static int maxCount(String S[][], int i, int j)
    {
        if(i<0 || i>=iLen || j<0 || j>=jLen ){
            return 0;
        }

        if("S".equals(S[i][j])){
            S[i][j] = "O";
            //Incrementing Counter
            count++;
            //Recursion
            maxCount(S, i-1,j-1);
            maxCount(S, i,j-1);
            maxCount(S, i+1,j-1);
            maxCount(S, i+1,j);
            maxCount(S, i+1,j+1);
            maxCount(S, i,j+1);
            maxCount(S, i-1,j+1);
            maxCount(S, i-1,j);
        }
        return 1;
    }

    public static void main(String[] args)
    {
        //Creating Scanner class object
        Scanner s = new Scanner(System.in);
        System.out.println("Enter total no. of rows");
        int k = s.nextInt(); //Total Rows
        System.out.println("Enter total no. of columns");
        int l = s.nextInt();  // Total Columns

        //Defining Array based on User Entered Rows & Columns
        String arr[][] = new String[k][l];

        //Iterating Loop to get value from the user by Row & Column Index
        for(int i=0;i<k;i++){
            for(int j=0;j<l;j++){
                System.out.println("Enter ["+ i+"] ["+j+"] element");
                arr[i][j] = s.next();
            }
        }

        // {{"X", "X", "S","S", "X", "X"},
        //               {"X", "X", "S","S", "X", "S"},
        //               {"S", "X", "X","X", "X", "S"},
        //               {"X", "X", "X","X", "S", "S"},
        //               {"X", "X", "S","X", "S", "X"}
        // };

        iLen = arr.length;
        jLen = arr[iLen-1].length;

        for(int i=0;i<iLen;i++){
            for(int j=0;j<jLen;j++){
                maxCount(arr, i, j);
                if(maxCount<count){
                    maxCount = count;
                }
                count=0;
            }
        }
        System.out.println(maxCount);
    }
}
