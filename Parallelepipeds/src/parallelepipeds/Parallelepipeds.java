
package parallelepipeds;

import java.io.*;
import java.util.*;

public class Parallelepipeds {

    public static void main(String[] args) throws IOException {
        new Parallelepipeds().solve();
    }
    
    private void input(ArrayList<ArrayList<Integer>> parallelepipeds) throws IOException{
        
        Scanner in = new Scanner(new BufferedReader(new FileReader("input.txt")));
        int n;
        int m;
        n = in.nextInt();
        m = in.nextInt();
        int i;
        int j;
        for(i = 0; i < m; ++i){
            parallelepipeds.add(new ArrayList<Integer>());
            for(j = 0; j < n; ++j){
                parallelepipeds.get(i).add(in.nextInt());
            }
        }
        
    }
    
    private void coordSort(ArrayList<ArrayList<Integer>>parallelepipeds){
        int n = parallelepipeds.size();
        int i;
        for(i = 0; i < n; ++i){
            Collections.sort(parallelepipeds.get(i));
        }
    }
    
    private void volumes(ArrayList<ArrayList<Integer>> parallelepipeds){
        int n = parallelepipeds.size();
        int vol;
        int j;
        int m;
        ArrayList<Integer> par = new ArrayList<Integer>();
        for(int i = 0; i < n; ++i){
            par = parallelepipeds.get(i);
            vol = 1;
            m = par.size();
            for(j = 0; j < m; ++j){
                vol *= par.get(j);
            }
            parallelepipeds.get(i).add(vol);
        }
    } 
    
    private class VolCompare implements Comparator{
        public int compare(Object obj1, Object obj2){
            ArrayList<Integer> par1 = (ArrayList<Integer>)obj1;
            ArrayList<Integer> par2 = (ArrayList<Integer>)obj2;
            int n = par1.size();
            return par2.get(n-1) - par1.get(n-1);
        }    
    }
    
    private void volumeSort(ArrayList<ArrayList<Integer>> parallelepipeds){
        Collections.sort(parallelepipeds, new VolCompare());
    }
    
    private int enclosure(ArrayList<ArrayList<Integer>>parallelepipeds){
        int n = parallelepipeds.size();
        int m = parallelepipeds.get(0).size() - 1;
        int enc[] = new int[n];
        
        int i;
        int j;
        int k;
        int max;
        boolean flag;
        for(i = 0; i < n; ++i){
            enc[i] = 1;
        }
        for(i = 1; i < n; ++i)
        {
            max = 1;
            for(j = 0; j < i; ++j){
                 flag = true;
                for(k = 0; k < m; ++k){
                    if(parallelepipeds.get(i).get(k) > parallelepipeds.get(j).get(k)){
                        flag = false;
                    }
                }
                if(!flag){
                    continue;
                }
                enc[i] = enc[j] + 1;
            }
            
        }
        max = 1;
        for(i = 1; i < n; ++i){
            if(enc[i] > max){
                max = enc[i];
            }
        }
        
        return max;
    }
    
    private void output(int enclosures) throws IOException{
        PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
        out.print(enclosures);
        out.flush();
    }
    
    private void solve() throws IOException{
        ArrayList<ArrayList<Integer>> parallelepipeds = new ArrayList<ArrayList<Integer>>();
        input(parallelepipeds);
        coordSort(parallelepipeds);
        volumes(parallelepipeds);
        volumeSort(parallelepipeds);
        int enclosures = enclosure(parallelepipeds);
        output(enclosures);
        
    }
    
}
