
package Game;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Perm_Comb {

    static Scanner input = new Scanner(System.in);

    //Queue implementation
    static Queue<String> queue = new LinkedList<>();

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n===== PERMUTATION AND COMBINATION =====");
            System.out.println("[1] Add Elements to Queue");
            System.out.println("[2] Display Queue");
            System.out.println("[3] Generate Permutations");
            System.out.println("[4] Generate Combinations");
            System.out.println("[5] Exit");
            System.out.print("Enter choice: ");

            choice = input.nextInt();

            switch (choice) {

                case 1:
                    addElements();
                    break;

                case 2:
                    displayQueue();
                    break;

                case 3:
                    generatePermutations();
                    break;

                case 4:
                    generateCombinations();
                    break;

                case 5:
                    System.out.println("Program terminated.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

    }

    //Accept elements and add them to the Queue
    static void addElements() {

        System.out.print("How many elements do you want to add? ");

        int n = input.nextInt();

        for (int i = 0; i < n; i++) {

            System.out.print("Enter element " + (i + 1) + ": ");

            String element = input.next();

            queue.add(element);

        }

        System.out.println("Elements successfully added!");

        System.out.println("Front element: " + queue.peek());

    }

    //Display all elements in the Queue
    static void displayQueue() {

        if (queue.isEmpty()) {

            System.out.println("Queue is empty!");

            return;

        }

        System.out.println("Queue: " + queue);

        //Dequeue the two elements
        String answer;

        while (true) {

            System.out.print("Do you want to dequeue two elements? (yes/no): ");

            answer = input.next();

            if (answer.equalsIgnoreCase("yes") ||
                answer.equalsIgnoreCase("no")) {

                break;

            } else {

                System.out.println("\nInvalid input! Yes or No only.");

            }

        }

        if (answer.equalsIgnoreCase("yes")) {

            for (int i = 0; i < 2; i++) {

                if (!queue.isEmpty()) {

                    System.out.println("Removed: " + queue.poll());

                } else {

                    System.out.println("Queue is already empty!");

                    break;

                }

            }

            System.out.println("Updated Queue: " + queue);

        } else {

            System.out.println("No elements were removed.");

        }

    }

    //Generate all possible permutations
    static void generatePermutations() {

        if (queue.isEmpty()) {

            System.out.println("Queue is empty!");

            return;

        }

        List<String> elements = new ArrayList<>(queue);

        System.out.print("Enter number of elements to arrange: ");

        int r = input.nextInt();

        if (r < 1 || r > elements.size()) {

            System.out.println("Invalid number of elements!");

            return;

        }

        List<String> selected = new ArrayList<>();

        int[] count = {0};

        System.out.println("\nPermutations:");

        permutation(elements, selected, r, count);

        System.out.println("Total Permutations: " + count[0]);

    }

    //Recursive permutation method
    static void permutation(List<String> elements,
                            List<String> selected,
                            int r,
                            int[] count) {

        if (selected.size() == r) {

            for (String element : selected) {

                System.out.print(element);

            }

            System.out.println();

            count[0]++;

            return;

        }

        for (int i = 0; i < elements.size(); i++) {

            if (!selected.contains(elements.get(i))) {

                selected.add(elements.get(i));

                permutation(elements, selected, r, count);

                selected.remove(selected.size() - 1);

            }

        }

    }

    //Generate all possible combinations
    static void generateCombinations() {

        if (queue.isEmpty()) {

            System.out.println("Queue is empty!");

            return;

        }

        List<String> elements = new ArrayList<>(queue);

        System.out.print("Enter number of elements to select: ");

        int r = input.nextInt();

        if (r < 1 || r > elements.size()) {

            System.out.println("Invalid number of elements!");

            return;

        }

        List<String> selected = new ArrayList<>();

        int[] count = {0};

        System.out.println("\nCombinations:");

        combination(elements, selected, 0, r, count);

        System.out.println("Total Combinations: " + count[0]);

    }

    //Recursive combination method
    static void combination(List<String> elements,
                            List<String> selected,
                            int start,
                            int r,
                            int[] count) {

        if (selected.size() == r) {

            for (String element : selected) {

                System.out.print(element);

            }

            System.out.println();

            count[0]++;

            return;

        }

        for (int i = start; i < elements.size(); i++) {

            selected.add(elements.get(i));

            combination(elements, selected, i + 1, r, count);

            selected.remove(selected.size() - 1);

        }

    }

}
