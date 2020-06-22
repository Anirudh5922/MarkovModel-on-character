import java.util.Random;
import java.util.*;
import java.io.*;
import edu.duke.*;
/**
 * Write a description of Tester here.
 * 
 * @author Anirudh Maheshwari 
 * @version 1.0
 */
public class Tester {
   public void testGetFollows(){
      MarkovOne mak = new MarkovOne();
      String s = "this is a test yes this is a test.";
      mak.setTraining(s);
      String key = "t";
      ArrayList<String> next = mak.getFollows(key);
      System.out.println(key+" : "+next);
      
      key = "t.";
      next = mak.getFollows(key);
      System.out.println(key+" : "+next);
      
      key = "tes";
      next = mak.getFollows(key);
      System.out.println(key+" : "+next);
    }
    
   public void  testGetFollowsWithFile(){
      MarkovOne mak = new MarkovOne();
      FileResource fr = new FileResource();
      String s = fr.asString();
      mak.setTraining(s);
      String key = "t";
      ArrayList<String> next = mak.getFollows(key);
      System.out.println(key+" : "+next);
      System.out.println("Size : "+next.size()+"\n");
    } 
}
