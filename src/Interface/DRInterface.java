package Interface;
import Domain.Classes.*;
import Domain.Controllers.dieController;

import javax.swing.*;

public class DRInterface {
  private JFrame jfMain = new JFrame("Dice Roller GUI interface");
  private JPanel JPMainPanel;
  private JButton jbtnNewDie;
  private JButton jbtnRoll;
  private JTable jtDiceRoller;

  public DRInterface(system s) {
    setInterface();
  }

  private void setInterface(){
    this.JPMainPanel.setEnabled(true);
    this.JPMainPanel.setVisible(true);
    this.jfMain.add(JPMainPanel);
    this.jfMain.setVisible(true);
    this.jfMain.setLocationRelativeTo(null);
    this.jfMain.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    this.jfMain.setEnabled(true);
    this.jfMain.setResizable(false);
    this.jfMain.setSize(400,400);
  }
}
