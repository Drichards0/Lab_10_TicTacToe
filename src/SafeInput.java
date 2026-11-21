
import java.util.Scanner;

public class SafeInput
{
    // PART A: getNonZeroLenString
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = "";

        do
        {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();

        } while(retString.length() == 0);

        return retString;
    }


    // PART B: getInt
    public static int getInt(Scanner pipe, String prompt)
    {
        int value = 0;
        boolean valid = false;

        do
        {
            System.out.print("\n" + prompt + ": ");

            if(pipe.hasNextInt())
            {
                value = pipe.nextInt();
                valid = true;
            }
            else
            {
                System.out.println("Invalid input. Please enter an integer.");
            }

            pipe.nextLine();

        } while(!valid);

        return value;
    }


    // PART C: getDouble
    public static double getDouble(Scanner pipe, String prompt)
    {
        double value = 0;
        boolean valid = false;

        do
        {
            System.out.print("\n" + prompt + ": ");

            if(pipe.hasNextDouble())
            {
                value = pipe.nextDouble();
                valid = true;
            }
            else
            {
                System.out.println("Invalid input. Please enter a number.");
            }

            pipe.nextLine();

        } while(!valid);

        return value;
    }


    // PART D: getRangedInt
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int value = 0;
        boolean valid = false;

        do
        {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");

            if(pipe.hasNextInt())
            {
                value = pipe.nextInt();

                if(value >= low && value <= high)
                {
                    valid = true;
                }
                else
                {
                    System.out.println("Number is outside the allowed range.");
                }
            }
            else
            {
                System.out.println("Invalid input. Please enter an integer.");
            }

            pipe.nextLine();

        } while(!valid);

        return value;
    }


    // PART E: getRangedDouble
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        double value = 0;
        boolean valid = false;

        do
        {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");

            if(pipe.hasNextDouble())
            {
                value = pipe.nextDouble();

                if(value >= low && value <= high)
                {
                    valid = true;
                }
                else
                {
                    System.out.println("Number is outside the allowed range.");
                }
            }
            else
            {
                System.out.println("Invalid input. Please enter a number.");
            }

            pipe.nextLine();

        } while(!valid);

        return value;
    }


    // PART F: getYNConfirm
    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        String response = "";

        do
        {
            System.out.print("\n" + prompt + " (Y/N): ");
            response = pipe.nextLine();

            if(response.equalsIgnoreCase("Y"))
            {
                return true;
            }
            else if(response.equalsIgnoreCase("N"))
            {
                return false;
            }
            else
            {
                System.out.println("Invalid input. Enter Y or N.");
            }

        } while(true);
    }


    // PART G: getRegExString
    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        String value = "";

        do
        {
            System.out.print("\n" + prompt + ": ");
            value = pipe.nextLine();

            if(!value.matches(regEx))
            {
                System.out.println("Invalid format. Please try again.");
            }

        } while(!value.matches(regEx));

        return value;
    }


    // PART H: prettyHeader
    public static void prettyHeader(String msg)
    {
        // Print top row
        for(int i = 0; i < 60; i++)
        {
            System.out.print("*");
        }

        System.out.println();

        // Calculate spaces
        int spaces = 54 - msg.length();
        int leftSpaces = spaces / 2;
        int rightSpaces = spaces - leftSpaces;

        // Print message row
        System.out.print("***");

        for(int i = 0; i < leftSpaces; i++)
        {
            System.out.print(" ");
        }

        System.out.print(msg);

        for(int i = 0; i < rightSpaces; i++)
        {
            System.out.print(" ");
        }

        System.out.println("***");

        // Print bottom row
        for(int i = 0; i < 60; i++)
        {
            System.out.print("*");
        }

        System.out.println();
    }
}

