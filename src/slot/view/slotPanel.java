package slot.view;

import slots.Controller.slotController;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.*;

public class slotPanel extends JPanel
{
	private SpringLayout baseLayout;
	private JLabel slot1;
	private JLabel slot2;
	private JLabel slot3;
	private JButton slotStart;
	private String lemon;
	private String seven;
	private String bar;
	private String bar2;
	private String bar3;
	private String jackpot;
	private String blank;
	private int slot1Number;
	private int slot2Number;
	private int slot3Number;
	
	private int slot1Value;
	private int slot2Value;
	private int slot3Value;
	
	private String slot1Pic;
	private String slot2Pic;
	private String slot3Pic;
	private long playerCoins;
	private JLabel totalCoins;
	private JLabel latestWinning;
	private int lastWin;
	private long prevCoins;
	private int prev;
	private JLabel prevJCoins;
	private long spinCount;
	
	
	
	
private slotController baseController;

	public slotPanel(slotController baseController)
	{
		this.baseController = baseController;
		
		slot1Pic = new String("blank.png");
		slot2Pic = new String("blank.png");
		slot3Pic = new String("blank.png");
		slot1Number = 3;
		slot2Number = 3;
		slot3Number = 3;
		
		
		spinCount = 0;
		playerCoins =25;
		prevCoins = playerCoins;
		prev = 0;
		
		
		totalCoins = new JLabel("Coins: "+playerCoins);
		prevJCoins = new JLabel(""+prevCoins);
		
		slot1Value = 0;
		slot2Value = 0;
		slot3Value = 0;
		lastWin = 0;
		latestWinning = new JLabel(""+lastWin);
		
		blank = new String("blank.png");
		jackpot = new String("jackpot.png");
		bar3 = new String("bar3.png");
		bar2 = new String("bar2.png");
		bar = new String("bar.png");
		lemon = new String("lemon.png");
		seven = new String("7.png");
	
		slotStart = new JButton("SPIN!");
		
		slot1 = new JLabel("");
		slot1.setIcon(new ImageIcon(slotPanel.class.getResource("/slot/view/images/"+slot1Pic)));
		
		slot2 = new JLabel("");
		slot2.setIcon(new ImageIcon(slotPanel.class.getResource("/slot/view/images/"+slot2Pic)));
		
		slot3= new JLabel("");
		slot3.setIcon(new ImageIcon(slotPanel.class.getResource("/slot/view/images/"+slot3Pic)));
		
		baseLayout = new SpringLayout();
	
		
		
		
		
		
		
		
		
		setupPanel();
		setupLayout();
		setupListeners();
		setupSlotOne();
		setupSlotTwo();
		setupSlotThree();
		setupPayOut();
		
		
	}
	
