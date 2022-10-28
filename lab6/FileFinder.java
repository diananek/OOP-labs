package lab6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class FileFinder {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in, "cp866")) {
            System.out.println("Введите путь к директории:");
            Path directoryPath = Paths.get(input.nextLine().trim());

            System.out.println("1 - поиск по названию, 2 - поиск по содержимому:");
            int option = input.nextInt();
            input.nextLine();
            try {
                switch(option) {
                    case 1:
                        System.out.println("Введите имя файла:");
                        String fileName = input.nextLine().trim();
                        File resultFile = searchFile(directoryPath, fileName);
                        System.out.println(resultFile.getPath());
                    case 2:
                        System.out.println("Введите содержимое файла:");
                        String fileContent = input.nextLine();
                        List<String> pathList = getDirectoryFiles(directoryPath);
                        for (String path : pathList) {
                            if (isContainContent(path, fileContent)) {
                                System.out.println(path);
                            }
                        }
                    default:
                        System.out.println("Введите корректное значение!");
    
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            
        }
    }

    public static List<String> getDirectoryFiles(Path directoryPath) throws IOException {
        List<String> pathList = new ArrayList<String>();

        try (Stream<Path> stream = Files.walk(directoryPath)) {
            pathList = stream
            .map(Path::normalize)
            .filter(Files::isRegularFile)
            .filter(path -> path.getFileName().toString().endsWith(".txt"))
            .map(path -> path.toString())
            .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return pathList;
    }

    public static Boolean isContainContent(String pathFile, String searchString) throws FileNotFoundException {
        InputStream stream = new FileInputStream(pathFile);
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream))) {
            Stream<String> linesStream = bufferedReader.lines();
            return linesStream.allMatch(line -> line.contains(searchString));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static File searchFile(Path directoryPath, String fileName) throws IOException {
        File target = null;
        try (Stream<Path> stream = Files.find(directoryPath, Integer.MAX_VALUE,
            (path, attr) -> path.getFileName().toString().equals(fileName))) {
                Optional<Path> path = stream.findFirst();
                if(path.isPresent()) {
                    target = path.get().toFile();
                }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return target;
    }
}
