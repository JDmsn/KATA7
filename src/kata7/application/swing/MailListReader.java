package kata7.application.swing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;

public class MailListReader {
    public static List<Person> readFromFile(String fileName) throws FileNotFoundException, IOException {        
        ArrayList<Person> mlList = new ArrayList<>();
        BufferedReader fileRead = new BufferedReader(new FileReader(new File(fileName)));
        int id=0;
        String email;
        while((email = fileRead.readLine())!= null) 
            if(email.contains("@")) {
            	mlList.add(new Person(id++, email));   
            }       
        return mlList;
    }
}
