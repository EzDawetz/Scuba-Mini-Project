
package miniprojectpsb;
import java.util.Scanner;
/**
 *
 * @author david
 *
 * 
 * UPDATE: Added Justin's CheckInput method and overloaded it for my needs
 */
public class UseSurfaceTime extends vars{
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args){
        //Declare arrays here
        
        
        //END
        //Detemine pressure group with depth and bottom time rounded up
        //Determine number of dives
        int dives = CheckInput("Input number of dives: ", "Error", 0,10);

        
        int depth = CheckInput("Input depth: ", "Error", 1, 42);
        //Determine first dive's depth
        depth = RoundUp(depth,depthsArray);
        //Round up depth to values in depthsArray array 


        //Default value for first pressure group
        String pressureGroup = "null";
        int NDL = 0;
        for (int count=0;count<depthsArray.length;count++){
            if (depth==depthsArray[count]){
                NDL = bottomTimeArray[count][bottomTimeArray[count].length - 1];
                System.out.println("Your NDL is "
                + NDL);
                /**
                 * Use for loop to find depth position in depthsArray array.
                 * Take that position to find the last array
                 * value(In the bottom time array) for that certain depth.
                */
                break;
            }
        }


        int bottomTime = CheckInput("Enter bottom time: ", "Error", 0, NDL);
        for (int count=0;count<depthsArray.length;count++){
        /*
        * Since the array of bottom time is 2D, we need a for loop to find the
        * first bottom time array value to round up (array[FirstValue])
        */
            if (depth==depthsArray[count]){
                /**
                 * count is depth's position in the depthsArray array, which is our
                 * FirstValue. Find BottomTimeArray[FirstValue] and round up to
                 * whatever value is higher
                */
                bottomTime = RoundUp(bottomTime, bottomTimeArray[count]);
            }
        }


        for (int count=0;count<depthsArray.length;count++){  //To find pressure group
            if (depth==depthsArray[count]){
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
            

            int surfaceTime = CheckInput("Please enter total surface time in minutes: ", "Error", 0,1000);
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
            depth = RoundUp(depth, depthsArray);
            //Input depth and round up based on values in depthsArray array

            for (int count = 0; count<depthsArray.length; count++){
                /**
                 * To get actualBottomTime we need its position in the
                 * bottomTimeArray
                 */
                if (depth == depthsArray[count]){
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


            for (int count=0;count<depthsArray.length;count++){
                /**
                 * Again, bottomTimeArray is 2D, so we need our first value to
                 * which is the position of the depth to round up
                 */

                if (depth==depthsArray[count]){
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


            for (int count=0;count<depthsArray.length;count++){
                //Find pressure group
                if (depth==depthsArray[count]){
                /**
                 * Same process as before. To put it simply, this is like
                 * sliding your finger horizontally through the depthsArray row
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
     
     
}
