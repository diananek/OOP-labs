package lab4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class DataLogger {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Введите показания: ");
        String dataLine = input.nextLine();
        System.out.println("По какому полю сортировать (1 - по id; 2 - по средней температуре): ");
        int sortOption = input.nextInt();
        double[][] dataArray = null;

        try {
            dataArray = dataHandler(dataLine);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        averagesHandler(dataArray);

        if (sortOption == 1) {
            Arrays.sort(dataArray, Comparator.comparingDouble(x -> x[0]));
            for (int i = 0; i < dataArray.length; i++) {
                if (dataArray[i][0] != 0) {
                    System.out.printf("%.0f %.1f%n", dataArray[i][0], dataArray[i][1]);
                } 
            }
        } else {
            Arrays.sort(dataArray, Comparator.comparingDouble(x -> x[1]));
            for (int i = 0; i < dataArray.length; i++) {
                if (dataArray[i][0] != 0) {
                    System.out.printf("%.0f %.1f%n", dataArray[i][0], dataArray[i][1]);
                }
            }
            
        }
    }

    public static double[][] dataHandler(String line) throws Exception {
        String[] data = line.split("@");
        double[][] dataArray = new double[data.length][2];

        for (int i = 0; i < data.length; i++) {
            double id = Double.parseDouble(data[i].substring(0, 2));
            double temp = Double.parseDouble(data[i].substring(2));

            try {
                if (temp > 50 || temp < -50) {
                    throw new ValueOutRangeException();
                }
            } catch (ValueOutRangeException e) {
                System.out.println(e);
                System.exit(0);
            }
            
            double[] tuple = {id, temp};
            dataArray[i] = tuple;
        }

        return dataArray;
    }
    
    public static void averagesHandler(double[][] dataArray) {
        for (int i = 0; i < dataArray.length; i++) {
            int count = 1;
            for (int j = 0; j < dataArray.length; j++) {
                if (dataArray[i][0] == dataArray[j][0] && i != j) {
                    dataArray[i][1] += dataArray[j][1];
                    count++;
                    dataArray[j][0] = 0;
                }
            }
            dataArray[i][1] = dataArray[i][1] / count; 
        }
    }
}
