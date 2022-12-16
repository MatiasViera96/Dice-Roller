package Domain.Classes;
import Domain.Classes.die;

import java.util.ArrayList;

public class system {

  private void checkDieDataEntry(int[] diceType, int[] diceAmount)throws Exception{

    if(diceType.length!=diceAmount.length) throw new Exception("Error: the amount of dice to roll must be equal to the length of diceType");

    for(int i =0;i<diceType.length;i++) {
      if (diceType[i] <= 0 || diceAmount[i] <= 0) throw new Exception("All values must be greater than 0");
    }
    //everything is ok!
  }

  public ArrayList<Integer>[] rollDie(int[] diceType, int[] diceAmount) throws Exception{
    checkDieDataEntry(diceType,diceAmount);
    ArrayList<Integer>[] ret = new ArrayList[diceType.length];
    for (int i =0;i<diceType.length;i++){
      die rollingDie = new die(diceType[i]);
      int sum = 0;
      for(int j = 0 ; j <diceAmount[i];j++){
        int value = rollingDie.roll();
        ret[i].add(value);
        sum+=value;
      }
      if(diceAmount[i]>1) ret[i].add(sum);
    }
    return ret;
  }

}
