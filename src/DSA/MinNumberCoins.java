package DSA;

import java.util.*;
public class MinNumberCoins {
    public static void main(String[] args) {

//        int V = 24;
//        ArrayList < Integer > ans = new ArrayList < > ();
//        int coins[] = {7,8,9};
//        int n = coins.length;
//        for (int i = n - 1; i >= 0; i--) {
//            while (V >= coins[i]) {
//                V -= coins[i];
//                ans.add(coins[i]);
//            }
//        }
//        System.out.println("The minimum number of coins is "+ans.size());
//        System.out.println("The coins are ");
//        for (int i = 0; i < ans.size(); i++) {
//            System.out.print(" " + ans.get(i));
//        }
        List<Integer> temp = new ArrayList<>();
        String s = "1234";
        int i = 0;
        int index = 3;
        String swapStr = s.substring(0,i) + s.charAt(index) + s.substring(i, index) + s.substring(index+1);
        System.out.println(swapStr);


    }
}
