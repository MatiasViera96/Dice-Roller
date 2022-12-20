package test;

import Domain.Classes.die;
import java.util.*;

class dieTest {
  /**
   * This class is used to test the die class and its functionalities
   */

  //defines an empty constructor

  /**
   * Generates all the values in range for the die to be tested. from 1 to range
   * @param range number of sides of the die to be tested
   * @return an array containing numbers from 1 to die number of sides
   */
  private int [] generateDiveValueArray(int range){
    int [] ret = new int[range];
    for(int i =0; i<range;i++){
      ret[i] = i+1;
    }
    return ret;
  }

  /**
   * test the roll funciton and die constructor of die class
   * @param dieType must be the number of sides of the die to roll. die number of sides must be > 0
   */
  public void test(int dieType){
    int [] dieValue = generateDiveValueArray(dieType);
    try{
      die testDie = new die (dieType);
      boolean containsAll [] = new boolean[dieValue.length];//array contains all false upon creation, is used to
                                                            // check that the roll function is returning every
                                                            //value in its range
      boolean endTest = false;
      for(int i =0;i<dieType*10 && !endTest;i++){
        boolean contains = false;
        int rolledValue = testDie.roll();
        for(int j=0;j<dieValue.length && !contains;j++){
          if(dieValue[j] == rolledValue) {
            containsAll[j] = true;
            contains = true;
          }
        }
        if(!contains) System.out.println("die rolled "+ rolledValue +" and is not in expected range of 1 .. " + dieType);
        for(int j=0;j<dieValue.length && containsAll[j] ;j++){
          if (j==dieValue.length -1 ) endTest = true;
        }
      }
      if(endTest){
        System.out.println("Test succesfull!!");
      }
    }catch (Exception e){
      System.out.println(e.getMessage());
    }
 }

}
