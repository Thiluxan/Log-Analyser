package com.assignment.fileOperations;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileRead {

    public String readFile(String path) {
        try
        {
            File file=new File(path);
            FileReader fr=new FileReader(file);
            BufferedReader br=new BufferedReader(fr);
            StringBuffer sb=new StringBuffer();
            String line;
            while((line=br.readLine())!=null)
            {
                sb.append(line);
                boolean isERROR = line.contains("ERROR");
                if(isERROR){
                    System.out.println("Error occured send mail");
                    break;
                }
                sb.append("\n");
            }
            fr.close();
            System.out.println(sb.toString());
            return sb.toString();
        }

        catch(IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
