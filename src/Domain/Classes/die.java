package Domain.Classes;

import java.lang.Math;

public class die {

  private int dieValue;
  private final int dieSides;

  public die (int dieSides) throws Exception{
    if (dieSides < 0) throw new Exception ("Numer of sides in die must be > 0");
    this.dieSides = dieSides;
    this.roll();
  }

  public int getdieValue(){
    return this.dieValue;
  }

  public int getDieSides(){
    return this.dieSides;
  }

  public int roll (){
    this.dieValue = (int)(1+Math.random()*this.dieSides);
    return this.dieValue;
  }
}
