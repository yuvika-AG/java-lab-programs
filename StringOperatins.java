
import java.util.Scanner;

class StringOperations {
    String str;

    // Constructor
    StringOperations(String str) {
        this.str = str;
    }

    // Using String class

    // 1. Find length
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

    // Using StringBuffer class

    // 4. Reverse the original string
    String reverseString() {
        StringBuffer sb = new StringBuffer(str);
        return sb.reverse().toString();
    }

    // 5. Find first occurrence
    int findFirstOccurrence(char ch) {
        StringBuffer sb = new StringBuffer(str);
        return sb.indexOf(String.valueOf(ch));
    }

    // 6. Find last occurrence
    int findLastOccurrence(char ch) {
        StringBuffer sb = new StringBuffer(str);
        return sb.lastIndexOf(String.valueOf(ch));
    }

    // Additional: Find unique characters
    void findUniqueCharacters() {
        System.out.print("Unique characters: ");

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            boolean found = false;

            for (int j = 0; j < i; j++) {
                if (str.charAt(j) == ch) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.print(ch + " ");
            }
        }
        System.out.println();
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
            System.out.println("1. Find String Length");
            System.out.println("2. Extract Substring");
            System.out.println("3. Replace Character");
            System.out.println("4. Reverse String");
            System.out.println("5. Find First Occurrence");
            System.out.println("6. Find Last Occurrence");
            System.out.println("7. Find Unique Characters");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Length: " + obj.stringLength());
                    break;

                case 2:
                    System.out.print("Enter start index: ");
                    int start = sc.nextInt();

                    System.out.print("Enter end index: ");
                    int end = sc.nextInt();

                    if (start >= 0 && end <= input.length()
                            && start < end) {
                        System.out.println("Substring: "
                                + obj.extractSubstring(start, end));
                    } else {
                        System.out.println("Invalid indices!");
                    }
                    break;

                case 3:
                    System.out.print("Enter old character: ");
                    char oldChar = sc.next().charAt(0);

                    System.out.print("Enter new character: ");
                    char newChar = sc.next().charAt(0);

                    System.out.println("Updated String: "
                            + obj.replaceCharacter(oldChar, newChar));
                    break;

                case 4:
                    System.out.println("Reversed String: "
                            + obj.reverseString());
                    break;

                case 5:
                    System.out.print("Enter character to search: ");
                    char ch1 = sc.next().charAt(0);

                    System.out.println("First occurrence index: "
                            + obj.findFirstOccurrence(ch1));
                    break;

                case 6:
                    System.out.print("Enter character to search: ");
                    char ch2 = sc.next().charAt(0);

                    System.out.println("Last occurrence index: "
                            + obj.findLastOccurrence(ch2));
                    break;

                case 7:
                    obj.findUniqueCharacters();
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
