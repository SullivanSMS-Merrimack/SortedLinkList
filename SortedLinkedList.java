import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Represents a sorted linked list of integers.
 * The list is created from a comma-separated string of integers.
 * <pre>
 * How to Run:
 *
 * javac -d bin *.java
 * java -cp bin SortedLinkedList.java
 * </pre>
 * <pre>
 * Command Used to create Javadocs:
 *
 * javadoc -d docs *.java
 * </pre>
 */
public class SortedLinkedList {
    private static final Scanner SC = new Scanner(System.in);
    private final LinkedList<Integer> sortedList;

    /**
     * Getter for the sorted link list.
     *
     * @return A sorted LinkedList of integers or null if the integer string was unable to be parsed.
     */
    public LinkedList<Integer> getSortedLinkedList() {
        return sortedList;
    }

    /**
     * Constructs a SortedLinkedList from a comma-separated string of integers.
     * If the string is null or empty, an empty list is created.
     * If the string cannot be parsed, an error is printed.
     *
     * @param integerString A string containing comma-separated integers.
     */
    public SortedLinkedList(String integerString) {
        this.sortedList = createSortedLinkedList(integerString);
    }

    /**
     * Returns a string representation of the sorted linked list.
     *
     * @return A string representation of the list, e.g., "[1, 2, 3]".
     */
    public String toString() {
        if (sortedList == null) {
            return "Unable to print sortedList as the original input was invalid.";
        }

        // Reuse of the toString method to convert the list into a string
        return this.sortedList.toString();
    }

    /**
     * Creates a sorted linked list of integers from a given string.
     *
     * @param integerString A string containing comma-separated integers.
     * @return A sorted LinkedList of integers. Returns an empty list if the input string is null or empty.
     * Returns null if an error occurs during parsing.
     */
    private LinkedList<Integer> createSortedLinkedList(String integerString) {
        // Early exit if we're passed an empty string

        // Reuse of the trim and isEmpty string methods to remove whitespace and check string length
        if (integerString == null || integerString.trim().isEmpty()) {
            return new LinkedList<>();
        }

        try {
            // 1. Splitting string on ',' delimiter
            // 2. Removing whitespace around integers
            // 3. Parsing integers
            // 4. Sorting values
            // 5. Collecting into LinkedList
            return Arrays.stream(integerString.split(","))
                    .map(String::trim)          // Reuse of the trim method to remove whitespace
                    .map(Integer::parseInt)     // Reuse of the parseInt method to convert to integers
                    .sorted()                   // Reuse of the sorted method to sort integers
                    .collect(Collectors.toCollection(LinkedList::new));

        } catch (Exception e) {
            System.err.println("Error while parsing string: " + integerString);
            return null;
        }
    }

    /**
     * The main method to demonstrate the SortedLinkedList functionality.
     * Prompts the user to enter a comma-separated string of integers, creates a SortedLinkedList, and prints it.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        /*
         * How to Run:
         * javac -d bin *.java
         * java -cp bin SortedLinkedList.java
         *
         * Command Used to create Javadocs:
         * javadoc -d docs *.java
         */

        System.out.println("Enter a comma separated list of integers.");
        System.out.println("e.g. 5, 4, 3, 2, 1");
        System.out.print("> ");
        String integerString = SC.nextLine();

        SortedLinkedList sortedLinkedList = new SortedLinkedList(integerString);
        System.out.println(sortedLinkedList);
    }
}
