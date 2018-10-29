 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojectpsb;
import java.util.Scanner;
/**
 *
 * @author david
 *
 * 
 * UPDATE: Added Justin's CheckInput method and overloaded it for my needs
 */
public class UseSurfaceTime {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args){
        //Declare arrays here
        int bottomTimeArray[][] = {{10,20,26,30,34,37,41,45,50,54,59,64,70,75,82,88,95,104,112,122,133,145,160,178,199,219},
            {9,17,23,26,29,32,35,38,42,45,49,53,57,62,66,71,76,82,88,94,101,108,116,125,134,147},
            {8,15,19,22,24,27,29,32,35,37,40,43,47,50,53,57,61,64,68,73,77,82,87,92,98},
            {7,13,17,19,21,23,25,27,29,32,34,37,39,42,45,48,50,53,56,60,63,67,70,72},
            {6,11,15,16,18,20,22,24,26,28,30,32,34,36,39,41,43,46,48,51,53,55,56},
            {6,10,13,15,16,18,20,21,23,25,26,28,30,32,34,36,38,40,42,44,45},
            {5,9,12,13,15,16,18,19,21,22,24,25,27,29,30,32,34,36,37},
            {4,8,10,11,13,14,15,17,18,19,21,22,23,25,26,28,29},
            {3,6,8,9,10,11,12,13,14,15,16,17,19,20},
            {3,5,7,8,-1,9,10,11,12,13,14},
            {-1,5,6,-1,7,8,9},
            {-1,4,-1,6,7,8}
        };
        String[][] surfaceTimeArray=
            {{"0:00 to 3:00"}, // A
            {"0:48 to 3:48", "0:00 to 0:47"}, // B
            {"1:10 to 4:10", "0:22 to 1:09", "0:00 to 0:21"}, // C
            {"1:19 to 4:19", "0:31 to 1:18", "0:09 to 0:30", "0:00 to 0:08"}, // D
            {"1:38 to 4:28", "0:39 to 1:27", "0:17 to 0:38", "0:08 to 0:16", "0:00 to 0:07"}, // E
            {"1:35 to 4:35", "0:47 to 1:34", "0:25 to 0:46", "0:16 to 0:24", "0:08 to 0:15", "0:00 to 0:07"}, // F
            {"1:42 to 4:42", "0:54 to 1:41", "0:32 to 0:53", "0:23 to 0:31", "0:14 to 0:22", "0:07 to 0:13", "0:00 to 0:06"}, // G
            {"1:48 to 4:48", "1:00 to 1:47", "0:38 to 0:59", "0:29 to 0:37", "0:21 to 0:28", "0:13 to 0:20", "0:06 to 0:12", "0:00 to 0:05"}, // H
            {"1:54 to 4:54", "1:06 to 1:53", "0:44 to 1:05", "0:35 to 0:43", "0:27 to 0:34", "0:19 to 0:26", "0:12 to 0:18", "0:06 to 0:11", "0:00 to 0:05"}, // I
            {"2:00 to 5:00", "1:12 to 1:59", "0:50 to 1:11", "0:41 to 0:49", "0:32 to 0:40", "0:25 to 0:31", "0:18 to 0:24", "0:12 to 0:17", "0:06 to 0:11", "0:00 to 0:05"}, // J
            {"2:05 to 5:05", "1:17 to 2:04", "0:55 to 1:16", "0:46 to 0:54", "0:38 to 0:45", "0:30 to 0:37", "0:23 to 0:29", "0:17 to 0:22", "0:11 to 0:16", "0:05 to 0:10", "0:00 to 0:04"}, // K
            {"2:10 to 5:10", "1:22 to 2:09", "1:00 to 1:21", "0:51 to 0:59", "0:43 to 0:50", "0:35 to 0:42", "0:28 to 0:34", "0:22 to 0:27", "0:16 to 0:21", "0:10 to 0:15", "0:05 to 0:09", "0:00 to 0:04"}, // L
            {"2:15 to 5:15", "1:26 to 2:14", "1:05 to 1:25", "0:56 to 1:04", "0:47 to 0:55", "0:40 to 0:46", "0:33 to 0:39", "0:26 to 0:32", "0:20 to 0:25", "0:15 to 0:19", "0:10 to 0:14", "0:05 to 0:09", "0:00 to 0:04"}, // M
            {"2:19 to 5:19", "1:31 to 2:18", "1:09 to 1:30", "1:00 to 1:08", "0:52 to 0:59", "0:44 to 0:51", "0:37 to 0:43", "0:31 to 0:36", "0:25 to 0:30", "0:19 to 0:24", "0:14 to 0:18", "0:09 to 0:13", "0:04 to 0:08", "0:00 to 0:03"}, // N
            {"2:24 to 5:24", "1:35 to 2:23", "1:13 to 1:34", "1:04 to 1:12", "0:56 to 1:03", "0:48 to 0:55", "0:42 to 0:47", "0:35 to 0:41", "0:29 to 0:34", "0:24 to 0:28", "0:18 to 0:23", "0:13 to 0:17", "0:09 to 0:12", "0:04 to 0:08", "0:00 to 0:03"}, // O
            {"2:28 to 5:28", "1:39 to 2:27", "1:17 to 1:38", "1:08 to 1:16", "1:00 to 1:07", "0:52 to 0:59", "0:46 to 0:51", "0:39 to 0:45", "0:33 to 0:38", "0:28 to 0:32", "0:22 to 0:27", "0:17 to 0:21", "0:13 to 0:16", "0:08 to 0:12", "0:04 to 0:07", "0:00 to 0:03"}, // P
            {"2:31 to 5:31", "1:43 to 2:30", "1:21 to 1:42", "1:12 to 1:20", "1:04 to 1:11", "0:56 to 1:03", "0:49 to 0:55", "0:43 to 0:48", "0:37 to 0:42", "0:31 to 0:36", "0:26 to 0:30", "0:21 to 0:25", "0:17 to 0:20", "0:12 to 0:16", "0:08 to 0:11", "0:04 to 0:07", "0:00 to 0:03"}, // Q
            {"2:25 to 5:35", "1:47 to 2:34", "1:25 to 1:46", "1:16 to 1:24", "1:08 to 1:15", "1:00 to 1:07", "0:53 to 0:59", "0:47 to 0:52", "0:41 to 0:46", "0:35 to 0:40", "0:30 to 0:39", "0:25 to 0:29", "0:20 to 0:24", "0:16 to 0:19", "0:12 to 0:15", "0:08 to 0:11", "0:04 to 0:07", "0:00 to 0:03"}, // R
            {"2:39 to 5:39", "1:50 to 2:38", "1:28 to 1:49", "1:19 to 1:27", "1:11 to 1:18", "1:04 to 1:10", "0:57 to 1:03", "0:50 to 0:56", "0:44 to 0:49", "0:39 to 0:43", "0:33 to 0:38", "0:28 to 0:32", "0:24 to 0:27", "0:19 to 0:23", "0:15 to 0:18", "0:11 to 0:14", "0:07 to 0:10", "0:04 to 0:06", "0:00 to 0:03"}, // S
            {"2:42 to 5:42", "1:54 to 2:41", "1:32 to 1:53", "1:23 to 1:31", "1:14 to 1:22", "1:07 to 1:13", "1:00 to 1:06", "0:54 to 0:59", "0:48 to 0:53", "0:42 to 0:47", "0:37 to 0:41", "0:32 to 0:36", "0:27 to 0:31", "0:23 to 0:26", "0:18 to 0:22", "0:14 to 0:17", "0:10 to 0:13", "0:07 to 0:10", "0:03 to 0:06", "0:00 to 0:02"}, // T
            {"2:45 to 5:45", "1:57 to 2:44", "1:35 to 1:56", "1:26 to 1:34", "1:18 to 1:25", "1:10 to 1:17", "1:03 to 1:09", "0:57 to 1:02", "0:51 to 0:51", "0:45 to 0:50", "0:40 to 0:44", "0:35 to 0:39", "0:30 to 0:34", "0:26 to 0:29", "0:22 to 0:25", "0:18 to 0:18", "0:14 to 0:17", "0:10 to 0:13", "0:07 to 0:09", "0:03 to 0:06", "0:00 to 0:02"}, // U
            {"2:48 to 2:48", "2:00 to 2:47", "1:38 to 1:59", "1:29 to 1:37", "1:21 to 1:28", "1:13 to 1:20", "1:06 to 1:12", "1:00 to 1:05", "0:54 to 0:59", "0:48 to 0:53", "0:43 to 0:47", "0:38 to 0:42", "0:34 to 0:37", "0:29 to 0:33", "0:25 to 0:28", "0:21 to 0:24", "0:17 to 0:20", "0:13 to 0:16", "0:10 to 0:12", "0:06 to 0:09", "0:03 to 0:05", "0:00 to 0:02"}, // V
            {"2:51 to 5:51", "2:03 to 2:50", "1:41 to 2:02", "1:32 to 1:40", "1:24 to 1:31", "1:16 to 1:23", "1:09 to 1:15", "1:03 to 1:08", "0:57 to 1:02", "0:51 to 0:56", "0:46 to 0:50", "0:41 to 0:45", "0:37 to 0:40", "0:32 to 0:36", "0:28 to 0:31", "0:24 to 0:27", "0:20 to 0:23", "0:16 to 0:19", "0:13 to 0:15", "0:09 to 0:12", "0:06 to 0:08", "0:03 to 0:05", "0:00 to 0:02"}, // W
            {"2:54 to 5:54", "2:06 to 2:53", "1:44 to 2:05", "1:35 to 1:43", "1:27 to 1:34", "1:19 to 1:26", "1:12 to 1:18", "1:06 to 1:11", "1:00 to 1:05", "0:54 to 0:59", "0:49 to 0:53", "0:44 to 0:48", "0:40 to 0:43", "0:35 to 0:39", "0:31 to 0:34", "0:27 to 0:30", "0:23 to 0:26", "0:19 to 0:22", "0:16 to 0:18", "0:12 to 0:15", "0:09 to 0:11", "0:06 to 0:08", "0:03 to 0:05", "0:00 to 0:02"}, // X
            {"2:57 to 5:57", "2:09 to 2:56", "1:47 to 2:08", "1:38 to 1:46", "1:30 to 1:37", "1:22 to 1:29", "1:15 to 1:21", "1:09 to 1:14", "1:03 to 1:08", "0:57 to 1:02", "0:52 to 0:56", "0:47 to 0:51", "0:42 to 0:46", "0:38 to 0:41", "0:34 to 0:37", "0:30 to 0:33", "0:26 to 0:29", "0:22 to 0:25", "0:19 to 0:21", "0:15 to 0:18", "0:12 to 0:14", "0:09 to 0:11", "0:06 to 0:08", "0:03 to 0:05", "0:00 to 0:02"}, // Y
            {"3:00 to 6:00", "2:12 to 2:59", "1:50 to 2:11", "1:41 to 1:49", "1:32 to 1:40", "1:25 to 1:31", "1:18 to 1:24", "1:12 to 1:17", "1:06 to 1:11", "1:00 to 1:05", "0:55 to 0:59", "0:50 to 0:54", "0:45 to 0:49", "0:41 to 0:44", "0:36 to 0:40", "0:32 to 0:35", "0:29 to 0:31", "0:25 to 0:28", "0:21 to 0:24", "0:18 to 0:20", "0:15 to 0:17", "0:12 to 0:14", "0:09 to 0:11", "0:06 to 0:08", "0:03 to 0:05", "0:00 to 0:02"}}; // Z
        String alphabet[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        int depths[] = {10,12,14,16,18,20,22,25,30,35,40,42};
        //END
        //Detemine pressure group with depth and bottom time rounded up
        //Determine number of dives
        int dives = CheckInput("Input number of dives: ", "Error", 0);

        
        int depth = CheckInput("Input depth: ", "Error", 1, 42);
        //Determine first dive's depth
        depth = RoundUp(depth,depths);
        //Round up depth to values in depths array


        //Default value for first pressure group
        String pressureGroup = "null";
        int NDL = 0;
        for (int count=0;count<depths.length;count++){
            if (depth==depths[count]){
                NDL = bottomTimeArray[count][bottomTimeArray[count].length - 1];
                System.out.println("Your NDL is "
                + NDL);
                /**
                 * Use for loop to find depth position in depths array.
                 * Take that position to find the last array
                 * value(In the bottom time array) for that certain depth.
                */
                break;
            }
        }


        int bottomTime = CheckInput("Enter bottom time: ", "Error", 0, NDL);
        for (int count=0;count<depths.length;count++){
        /*
        * Since the array of bottom time is 2D, we need a for loop to find the
        * first bottom time array value to round up (array[FirstValue])
        */
            if (depth==depths[count]){
                /**
                 * count is depth's position in the depths array, which is our
                 * FirstValue. Find BottomTimeArray[FirstValue] and round up to
                 * whatever value is higher
                */
                bottomTime = RoundUp(bottomTime, bottomTimeArray[count]);
            }
        }


        for (int count=0;count<depths.length;count++){  //To find pressure group
            if (depth==depths[count]){
                for (int count2=0;count2<bottomTimeArray[count].length;
                count2++){
                    if(bottomTimeArray[count][count2] == bottomTime){
                        pressureGroup = alphabet[count2];
                        break;
                    }
                }
                break;
            }
        }


        System.out.println("Your pressure group is " + pressureGroup);
        //END

        //For loop for 2+ dives
        for (int coun = 0; coun<dives-1; coun++){
            //Dives - 1 because first dive has already been processed


            /*
            * Determine new pressure group with
            * old pressure group's surface time
            */


            int locationInSurface = 0;
            for (int count = 0; count<alphabet.length; count++){
                if (pressureGroup == alphabet[count]){
                    locationInSurface = count;
                    /*
                    * Since surfaceTime is a 2D array, we need to find
                    * surfaceTime's firstValue again. This is stored in
                    * the variable locationInSurface
                    */
                }
            }


            System.out.print("Please enter total surface time in minutes: ");
            int surfaceTime = input.nextInt();
            //Total surface time in minutes


            String newPressureGroup = "0";      //Setting default value

            for (int count = 0; count<surfaceTimeArray[locationInSurface].length
                ;count++){

                int hour1 = Integer.parseInt
                (SliceRange(surfaceTimeArray[locationInSurface][count],0,1));
                /**
                 * Slice range takes the hour as a substring, then
                 * parseInt converts it to an int
                */

                int minute1 = Integer.parseInt
                (SliceRange(surfaceTimeArray[locationInSurface][count],2,4));

                int totalMinute1 = hour1*60 + minute1;
                /*
                * The above program translates the value in the surfaceTimeArray
                * which is a string, to an int value in minutes. hour1 x 60 and
                * minute1 are then added to totalMinute1. This will be our
                * minimum value for if else tests. ex. "3.30 to 4.30", 3.30 is
                * our totalMinute1(3 * 60 + 30)
                */


                int hour2 = Integer.parseInt
                (SliceRange(surfaceTimeArray[locationInSurface][count],8,9));

                int minute2 = Integer.parseInt
                (SliceRange(surfaceTimeArray[locationInSurface][count],10,12));

                int totalMinute2 = hour2*60 + minute2;
                /*
                * Same process as totalMinute1 but takes the second part.
                * ex. "3.30 to 4.30", 4.30 is out totalMinute2
                */




                if(surfaceTime>=totalMinute1 && surfaceTime<=totalMinute2){
                    newPressureGroup = alphabet[count];
                    /*
                    * So we compare each of the min and max values of each value
                    * in surfaceTimeArray[FirstValue] then fit in the user's
                    * into each value. If it fits, break and we got our new
                    * pressure group. Get the letter with alphabet[count]
                    */
                    break;
                }
            }

            System.out.println
            ("Your new pressure group is " + newPressureGroup);
            //Simply print out new pressure group afer surface time
            //END


            /*
            * Determine new NDL using new pressure group and ask for
            * depth and bottom time
            */


            int newNDL = 0;
            int actualBottomTime = 0;
            //Defaut values

            depth = CheckInput("Input depth: ", "Error", 1, 42);
            depth = RoundUp(depth, depths);
            //Input depth and round up based on values in depths array

            for (int count = 0; count<depths.length; count++){
                /**
                 * To get actualBottomTime we need its position in the
                 * bottomTimeArray
                 */
                if (depth == depths[count]){
                    /**
                     * With this if statement, we get the first value from the
                     * user's input. Again, bottomTimeArray is a 2D array,
                     * count is our firstValue
                     */

                    for (int count2 = 0; count2<alphabet.length;count2++){
                        if (newPressureGroup == alphabet[count2]){
                            /**
                             * With this if statement, we get the second value
                             * from our current pressure group
                             */

                            actualBottomTime = bottomTimeArray[count][count2];
                            //Now we just store the value into a variable

                            newNDL = bottomTimeArray[count]
                            [bottomTimeArray[count].length - 1] -
                            actualBottomTime;
                            /**
                             * Then we can get our new NDL by subtracting the
                             * original NDL by th actualBottomTime
                             */
                        }
                    }
                }
            }
            System.out.println("Your new NDL is " + newNDL);
            //Prints out newNDL


            bottomTime = CheckInput("Input new bottom time: ","Error",1,newNDL) + actualBottomTime;
            /**
             * Take user input and store it in bottomTime, add actualBottomTime
             * to it
            */


            for (int count=0;count<depths.length;count++){
                /**
                 * Again, bottomTimeArray is 2D, so we need our first value to
                 * which is the position of the depth to round up
                 */

                if (depth==depths[count]){
                    //If statement to get our depth's position

                    bottomTime = RoundUp(bottomTime, bottomTimeArray[count]);
                    /**
                     * Use depth's array position as firstValue to
                     * bottomTimeArray. So now we have the 1D array we need to
                     * round up bottom time
                    */
                    }
            }

            System.out.println
            ("Your total bottom time is "+ bottomTime + " minutes");
            //Print out total bottom time


            for (int count=0;count<depths.length;count++){
                //Find pressure group
                if (depth==depths[count]){
                /**
                 * Same process as before. To put it simply, this is like
                 * sliding your finger horizontally through the depths row
                 */


                    for (int count2=0;count2<bottomTimeArray[count].length;
                    count2++){

                        if(bottomTimeArray[count][count2] == bottomTime){
                            /**
                             * This is like sliding your finger down from your
                             * current depth until you find your bottom time
                             */

                            pressureGroup = alphabet[count2];
                            //With that, slide left and that's ur pressure group
                            break;
                        }
                    }
                    break;
                }
            }
            System.out.println("Your new pressure group is " + pressureGroup);

            //END
        }
    }