	private void setupPanel()
	{
		
		this.add(prevJCoins);
		this.add(latestWinning);
		this.add(totalCoins);
		this.add(slotStart);
		this.add(slot1);
		this.add(slot2);
		this.add(slot3);
		this.setLayout(baseLayout);
		this.setBackground(new Color(82,173,192));//original color is R:82 G:173 B:192
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, slot2, 0, SpringLayout.NORTH, slot1);
		baseLayout.putConstraint(SpringLayout.WEST, slot2, 0, SpringLayout.WEST, slotStart);
		baseLayout.putConstraint(SpringLayout.NORTH, slot1, 110, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, slot3, 110, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, slot1, 53, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, slot3, -91, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, slotStart, 166, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, slotStart, -48, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, totalCoins, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, totalCoins, 0, SpringLayout.EAST, slotStart);
		baseLayout.putConstraint(SpringLayout.NORTH, latestWinning, 26, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, latestWinning, 32, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, latestWinning, 187, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, prevJCoins, 0, SpringLayout.NORTH, totalCoins);
		baseLayout.putConstraint(SpringLayout.WEST, prevJCoins, 41, SpringLayout.WEST, this);
		
	}
	
	private void setupListeners()
	{
	     slotStart.addActionListener(new ActionListener()
	    		 {
	    	 public void actionPerformed(ActionEvent click)
	    	 {
	    		 
	    		 spinCount = spinCount+1;
	    		 prevCoins = playerCoins;
	    		 if(playerCoins<=0)
	    		 {
	    			 setupLoser();
	    		 }
	    		 playerCoins = playerCoins - 2;
	    		 prev = prev+1;
	    		 totalCoins.setText("Coins: "+playerCoins);
	    		slot1Number = (int) (Math.random()*129);
	    		slot2Number = (int) (Math.random()*129);
	    		slot3Number = (int) (Math.random()*129);
	    		if(prev ==2)
	    		{
	    			
	    			prevJCoins.setText(""+prevCoins);
	    			prev= prev -1;
	    		}
	    		
	    		
	    		
	    		
	    		
	    		setupSlotOne();
	    		setupSlotTwo();
	    		setupSlotThree();
	    		
	    		
	    		
	    	 }
	     });
				
					
	}
	
	private void setupSlotOne()
	{
		//lemon
		if(slot1Number == 1 || slot1Number == 2 || slot1Number == 42 || slot1Number == 43 || slot1Number == 63)
		{
			slot1Value =1;
			slot1Pic = lemon;
			slot1.setIcon(new ImageIcon(slotPanel.class.getResource("/slot/view/images/"+slot1Pic)));
			
		}
		//bar
		else if(slot1Number ==  8 || slot1Number == 9  || slot1Number == 10 || slot1Number == 11 || 
				slot1Number ==12 || slot1Number == 31 || slot1Number == 32 || slot1Number == 33 || 
				slot1Number == 34 || slot1Number == 35|| slot1Number == 82 || slot1Number == 83 || 
				slot1Number == 84 || slot1Number == 85|| slot1Number == 86 || slot1Number == 87   )
		{
			slot1Value =2;
			slot1Pic = bar;
			slot1.setIcon(new ImageIcon(slotPanel.class.getResource("/slot/view/images/"+slot1Pic)));
			
		}
		//bar2
		else if(slot1Number == 50 || slot1Number == 51 || slot1Number == 52 || slot1Number == 53 ||
				slot1Number == 54 || slot1Number == 55 || slot1Number == 56 || slot1Number == 70 ||
				slot1Number == 71 || slot1Number == 72 || slot1Number == 73 || slot1Number == 74 ||
				slot1Number == 75)
		{
			slot1Value=3;
			slot1Pic = bar2;
			slot1.setIcon(new ImageIcon(slotPanel.class.getResource("/slot/view/images/"+slot1Pic)));
		}
		//bar3
		else if(slot1Number ==94 || slot1Number==95 || slot1Number == 96 || slot1Number == 97 || slot1Number == 98
				|| slot1Number == 99 || slot1Number == 100 || slot1Number == 101 || slot1Number == 102 || 
				slot1Number == 103 || slot1Number == 104)
		{
			slot1Value=4;
			slot1Pic = bar3;
			slot1.setIcon(new ImageIcon(slotPanel.class.getResource("/slot/view/images/"+slot1Pic)));
		}
		//7
		else if(slot1Number == 18 || slot1Number == 19|slot1Number ==20||slot1Number ==21||slot1Number ==22
				||slot1Number ==23||slot1Number ==24||slot1Number ==25)
		{
			slot1Value = 5;
			slot1Pic = seven;
			slot1.setIcon(new ImageIcon(slotPanel.class.getResource("/slot/view/images/"+slot1Pic)));
		}
		//jackpot
		else if(slot1Number == 116||slot1Number==117)
		{
			slot1Value=6;
			slot1Pic = jackpot;
			slot1.setIcon(new ImageIcon(slotPanel.class.getResource("/slot/view/images/"+slot1Pic)));
		}
		//blank spaces
		else
		{
			slot1Value = 7;
			slot1Pic = blank;
			slot1.setIcon(new ImageIcon(slotPanel.class.getResource("/slot/view/images/"+slot1Pic)));
		}
		setupPayOut();
	}
	
	private void setupSlotTwo()
	{
		//lemon
		if(slot2Number == 1 || slot2Number == 2 || slot2Number == 42 || slot2Number == 43 || slot2Number == 63)
		{
			slot2Value=1;
			slot2Pic = lemon;
			
			slot2.setIcon(new ImageIcon(slotPanel.class.getResource("/slot/view/images/"+slot2Pic)));
		}
		//bar
		else if(slot2Number ==  8 || slot2Number == 9  || slot2Number == 10 || slot2Number == 11 || 
				slot2Number ==12 || slot2Number == 31 || slot2Number == 32 || slot2Number == 33 || 
				slot2Number == 34 || slot2Number == 35|| slot2Number == 82 || slot2Number == 83 || 
				slot2Number == 84 || slot2Number == 85|| slot2Number == 86 || slot2Number == 87   )
		{
			slot2Value=2;
			slot2Pic = bar;
			slot2.setIcon(new ImageIcon(slotPanel.class.getResource("/slot/view/images/"+slot2Pic)));
			
		}
		//bar2
		else if(slot2Number == 50 || slot2Number == 51 || slot2Number == 52 || slot2Number == 53 ||
				slot2Number == 54 || slot2Number == 55 || slot2Number == 56 || slot2Number == 70 ||
				slot2Number == 71 || slot2Number == 72 || slot2Number == 73 || slot2Number == 74 ||
				slot2Number == 75)
		{
			slot2Value=3;
			slot2Pic = bar2;
			slot2.setIcon(new ImageIcon(slotPanel.class.getResource("/slot/view/images/"+slot2Pic)));
		}
		//bar3
		else if(slot2Number ==94 || slot2Number==95 || slot2Number == 96 || slot2Number == 97 || slot2Number == 98
				|| slot2Number == 99 || slot2Number == 100 || slot2Number == 101 || slot2Number == 102 || 
				slot2Number == 103 || slot2Number == 104)
		{
			slot2Value=4;
			slot2Pic = bar3;
			slot2.setIcon(new ImageIcon(slotPanel.class.getResource("/slot/view/images/"+slot2Pic)));
		}
		//7
		else if(slot2Number == 18 || slot2Number == 19|slot2Number ==20||slot2Number ==21||slot2Number ==22
				||slot2Number ==23||slot2Number ==24||slot2Number ==25)
		{
			slot2Value=5;
			slot2Pic = seven;
			slot2.setIcon(new ImageIcon(slotPanel.class.getResource("/slot/view/images/"+slot2Pic)));
		}
		//jackpot
		else if(slot2Number == 116||slot2Number==117)
		{
			slot2Value=6;
			slot2Pic = jackpot;
			slot2.setIcon(new ImageIcon(slotPanel.class.getResource("/slot/view/images/"+slot2Pic)));
		}
		//blank spaces
		else
		{
			slot2Value=7;
			slot2Pic = blank;
			slot2.setIcon(new ImageIcon(slotPanel.class.getResource("/slot/view/images/"+slot2Pic)));
		}
		setupPayOut();
	}
	
	private void setupSlotThree()
	{
		//lemon
		if(slot3Number == 1 || slot3Number == 2 || slot3Number == 42 || slot3Number == 43 || slot3Number == 63)
		{
			slot3Value=1;
			slot3Pic = lemon;
			
			slot3.setIcon(new ImageIcon(slotPanel.class.getResource("/slot/view/images/"+slot3Pic)));
		}
		//bar
		else if(slot3Number ==  8 || slot3Number == 9  || slot3Number == 10 || slot3Number == 11 || 
				slot3Number ==12 || slot3Number == 31 || slot3Number == 32 || slot3Number == 33 || 
				slot3Number == 34 || slot3Number == 35|| slot3Number == 82 || slot3Number == 83 || 
				slot3Number == 84 || slot3Number == 85|| slot3Number == 86 || slot3Number == 87   )
		{
			slot3Value=2;
			slot3Pic = bar;
			slot3.setIcon(new ImageIcon(slotPanel.class.getResource("/slot/view/images/"+slot3Pic)));
			
		}
		//bar2
		else if(slot3Number == 50 || slot3Number == 51 || slot3Number == 52 || slot3Number == 53 ||
				slot3Number == 54 || slot3Number == 55 || slot3Number == 56 || slot3Number == 70 ||
				slot3Number == 71 || slot3Number == 72 || slot3Number == 73 || slot3Number == 74 ||
				slot3Number == 75)
		{
			slot3Value=3;
			slot3Pic = bar2;
			slot3.setIcon(new ImageIcon(slotPanel.class.getResource("/slot/view/images/"+slot3Pic)));
		}
		//bar3
		else if(slot3Number ==94 || slot3Number==95 || slot3Number == 96 || slot3Number == 97 || slot3Number == 98
				|| slot3Number == 99 || slot3Number == 100 || slot3Number == 101 || slot3Number == 102 || 
				slot3Number == 103 || slot3Number == 104)
		{
			slot3Value=4;
			slot3Pic = bar3;
			slot3.setIcon(new ImageIcon(slotPanel.class.getResource("/slot/view/images/"+slot3Pic)));
		}
		//7
		else if(slot3Number == 18 || slot3Number == 19|slot3Number ==20||slot3Number ==21||slot3Number ==22
				||slot3Number ==23||slot3Number ==24||slot3Number ==25)
		{
			slot3Value=5;
			slot3Pic = seven;
			slot3.setIcon(new ImageIcon(slotPanel.class.getResource("/slot/view/images/"+slot3Pic)));
		}
		//jackpot
		else if(slot3Number == 116||slot3Number==117)
		{
			slot3Value=6;
			slot3Pic = jackpot;
			slot3.setIcon(new ImageIcon(slotPanel.class.getResource("/slot/view/images/"+slot3Pic)));
		}
		//blank spaces
		else
		{
			slot3Value=7;
			slot3Pic = blank;
			slot3.setIcon(new ImageIcon(slotPanel.class.getResource("/slot/view/images/"+slot3Pic)));
		}
		setupPayOut();
	}

	
	private void setupPayOut()
	{
		//single lemon pay outs
		if(slot1Value == 1 && slot2Value !=1 && slot3Value !=1)
		{
			playerCoins = playerCoins +3;
			totalCoins.setText("Coins: "+playerCoins);
			lastWin= 3;
			latestWinning.setText(""+lastWin);
			
		}
		else if(slot1Value != 1 && slot2Value ==1 && slot3Value !=1)
		{
			playerCoins = playerCoins +3;
			totalCoins.setText("Coins: "+playerCoins);
			lastWin= 3;
			latestWinning.setText(""+lastWin);
			
		}
		else if(slot1Value != 1 && slot2Value !=1 && slot3Value ==1)
		{
			playerCoins = playerCoins +3;
			totalCoins.setText("Coins: "+playerCoins);
			lastWin= 3;
			latestWinning.setText(""+lastWin);
			
		}
		//double lemon pay out
		else if(slot1Value == 1 && slot2Value == 1 && slot3Value !=1)
		{
			playerCoins = playerCoins + 6;
			totalCoins.setText("Coins: "+playerCoins);
			lastWin= 6;
			latestWinning.setText(""+lastWin);
		}
			
		else if(slot1Value == 1 && slot2Value != 1 && slot3Value ==1)
		{
			playerCoins = playerCoins + 6;
			totalCoins.setText("Coins: "+playerCoins);
			lastWin= 6;
			latestWinning.setText(""+lastWin);
			
			
		}
		else if(slot1Value !=1 && slot2Value ==1 && slot3Value == 1)
		{
			playerCoins = playerCoins + 6;
			totalCoins.setText("Coins: "+playerCoins);
			lastWin= 6;
			latestWinning.setText(""+lastWin);
			
			
		}
		//3 lemons
		else if (slot1Value == 1 && slot2Value == 1 && slot3Value == 1)
		{
			playerCoins = playerCoins + 12;
			totalCoins.setText("Coins: "+playerCoins);
			lastWin= 12;
			latestWinning.setText(""+lastWin);
				
		}
		//any 3 bar
		else if(slot1Value ==2 && slot2Value ==2 && slot3Value== 3)
		{
			playerCoins = playerCoins + 12;
			totalCoins.setText("Coins: "+playerCoins);
			lastWin= 12;
			latestWinning.setText(""+lastWin);
		}
		else if(slot1Value == 2 && slot2Value == 2 && slot3Value ==4)
		{
			playerCoins = playerCoins + 12;
			totalCoins.setText("Coins: "+playerCoins);
			lastWin= 12;
			latestWinning.setText(""+lastWin);
		}
		else if(slot1Value==2 && slot2Value == 3 && slot3Value ==2 )
		{
			playerCoins = playerCoins + 12;
			totalCoins.setText("Coins: "+playerCoins);
			lastWin= 12;
			latestWinning.setText(""+lastWin);
		}
		else if (slot1Value == 2 && slot2Value == 4 && slot3Value == 2)
		{
			playerCoins = playerCoins +12;
			totalCoins.setText("Coins: "+playerCoins);
			lastWin= 12;
			latestWinning.setText(""+lastWin);
		}
		else if (slot1Value == 2 && slot2Value ==3 && slot3Value == 3)
		{
			playerCoins=playerCoins+12;
			totalCoins.setText("Coins: "+playerCoins);
			lastWin= 12;
			latestWinning.setText(""+lastWin);
		}
		else if(slot1Value ==2 && slot2Value ==4 && slot3Value == 4)
		{
			playerCoins=playerCoins+12;
			totalCoins.setText("Coins: "+playerCoins);
			lastWin= 12;
			latestWinning.setText(""+lastWin);
		}
		else if(slot1Value == 2 && slot2Value == 4 && slot3Value == 3)
		{
			playerCoins=playerCoins+12;
			totalCoins.setText("Coins: "+playerCoins);
			lastWin= 12;
			latestWinning.setText(""+lastWin);
		}
		else if(slot1Value == 2 && slot2Value == 3 && slot3Value == 4)
		{
			playerCoins=playerCoins+12;
			totalCoins.setText("Coins: "+playerCoins);
			lastWin= 12;
			latestWinning.setText(""+lastWin);
		}
		else if(slot1Value== 3 && slot2Value == 2 && slot3Value ==3)
		{
			playerCoins=playerCoins+12;
			totalCoins.setText("Coins: "+playerCoins);
			lastWin= 12;
			latestWinning.setText(""+lastWin);
		}
		else if(slot1Value==3 && slot2Value ==2 && slot3Value ==4)
		{
			playerCoins=playerCoins+12;
			totalCoins.setText("Coins: "+playerCoins);
			lastWin= 12;
			latestWinning.setText(""+lastWin);
		}
		else if(slot1Value == 3 && slot2Value == 3 && slot3Value==2)
		{
			playerCoins=playerCoins+12;
			totalCoins.setText("Coins: "+playerCoins);
			lastWin= 12;
			latestWinning.setText(""+lastWin);
		}
		else if(slot1Value == 3 && slot2Value == 4 && slot3Value == 2)
		{
			playerCoins=playerCoins+12;
			totalCoins.setText("Coins: "+playerCoins);
			lastWin= 12;
			latestWinning.setText(""+lastWin);
		}
		else if(slot1Value == 3 && slot2Value ==4 && slot3Value ==2)
		{
			playerCoins=playerCoins+12;
			totalCoins.setText("Coins: "+playerCoins);
			lastWin= 12;
			latestWinning.setText(""+lastWin);
		}
		else if(slot1Value==3 && slot2Value == 4 && slot3Value==4)
		{
			playerCoins=playerCoins+12;
			totalCoins.setText("Coins: "+playerCoins);
			lastWin= 12;
			latestWinning.setText(""+lastWin);
		}
		else if(slot1Value==3 && slot2Value==4 && slot3Value==3)
		{
			playerCoins=playerCoins+12;
			totalCoins.setText("Coins: "+playerCoins);
			lastWin= 12;
			latestWinning.setText(""+lastWin);
		}
		else if(slot1Value==3 && slot2Value ==3 &slot3Value==4)
		{
			playerCoins=playerCoins+12;
			totalCoins.setText("Coins: "+playerCoins);
			lastWin= 12;
			latestWinning.setText(""+lastWin);
		}
		else if(slot1Value == 3 && slot2Value ==2 && slot3Value == 2)
		{
			playerCoins=playerCoins+12;
			totalCoins.setText("Coins: "+playerCoins);
			lastWin= 12;
			latestWinning.setText(""+lastWin);	
		}
		else if(slot1Value ==4 && slot2Value== 2 && slot3Value ==3)
		{
			playerCoins=playerCoins+12;
			totalCoins.setText("Coins: "+playerCoins);
			lastWin= 12;
			latestWinning.setText(""+lastWin);
		}
		else if(slot1Value ==4 && slot2Value== 2 && slot3Value == 4)
		{
			playerCoins=playerCoins+12;
			totalCoins.setText("Coins: "+playerCoins);
			lastWin= 12;
			latestWinning.setText(""+lastWin);
		}
		else if(slot1Value == 4 && slot2Value == 3 && slot3Value==2)
		{
			playerCoins=playerCoins+12;
			totalCoins.setText("Coins: "+playerCoins);
			lastWin= 12;
			latestWinning.setText(""+lastWin);
		}
		else if(slot1Value ==4 && slot2Value== 4 && slot3Value==2)
		{
			playerCoins=playerCoins+12;
			totalCoins.setText("Coins: "+playerCoins);
			lastWin= 12;
			latestWinning.setText(""+lastWin);
		}
		else if(slot1Value==4 && slot2Value==3 && slot3Value==3)
		{
			playerCoins=playerCoins+12;
			totalCoins.setText("Coins: "+playerCoins);
			lastWin= 12;
			latestWinning.setText(""+lastWin);
		}
		else if(slot1Value == 4 && slot2Value ==4 &&slot3Value == 3)
		{
			playerCoins=playerCoins+12;
			totalCoins.setText("Coins: "+playerCoins);
			lastWin= 12;
			latestWinning.setText(""+lastWin);
		}
		else if(slot1Value == 4 && slot2Value ==3 && slot3Value ==4)
		{
			playerCoins=playerCoins+12;
			totalCoins.setText("Coins: "+playerCoins);
			lastWin= 12;
			latestWinning.setText(""+lastWin);
		}
		else if(slot1Value ==4 && slot2Value == 2 && slot3Value ==2)
		{
			playerCoins=playerCoins+12;
			totalCoins.setText("Coins: "+playerCoins);
			lastWin= 12;
			latestWinning.setText(""+lastWin);
		}
		//3  bars
		else if(slot1Value ==2 && slot2Value ==2 && slot3Value==2)
		{
			playerCoins=playerCoins+25;
			totalCoins.setText("Coins: "+playerCoins);
			lastWin= 25;
			latestWinning.setText(""+lastWin);
		}
		//3 2Bars
		else if(slot1Value==3 && slot2Value == 3 && slot3Value ==3)
		{
			playerCoins=playerCoins+50;
			totalCoins.setText("Coins: "+playerCoins);
			lastWin= 50;
			latestWinning.setText(""+lastWin);
		}
		//3 3bars
		else if(slot1Value == 4 && slot2Value == 4 && slot3Value== 4)
		{
			playerCoins=playerCoins+100;
			totalCoins.setText("Coins: "+playerCoins);
			lastWin= 100;
			latestWinning.setText(""+lastWin);
		}
		//3 sevens
		else if(slot1Value == 5 && slot2Value == 5 && slot3Value==5)
		{
			playerCoins=playerCoins+300;
			totalCoins.setText("Coins: "+playerCoins);
			lastWin= 300;
			latestWinning.setText(""+lastWin);
		}
		//Jackpot
		else if(slot1Value == 6 && slot2Value == 6 && slot3Value == 6)
		{
			playerCoins=playerCoins+1666;
			totalCoins.setText("Coins: "+playerCoins);
			lastWin= 1666;
			latestWinning.setText(""+lastWin);
		}
		
	}
	
	private void setupLoser()
	{
		this.setBackground(new Color(0,0,0));
		totalCoins.setVisible(false);
		slotStart.setVisible(false);
		totalCoins.setVisible(false);
		prevJCoins.setVisible(false);
		slot1.setVisible(false);
		slot3.setVisible(false);
		slot2.setIcon(new ImageIcon(slotPanel.class.getResource("/slot/view/images/lost.png")));
		latestWinning.setForeground (Color.white);
		latestWinning.setText("You spun "+spinCount+" times before you lost");
		
		
	}
	
	
}
