import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Readcol {
    public static void main(String[] args) throws Exception{
       
        String filePath = "C:\\\\Users\\\\kavin.garcia\\\\Documents\\\\Readfile\\\\Data.csv"; // Replace with the path to your file
        
        int expectedColumnCount = 3; // Set the expected number of columns

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into columns using a delimiter (e.g., comma for CSV)
                String[] columns = line.split(",");
                
                // Check if the number of columns matches the expected count
                if (columns.length != expectedColumnCount) {
                   
                    System.out.println("Error: Line with incorrect column count found!");
                    System.out.println("Expected: " + expectedColumnCount + " columns");
                    System.out.println("Actual: " + columns.length + " columns");
                    System.out.println("Line content: " + line);
                }
                else{
                    for(String var : columns){
                        System.out.println(var);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}