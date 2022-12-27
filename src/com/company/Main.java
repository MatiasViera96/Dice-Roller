package com.company;

import Domain.Classes.system;
import Interface.DRTextInterface;
import Interface.DRInterface;


public class Main {

  public static void main(String[] args) {
    testDRWGUI();
  }

  public static void testDRWGUI() {
    system syst = new system();
    DRInterface GUInterface = new DRInterface(syst);
  }
}
