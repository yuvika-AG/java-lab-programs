
import java.util.Scanner;

class StringOperations {
    String str;

    // Constructor
    StringOperations(String str) {
        this.str = str;
    }

    // 1. Return length of string
    int stringLength() {
        return str.length();
    }

    // 2. Extract substring
    String extractSubstring(int start, int end) {
        return str.substring(start, end);
    }

    // 3. Replace character
    String replaceCharacter(char oldChar, char newChar) {
        return str.replace(oldChar, newChar);
    }

    // 4. Reverse string using StringBuffer
    String reverseString() {
        StringBuffer sb = new StringBuffer(str);
        return sb.reverse().toString();
    }

    // 5. Find first occurrence using StringBuffer
    int findFirstOccurrence(char ch) {
        StringBuffer sb = new StringBuffer(str);
        return sb.indexOf(String.valueOf(ch));
    }

    // 6. Find last occurrence using StringBuffer
    int findLastOccurrence(char ch) {
        StringBuffer sb = new StringBuffer(str);
        return sb.lastIndexOf(String.valueOf(ch));
    }

    // 7. Identify unique characters
    String findUniqueCharacters() {
        String unique = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int count = 0;

            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == ch) {
                    count++;
                }
            }

            if (count == 1) {
                unique = unique + ch;
            }
        }

        return unique;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        StringOperations obj = new StringOperations(input);

        int choice;

        do {
            System.out.println("\n----- STRING OPERATIONS MENU -----");
            System.out.println("1. Find length of string");
            System.out.println("2. Extract substring");
            System.out.println("3. Replace character");
            System.out.println("4. Reverse string");
            System.out.println("5. Find first occurrence");
            System.out.println("6. Find last occurrence");
            System.out.println("7. Find unique characters");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Length: " +
                                       obj.stringLength());
                    break;

                case 2:
                    System.out.print("Enter start index: ");
                    int start = sc.nextInt();

                    System.out.print("Enter end index: ");
                    int end = sc.nextInt();

                    if (start >= 0 && end <= input.length()
                            && start <= end) {
                        System.out.println("Substring: " +
                            obj.extractSubstring(start, end));
                    } else {
                        System.out.println("Invalid indices!");
                    }
                    break;

                case 3:
                    System.out.print("Enter old character: ");
                    char oldChar = sc.next().charAt(0);

                    System.out.print("Enter new character: ");
                    char newChar = sc.next().charAt(0);

                    System.out.println("Modified String: " +
                        obj.replaceCharacter(oldChar, newChar));
                    break;

                case 4:
                    System.out.println("Reversed String: " +
                                       obj.reverseString());
                    break;

                case 5:
                    System.out.print("Enter character to search: ");
                    char ch1 = sc.next().charAt(0);

                    System.out.println("First occurrence index: " +
                        obj.findFirstOccurrence(ch1));
                    break;

                case 6:
                    System.out.print("Enter character to search: ");
                    char ch2 = sc.next().charAt(0);

                    System.out.println("Last occurrence index: " +
                        obj.findLastOccurrence(ch2));
                    break;

                case 7:
                    System.out.println("Unique characters: " +
                        obj.findUniqueCharacters());
                    break;

                case 8:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 8);

        sc.close();
    }
}
