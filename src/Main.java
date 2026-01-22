// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            File file = new File("C:\\Users\\ADMIN\\IdeaProjects\\nic\\src\\input.txt");
            Scanner inputFile = new Scanner(file);

            while (inputFile.hasNextLine()) {
                ArrayList<Integer> list = new ArrayList<>();
                String line = inputFile.nextLine();
                int n = Integer.parseInt(line);
                int count = 0;
                for(int i = 2; i < n; i++){
                    if(isPerfectNumber(i)){
                        count++;
                        list.add(i);
                    }
                }
                System.out.print(count + " ,[");
                for(int i = 0; i < list.size();i++){
                    System.out.println(list.get(i));
                }
            }
            inputFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred: File not found.");
            e.printStackTrace();
        }

    }

    public static boolean isPerfectNumber(int n) {
        if (n <= 1) return false;

        int sum = 1; // 1 is always a divisor
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                sum += i;
                if (i != n / i) {
                    sum += n / i;
                }
            }
        }
        return sum == n;
    }
}