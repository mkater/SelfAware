

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


public class SelfAware implements Language{

    public int occurrences(final String sourceFile) throws Exception{

        final String s = new String(Files.readAllBytes(Paths.get(sourceFile)));
        String[] sa = s.split("\\W+");
        Language.sort();


        int j = 0;
        for(int i = 0; i < sa.length; i++){
            for(int k = 0; k < ReservedWords.length; k++){
                if(sa[i].equalsIgnoreCase(ReservedWords[k])){
                    j++;
                    k = ReservedWords.length;
                }
            }
        }
        return j;
    }


    public void append(String sourceFile, String message) throws IOException{
        Files.write(Paths.get(sourceFile), message.getBytes(),
                StandardOpenOption.APPEND, StandardOpenOption.CREATE);
    }


    public static void main(String[] args) throws Exception {
        final String code = System.getProperty("user.dir") + File.separator +
                "src"  + File.separator + SelfAware.class.getName().replace(".", File.separator) + ".java";
        SelfAware sa = new SelfAware();
        sa.append(code,"\n//Keyword occurrences: " + sa.occurrences(code));
    }
}


//Keyword occurrences: 33
// public void private package print
//Keyword occurrences: 37
// doesn't count print in comments line 50 or the current line yay
//Keyword occurrences: 37