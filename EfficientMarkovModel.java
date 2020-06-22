import java.util.Random;
import java.util.*;
import java.io.*;
import edu.duke.*;
/**
 * Write a description of EfficientMarkovModel here.
 * 
 * @author Anirudh Maheshwari 
 * @version 1.0
 */
public class EfficientMarkovModel extends AbstractMarkovModel{
    
    private int N;	
    private HashMap<String,ArrayList<String>> map; 
    
    public EfficientMarkovModel(int n) {
	    myRandom = new Random();
	    N=n;
	      }
	
    public void setRandom(int seed){
	    myRandom = new Random(seed);
	  }
	
    public void setTraining(String s){
	    myText = s.trim();
	    map = buildMap();
	    printHashMapInfo();
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
    
    public HashMap<String,ArrayList<String>> buildMap(){
       HashMap<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
       if (myText == null){
		return map;
	   }
	   
       for(int i=0;i<myText.length()-N;i++){
          if(!map.containsKey(myText.substring(i,i+N)))
           {   ArrayList<String> arr = new ArrayList<String>();
               arr.add(myText.substring(i+N,i+N+1));
               map.put(myText.substring(i,i+N),arr);
            }
          else
            { ArrayList<String> arr = map.get(myText.substring(i,i+N));
              arr.add(myText.substring(i+N,i+N+1));
              map.put(myText.substring(i,i+N),arr);
            }
        }
       ArrayList<String> arr = new ArrayList<String>();
       map.put(myText.substring(myText.length()-N,myText.length()),arr);
       return map;
    }
    
    public ArrayList<String> getFollows(String key){
       ArrayList<String> ans = map.get(key);
       return ans;
    }
    
    public String toString(){
         return "EfficientMarkovModel of order "+N;
      }	  
    
    public void printHashMapInfo(){
      int max=0; 
      ArrayList<String> kmax=new ArrayList<String>();
      for(String s:map.keySet()){
         System.out.println(s+" : "+map.get(s));
         if(max<map.get(s).size())
            { max = map.get(s).size();
              
            }
        }
      System.out.println("No. of keys : "+map.size()); 
      for(String s:map.keySet()){
         //System.out.println(s+" : "+map.get(s));
         if(max==map.get(s).size())
            { kmax.add(s);
            }
        }
        
      System.out.println("Maximum Size : "+max+" at key : "+kmax); 
      
    }
}
