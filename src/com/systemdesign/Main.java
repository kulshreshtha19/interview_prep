package com.systemdesign;
//- 2-4 player can play (each player will have 4 coins
//        - 2 type of boxes
//        - normal : if coin is already there and another coin comes on this previous coin will start again
//        - special : if coin is already there and another coin comes on this - nothing happnes both will take this position
//        - no need to open on 6, any no comes player can start the coin
//        - we need to complete the round of board to make a coin home
//        - player whose all coins reaches home is winner
//
//
//Player
//Name
//
//
//
//
//Board
//No. of steps
//No. of  special boxes;
//No. of normal boxes;
//List<int> specialIndex;
//
//Status
//Player player;
//int step;
//



class Main {
    public static void main(String[] args) {
        int[] arr = {3,6,10,11,12,35,37};

        int start = 0;
        int end = arr.length-1;
        int search = 37;
        boolean flag = false;
        while (start<=end) {
            int mid = (start + end)/2;
            if(arr[mid] == search) {
                flag = true;
                System.out.println("True");
                break;
            }

            else if(arr[mid]<search) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if (!flag) {
            System.out.println("False");
        }
    }
}


//git clone ""
//git status
//git checkout "a"
//git merge b