    public static int RoundUp(int i, int[] array){  //Method to round up
        /**
         * RoundUp takes an int and an array as value
         */
        int d = 0;
        //int d is the new rounded number, which we will return

        for(int count=0;count<array.length;count++){
            //This for loop will loop through each of the values in a 1D array
            if (i<=array[count]){
                /**
                 * If the given int is less than or equal to one value, we set
                 * int d to that value and end the loop.
                 */
                d = array[count];
                break;
            }
        }
        return d;
    }


    public static String SliceRange(String s, int startIndex, int endIndex) {
        //Method to take part of a string
        //I just took it from the internet, don't know how it works
        //THIS IS OOP :D not 
        if (startIndex < 0) startIndex = s.length() + startIndex;
        if (endIndex < 0) endIndex = s.length() + endIndex;
        return s.substring(startIndex, endIndex);
    }
    
     public static int CheckInput(String showUser,String ErrorMessage,int minValue,int maxValue) {
        int d = 0;
        boolean valid = false;
        
        do{
        System.out.print(showUser);
        if(input.hasNextInt()){
           d = input.nextInt();
            if (d < minValue || d > maxValue) {
                System.out.println(ErrorMessage);
            }else  {
                valid = true;
            }
        }
        else{
            System.out.print("Not a valid input!\n");
            input.next();
        }
        }while(valid == false);
        return d;
    }
     public static int CheckInput(String showUser,String ErrorMessage,int minValue) {
        int d = 0;
        boolean valid = false;
        
        do{
        System.out.print(showUser);
        if(input.hasNextInt()){
           d = input.nextInt();
            if (d < minValue) {
                System.out.println(ErrorMessage);
            }else  {
                valid = true;
            }
        }
        else{
            System.out.print("Not a valid input!\n");
            input.next();
        }
        }while(valid == false);
        return d;
    }
     
}
