import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadFileUsingStream {
    public static void main(String[] args) throws Exception {
        // Specify the path to the file you want to read
        String filePath = "C:\\Users\\kavin.garcia\\Documents\\Readfile\\Data.csv";

        // Use try-with-resources to automatically close the stream
        Stream<String> ReadFileUsingStream = Files.lines(Paths.get(filePath));

        // preserve order

        // lines.forEachOrdered(System.out::println);

    // List<String> collect = ReadFileUsingStream.collect(Collectors.toList());
    // System.out.println(collect);
   // ReadFileUsingStream.forEach(System.out::println);
    long fileLength = ReadFileUsingStream.count(); // This returns the length of the file in bytes
    System.out.println("File length: " + fileLength + " rows");
}
}
    

    
