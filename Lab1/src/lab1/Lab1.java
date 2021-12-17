package lab1;
import java.io.*;
public class Lab1 {


    public static void main(String[] args) {
    int[][] mass= new int [100][2];
    char[] alf=new char[]{'о', 'е', 'а', 'и', 'н', 'т', 'с', 'л', 'в', 'р', 'к', 'м', 'у', 'д', 'п', 'я', 'ь', 'б', 'з', 'ы', 'ч', 'г', 'ж', 'х', 'й', 'ш', 'ю', 'ф', 'э', 'щ', 'ё', 'ц', 'ъ'};
    int massMax=1;
    
        try(FileReader reader = new FileReader("C:\\Users\\Chipprik\\Documents\\NetBeansProjects\\Lab1\\Chapter.txt"))
        {
            int c;
            while((c=reader.read())!=-1){
            try(FileWriter writer = new FileWriter("C:\\Users\\Chipprik\\Documents\\NetBeansProjects\\Lab1\\ChapterChanged.txt", true))
            {
                
                int x = c;
                if ((char)c>='а' && (char)c<='я') 
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
            if (!(((char)c>='!' && (char)c<='@') || c==13 || (char)c==' ' || (char)c=='—'))
               for (int i=0;i<massMax;i++){
                   if (c==mass[i][0])
                   {
                       mass[i][1]++;
                       break;
                   }
                   else if((i+1)==massMax)
                   {
                        mass[massMax][0]=c;
                        mass[massMax][1]++;
                        massMax++;
                   }
               }

            } 
        }      
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        }
        boolean isSorted = false;
        int buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < massMax-1; i++) {
                if(mass[i][1] < mass[i+1][1]){
                    isSorted = false;
                    buf = mass[i][0];
                    mass[i][0] = mass[i+1][0];
                    mass[i+1][0] = buf;
                    buf = mass[i][1];
                    mass[i][1] = mass[i+1][1];
                    mass[i+1][1] = buf;
                }
            }
        }
        massMax=33;
        try(FileReader reader = new FileReader("C:\\Users\\Chipprik\\Documents\\NetBeansProjects\\Lab1\\ChapterChanged.txt"))
        {
            int c;
            while((c=reader.read())!=-1){
            try(FileWriter writer = new FileWriter("C:\\Users\\Chipprik\\Documents\\NetBeansProjects\\Lab1\\ChapterChangedBack.txt", true))
            {

                int x = c;
                for (int i=0;i<massMax;i++){
                   if (c==mass[i][0])
                        x=(int)alf[i];
               }
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
