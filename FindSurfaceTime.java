 package miniprojectpsb;
import java.util.Scanner;

/**
 *
 * @author David Angkawijaya
 */
public class FindSurfaceTime extends vars{
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args){
        
        //FIND PRESSURE GROUP OF FIRST DIVE-------------------------------------
        int depth = CheckInput("Input depth here(1-42): ",
                "Invalid input!", 0,42);
        depth = GetPosition(depth,depthsArray);
        
        int NDL = bottomTimeArray[depth][bottomTimeArray[depth].length-1];
        System.out.println("The NDL for that depth = " + NDL);
        
        int bottomTime = CheckInput("Input bottom time here (1-" +NDL+"):"
                + " ", "Invalid input", 0, NDL);
        bottomTime = GetPosition(bottomTime, bottomTimeArray[depth]);
        
        getSafetyStop(depth,bottomTime);
        
        int pressureGroup = bottomTime;
        System.out.println("Your pressure group after first dive ="
                + " " + alphabet[pressureGroup]);
        //END-------------------------------------------------------------------
        
        
        boolean noNeedSurface = false;
        for(;;){
            if (!noNeedSurface){
                if (CheckInput("Would you like to dive again? (Input 1 for yes "
                        + "and 2 for no): ", "Invalid input!", 1, 2) == 2){
                    break;
                }
            }
            depth = CheckInput("Input depth here(1-40): ",
                    "Invalid input!", 0,40);
            depth = GetPosition(depth,depthsArray);
            
            NDL = ANDLArray[depth][0];
            System.out.println("Your ANDL = " + NDL);
            
            bottomTime = CheckInput("Input bottom time here (1-" +NDL+"): ",
                    "Invalid input", 0, NDL);
            bottomTime = GetPosition(bottomTime, bottomTimeArray[depth]);
            
            int requiredBottomTime = ANDLArray[depth][bottomTime]; 
            int requiredPressureGroup = GetPosition(requiredBottomTime,
                    bottomTimeArray[depth]);
            System.out.println("Your required pressure group = "
                    + alphabet[requiredPressureGroup]);
            
            noNeedSurface = requiredPressureGroup>pressureGroup;
            if (noNeedSurface){
                System.out.println("You don't need to "
                        + "surface. Please re-input");
                continue;
            }
            
            
            String surfaceTime = 
                    surfaceTimeArray[pressureGroup][requiredPressureGroup];
            System.out.println("Your required surface time = " + surfaceTime);
            
            getSafetyStop(depth,bottomTime);
            
            pressureGroup = bottomTime;
            System.out.println("Your new pressure group = " 
                    + alphabet[pressureGroup]);
        }
        
         
    }
    
    
    //METHODS ARE DOWN THERE----------------------------------------------------
    
    
    public static int GetPosition(int i, int[] array){
        int d = 0;
        for(int count=0;count<array.length;count++){
            if (i<=array[count]){
                d = array[count];
                break;
            }
        }
        int positionInArray = 0;
        while (array[positionInArray] != d){
            positionInArray++;
        }
        return positionInArray;
    }
    public static void getSafetyStop(int a , int b){
        int depth = depthsArray[a];
        int time  = bottomTimeArray[a][b];
        if ((depth == 10 && time >= 160)
                || (depth == 12 && time >= 116)
                || (depth == 14 && time >= 82)
                || (depth == 16 && time >= 63)
                || (depth == 18 && time >= 51)
                || (depth == 20 && time >= 40)
                || (depth == 22 && time >= 32)
                || (depth == 25 && time >= 25)
                || depth >= 30) {
            System.out.println("Safety stop is required");
        }
        else{
            System.out.println("Safety stop is not required");
        }
    }
}
