package com.tcg.json;

import java.awt.Color;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.json.JSONObject;

/*
 * Author: Josip Antony Jurina
 * SID: 216164785
 * SIT305
 * 
 * 
 * 
 */
public class Main {
	//variables
	
	JFrame window;
	Container con;
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel, loadButtonPanel, exitButtonPanel;
	JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
	JButton startButton, choice1, choice2, choice3, choice4, loadButton, exitButton;
	JTextArea mainTextArea;
	int playerHP, monsterHP, silverRing, cracked_Dagger, desertMonsterHP, mineMonsterHP, priestHP, demonKingHP, save;
	String weapon, position;
	
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceHandler choiceHandler = new ChoiceHandler();
	ExitHandler exitHandler = new ExitHandler();
	LoadHandler loadHandler = new LoadHandler(); 

	public static void main(String[] args) {
		
		//JSONObject obj = JSONUtils.getJSONObjectFromFile("/openfields.json");
		//String[] names = JSONObject.getNames(obj);

		new Main();
	}
	
	public Main(){
		
//******Creating the Main Menu Screen*************************************************************	
		window = new JFrame();
		window.setSize(800, 600);
		//window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
		window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		window.setVisible(true);
		con = window.getContentPane();
//************************************************************************************************	
		
//******Main Title********************************************************************************		
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 100, 600, 150);
		titleNamePanel.setBackground(Color.black);
		titleNameLabel = new JLabel("Eriekith");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);	
//************************************************************************************************	

//******Start Button******************************************************************************
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(100, 400, 200, 100);
		startButtonPanel.setBackground(Color.black);
		
		startButton = new JButton("START");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont);
		startButton.addActionListener(tsHandler);
		startButton.setFocusPainted(false);
//************************************************************************************************		
		
//******Load Button*******************************************************************************
		loadButtonPanel = new JPanel();
		loadButtonPanel.setBounds(300, 400, 200, 100);
		loadButtonPanel.setBackground(Color.black);
		
		loadButton = new JButton("LOAD");
		loadButton.setBackground(Color.black);
		loadButton.setForeground(Color.white);
		loadButton.setFont(normalFont);
		loadButton.addActionListener(loadHandler);
//************************************************************************************************		
		
//******Exit Button*******************************************************************************
		exitButtonPanel = new JPanel();
		exitButtonPanel.setBounds(500, 400, 200, 100);
		exitButtonPanel.setBackground(Color.black);
		
		exitButton = new JButton("EXIT");
		exitButton.setBackground(Color.black);
		exitButton.setForeground(Color.white);
		exitButton.setFont(normalFont);
		exitButton.addActionListener(exitHandler);
//************************************************************************************************
		
		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(startButton);
		loadButtonPanel.add(loadButton);
		exitButtonPanel.add(exitButton);
		
		con.add(titleNamePanel);
		con.add(startButtonPanel);
		con.add(loadButtonPanel);
		con.add(exitButtonPanel);
	}
	public void exitGame() {
		 	
		 window.dispose();
	}
	
	
