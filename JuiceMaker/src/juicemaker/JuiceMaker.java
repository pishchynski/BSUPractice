
package juicemaker;

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
        juices.sort((Juice juice1, Juice juice2) -> juice1.getSize() - juice2.getSize());
        Components components = new Components(juicesComponents);
        Components permanentComponents = new Components(juicesComponents);
        int washesCount = 1;
        int i = 0;
        int j;
        int k;
        boolean flag = false;
        
        String tempName;
        int maxSize;
        while(!flag) {
            maxSize = maxJuiceSize(juices);
            components.sort();
            j = 0;
            flag = true;
            while(j < maxSize) {
                
                k = 0;
                while(juices.get(k).getSize() == j+1){
                    
                    tempName = components.getName(j);
                    if(juices.get(k).hasComponent(tempName)) {
                        juices.remove(k);
                        components.setNum(tempName, components.getNum(tempName)-1);
                        flag = false;
                        --k;
                    }
                    ++k;
                }
                
                ++j;
            }
            washesCount++;
        }
        
        System.out.println(washesCount);
    }
    
}
