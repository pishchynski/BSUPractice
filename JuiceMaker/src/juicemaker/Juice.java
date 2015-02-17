
package juicemaker;

import java.io.*;
import java.util.*;


public class Juice {
    private Set<String> components = new TreeSet<String>();
    
    Juice(ArrayList<String> components) {
        this.components.addAll(components);
    }
    
    public int getSize(){
        return components.size();
    }
}
