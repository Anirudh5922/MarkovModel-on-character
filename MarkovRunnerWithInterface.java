
/**
 * Write a description of class MarkovRunner here.
 * 
 * @author Anirudh Maheshwari
 * @version 1.0
 */

import edu.duke.*; 

public class MarkovRunnerWithInterface {
    public void runModel(IMarkovModel markov, String text, int size) {
        markov.setTraining(text);
        System.out.println("running with " + markov);
        for(int k=0; k < 3; k++){
			String st= markov.getRandomText(size);
			printOut(st);
		}
    }
    
    public void runMarkov() {
        FileResource fr = new FileResource();
	
        String st = fr.asString();
		st = st.replace('\n', ' ');
		int size = 200;
	/*	
        MarkovZero mz = new MarkovZero();
        mz.setRandom(42);
        runModel(mz, st, size);
        
        MarkovOne mOne = new MarkovOne();
        mOne.setRandom(42);
        runModel(mOne, st, size);*/
        
        MarkovModel mThree = new MarkovModel(2);
        mThree.setRandom(42);
        runModel(mThree, st, 1000);
        //System.out.println(System.nanoTime());
        /*
        MarkovFour mFour = new MarkovFour();
        mFour.setRandom(42);
        runModel(mFour, st, size);
         */
    }
    
    public void testHashMap(){
       FileResource fr = new FileResource();
       String st = fr.asString();
       st = st.replace('\n', ' ');
       //st = "yes-this-is-a-thin-pretty-pink-thistle";
       int size = 100;
       EfficientMarkovModel m2 = new EfficientMarkovModel(5);
       m2.setRandom(531);
       runModel(m2, st, size);
       //System.out.println(System.nanoTime());
       //m2.printHashMapInfo();
    }
     
      private void printOut(String s){
		String[] words = s.split("\\s+");
		int psize = 0;
		System.out.println("----------------------------------");
		for(int k=0; k < words.length; k++){
			System.out.print(words[k]+ " ");
			psize += words[k].length() + 1;
			if (psize > 60) {
				System.out.println();
				psize = 0;
			}
		}
		System.out.println("\n----------------------------------");
	 }
	
}
