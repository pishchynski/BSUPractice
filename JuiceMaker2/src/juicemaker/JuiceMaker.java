
package juicemaker;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;
import javafx.util.Pair;


public class JuiceMaker {

    public static void main(String[] args) {
        new JuiceMaker().solve();
    }
    
    
     private ArrayList<Pair<String, Integer> > input()
    {
        try{
            ArrayList<Pair<String, Integer> > juices = new ArrayList<Pair<String, Integer> >();
            
            Scanner in = new Scanner(new BufferedReader(new FileReader("input1.in")));
            ArrayList<String> tokens = new ArrayList<String>();
            StringTokenizer  componentsTokenizer;
            int index;
            StringBuffer temp = new StringBuffer("");
            while(in.hasNextLine()){
                tokens.clear();
                index = 0;
                temp.delete(0, temp.length());
                componentsTokenizer = new StringTokenizer(in.nextLine());
                while(componentsTokenizer.hasMoreTokens()) {
                    tokens.add(componentsTokenizer.nextToken());
                    ++index;
                }
                tokens.sort(null);
                for(String str: tokens) {
                    temp.append( str + " ");
                }
                temp.trimToSize();
                juices.add(new Pair<String, Integer>(temp.toString(), index));
            }
            return juices;
            
                
        }
        catch(FileNotFoundException e){
            System.out.print("File not found!");
            return null;
        }
    }
    
    private int countWashes(ArrayList<Pair<String, Integer> > components) {
        ArrayList<String> juices = new ArrayList<String>();
        Iterator<Pair<String, Integer> > it = components.iterator();
        while(it.hasNext()) {
            juices.add(it.next().getKey());
        }
        
        String temp = "";
        int countWashes = 0;
        int quant = juices.size();
        int i = 0;
        boolean flag = false;
        StringTokenizer juiceTokenizer;
        while (quant != 0) {
            i = 0;
            temp = juices.get(i);
            quant--;
            juices.remove(i);
            for(; i < quant; ++i) {
                juiceTokenizer = new StringTokenizer(temp);
                flag = false;
                while(juiceTokenizer.hasMoreTokens()){
                    if(juices.get(i).contains(juiceTokenizer.nextToken())) {
                        flag = true;
                    }
                }
                if(flag){
                    temp = juices.get(i);
                    quant--;
                    juices.remove(i);
                    i--;
                }
            }
            countWashes++;
        }
        
        System.out.println(countWashes);
        return countWashes;
    } 
    
    private void solve() {
        ArrayList<Pair<String, Integer> > juices = new ArrayList<Pair<String, Integer> >();
        juices = input();
        juices.sort((Pair<String, Integer> juice1, Pair<String, Integer> juice2) -> juice1.getValue()- juice2.getValue());
        int countWashes = countWashes(juices);
    }
    
}
