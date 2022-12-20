package Domain.Classes;
import Domain.Controllers.dieController;

import java.util.ArrayList;
import java.util.List;

public class system {

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
  public List<Integer>[] rollDie(int[] diceType, int[] diceAmount) throws Exception {
    return new dieController().rollDie(diceType, diceAmount);
  }

}
