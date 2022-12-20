package Domain.Controllers;

import Domain.Classes.die;

import java.util.ArrayList;
import java.util.List;
public class dieController {

  //constructor method is the default method. No data is required

  /**
   * This function calculates all the values of the dice rolled and returns them.
   * diceType.length must be equal to diceAmount.length
   * An example of use of this function is as follows:
   * dicetype={6,8,10} and diceAmount= {1,3,2} the dis function rolls 1d6,3d8 and 2d10 and returns the the values of each
   * die in an ArrayList.
   * @param diceType that contains all the dice to roll. For example {6,8,10} in this case this function roll
   *                 d6,d8,d10 an amount of times wich must be specified in diceAmont variable
   * @param diceAmount that contains the amount of dice to be roll for each die in diceType variable
   * @return Returns an ArrayList<Integer> [], in each list [0] returns the add value for the roll and in the subsequent
   *         values returns the value of the individual roll. If the number of rolls for a die is 1 then the length of the
   *         list for that die is only 1 with the corresponding rolled value
   * @throws Exception In case that this function detects an error in the data input returns an exception with the
   *                   corresponding error message
   */
  public List<Integer>[] rollDie(int[] diceType, int[] diceAmount) throws Exception{
    checkDieDataEntry(diceType, diceAmount);
    List<Integer>[] ret = new List[diceType.length];
    for (int i =0;i<diceType.length;i++){
      die rollingDie = new die(diceType[i]);
      int sum = 0;
      List<Integer> l = new ArrayList<Integer>();
      for(int j = 0 ; j <diceAmount[i];j++){
        int value = rollingDie.roll();
        l.add(value);
        sum+=value;
      }
      if(diceAmount[i]>1) l.add(0,sum);
      ret[i] = l;
    }
    return ret;
  }

  /**
   * This function test that the input values to be rolled are ok
   * the only accepted die are d4,d6,d8,d10, d12 and d20
   * @param diceType that contains all the dice to roll. For example {6,8,10} in this case this function roll
   *    *             d6,d8,d10 an amount of times wich must be specified in diceAmont variable
   * @param diceAmount that contains the amount of dice to be roll for each die in diceType variable
   * @throws Exception In case that this function detects an error in the data input returns an exception with the
   *                   corresponding error message
   */
  private void checkDieDataEntry(int[] diceType, int[] diceAmount)throws Exception{
    if(diceType.length!=diceAmount.length) throw new Exception("Error: the amount of dice to roll must be equal to the length of diceType");
    int [] check ={4,6,8,10,12,20};
    for(int i =0;i<diceType.length;i++) {
      boolean contains = false;
      for(int j=0;j<check.length && !contains;j++){
        if(check[j]==diceType[i]) contains = true;
      }
      if (!contains) throw new Exception("dieType values must be 4,6,10,12 or 20");
    }
    //everything is ok!
  }

}
