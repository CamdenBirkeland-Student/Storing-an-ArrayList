import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1, "Alice", "123 Street, City"));
        students.add(new Student(3, "Bob", "456 Road, Town"));
        students.add(new Student(2, "Charlie", "789 Avenue, Village"));
        students.add(new Student(5, "David", "321 Boulevard, Suburb"));
        students.add(new Student(4, "Emma", "654 Lane, Countryside"));
        students.add(new Student(7, "Frank", "987 Drive, Hamlet"));
        students.add(new Student(6, "Grace", "135 Court, Metropolis"));
        students.add(new Student(9, "Henry", "864 Circle, Capital"));
        students.add(new Student(8, "Ivy", "246 Place, Megalopolis"));
        students.add(new Student(10, "Jack", "579 Square, Municipality"));

        // Sorting by name using selection sort
        selectionSort(students, new NameComparator());
        System.out.println("Sorted by Name:");
        for (Student student : students) {
            System.out.println(student);
        }

        // Sorting by rollno using selection sort
        selectionSort(students, new RollnoComparator());
        System.out.println("\nSorted by Rollno:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    static void selectionSort(ArrayList<Student> arr, Comparator<Student> comparator) {
        int n = arr.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (comparator.compare(arr.get(j), arr.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            // Swap arr[i] and arr[minIndex]
            Student temp = arr.get(minIndex);
            arr.set(minIndex, arr.get(i));
            arr.set(i, temp);
        }
    }

    static class NameComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return s1.getName().compareTo(s2.getName());
        }
    }

    static class RollnoComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return Integer.compare(s1.getRollno(), s2.getRollno());
        }
    }
}