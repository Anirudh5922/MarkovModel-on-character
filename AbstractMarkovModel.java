
/**
 * Abstract class AbstractMarkovModel - write a description of the class here
 * 
 * @author  Anirudh Maheshwari
 * @version 1.0
 */

import java.util.*;

public abstract class AbstractMarkovModel implements IMarkovModel {
    protected String myText;
    protected Random myRandom;
    
    public AbstractMarkovModel() {
        myRandom = new Random();
    }
    
    public void setTraining(String s) {
        myText = s.trim();
    }
 
    abstract public String getRandomText(int numChars);
    
    protected ArrayList<String> getFollows(String key){
       ArrayList<String> ans = new ArrayList<String>();
       int i=0;
       while(i<myText.length()){
         int idx = myText.indexOf(key,i);
         if(idx==-1)
            break;
         i=idx+key.length();
         if(i<myText.length())
            ans.add(myText.substring(i,i+1));            
        }
       return ans;
    }
}
