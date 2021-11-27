package lab1;
import java.io.*;
public class Lab1 {


    public static void main(String[] args) {
        
        try(FileReader reader = new FileReader("C:\\Users\\Chipprik\\Documents\\NetBeansProjects\\Lab1\\Chapter.txt"))
        {
            int c;
            while((c=reader.read())!=-1){
            try(FileWriter writer = new FileWriter("C:\\Users\\Chipprik\\Documents\\NetBeansProjects\\Lab1\\ChapterChanged.txt", true))
            {

                int x = c;
                x = (x + 14);
                writer.write((char)(x));
                
                
                writer.flush();
            }
                catch(IOException ex){
             
                    System.out.println(ex.getMessage());
                } 
            } 
        } 
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        }
        try(FileReader reader = new FileReader("C:\\Users\\Chipprik\\Documents\\NetBeansProjects\\Lab1\\ChapterChanged.txt"))
        {
            int c;
            while((c=reader.read())!=-1){
            try(FileWriter writer = new FileWriter("C:\\Users\\Chipprik\\Documents\\NetBeansProjects\\Lab1\\ChapterChangedBack.txt", true))
            {

                int x = c;
                x = (x - 14);
                writer.write((char)(x));
                
                
                writer.flush();
            }
                catch(IOException ex){
             
                    System.out.println(ex.getMessage());
                } 
            } 
        } 
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        }   
    } 
}
