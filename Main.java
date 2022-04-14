package analyzer;

import java.io.IOException;
import java.io.*;
import java.lang.*;

public class Main {
    
    public static void main(String[] args) {
        // example input : java Main --KMP huge_doc.pdf "%PDF-" "PDF document"
        // args[0] = algorithm type, args[1] = file, args[2] = pattern to search for, args[3] = File match statement
        
        if (args == null || args.length != 4) {
            System.out.println("Wrong number of String args. Please provide file, pattern String, and result String");
        }
        byte[] bytes = new byte[10000];
        
        try (InputStream streamIn = new BufferedInputStream(new FileInputStream(args[1]))) {
            int readByte = streamIn.read();
            while (readByte != -1) {
                readByte = streamIn.read(bytes);
            }
            
            String byteString = new String(bytes);
            
            
            if ("--naive".equals(args[1])) {
                long begin = System.nanoTime();
                
                boolean found = naiveStringSearch(byteString, args[2]);
                
                long end = System.nanoTime();
                long time = (end - begin) / 1_000_000_000;
                
                if (found == true) {
                    System.out.println("PDF document");
                    System.out.println("It took %f seconds", time);
                } else {
                    System.out.println("Unknown file type");
                    System.out.println("It took %f seconds", time); 
                }
            } else {
                System.out.println("Unknown algorithm type");
            }
            
            if ("--KMP".equals(args[1])) {
                long begin = System.nanoTime();
                
                boolean found = naiveStringSearch(byteString, args[2]);
                
                long end = System.nanoTime();
                long time = (end - begin) / 1_000_000_000;
                
                if (found == true) {
                    System.out.println("PDF document");
                    System.out.println("It took %f seconds", time);
                } else {
                    System.out.println("Unknown file type");
                    System.out.println("It took %f seconds", time); 
                }
            } else {
                System.out.println("Unknown algorithm type");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }
}
