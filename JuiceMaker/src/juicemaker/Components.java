
package juicemaker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Components {
    private Map<Integer, String> components = new TreeMap<Integer,String>();
    
    Components(ArrayList<ArrayList<String> > juicesComponents) {
        this.components = formMap(juicesComponents);   
    }
    private Map<Integer, String> formMap(ArrayList<ArrayList<String> > juicesComponents) {
        Map<String, Integer> compsByName = new TreeMap<String, Integer>();
        Map<Integer, String> compsByNum = new TreeMap<Integer,String>();
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
            compsByNum.put(compsByName.get(tempCompName), tempCompName);
        }
        return compsByNum;
    }
    String get(int num) {
        return components.get(num);
    }
    
    public void remove(String name) {
        components.remove(name);
    }
}
