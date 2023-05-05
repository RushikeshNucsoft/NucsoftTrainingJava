import java.io.*;

public class FileAppend {
   public static void main(String[] args) {
      try {
         // Open input file for reading
         File inputFile = new File("C:\\Rushikesh_Drive\\NucsoftTraining\\Java\\Assignment 4\\Read.txt");
         FileInputStream inputStream = new FileInputStream(inputFile);
         
         // Open output file for appending
         File outputFile = new File("C:\\\\Rushikesh_Drive\\\\NucsoftTraining\\\\Java\\\\Assignment 4\\\\Write.txt");
         FileOutputStream outputStream = new FileOutputStream(outputFile, true);
         
         // Read input file data and write to output file
         byte[] buffer = new byte[1024];
         int bytesRead;
         while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
         }
         
         // Close input and output streams
         inputStream.close();
         outputStream.close();
         
         System.out.println("Data from File1 appended to File2 successfully!");
      } catch (IOException e) {
         System.out.println("Error occurred while appending data to File2: " + e.getMessage());
      }
   }
}
