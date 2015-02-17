
package juicemaker;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import com.sun.java.swing.plaf.windows.resources.windows;
import java.io.*;
import java.util.*;

public class JuiceMaker {

    public static void main(String[] args) {
        new JuiceMaker().solve();
    }
    
    private ArrayList<ArrayList<String> > input()
    {
        try{
            ArrayList<ArrayList<String> > juices = new ArrayList<ArrayList<String> >();
            
            Scanner in = new Scanner(new BufferedReader(new FileReader("input1.in")));
            StringTokenizer  componentsTokenizer;
            int index = 0;
            while(in.hasNextLine()){
                juices.add(new ArrayList<String>());
                componentsTokenizer = new StringTokenizer(in.nextLine());
                while(componentsTokenizer.hasMoreTokens()) {
                juices.get(index).add(componentsTokenizer.nextToken());
                }
                ++index;
            }
            return juices;
            
                
        }
        catch(FileNotFoundException e){
            System.out.print("File not found!");
            return null;
        }
    }
    
    private void makeJuices(ArrayList<ArrayList<String> > juicesComponents, ArrayList<Juice> juices){
        int num = juicesComponents.size();
        for(int i = 0; i < num; ++i){
            juices.add(new Juice(juicesComponents.get(i)));
        }
    }
    
    private int maxJuiceSize(ArrayList<Juice> juices) {
        int n = juices.size();
        int i;
        int max = 0;
        for(i = 0; i < n; ++i) {
            if (max < (juices.get(i)).getSize());
            max = juices.get(i).getSize();
        }
        return max;
    }
    
    private void solve(){
        ArrayList<ArrayList<String> > juicesComponents = new ArrayList<ArrayList<String> >();
        ArrayList<Juice> juices = new ArrayList<Juice>();
        juicesComponents = input();
        makeJuices(juicesComponents, juices);
        Components components = new Components(juicesComponents);
        Components permanentComponents = new Components(juicesComponents);
        int washesCount = 1;
        int i;
        int j;
        boolean flag = false;
        int maxSize;
        while(!flag) {
            maxSize = maxJuiceSize(juices);
            while(j < maxSize)
        }
    }
    
}
