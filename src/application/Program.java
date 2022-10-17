package application;

import entities.Product;
import services.CalculationMaxService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args) throws IOException {

        String path = "/home/eduardo/Documents/JavaCursesProjects/generics2-java/ac.txt";
        List<Product> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();

            while (line != null) {
                String[] s = line.split(",");
                list.add(new Product(s[0], Double.parseDouble(s[1])));
                line = br.readLine();
            }

            Product x = CalculationMaxService.max(list);
            System.out.println(x);

        } catch (IOException e) {
            System.out.print("Error" + e.getMessage());
        }

    }
}
