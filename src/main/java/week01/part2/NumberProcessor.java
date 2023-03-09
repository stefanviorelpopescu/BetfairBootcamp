package week01.part2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class NumberProcessor
{
    public void readNumber(Scanner scanner) {
        System.out.println("Your number: ");
        int number = getInt(scanner);
        System.out.println(number);
    }

    public int getInt(Scanner scanner) {
        return scanner.nextInt();
    }

    public void readFromFile(String fileName)
    {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName)))
        {
            String line = br.readLine();
            while (line != null)
            {
                System.out.println(line);
                line = br.readLine();
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }

}
