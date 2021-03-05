import java.util.*;
public class Main {
    private static Object ArrayIndexOutOfBoundsException;
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            Prints print = new Prints();
            Calculation calc = new Calculation();

            System.out.println("How many values will you enter?");
            int arraySize = scanner.nextInt();
            while (arraySize > 25 || arraySize < 0) {
                System.out.println("Try again! Enter less than 25 numbers!");
                System.out.println("Try again: ");
                arraySize = scanner.nextInt();
            }
            scanner.nextLine();
            print.infoForUser();
            int[] unsorted = new int[arraySize];
            System.out.println("Enter: ");
            String nums = scanner.nextLine();
            nums = nums.replaceAll("\\s+", "");
            String[] stringNums = nums.split(",");
            if (stringNums.length != arraySize) throw (Throwable) ArrayIndexOutOfBoundsException;
            else {
                for (int i = 0; i < unsorted.length; i++) {
                    unsorted[i] = Integer.parseInt(stringNums[i]);
                }
            }
            int programRepeat = 1;
            while (programRepeat == 1) {
                print.whatDoesUserWantToDo();
                int userDesire = scanner.nextInt();
                if (userDesire == 1) {
                    calc.insertionSort(unsorted);
                    calc.print();
                }
                if (userDesire == 2) {
                    calc.insertionSort(unsorted);
                    calc.mean();
                }
                if (userDesire == 3) {
                    calc.insertionSort(unsorted);
                    calc.median();
                }
                if (userDesire == 4) {
                    calc.insertionSort(unsorted);
                    calc.mode();
                }
                if (userDesire == 5) {
                    System.out.println("How many more numbers would you like to add: ");
                    int newArraySize = scanner.nextInt();
                    while ((arraySize + newArraySize) > 25 || (arraySize + newArraySize) < 0) {
                        System.out.println("Try again! Enter less than " + (25 - arraySize) + " numbers!");
                        arraySize = scanner.nextInt();
                    }
                    int[] newNumbers = new int[newArraySize];
                    print.infoForUser();
                    for (int i = 0; i < newArraySize; i++) {
                        System.out.println("Enter: ");
                        newNumbers[i] = scanner.nextInt();
                    }
                    calc.addNumbers(arraySize, newArraySize, newNumbers);
                    calc.insertionSort(calc.finalNumbers);
                    arraySize = calc.finalNumbers.length;
                    unsorted = calc.finalNumbers;
                }
                if (userDesire == 6) {
                    calc.insertionSort(unsorted);
                    System.out.println("How many values will you enter?");
                    arraySize = scanner.nextInt();
                    while (arraySize > 25 || arraySize < 0) {
                        System.out.println("Try again! Enter less than 25 numbers!");
                        System.out.println("Try again: ");
                        arraySize = scanner.nextInt();
                    }
                    scanner.nextLine();
                    print.infoForUser();
                    unsorted = new int[arraySize];
                    for (int i = 0; i < arraySize; i++) {
                        System.out.println("Enter: ");
                        unsorted[i] = scanner.nextInt();
                    }
                }
                if (userDesire == 7) {
                    calc.insertionSort(unsorted);
                    calc.mean();
                    calc.StandardDeviation();
                }
                if (userDesire == 0) {
                    System.out.println("Thank you!");
                    programRepeat = 0;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Please Enter a valid Integer value! ");
            System.out.println("Program is exiting! ");
            System.exit(0);
        } catch (NullPointerException e){
            System.out.println("You did not enter the correct amount of numbers");
            System.out.println("Program is exiting! ");
            System.exit(0);
        } catch (Throwable throwable) {
            System.out.println("You did something wrong");
            System.out.println("Program is exiting! ");
            System.exit(0);
        }
    }
}
