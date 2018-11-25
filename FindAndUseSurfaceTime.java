package miniprojectpsb;
import java.util.Scanner;

/**
 *
 * @author David Angkawijaya
 */
public class FindAndUseSurfaceTime extends vars{
    static Scanner input = new Scanner(System.in); 
    public static void main(String[] args){
        
        //FIND PRESSURE GROUP OF FIRST DIVE-------------------------------------
        System.out.println("Dive 1");
        int depth = checkInput("Input depth here(1-42): ",
                "Invalid input!", 0,42);
        depth = getPosition(depth,depthsArray);
        
        int NDL = bottomTimeArray[depth][bottomTimeArray[depth].length-1];
        System.out.println("The NDL for that depth = " + NDL);
        
        int bottomTime = checkInput("Input bottom time here (1-" +NDL+"):"
                + " ", "Invalid input", 0, NDL);
        bottomTime = getPosition(bottomTime, bottomTimeArray[depth]);
        
        safetyStop(depth,bottomTime);
        
        int pressureGroup = bottomTime;
        System.out.println("Your pressure group after first dive ="
                + " " + alphabet[pressureGroup]);
        //END-------------------------------------------------------------------
        
        
        boolean noNeedSurface = false;
        for(int c = 2;c>-1;c++){
            if (!noNeedSurface){
                if (checkInput(" \nWould you like to dive again? (Input 1 for yes "
                        + "and 2 for no): ", "Invalid input!", 1, 2) == 2){
                    break;
                }
            }
            System.out.println("\nDive " + c);
            depth = checkInput("Input depth here(1-40): ",
                    "Invalid input!", 0,40);
            depth = getPosition(depth,depthsArray);
            
            NDL = ANDLArray[depth][ANDLArray[depth].length-1];
            System.out.println("Your ANDL = " + NDL);
            
            bottomTime = checkInput("Input bottom time here (1-" +NDL+"): ",
                    "Invalid input", 0, NDL);
            bottomTime = getPosition(bottomTime, ANDLArray[depth]);
            
            
            safetyStop(depth,bottomTime);
            
            int requiredPressureGroup = (ANDLArray[depth].length-1) - bottomTime;
            
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
            
            
            int minSurfaceHour = Integer.parseInt(sliceRange(surfaceTime, 0,1));
            int minSurfaceMinute = Integer.parseInt(sliceRange(surfaceTime, 2,4));
            int minSurface = minSurfaceHour * 60 + minSurfaceMinute;
            
            String surfaceTimeMax = surfaceTimeArray[pressureGroup][0];
            int maxSurfaceHour = Integer.parseInt(sliceRange(surfaceTimeMax,8,9));
            int maxSurfaceMinute = Integer.parseInt(sliceRange(surfaceTimeMax,10,12));
            int maxSurface = maxSurfaceHour * 60 + maxSurfaceMinute;
            
            int PGAfterSurface = 0;
            int surfaceTimeInput = checkInput("Please input surface time in minutes here (" +minSurface+ "-"+maxSurface+"): ","Invalid input",minSurface,1000);
            for (int count = 0; count<surfaceTimeArray[pressureGroup].length;count++){
                int hour1 = Integer.parseInt(sliceRange(surfaceTimeArray[pressureGroup][count], 0, 1));
                int minute1 = Integer.parseInt(sliceRange(surfaceTimeArray[pressureGroup][count], 2, 4));
                int total1 = hour1*60 + minute1;
                
                
                int hour2 = Integer.parseInt(sliceRange(surfaceTimeArray[pressureGroup][count], 8, 9));
                int minute2 = Integer.parseInt(sliceRange(surfaceTimeArray[pressureGroup][count], 10, 12));
                int total2 = hour2*60 + minute2;
                
                if (surfaceTimeInput >= total1 && surfaceTimeInput <= total2){
                    PGAfterSurface= count;
                }
            }
            
            System.out.println("Your pressure group after surfacing = "+alphabet[PGAfterSurface]);
            
            if(bottomTimeArray[depth][PGAfterSurface] + bottomTimeArray[depth][pressureGroup]>bottomTimeArray[depth][bottomTimeArray[depth].length-1]) pressureGroup = bottomTimeArray[depth].length - 1;
            else pressureGroup = getPosition(bottomTimeArray[depth][PGAfterSurface] + bottomTimeArray[depth][pressureGroup], bottomTimeArray[depth]);
            
            System.out.println("Your new pressure group after finishing your dive = " 
                    + alphabet[pressureGroup]);
        }
        
         
    }
    
    
    //METHODS ARE DOWN THERE----------------------------------------------------
    
    
    public static String sliceRange(String s, int startIndex, int endIndex) {
        //Method to take part of a string
        //I just took it from the internet, don't know how it works
        //THIS IS OOP :D not 
        if (startIndex < 0) startIndex = s.length() + startIndex;
        if (endIndex < 0) endIndex = s.length() + endIndex;
        return s.substring(startIndex, endIndex);
    }
    
    
    public static int getPosition(int i, int[] array){
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
    public static void safetyStop(int a , int b){
        int time  = bottomTimeArray[a][b];
        if ((a == 0 && time >= 160)
                || (a == 1 && time >= 116)
                || (a == 2 && time >= 82)
                || (a == 3 && time >= 63)
                || (a == 4 && time >= 51)
                || (a == 5 && time >= 40)
                || (a == 6 && time >= 32)
                || (a == 7 && time >= 25)
                || a >= 8) {
            System.out.println("Safety stop is required");
        }
    }
 }