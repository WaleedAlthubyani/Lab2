import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        /*1.Write a program to find all the longest word in a given dictionary.*/
        String[] arr = { "cat", "dog", "red", "is", "am" };

        for (String l : longestWord(arr))
            System.out.print(l + " ");

        System.out.println("\n----------------------------\n");

        /*2. Write a program that displays the number of occurrences of an element in the array.*/

        int[] numbers = {1,1,1,3,3,5};
        int number;
        String inputCheck;
        do {
            System.out.println("Enter a number to see how many times it appeared in the array or quit to exit");
            inputCheck=input.next();
            if (inputCheck.equalsIgnoreCase("quit"))
                break;
            number= Integer.parseInt(inputCheck);

            System.out.println(number+" occurs " + occurrences(numbers,number) + " time/s");
        }while (true);

        System.out.println("\n----------------------------\n");

        /*3.Write a program to find the k largest elements in a given array. Elements in the array can be in any order.*/
        int[] integersArray = {1, 4, 17, 7, 25, 3, 100};

        System.out.println("Enter a number to choose how many of the largest elements you want to see");
        int k=input.nextInt();

        System.out.println(k + " largest elements of the said array are:");
        for (int i : kLargestElements(integersArray,k)){
            System.out.print(i+" ");
        }

        System.out.println("\n----------------------------\n");

        /*4. Create a method to reverse an array of integers. Implement the method without creating a new array.*/

        int[] originalArray = {5,4,3,2,1};

        System.out.println("Reversed array: ");
        for (int r : reverseIntegers(originalArray)){
            System.out.print(r+" ");
        }

        System.out.println("\n----------------------------\n");

        /*5. Write a menu driven Java program with following option: */

        System.out.println("How big is your array of integers?");
        int[] values = new int[input.nextInt()];
        int choice;
        System.out.println("choose one of the following numbers: ");
        do {
            System.out.println("1. Accept elements of an array");
            System.out.println("2. Display elements of an array");
            System.out.println("3. Search the element within array");
            System.out.println("4. Sort the array");
            System.out.println("5. To Stop");
            choice=input.nextInt();

            switch (choice){
                case 1:
                    acceptElement(values);
                    break;
                case 2:
                    displayElements(values);
                    break;
                case 3:
                    System.out.println("What element are you looking for?");
                    searchElement(values,input.nextInt());
                    break;
                case 4:
                    sortArray(values);
                    break;
                case 5:
                    System.out.println("See you late");
                    break;
                default:
                    System.out.println("Incorrect number please choose one of the followings:");
            }

        }while(choice!=5);

        System.out.println("\n----------------------------\n");

        /*6. Create a method that generates a random number within a given range. Allow the user to
        specify the range and call the method to display random numbers.*/

        System.out.print("Enter the minimum value of the range: ");
        int min = input.nextInt();
        System.out.print("\nEnter the maximum value of the range: ");
        int max=input.nextInt();
        System.out.print("\nEnter the number of random numbers to generate: ");
        int rands=input.nextInt();
        System.out.println("\nnumbers within the specified range: ");

        System.out.println(randomInRange(min,max,rands));

        System.out.println("\n----------------------------\n");

        /*7. Write a program that checks the strength of a password. Create a method that evaluates a
        password based on criteria like length, inclusion of special characters, and
        uppercase/lowercase letters.*/

        System.out.println("Enter a password: ");
        String password = input.next();

        int totalScore=0;

        totalScore+=checkLength(password);
        totalScore+=checkSpecialCharacters(password);
        totalScore+=checkUpperCaseLowerCase(password);


        if (totalScore>=8){
            System.out.println("Password is strong.");
        } else if (totalScore>5 && totalScore<8) {
            System.out.println("Password is moderately strong.");
        }else
            System.out.println("Password is weak.");

        System.out.println("\n----------------------------\n");

        /*8. Create a method that generates the Fibonacci sequence up to a specified number of terms.*/

        System.out.println("Enter the number of Fibonacci terms to generate:");
        int limit = input.nextInt();

        System.out.println("Fibonacci sequence with "+limit+" terms: ");
        for (int f : fibonacci(limit))
            System.out.print(f+" ");
    }

    public static int[] sortArray(int[] arr){
        Arrays.sort(arr);
        return arr;
    }

    public static void searchElement(int[] arr,int element){
        boolean exist =false;
        for (int a :arr){
            if(a==element){
                exist=true;
                break;
            }
        }
        System.out.println((exist) ? "There is a "+element+ " in the array":"There isn't a "+element+ " in the array");
    }

    public static void displayElements(int[] arr){
        for (int a : arr)
            System.out.print(a+" ");
        System.out.println();
    }

    public static int[] acceptElement(int[] arr){
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < arr.length; i++) {
            System.out.println("Enter the " + (i+1)+" Element:");
            arr[i]=input.nextInt();
        }
        return arr;
    }

    public static int[] fibonacci(int limit){
        int[] fibonacci = new int[limit];

        if (limit>1)
            fibonacci[1]=1;

        for (int i = 2; i < limit; i++) {
            fibonacci[i]=fibonacci[i-1]+fibonacci[i-2];
        }

        return fibonacci;
    }

    public static int checkUpperCaseLowerCase(String password){
        boolean upperCase = password.length()>password.replaceAll("[A-Z]","").length();
        boolean lowerCase = password.length() > password.replaceAll("[a-z]", "").length();

        if (upperCase&&lowerCase)
            return 3;

        return 0;
    }

    public static int checkSpecialCharacters(String password){
        if (password.replaceAll("[a-zA-Z0-9]","").isEmpty())
            return 0;
        return 2;
    }

    public static int checkLength(String password){
        if (password.length()<=5)
            return 0;
        else if (password.length()>5 && password.length()<8)
            return 2;
        else
            return 3;
    }

    public static String randomInRange(int rangeMin,int rangeMax, int numberOfRandoms){
        String randoms = "";
        Random rand = new Random();
        for (int i = 0; i < numberOfRandoms; i++) {
            randoms+=rand.nextInt(rangeMin,rangeMax) + " ";
        }

        return randoms.trim();
    }

    public static int[] reverseIntegers(int[] arr){
        int reverseIndex= arr.length-1;
        int temp;
        for (int i = 0; i < arr.length/2; i++) {
            temp = arr[i];
            arr[i]=arr[reverseIndex];
            arr[reverseIndex]=temp;
            reverseIndex--;
        }

        return arr;
    }

    public static int[] kLargestElements(int[]numbers, int k){
        int[] kLargest = new int[k];
        int index = 0;
        int largest = numbers[0];

        for (int i = 0; i < k; i++) {
            for (int j = i; j < numbers.length; j++) {
                if (largest<=numbers[j]){
                    largest=numbers[j];
                    index=j;
                }
                if(j==numbers.length-1){//swap largest to the beginning so that we don't take again
                    numbers[index]=numbers[i];
                    numbers[i]=largest;
                    largest=numbers[i+1];
                }
            }
            kLargest[i]=numbers[i];
        }

        return kLargest;
    }

    public static int occurrences(int[] numbersArray,int number){
        int occurrenceCounter=0;
        for (int i:numbersArray){
            if (i==number)
                occurrenceCounter++;
        }

        return occurrenceCounter;
    }

    public static String[] longestWord(String[] words){
        String longest = "";
        int longestWordLength=0;
        for (String w : words){
            if (longestWordLength<w.length())
                longestWordLength=w.length();
        }

        for (String w : words){
            if (longestWordLength==w.length())
                longest+= w+" ";
        }

        return longest.split(" ");
    }
}