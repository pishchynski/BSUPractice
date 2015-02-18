
package juicemaker;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javafx.util.Pair;

public class Components {
    private ArrayList<Pair<String, Integer> > components = new ArrayList<Pair<String,Integer> >();
    
    private class NumComp implements Comparator {
        public int compare(Object obj1, Object obj2) {
            Pair<String, Integer> component1 = (Pair<String, Integer>)obj1;
            Pair<String, Integer> component2 = (Pair<String, Integer>)obj2;
            return component2.getValue() - component1.getValue();
        }
    }
    
    Components(ArrayList<ArrayList<String> > juicesComponents) {
        this.components = formMap(juicesComponents);   
    }
    private ArrayList<Pair<String, Integer> > formMap(ArrayList<ArrayList<String> > juicesComponents) {
        Map<String, Integer> compsByName = new TreeMap<String,Integer>();
        ArrayList<Pair<String, Integer> > components = new ArrayList<Pair<String, Integer> >();
        int juicesNum = juicesComponents.size();
        int compsNum;
        int i;
        int j;
        ArrayList<String> temp;
        for(i = 0; i < juicesNum; ++i) {
            temp = juicesComponents.get(i);
            compsNum = temp.size();
            for(j = 0; j < compsNum; ++j) {
                if(compsByName.get(temp.get(j)) == null) {
                    compsByName.put(temp.get(j), 1);
                }
                else {
                    compsByName.replace(temp.get(j), compsByName.get(temp.get(j))+1);
                }
            }
        }
        Set<String> compNamesSet = compsByName.keySet();
        Iterator<String> it = compNamesSet.iterator();
        String tempCompName; 
        while(it.hasNext()) {
            tempCompName = it.next();
            components.add(new Pair<String, Integer>(tempCompName, compsByName.get(tempCompName)));
        }
        components.sort(new NumComp());
        return components;
    }
    
    public String getName(int index) {
        return components.get(index).getKey();
    }
    
    public int getNum(String name){
        int n = components.size();
        int i;
        for(i = 0; i < n; ++i){
            if((components.get(i)).getKey().equals(name)){
                return components.get(i).getValue();
            }
        }
        return -1;
    }
    
    public void setNum(String name, int num) {
        int n = components.size();
        int i;
        for(i = 0; i < n; ++i){
            if((components.get(i)).getKey().equals(name)){
                 components.set(i, new Pair<String, Integer>(name, num));
            }
        }
    }
    
    public void sort() {
         components.sort(new NumComp());
    }
    
    
    public void remove(String name) {
        int n = components.size();
        int i;
        for(i = 0; i < n; ++i){
            if((components.get(i)).getKey().equals(name)){
                components.remove(i);
                break;
            }
        }
    }
    
}
