import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution2{
    public static void main(String[] args){
        String pattern ="\\<(.+)\\>([^\\<\\>]+)\\<\\/\\1\\>";
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while(testCases>0){
            String line = in.nextLine();
            Pattern p = Pattern.compile(pattern);
            Matcher m =  p.matcher(line);
            String val = "";
            //Write your code here
            while(m.find())
            {
                val+=m.group(2)+"\n";
            }
            if(val.length()==0)
                System.out.println("None");
            else {
                System.out.println(val.substring(0,val.length()-1));
            }
            testCases--;
        }





    }
}



