package com.company;

import Domain.Classes.system;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    system syst = new system();
    int [] dieType = {6,8,12};
    int [] dieAmount = {6,3,1};
    try{
      List<Integer>[] rolledValues = syst.rollDie(dieType,dieAmount);
      System.out.println("\nDice Rolled\n");
      for(int i =0; i<rolledValues.length; i++){
        System.out.print(dieAmount[i]+"d"+dieType[i] + " : "+rolledValues[i].get(0));
        if(rolledValues[i].size()>1) System.out.print(" (");
        for(int j = 1; j<rolledValues[i].size();j++){
          System.out.print(rolledValues[i].get(j));
          if (j!= rolledValues[i].size()-1) System.out.print(" + ");
        }
        if(rolledValues[i].size()>1) System.out.print(")");
        System.out.println("\n");
      }
    }catch (Exception e){
      System.out.println(e.getMessage());
    }
  }
}
