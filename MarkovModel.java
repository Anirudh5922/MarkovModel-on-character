import java.util.Random;
import java.util.*;
import java.io.*;
import edu.duke.*;
/**
 * Write a description of MakovModel here.
 * 
 * @author Anirudh Maheshwari
 * @version 1.0
 */
public class MarkovModel extends AbstractMarkovModel{
    
    //private String myText;
    //private Random myRandom;
    private int N;	
    
    public MarkovModel(int n) {
	    myRandom = new Random();
	    N=n;
	      }
	
    public void setRandom(int seed){
	    myRandom = new Random(seed);
	  }
	
    public void setTraining(String s){
	    myText = s.trim();
	  }
	
    public String getRandomText(int numChars){
	 if (myText == null){
		return "";
	   }
	 StringBuilder sb = new StringBuilder();
	 int index = myRandom.nextInt(myText.length()-N);
	 String key = myText.substring(index,index+N);
	 sb.append(key);
	 for(int k=0; k < numChars-N; k++){
	      ArrayList<String> follows = getFollows(key);
	      if(follows.size()==0){
	         break;
	       }
	      index = myRandom.nextInt(follows.size());
	      String next = follows.get(index);
	      sb.append(next);
	      key = key.substring(1) + next ;
	   }
		
	 return sb.toString();
      }
    
    public String toString(){
         return "MarkovModel of order "+N;
      }	  
}