//******New screen created when pressing the start button*****************************************
	public void createGameScreen(){
		
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		loadButtonPanel.setVisible(false);
		exitButtonPanel.setVisible(false);
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100, 100, 600, 250);
		mainTextPanel.setBackground(Color.black);
		con.add(mainTextPanel);
		
		mainTextArea = new JTextArea("");
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextPanel.add(mainTextArea);  
		
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(250, 350, 300, 150);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(4,1));
		con.add(choiceButtonPanel);
		
		choice1 = new JButton("Choice 1");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(normalFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(choiceHandler);
		choice1.setActionCommand("c1");
		choiceButtonPanel.add(choice1);
		choice2 = new JButton("Choice 2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(normalFont);
		choice2.setFocusPainted(false);
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);
		choice3 = new JButton("Choice 3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(normalFont);
		choice3.setFocusPainted(false);
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);
		choice4 = new JButton("Choice 4");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(normalFont);
		choice4.setFocusPainted(false);
		choice4.addActionListener(choiceHandler);
		choice4.setActionCommand("c4");
		choiceButtonPanel.add(choice4);
		
		playerPanel = new JPanel();
		playerPanel.setBounds(100, 15, 600, 50);
		playerPanel.setBackground(Color.black);
		playerPanel.setLayout(new GridLayout(1,4));
		con.add(playerPanel);
		hpLabel = new JLabel("HP:");
		hpLabel.setFont(normalFont);
		hpLabel.setForeground(Color.white);
		playerPanel.add(hpLabel);
		hpLabelNumber = new JLabel();
		hpLabelNumber.setFont(normalFont);
		hpLabelNumber.setForeground(Color.white);
		playerPanel.add(hpLabelNumber);
		weaponLabel = new JLabel("Weapon:");
		weaponLabel.setFont(normalFont);
		weaponLabel.setForeground(Color.white);
		playerPanel.add(weaponLabel);
		weaponLabelName = new JLabel();
		weaponLabelName.setFont(normalFont);
		weaponLabelName.setForeground(Color.white);
		playerPanel.add(weaponLabelName);
		
		playerSetup();
		
//************************************************************************************************
	}
	public void loadgame() {
		createGameScreen();
	}
	
	//*********************************************PLAYER SETUP*********************************************//
	public void playerSetup(){
		playerHP = 20;
		monsterHP = 20;
		desertMonsterHP = 50;
		mineMonsterHP = 70;
		priestHP = 90;
		demonKingHP = 150;
		weapon = "Knife";
		weaponLabelName.setText(weapon);
		hpLabelNumber.setText("" + playerHP);
		
		townGate();
	}
	
	//******************************************************************************************************//
	//*********************************************FIGHT SCENE*********************************************//
	public void fight(){
		position = "fight";
		mainTextArea.setText("Monster HP: " + monsterHP + "\n\nWhat do you do?");
		choice1.setText("Attack");
		choice2.setText("Run");
		choice3.setText("");
		choice4.setText("");
	}
	public void desertfight(){
		position = "desertfight";
		mainTextArea.setText("Monster HP: " + desertMonsterHP + "\n\nWhat do you do?");
		choice1.setText("Attack");
		choice2.setText("Run");
		choice3.setText("");
		choice4.setText("");
	}
	public void minesfight(){
		position = "minesfight";
		mainTextArea.setText("Monster HP: " + mineMonsterHP + "\n\nWhat do you do?");
		choice1.setText("Attack");
		choice2.setText("Run");
		choice3.setText("");
		choice4.setText("");
	}
	public void priestfight(){
		position = "priestfight";
		mainTextArea.setText("Monster HP: " + priestHP + "\n\nWhat do you do?");
		choice1.setText("Attack");
		choice2.setText("Run");
		choice3.setText("");
		choice4.setText("");
	}
	public void demonkingfight(){
		position = "demonkingfight";
		mainTextArea.setText("Monster HP: " + demonKingHP + "\n\nWhat do you do?");
		choice1.setText("Attack");
		choice2.setText("Run");
		choice3.setText("");
		choice4.setText("");
	}
	//******************************************************************************************************//
	//*********************************************PLAYERS ATTACK*********************************************//
	public void playerAttack(){
		position = "playerAttack";
		
		int playerDamage = 0;
		
		if(weapon.equals("Knife")){
			playerDamage = new java.util.Random().nextInt(3);
		}
		else if(weapon.equals("Long Sword")){
			playerDamage = new java.util.Random().nextInt(15); 
		}
		
		mainTextArea.setText("You attacked the Goblin and did " + playerDamage + " damage!");
		
		monsterHP = monsterHP - playerDamage;
		
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");		
	}
	public void desertplayerAttack(){
		position = "desertplayerAttack";
		
		int dplayerDamage = 7;
		
		if(weapon.equals("Knife")){
			dplayerDamage = new java.util.Random().nextInt(3);
		}
		else if(weapon.equals("Long Sword")){
			dplayerDamage = new java.util.Random().nextInt(15); 
		}
		
		mainTextArea.setText("You attacked the Giant Sand Worm and did " + dplayerDamage + " damage!");
		
		desertMonsterHP = desertMonsterHP - dplayerDamage;
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");		
	}
	public void mineplayerAttack(){
		position = "mineplayerAttack";
		
		int mplayerDamage = 13;
		
		if(weapon.equals("Knife")){
			mplayerDamage = new java.util.Random().nextInt(3);
		}
		else if(weapon.equals("Long Sword")){
			mplayerDamage = new java.util.Random().nextInt(15); 
		}
		
		mainTextArea.setText("You attacked the Troll and did " + mplayerDamage + " damage!");
		
		mineMonsterHP = mineMonsterHP - mplayerDamage;
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");		
	}
	public void priestplayerAttack(){
		position = "priestplayerAttack";
		
		int pplayerDamage = 17;
		
		
		if(weapon.equals("Knife")){
			pplayerDamage = new java.util.Random().nextInt(3);
		}
		else if(weapon.equals("Long Sword")){
			pplayerDamage = new java.util.Random().nextInt(15); 
		}
		else if(weapon.equals("Great Sword")){
			pplayerDamage = new java.util.Random().nextInt(25); 
		}
		
		mainTextArea.setText("You attacked the Wicked Priest and did " + pplayerDamage + " damage!");
		
		priestHP = priestHP - pplayerDamage;
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");		
	}
	public void demonkingplayerAttack(){
		position = "demonkingplayerAttack";
		
		int dkplayerDamage = 35;
		
		
		if(weapon.equals("Knife")){
			dkplayerDamage = new java.util.Random().nextInt(3);
		}
		else if(weapon.equals("Long Sword")){
			dkplayerDamage = new java.util.Random().nextInt(12); 
		}
		else if(weapon.equals("Great Sword")){
			dkplayerDamage = new java.util.Random().nextInt(25); 
		}
		else if(weapon.equals("Sacred Dagger")){
			dkplayerDamage = new java.util.Random().nextInt(50); 
		}
		
		mainTextArea.setText("You attacked the Demon King and did " + dkplayerDamage + " damage!");
		
		demonKingHP = demonKingHP - dkplayerDamage;
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");		
	}
	//******************************************************************************************************//
	//*********************************************MONSTERS ATTACK*********************************************//
	public void monsterAttack(){
		position = "monsterAttack";
		
		int monsterDamage = 0;
		
		monsterDamage = new java.util.Random().nextInt(6); 
		
		mainTextArea.setText("The Golbin attacked you and did " + monsterDamage + " damage!");
		
		playerHP = playerHP - monsterDamage;
		hpLabelNumber.setText(""+playerHP);
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");	
	}
	public void desertmonsterAttack(){
		position = "desertmonsterAttack";
		
		int dmonsterDamage = 0;
		
		dmonsterDamage = new java.util.Random().nextInt(9); 
		
		mainTextArea.setText("The Giant Sand Worm attacked you and did " + dmonsterDamage + " damage!");
		
		playerHP = playerHP - dmonsterDamage;
		hpLabelNumber.setText(""+playerHP);
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");	
	}
	public void minemonsterAttack(){
		position = "minemonsterAttack";
		
		int mmonsterDamage = 0;
		
		mmonsterDamage = new java.util.Random().nextInt(10); 
		
		mainTextArea.setText("The Troll attacked you and did " + mmonsterDamage + " damage!");
		
		playerHP = playerHP - mmonsterDamage;
		hpLabelNumber.setText(""+playerHP);
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");	
	}
	public void priestmonsterAttack(){
		position = "priestmonsterAttack";
		
		int pmonsterDamage = 0;
		
		pmonsterDamage = new java.util.Random().nextInt(15); 
		
		mainTextArea.setText("The Wicked Priest attacked you and did " + pmonsterDamage + " damage!");
		
		playerHP = playerHP - pmonsterDamage;
		hpLabelNumber.setText(""+playerHP);
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");	
	}
	public void demonkingmonsterAttack(){
		position = "demonkingmonsterAttack";
		
		int dkmonsterDamage = 0;
		
		
		if(weapon.equals("Knife")){
			dkmonsterDamage = new java.util.Random().nextInt(100); 
		}
		else if(weapon.equals("Long Sword")){
			dkmonsterDamage = new java.util.Random().nextInt(100); 
		}
		else if(weapon.equals("Great Sword")){
			dkmonsterDamage = new java.util.Random().nextInt(100); 
		}
		else if(weapon.equals("Sacred Dagger")){
			dkmonsterDamage = new java.util.Random().nextInt(35); 
		}
		
		
		
		mainTextArea.setText("The Demon King attacked you and did " + dkmonsterDamage + " damage!");
		
		playerHP = playerHP - dkmonsterDamage;
		hpLabelNumber.setText(""+playerHP);
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");	
	}
	//******************************************************************************************************//
	//*********************************************WIN SCENE*********************************************//
	public void demonkingwin() {
		position = "demonkingwin";
		mainTextArea.setText("All monsters who once terrorized this world are now in fear as the Demon King is Dead\n"
				+ "Thank you for playing my game this is the end.");
		
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
		
	}
	public void priestwin(){
		position = "priestwin";
		mainTextArea.setText("You defeated the Priest! \n The Priest dropped the last piece of the dagger!\n Your silver ring start glowing"
				+ "and then combining the pieces into to make the sacred dagger \n(You obtained a Sacred Dagger");
		
		cracked_Dagger = 4;
		weapon = "Sacred Dagger";
		weaponLabelName.setText(weapon);
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
	public void trollwin(){
		position = "trollwin";
		mainTextArea.setText("You defeated the Troll! \n The Troll dropped Great Sword!\n\n(You obtained a Great Sword)");
		weapon = "Great Sword";
		weaponLabelName.setText(weapon);
		choice1.setText("Go South");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
	public void desertwin(){
		position = "desertwin";
		
		mainTextArea.setText("You defeated the monster!\nThe monster dropped a cracked piece of dagger !\n(You obtained a cracked piece of dagger)\n\n"
				+ "(I now have two pieces, I should go tell the guard, maybe he will let me in\n and see if someone can help me with my memory!!");
		
		cracked_Dagger = 2;
		
		choice1.setText("Go South");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
	public void win(){
		position = "win";
		
		mainTextArea.setText("You defeated the Goblin!\nThe Globin dropped a ring!\n\n(You obtained a Silver Ring)");
		
		silverRing = 1;
		
		choice1.setText("Go east");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
	//******************************************************************************************************//
	//*********************************************DEATH SCENE*********************************************//
	public void lose(){
		position = "lose";
		
		mainTextArea.setText("You are dead!\n\n");
		
		choice1.setText("Retry");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
		
	}
	public void minesPriestlose(){
		position = "minesPriestlose";
		
		mainTextArea.setText("The Priest had the last piece of the dagger!\n He turn into the Demon King and killed you\n\n YOU ARE DEAD");
		
		choice1.setText("Retry");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
		playerHP = 15;
		monsterHP = 20;
		desertMonsterHP = 70;
		weapon = "Knife";
		weaponLabelName.setText(weapon);
		hpLabelNumber.setText("" + playerHP);
		
		
		
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	public void DKlose(){
		position = "DKlose";
		
		mainTextArea.setText(" You are dead!\n The Demon King takes the dagger away a rules the world!\n\n");
		
		choice1.setText("Retry");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
		
	}
	//******************************************************************************************************//
		//*********************************************CHAPTER ONE *********************************************//
		public void townGate(){
			position = "townGate";
			mainTextArea.setText("You are at the gate of the town. \nA guard is standing in front of you. \n\nWhat do you do?");		
			choice1.setText("Talk to the guard");
			choice2.setText("Attack the guard");
			choice3.setText("Leave"); 
			choice4.setText("");
		}
		//******************************************************************************************************//
		//*********************************************CHAPTER ONE *********************************************//
		public void talkGuard(){
			position = "talkGuard";
			mainTextArea.setText("Guard: Hello stranger. I have never seen your face. \nI'm sorry but we cannot let a stranger enter our town.");
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		//******************************************************************************************************//
		//*********************************************CHAPTER ONE *********************************************//
		public void attackGuard(){
			position = "attackGuard";
			mainTextArea.setText("Guard: Hey don't be stupid!\n\nThe guard fought back and hit you hard.\n(You receive 3 damage)");
			playerHP = playerHP -3;
			hpLabelNumber.setText(""+playerHP);
			choice1.setText(">");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
		}
		//******************************************************************************************************//
		//*********************************************CHAPTER ONE *********************************************//
		public void crossRoad(){
			position = "crossRoad";
			mainTextArea.setText("You are at a crossroad.\nIf you go south, you will go back to the town.");
			choice1.setText("Go north");
			choice2.setText("Go east");
			choice3.setText("Go south");
			choice4.setText("Go west");
		}
		//******************************************************************************************************//
		//*********************************************CHAPTER ONE *********************************************//
		public void north(){
			position = "north";
			mainTextArea.setText("There is a river. \nYou drink the water and rest at the riverside. \n\n(Your HP is recovered by 2)");
			playerHP = playerHP + 2;
			hpLabelNumber.setText(""+playerHP);
			choice1.setText("Go south");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");		
		}
		//******************************************************************************************************//
		//*********************************************CHAPTER ONE *********************************************//
		public void east(){
			position = "east";
			mainTextArea.setText("You walked into a forest and found a Long Sword!\n\n(You obtained a Long Sword)");
			weapon = "Long Sword";
			weaponLabelName.setText(weapon);
			choice1.setText("Go west");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
			
		}
		//******************************************************************************************************//
		//*********************************************CHAPTER ONE *********************************************//
		public void west(){
			position = "west";
			mainTextArea.setText("You encounter a goblin!");
			choice1.setText("Fight");
			choice2.setText("Run");
			choice3.setText("");
			choice4.setText("");
		}
	//******************************************************************************************************//
	//*********************************************CHAPTER ONE*********************************************//
	public void entertown(){
		position = "entertown";
		
		mainTextArea.setText("Guard: Oh you killed that goblin!?\nThank you so much. You are true hero!\nWelcome to our town!\n\n");
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
	//******************************************************************************************************//
	//*********************************************CHAPTER ONE *********************************************//
	public void firsttown() {
		position = "firsttown";
		
		mainTextArea.setText("Guard: The priest was the owner of that silver ring. \n Return it to him and he will reward you\n The priest will be "
				+ "inside the church just follow the signs and you will find it.");
		
		choice1.setText("Go to Church");
		choice2.setText("Go to inn");
		choice3.setText("Leave");
		choice4.setText("");
		
		
	}
	//******************************************************************************************************//
	//*********************************************CHAPTER ONE *********************************************//
	public void inn() {
		position = "inn";
		
		mainTextArea.setText("You enter the inn. \nYou rest at the inn. \n\n(Your HP is recovered by 5)\n\n ");
		playerHP = playerHP + 5;
		hpLabelNumber.setText(""+playerHP);
		save = 1;
		
		choice1.setText("Leave");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void church() {
		position = "church";
		mainTextArea.setText("Priest: Hello there warrior how can I help you?");
		
		choice1.setText("Talk to Priest");
		choice2.setText("Leave");
		choice3.setText("");
		choice4.setText("");
		
	}
	//******************************************************************************************************//
	//*********************************************CHAPTER ONE *********************************************//
	public void talkpriest() {
	    position = "talkpriest";
	    
	    mainTextArea.setText("Priest: Ohhh you have my silver ring, you were the one who defeated that goblin, keep it, it may give you goodluck\n"
	    		+ "Here is your reward also (You have obtained a piece of a cracked dagger)\n Find the other 3 pieces");
	   
	    cracked_Dagger = 1;
	    
	    choice1.setText("Quest");
		choice2.setText("Leave");
		choice3.setText("");
		choice4.setText("");
	}
	//******************************************************************************************************//
	//*********************************************CHAPTER ONE**********************************************//
	public void firstquest() {
		position = "firstquest";
		mainTextArea.setText("Priest: If you accepted this quest I will send you to the next area\n Where you will begin your journy to find the other pieces\n\n"
				+ "(Do you accepted?)");
		
		choice1.setText("Yes");
		choice2.setText("No");
		choice3.setText("");
		choice4.setText("");
	}
	//******************************************************************************************************//
	//*********************************************CHAPTER TWO**********************************************//
    public void deserttowngate() {
    	position = "deserttowngate";
    	mainTextArea.setText("You wake up only to be lieing on sand.\nYou are at the gate of a castle. \nA guard is standing in front of you. \n (Wait... Wait...)\n (Doesn't this feel familiar) "
    			+ "\n Your memomry seems blank, only remembering to find the sacred dagger\n\n ( What do you do?)");		
		choice1.setText("Talk to the guard");
		choice2.setText("Attack the guard");
		choice3.setText("Leave"); 
		choice4.setText("");
    }
    //******************************************************************************************************//
    //*********************************************CHAPTER TWO**********************************************//
    public void deserttalkGuard(){
		position = "deserttalkGuard";
		mainTextArea.setText("Guard: Hello stranger. I have never seen your face. \nI'm sorry but we cannot let a stranger enter this castle.\n\n "
				+ "(I swear this all seems famaliar)");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
    //******************************************************************************************************//
    //*********************************************CHAPTER TWO**********************************************//
    public void desertattackGuard(){
		position = "desertattackGuard";
		mainTextArea.setText("Guard: Hey don't be stupid!\n\nThe guard fought back and as soon as he was about to hit you dodged his punch.\n(You were "
				+ "surprised but you also decided to flee)");
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
    //******************************************************************************************************//
    //*********************************************CHAPTER TWO**********************************************//
    public void desertcrossRoad(){
		position = "desertcrossRoad";
		mainTextArea.setText("You look up into the sun, your shoes filled with sand this desert sure is hot. \nYou are at a crossroad.\nIf you go south, you will go back to the castle.");
		choice1.setText("Go north");
		choice2.setText("Go east");
		choice3.setText("Go south");
		choice4.setText("Go west");
	}
    //******************************************************************************************************//
    //*********************************************CHAPTER TWO**********************************************//
    public void desertnorth(){
		position = "desertnorth";
		mainTextArea.setText("You walked into the sandstorm and out from the ground you encounter a Sand Worm!");
		
		choice1.setText("Fight");
		choice2.setText("Run");
		choice3.setText("");
		choice4.setText("");		
	}
	//******************************************************************************************************//
	//*********************************************CHAPTER TWO**********************************************//
	public void deserteast(){
		position = "deserteast";
		mainTextArea.setText("Starting to feel thirsty you spot a large palm tree surrounded by a small lake. \nYou drink the water and rest under the tree. \n\n(Your HP is recovered by 5)");
		playerHP = playerHP + 5;
		hpLabelNumber.setText(""+playerHP);
		choice1.setText("Go west");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
	//******************************************************************************************************//
	//*********************************************CHAPTER TWO**********************************************//
	public void desertwest(){
		position = "desertwest";
		
		mainTextArea.setText("Walking west you spot a cave.\n You enter the cave \nInside the cave you spot a skeleton and a note beside him");
		
		choice1.setText("Read Note");
		choice2.setText("Go East");
		choice3.setText("");
		choice4.setText("");
	}
	//******************************************************************************************************//
	//*********************************************CHAPTER TWO**********************************************//
	public void desertnote() {
		position = "desertnote";
		
		mainTextArea.setText(" The Sand worms are very strong, 3 times the average health pool. \n Anyone who reads this be prepare not like myself "
				+ "who will die alone in this cave. ");
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
	//******************************************************************************************************//
	//*********************************************CHAPTER TWO**********************************************//
	public void desertentercastle(){
		position = "desertentercastle";
		
		mainTextArea.setText("Guard: Oh you stoped those giant sand worms!?\nThank you so much. You are true hero!\nWelcome to our castle!\n\n");
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
	//******************************************************************************************************//
	//*********************************************CHAPTER TWO**********************************************//
	public void desertcastle() {
		position = "desertcastle";
		
		mainTextArea.setText("Guard: There is a church nearby which the priest requests a meet with the one who defeats the Sand worms\n There is also a inn "
				+ "nearby to if you want to rest\n You arn't allowed any further as only residents are allowed elsewhere.");
		
		choice1.setText("Go to Church");
		choice2.setText("Go to inn");
		choice3.setText("Leave");
		choice4.setText("");
		
		
	}
	//******************************************************************************************************//
	//*********************************************CHAPTER TWO**********************************************//
	public void castleinn() {
		position = "castleinn";
		
		mainTextArea.setText("You enter the inn. \nYou rest at the inn. \n\n(Your HP is recovered by 5)\n\n ");
		playerHP = playerHP + 5;
		hpLabelNumber.setText(""+playerHP);
		save++;
		
		choice1.setText("Leave");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	//******************************************************************************************************//
	//*********************************************CHAPTER TWO**********************************************//
	public void castlechurch() {
		position = "castlechurch";
		mainTextArea.setText("Priest: Hello there warrior, I see you've gotten the next piece.\n Lets talk.");
		
		choice1.setText("Talk to Priest");
		choice2.setText("Leave");
		choice3.setText("");
		choice4.setText("");
		
	}
	//******************************************************************************************************//
	//*********************************************CHAPTER TWO**********************************************//
	public void castletalktopriest() {
		position = "castletalktopriest";
		mainTextArea.setText("Priest: Find the last two pieces of the dagger and your memory will be back.\n Yes I know that you lost your memory\n"
				+ "(Is this guy foreal?)\n Priest: I have open up a portal to the next location.");
		
		choice1.setText("Portal");
		choice2.setText("Dagger");
		choice3.setText("Leave");
		choice4.setText("");
	}
	//******************************************************************************************************//
	//*********************************************CHAPTER TWO**********************************************//
	public void talkdagger() {
		position = "talkdagger";
		mainTextArea.setText("Priest: oohhhh you want to know more about the dagger??\n The Dagger is a weapon forge by god himself, the only weapon which "
				+ "can kill the Demon King, who is the reason for all these foul beasts. \n Even the ones you have slained.");
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	//******************************************************************************************************//
	//*********************************************CHAPTER THREE**********************************************//
	public void portal() {
		position = "portal";
		mainTextArea.setText("As I enter the portal, my memory seems be to going blank once again but before it does.\n (A Bright Light Shines and tells"
				+ "me do not trust the priest) ");
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	//******************************************************************************************************//
	//*********************************************CHAPTER THREE**********************************************//
	public void confused() {
		position = "confused";
		mainTextArea.setText("I wake up, confused, who was that talking to me and my memory it didnt disapear. \n (Don't trust the priest, what could that"
				+ "mean ? hmmmm) ");
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	//******************************************************************************************************//
	//*********************************************CHAPTER THREE**********************************************//
	public void crossroadmines() {
		position = "crossroadmines";
		mainTextArea.setText("It seems I am in some kind of Tunnel Mine and appear to be in the center of a crossroad.\n There are signs saying each direction"
				+ "which one shall I go?");
		
		choice1.setText("North");
		choice2.setText("East");
		choice3.setText("South");
		choice4.setText("West");
	}
	//******************************************************************************************************//
	//*********************************************CHAPTER THREE**********************************************//
	public void minesnorth(){
		position = "minesnorth";
		mainTextArea.setText("You walked north through the tunnel and end up at a dead end only to spot something shiny on the ground.\n"
				+ "(You have picked up a piece of the cracked dagger)\n (Ohh that was easy you think to yourself)\n Only then to encounter a Troll");
		
		cracked_Dagger = 3;
		
		choice1.setText("Fight");
		choice2.setText("Run");
		choice3.setText("");
		choice4.setText("");		
	}
	//******************************************************************************************************//
	//*********************************************CHAPTER THREE**********************************************//
	public void mineseast(){
		position = "mineseast";
		mainTextArea.setText("Heading east throught the tunnel you see a small abandom workers shack, you decide this could be a good place to rest. "
				+ "\n You take a nap for an hour.\n\n(Your HP is recovered by 5)");
		playerHP = playerHP + 5;
		hpLabelNumber.setText(""+playerHP);
		choice1.setText("Go west");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
	//******************************************************************************************************//
	//*********************************************CHAPTER THREE**********************************************//
	public void mineswest(){
		position = "mineswest";
		
		mainTextArea.setText("Walking west through the tunnels you seem to meet a dead end.\n (What do I do now? Guese I'll go back)");
		
		choice1.setText("Go East");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	//******************************************************************************************************//
	//*********************************************CHAPTER THREE**********************************************//
	public void minessouth(){
		position = "minessouth";
		
		mainTextArea.setText("Walking west through the tunnels you see the priest standing at what looks to be the exit");
		
		choice1.setText("Talk to Priest");
		choice2.setText("Go South");
		choice3.setText("");
		choice4.setText("");
	}
	//******************************************************************************************************//
	//*********************************************CHAPTER THREE**********************************************//
	public void exitpriest() {
		position = "exitpriest";
		mainTextArea.setText("Priest: Did you find the thrid piece of the dagger ?? Give it to me!!");
		
		choice1.setText("OK");
		choice2.setText("NO");
		choice3.setText("Leave");
		choice4.setText("");
	}
	//******************************************************************************************************//
	//*********************************************CHAPTER THREE**********************************************//
	public void fightpriest() {
		position = "fightpriest";
		mainTextArea.setText("Priest: WHAT DO YOU MEAN NO!!! GIVE IT TO ME NOW\n I WILL JUST HAVE TO TAKE IT BY FORCE!!\n You encounter the true side of the priest");
		
		
		choice1.setText("Fight");
		choice2.setText("Run");
		choice3.setText("");
		choice4.setText("");	
	}
	//******************************************************************************************************//
	//*********************************************CHAPTER THREE**********************************************//
	public void demonking() {
		position = "demonking";
		mainTextArea.setText("As soon as you thought it was over the Demon King jumps out of the priest body like it was a suit of armor. \n"
				+ "Demon King: YOU WILL FACE MY WRATH!!");
		
		
		choice1.setText("Fight");
		choice2.setText("Run");
		choice3.setText("");
		choice4.setText("");	
	}
	//******************************************************************************************************//
	//*********************************************CHAPTER THREE**********************************************//
	public void dkrun() {
		position = "dkrun";
		mainTextArea.setText("Demon King: YOU THOUGHT YOU COULD RUN AWAY NONSENSE PREPARE TO DIE!!!");
		
		
		choice1.setText("Fight");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	//******************************************************************************************************//
	//*********************************************EVENT LISTNER**********************************************//
	// Code here below is what's giving the buttons a function
	
	public class ExitHandler implements ActionListener{

		public void actionPerformed(ActionEvent event) {
			
			exitGame();
		}
		
	}
	public class LoadHandler implements ActionListener{

		public void actionPerformed(ActionEvent event) {
			
			loadgame();
		}
		
	}
		
	public class TitleScreenHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			
			createGameScreen();
			
		}
	}

	
	public class ChoiceHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			
			String yourChoice = event.getActionCommand();
//*********************************************CHAPTER ONE *********************************************//			
			switch(position){
			case "townGate":
				switch(yourChoice){
				case "c1": 
					if(silverRing==1){ //need the silver ring in order to get into the town
						entertown();
												
					}
					else{
						talkGuard();
					}
					break;
				case "c2": attackGuard();break;
				case "c3": crossRoad();break;
				}
				break;
			case "talkGuard":
				switch(yourChoice){
				case "c1": townGate(); break;
				}
				break;
			case "attackGuard":
				switch(yourChoice){
				case "c1": townGate(); break;
				}
				break;
			case "crossRoad":
				switch(yourChoice){
				case "c1": north(); break;
				case "c2": east();break;
				case "c3": townGate(); break;
				case "c4": west();break;
				}
				break;
			case "north":
				switch(yourChoice){
				case "c1": crossRoad(); break;
				}
				break;
			case "east":
				switch(yourChoice){
				case "c1": crossRoad(); break;
				}
				break;
			case "west":
				switch(yourChoice){
				case "c1": fight(); break;
				case "c2": crossRoad(); break;
				}
				break;
			case "fight":
				switch(yourChoice){
				case "c1": playerAttack();break;
				case "c2": crossRoad(); break;
				}
				break;
			case "playerAttack":
				switch(yourChoice){
				case "c1": 
					if(monsterHP<1){
						win();
					}
					else{
						monsterAttack();
					}
					break;
				}
				break;
			case "monsterAttack":
				switch(yourChoice){
				case "c1": 
					if(playerHP<1){
						lose();
					}
					else{
						fight();
					}
					break;
				}
				break;
			case "win":
				switch(yourChoice){
				case "c1": crossRoad();
				}
				break;
			case "lose":
				switch(yourChoice){
				case "c1": playerSetup();;
				}
				break;
			case "entertown" : 
				switch(yourChoice) {
				case "c1": firsttown(); break;
				}
				break;
			case "firsttown" :
				switch(yourChoice) {
				case "c1" : church(); break;
				case "c2" : inn(); break;
				}
				break;
			case "church" : 
				switch(yourChoice) {
				case "c1" : talkpriest();break;
				case "c2" : firsttown();break;
				}
				break;
			case "inn" : 
				switch(yourChoice) {
				case "c1" : firsttown(); break;
				}						
				break;
			case "talkpriest" :
				switch(yourChoice) {
				case "c1" : firstquest(); break;
				case "c2" : firsttown(); break;
				}
				break;
			case "firstquest" :
				switch(yourChoice) {
				case "c1" : deserttowngate(); break;
				case "c2" : firsttown(); break;
				}
				break;
//*********************************************CHAPTER ONE ENDS*********************************************//				
//*********************************************CHAPTER TWO*********************************************//
			case "deserttowngate" :
				switch(yourChoice) {
				case "c1" : 
					if(cracked_Dagger==2){ // need two pieces of cracked dagger in order to progress
						desertentercastle();
												
					}
					else{
						deserttalkGuard();
					}
					break;
				case "c2" : desertattackGuard(); break;
				case "c3" : desertcrossRoad(); break;
				}
				break;
			case "deserttalkGuard" :
				switch(yourChoice) {
				case "c1" : deserttowngate(); break;
				}
				break;
			case "desertattackGuard" :
				switch(yourChoice) {
				case "c1" : desertcrossRoad(); break;
				}
				break;
			case "desertcrossRoad" :
				switch(yourChoice) {
				case "c1" : desertnorth(); break;
				case "c2" : deserteast(); break;
				case "c3" : deserttowngate(); break;
				case "c4" : desertwest(); break;
				}
				break;
			case "desertwest" :
				switch(yourChoice) {
				case "c1" : desertnote(); break;
				case "c2" : desertcrossRoad(); break;
				}
				break;
			case "deserteast" :
				switch(yourChoice) {
				case "c1" : desertcrossRoad(); break;
				}
				break;
			case "desertnote" :
				switch(yourChoice ) {
				case "c1" : desertwest(); break;
				}
				break;
			case "desertnorth":
				switch(yourChoice){
				case "c1": desertfight(); break;
				case "c2": desertcrossRoad(); break;
				}
				break;
			case "desertfight":
				switch(yourChoice){
				case "c1": desertplayerAttack();break;
				case "c2": desertcrossRoad(); break;
				}
				break;
			case "desertplayerAttack":
				switch(yourChoice){
				case "c1": 
					if(desertMonsterHP<1){
						desertwin();
					}
					else{
						desertmonsterAttack();
					}
						break;
				}
				break;
			case "desertmonsterAttack":
				switch(yourChoice){
				case "c1": 
					if(playerHP<1){
						lose();
					}
					else{
						desertfight();
					}
					break;
				}
				break;
			case "desertwin":
				switch(yourChoice){
				case "c1": deserttowngate(); break;
				}
				break;
			case "desertentercastle" :
				switch(yourChoice) {
				case "c1" : desertcastle(); break;
				}
				break;
			case "desertcastle" :
				switch(yourChoice) {
				case "c1" : castlechurch(); break;
				case "c2" : castleinn(); break;
				case "c3" : desertcrossRoad(); break;
				}
				break;
			case "castleinn" :
				switch(yourChoice) {
				case "c1" : desertcastle(); break;
				}
				break;
			case "castlechurch" :
				switch(yourChoice) {
				case "c1" : castletalktopriest(); break;
				case "c2" : desertcastle(); break;
				}
				break;
			case "castletalktopriest" :
				switch(yourChoice) {
				case "c1" : portal(); break;
				case "c2" : talkdagger(); break;
				case "c3" : castletalktopriest(); break;
				}
				break;
			case "talkdagger" :
				switch(yourChoice) {
				case "c1" : castletalktopriest(); break;
				}
				break;
	//*********************************************CHAPTER TWO ENDS*********************************************//				
	//*********************************************CHAPTER THREE*********************************************//
			case "portal" :
				switch(yourChoice) {
				case "c1" : confused(); break;
				}
				break;
			case "confused" :
				switch(yourChoice) {
				case "c1" : crossroadmines(); break;
				}
				break;
			case "crossroadmines" :
				switch(yourChoice) {
				case "c1" : minesnorth(); break;
				case "c2" : mineseast(); break;
				case "c3" : minessouth();  break;
				case "c4" : mineswest(); break;
				}
				break;
			case  "mineswest" :
				switch(yourChoice) {
				case "c1" : crossroadmines(); break;
				}
				break;
			case "mineseast" :
				switch(yourChoice) {
				case "c1" : crossroadmines(); break;
				}
				break;
			case "minesnorth":
				switch(yourChoice){
				case "c1": minesfight(); break;
				case "c2": crossroadmines(); break;
				}
				break;
			case "minesfight":
				switch(yourChoice){
				case "c1": mineplayerAttack();break;
				case "c2": crossroadmines(); break;
				}
				break;
			case "mineplayerAttack":
				switch(yourChoice){
				case "c1": 
					if(mineMonsterHP<1){
						trollwin();
					}
					else{
						minemonsterAttack();
					}
					break;
				}
				break;
			case "minemonsterAttack":
				switch(yourChoice){
				case "c1": 
					if(playerHP<1){
						lose();
					}
					else{
						minesfight();
					}
					break;
				}
				break;
			case "trollwin":
				switch(yourChoice){
				case "c1": crossroadmines(); break;
				}
				break;
			case "minessouth":
				switch(yourChoice){
				case "c1": exitpriest(); break;
				case "c2": crossroadmines(); break;
				}
				break;
			case "exitpriest" :
				switch(yourChoice) {
				case "c1" : 
					if(cracked_Dagger == 3) {
						minesPriestlose();
					}
					else {
						crossroadmines();
					}
					break;
				case "c2" : priestfight(); break;
				case "c3" : crossroadmines(); break;
				}
				break;
			case "priestfight":
				switch(yourChoice){
				case "c1": priestplayerAttack();break;
				case "c2": crossroadmines(); break;
				}
				break;
			case "priestplayerAttack":
				switch(yourChoice){
				case "c1": 
					if(priestHP<1){
						priestwin();
					}
					else{
						priestmonsterAttack();
					}
					break;
				}
				break;
			case "priestmonsterAttack":
				switch(yourChoice){
				case "c1": 
					if(playerHP<1){
						lose();
					}
					else{
						priestfight();
					}
					break;
				}
				break;
			case "priestwin":
				switch(yourChoice){
				case "c1": demonking(); break;
				}
				break;
			case "demonking" :
				switch(yourChoice) {
				case "c1" : demonkingfight(); break;
				case "c2" : dkrun(); break;
				}
				break;
			case "dkrun" :
				switch(yourChoice) {
				case "c1" : demonkingfight(); break;
				}
				break;
			case "demonkingfight":
				switch(yourChoice){
				case "c1": demonkingplayerAttack();break;
				case "c2": dkrun(); break;
				}
				break;
			case "demonkingplayerAttack":
				switch(yourChoice){
				case "c1": 
					if(demonKingHP<1){
						demonkingwin();
					}
					else{
						demonkingmonsterAttack();
					}
					break;
				}
				break;
			case "demonkingmonsterAttack":
				switch(yourChoice){
				case "c1": 
					if(playerHP<1){
						DKlose();
					}
					else{
						demonkingfight();
					}
					break;
				}
				break;
			case "dklose" :
				switch(yourChoice) { //lose
				case "c1" : playerSetup(); break;
				}
				break;
			
			}
			
			
		}
	}
	/*
	 * The MIT License (MIT)

			Copyright (c) 2018 Josip Antony Jurina
			
			Permission is hereby granted, free of charge, to any person obtaining a copy of
			this software and associated documentation files (the "Software"), to deal in
			the Software without restriction, including without limitation the rights to
			use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
			the Software, and to permit persons to whom the Software is furnished to do so,
			subject to the following conditions:
			
			The above copyright notice and this permission notice shall be included in all
			copies or substantial portions of the Software.
			
			THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
			IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
			FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
			COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
			IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
			CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
	 * 
	 * 
	 * 
	 * 
	 */



}

