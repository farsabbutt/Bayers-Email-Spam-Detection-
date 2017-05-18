/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Qosmio
 */
public class ReadWrite {
    
    public ArrayList<Email> readData(String fileName){
        ArrayList<Email> listed = new ArrayList<Email>();
        
            listed = ReadFromFile(fileName);
        
        return listed;
    }
    
    private static ArrayList<Email> ReadFromFile(String fileName){
        ArrayList<Email> result = new ArrayList<Email>();
        try{
            
            InputStream in = ReadWrite.class.getResourceAsStream(fileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;
            
            while((line=reader.readLine()) != null){
                    //System.out.println(line);
                    boolean isSpam = false;
                    String splitted[] = line.split(",");
                    
                    if(splitted[1].equals("spam")){
                        isSpam = true;
                    }
                    result.add(new Email(splitted[0],isSpam));
            }
            
            }catch(IOException e){
                e.printStackTrace();
        }
        
        return result;
    
    }
}
