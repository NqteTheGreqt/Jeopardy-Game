import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/* Authors: Nathan and Guntaas
 * Date: January 8, 2020
 * Description: This is a Jeopardy game.  Most functionality is part of a GUI, but the console is used to output each player's money total after each question is answered
 * The big concept of the programming is the three dimensional array of objects.  We used this to do a lot of things faster and it allowed us to do double and final jeopardy.
 * The first dimension is 2 long, for single and double jeopardy
 * The second dimension is 5 long, for the amount of rows in each panel
 * The third dimension in 6 long, for the amount of columns in each panel
 * We had some issues with displaying each player's score after each question is answered in GUI, so we used the console to do that.  After the game is iver, the final results are displayed in the GUI
 */
public class Jeopardy {
	
	static JFrame frame = new JFrame("Jeopardy"); //frame
	
	//creating each main panel, question panel, question button and category title
	static JPanel [] mainPanels = new JPanel [5];
	static JPanel [] [] [] questionPanels  = new JPanel [2] [5] [6];
	static JButton [] [] [] questionButton = new JButton [2] [5] [6];
	static JLabel [] [] categoryTitle = new JLabel [2] [6];
	
	//creating each label that goes on the top of each panel and creating the start and play button.  also creating a text field array where the users enter their names
	static JLabel start = new JLabel("Jeopardy");
	static JLabel [] topStart  = new JLabel [5];
	static JLabel [] topJeopardy = new JLabel [5];
	static JLabel [] topDoubleJeopardy = new JLabel [5];
	static JLabel [] topFinalJeopardy = new JLabel [5];
	static JLabel [] topAbout = new JLabel [5];
	static JTextField [] playerNamesInput = new JTextField [3];
	static JButton startButton = new JButton("Start");
	static JButton goButton = new JButton("Play");
	static JButton ok = new JButton("OK");
	
	//Creating components for the rules section
	static JLabel [] rules = new JLabel [5];
	static JLabel rulesTitle = new JLabel("Rules");
	
	//Creating arrays of components for the questions, buttons to go to the answer and back to the board 
	static JTextArea [] [] [] questions = new JTextArea [2] [5] [6];
	static JButton [] [] [] goToAnswer = new JButton [2] [5] [6];
	static JButton [] [] [] returnToBoard = new JButton [2] [5] [6];
	static JTextArea [] [] [] answers = new JTextArea [2] [5] [6];
	
	//creating buttons that are clicked if the corresponding player is correct
	static JButton [] [] [] correctPlayerOne = new JButton [2] [5] [6];
	static JButton [] [] [] correctPlayerTwo = new JButton [2] [5] [6];
	static JButton [] [] [] correctPlayerThree = new JButton [2] [5] [6];
	
	//creating jlabels and jbuttons that are used in final jeopardy
	static JLabel finalJeopardy = new JLabel("Final Jeopardy (worth $1000)");
	static JLabel finalQuestion = new JLabel("This is the oldest continually inhabited city in the world.");
	static JLabel finalAnswer = new JLabel("What is Damascus, Syria?");
	static JButton goToFinalAnswer = new JButton("Answer");
	static JButton correctPlayerOneFinal = new JButton("Player 1");
	static JButton correctPlayerTwoFinal = new JButton("Player 2");
	static JButton correctPlayerThreeFinal = new JButton("Player 3");
	
	//creating an array of integers for each question's money amount
	static int [] [] [] moneyAmounts = new int [2] [5] [6];
	
	//creating an array for the player's scores
	static int [] playerScores = new int [3];
	
	//variable for the counter that keeps track of how many questions have been answered
	static int counter = 0;
	
	//creating a jlabel where each player's final score is outputted
	static JLabel [] finalScores = new JLabel [3];
	
	//creating a string array for each player's name
	static String [] playerName = new String [3];
	
	//creating fonts that will be used throughout the program
	static Font titleFont = new Font("Georgia", Font.BOLD, 48);
	static Font topFont = new Font("Georgia", Font.PLAIN, 18);
	static Font textFont = new Font("Georgia", Font.PLAIN, 24);
	

	
	public static void frame () {
		
		//modifying frame size, default close operation and location
		frame.setSize(915, 690);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
	} //this method sets up the frame
	
	public static void panels () {
		
		for (int a = 0; a < mainPanels.length; a ++) {
			mainPanels [a] = new JPanel(); //makes the main panel [a] an object
			mainPanels [a].setLayout(null); //sets the layout of the main panel [a] as null
			mainPanels [a].setBackground(Color.blue); //sets the background of the main panel [a] as null
		} //this loop modifies each of the main panels
		
		for (int a = 0; a < 2; a ++) {
			for (int b = 0; b < 5; b ++) {
				for (int c = 0; c < 6; c ++) {
					
					questionPanels [a] [b] [c] = new JPanel(); //makes the question panel [a] [b] [c] an object
					questionPanels [a] [b] [c].setLayout(null); //sets the layout of the question panel [a] [b] [c] as null
					questionPanels [a] [b] [c].setBackground(Color.blue); //sets the background of the question panel [a] [b] [c] as null
					
				} //this loop modifies each question panel in the row
			} //this loop modifies column in the panel
		} //this loop modifies each panel
	} //this method uses for loops to efficiently modify each panel
	
	public static void startPanel() {
		
		//modifying title
		start.setFont(titleFont);
		start.setForeground(Color.yellow);
		start.setBounds(325, 220, 250, 60);
		
		for (int a = 0; a < 5; a ++) {
			//modifying top start label
			topStart [a] = new JLabel("Start");
			topStart [a].setFont(topFont);
			topStart [a].setForeground(Color.yellow);
			topStart [a].setBounds(80, 0, 50, 50);
			
			//modifying top jeopardy label
			topJeopardy [a] = new JLabel("Jeopardy");
			topJeopardy [a].setFont(topFont);
			topJeopardy [a].setForeground(Color.yellow);
			topJeopardy [a].setBounds(200, 0, 90, 50);
					
			//modifying top double jeopardy label
			topDoubleJeopardy [a] = new JLabel("Double Jeopardy");
			topDoubleJeopardy [a].setFont(topFont);
			topDoubleJeopardy [a].setForeground(Color.yellow);
			topDoubleJeopardy [a].setBounds(360, 0, 160, 50);
			
			//modifying top final jeopardy label
			topFinalJeopardy [a] = new JLabel("Final Jeopardy");
			topFinalJeopardy [a].setFont(topFont);
			topFinalJeopardy [a].setForeground(Color.yellow);
			topFinalJeopardy [a].setBounds(580, 0, 140, 50);
			
			//modifying top about label
			topAbout [a] = new JLabel("End");
			topAbout [a].setFont(topFont);
			topAbout [a].setForeground(Color.yellow);
			topAbout [a].setBounds(780, 0, 60, 50);
		}
		
		topStart [0].setFont(new Font("Georgia", Font.BOLD, 18));
		topJeopardy [1].setFont(new Font("Georgia", Font.BOLD, 18));
		topDoubleJeopardy [2].setFont(new Font("Georgia", Font.BOLD, 18));
		topFinalJeopardy [3].setFont(new Font("Georgia", Font.BOLD, 18));
		topAbout [4].setFont(new Font("Georgia", Font.BOLD, 18));
		
		//modifying rules title label
		rulesTitle.setForeground(Color.yellow);
		rulesTitle.setVisible(false);
		rulesTitle.setBounds(915/2 - 45, 75, 90, 30);
		rulesTitle.setFont(new Font("Georgia", Font.PLAIN, 36));
		
		int rulePosition = 150; //variable for the vertical position of each line of rules
		for (int a = 0; a < rules.length; a ++) {
			//modifying each rule label
			rules [a] = new JLabel();
			rules [a].setForeground(Color.yellow);
			rules [a].setVisible(false);
			rules [a].setFont(textFont);
			rules [a].setBounds(50, rulePosition, 800, 30);
			
			rulePosition += 70; //adding 70 to the vertical position of the rule
		} //this loop goes through each rule in the array and modifies it
		
		//setting the actual text that is displayed for rules
		rules [0].setText("1. The question is in the form of an answer.");
		rules [1].setText("2. Your answer must be in the form of a question.");
		rules [2].setText("3. Once a question has been answered, press the button of whoever got");
		rules [3].setText("the question correct.");
		rules [4].setText("4. Player 1, player 2 and player 3 must enter their names below.");
		
		//modifying start button
		startButton.setFont(topFont);
		startButton.setForeground(Color.yellow);
		startButton.setBackground(Color.blue);
		startButton.setBounds(410, 300, 80, 50);
		startButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked (MouseEvent e) {
				//Making title and start button invisible
				startButton.setVisible(false);
				start.setVisible(false);
				
				//making the rules title visible
				rulesTitle.setVisible(true);
				
				for (int a = 0; a < rules.length; a ++) {
					rules [a].setVisible(true); //setting each rule as visible
				}
				
				for (int a = 0; a < 3; a ++) {
					playerNamesInput [a].setVisible(true); //Setting each name text field as visible		
				}
				ok.setVisible(true); //Setting the button that starts the program as visible

			} //when the start button is clicked do the things listed above
		}); //adding a mouse listener to the start button
		
		int x = 100; //variable for the horizontal position of the player name text field
		for (int a = 0; a < 3; a ++) {
			//modifying each player name text field
			playerNamesInput [a] = new JTextField();
			playerNamesInput [a].setBounds(x, 500, 200, 50);
			playerNamesInput [a].setVisible(false);
			//adding each player name text field to the first panel
			mainPanels [0].add(playerNamesInput [a]);
			x += 250; //adding 250 to the horizontal position of the player name text field
		} //this loop goes through each player name text field and modifies it
		
		//modifying the ok button that starts the actual jeopardy game
		ok.setBackground(Color.blue);
		ok.setForeground(Color.yellow);
		ok.setBounds(915/2 - 50, 580, 100, 50);
		ok.setVisible(false);
		ok.addMouseListener(new MouseAdapter() {
			public void mouseClicked (MouseEvent e) {
				for (int a = 0; a < 3; a ++) {
					playerName [a] = playerNamesInput [a].getText();
					
				}
				
				mainPanels [0].setVisible(false);
				frame.add(mainPanels [1]);
				jeopardyPanel();
			}
		});

		//adding stuff to the title panel
		mainPanels [0].add(start);
		
		for (int a = 0; a < 5; a ++) {
			//adding one of each top component to each main panel
			mainPanels [a].add(topStart [a]);
			mainPanels [a].add(topJeopardy [a]);
			mainPanels [a].add(topDoubleJeopardy [a]);
			mainPanels [a].add(topFinalJeopardy [a]);
			mainPanels [a].add(topAbout [a]);
		} //this loop goes through each main panel and adds top component to it
		
		//adding the start button, rules title and ok button to the first main panel
		mainPanels [0].add(startButton);
		mainPanels [0].add(rulesTitle);
		mainPanels [0].add(ok);
		for (int a = 0; a < rules.length; a ++) {
			//adding each rule to the first main panel
			mainPanels [0].add(rules [a]);
		} //this loop goes through each rule and adds it to the first main panel
		
		
	} //this method is for the main panels
	
	public static void jeopardyPanel () {
		
		int moneyAmount = 100; //variable for the amount of money displayed on the question
		
		for (int a = 1; a < 3; a ++) {
			
			int y = 150; //variable for the vertical position of each button
			
			for (int b = 0; b < 5; b ++) {
				
				int x = 0; //variable for the horizontal position of each button
				
				for (int c = 0; c < 6; c ++) {

					questionButton [a - 1] [b] [c] = new JButton(); //makes each question button an object
					questionButton [a - 1] [b] [c].setText("$" + Integer.toString(moneyAmount)); //sets the money amount that is displayed on each question button
					questionButton [a - 1] [b] [c].setBounds(x, y, 150, 100); //sets the location and size of each question button
					questionButton [a - 1] [b] [c].setFont(textFont);
					questionButton [a - 1] [b] [c].setForeground(Color.yellow);
					questionButton [a - 1] [b] [c].setBackground(Color.blue);
					mainPanels [a].add(questionButton [a - 1] [b] [c]);  //adds each question button to the main panel
					
					x += 150; //adds 150 to the horizontal position
					
					moneyAmounts [a - 1] [b] [c] = moneyAmount;
					
					//these final variables are for the mouse listener. they are set to their corresponding control variables
					final int h = a - 1;
					final int i = b;
					final int j = c;
					
					questionButton [a - 1] [b] [c].addMouseListener(new MouseAdapter () {
						public void mouseClicked (MouseEvent e) {
							
							frame.add(questionPanels [h] [i] [j]); //adds the correct question panel to the frame
							mainPanels [h + 1].setVisible(false); //sets the correct main panel as false

						}//when the question button is clicked do the things above
					}); //adds a mouse listener to each question button	
				} //this loop modifies each question button in the row
				moneyAmount += (100 * a); //modifies money amount so that it goes up by a specific amount each time
				
				y += 100; //adds 100 to the vertical position
			} //this loop modifies each column in the panel
			moneyAmount = 200; //sets the money amount to 200
		} //this loop modifies each panel in the game
		
		for (int a = 0; a < 2; a ++) {
			for (int b = 0; b < 5; b ++) {
				for (int c = 0; c < 6; c ++) {
					
					//modifying each question text area in the array
					questions [a] [b] [c] = new JTextArea();
					questions [a] [b] [c].setBackground(Color.blue);
					questions [a] [b] [c].setFont(new Font("Georgia", Font.PLAIN, 36));
					questions [a] [b] [c].setBounds(100, 250, 700, 150);
					questions [a] [b] [c].setForeground(Color.yellow);
					
					//modifying each button that takes user to the answer in the array
					goToAnswer [a] [b] [c] = new JButton("Answer");
					goToAnswer [a] [b] [c].setBounds(915 / 2 - 75, 400, 150, 100);
					goToAnswer [a] [b] [c].setBackground(Color.blue);
					goToAnswer [a] [b] [c].setForeground(Color.yellow);
					goToAnswer [a] [b] [c].setFont(new Font("Georgia", Font.BOLD, 24));
					
					//modifying each answer text area in the array
					answers [a] [b] [c] = new JTextArea();
					answers [a] [b] [c].setBounds(100, 250, 700, 150);
					answers [a] [b] [c].setBackground(Color.blue);
					answers [a] [b] [c].setForeground(Color.yellow);
					answers [a] [b] [c].setFont(new Font("Georgia", Font.PLAIN, 36));
					
					//modifying each button that return user to the board in the array
					returnToBoard [a] [b] [c] = new JButton("Return to board");
					returnToBoard [a] [b] [c].setBounds(915 / 2 - 125, 500, 250, 100);
					returnToBoard [a] [b] [c].setBackground(Color.blue);
					returnToBoard [a] [b] [c].setForeground(Color.yellow);
					returnToBoard [a] [b] [c].setFont(new Font("Georgia", Font.BOLD, 24));
					
					//these final variables are to be used in the mouse listener below
					final int h = a;
					final int i = b;
					final int j = c;
					
					goToAnswer [a] [b] [c].addMouseListener (new MouseAdapter() {
						public void mouseClicked (MouseEvent e) {
							//making the go to answer button and the question invisible
							goToAnswer [h] [i] [j].setVisible(false);
							questions [h] [i] [j].setVisible(false);
							
							//adding the answer and buttons for the player that answered it correctly in the array
							questionPanels [h] [i] [j].add(answers [h] [i] [j]);
							questionPanels [h] [i] [j].add(correctPlayerOne [h] [i] [j]);
							questionPanels [h] [i] [j].add(correctPlayerTwo [h] [i] [j]);
							questionPanels [h] [i] [j].add(correctPlayerThree [h] [i] [j]);
							
						}//when the go to answer button is clicked, do the tasks listed above
					}); //adds a mouse listener to each go to answer button
					
					//adds each question and go to answer button to the corresponding panel
					questionPanels [a] [b] [c].add(questions [a] [b] [c]);
					questionPanels [a] [b] [c].add(goToAnswer [a] [b] [c]);
					
				} //this loop modifies each question button in the row
			} //this loop modifies each column in the panel
		} //this loop modifies each panel in the game


		//setting the text of each question in single and double jeopardy
		questions [0] [0] [0].setText("The \"chicken leg piece meme\" originated \nfrom a tiktoker from this country.");	
		questions [0] [0] [1].setText("This player is known as the best player of all \ntime.");
		questions [0] [0] [2].setText("This team is nicknamed \"Canada’s team\".");
		questions [0] [0] [3].setText("This team is the current NBA champions.");
		questions [0] [0] [4].setText("Tom Brady currently plays for this team.");
		questions [0] [0] [5].setText("This player holds 6 trophies and is regarded \nas one of the best currently playing.");
		questions [0] [1] [0].setText("This tiktoker holds the record of the most \nfollowers on tik tok with 34.7 million.");
		questions [0] [1] [1].setText("This team has won 24 Stanley Cups.");
		questions [0] [1] [2].setText("He plays for the Angels and his last name \nis a type of fish.");
		questions [0] [1] [3].setText("These two players are known as the splash \nbrothers.");
		questions [0] [1] [4].setText("This team won the Super Bowl last year.");
		questions [0] [1] [5].setText("This soccer league holds the most skilled \nplayers and is considered the best league in \nthe world.");
		questions [0] [2] [0].setText("Charli D'Amelio, Lil Huddy and Addison \nEasterling are in this Tik Tok group.");
		questions [0] [2] [1].setText("This team last won a Stanley Cup in 1967.");
		questions [0] [2] [2].setText("This player broke the single season rookie \nhome run record in 2017.");
		questions [0] [2] [3].setText("This team drafted James Harden.");
		questions [0] [2] [4].setText("This veteran player returned from \nretirement to help his team make the \nplayoffs in the 2019 season.");
		questions [0] [2] [5].setText("This country won the FIFA World Cup in \n2018.");
		questions [0] [3] [0].setText("This app was taken down and replaced \nwith Tik Tok.");
		questions [0] [3] [1].setText("This city has a team called the Ducks.");
		questions [0] [3] [2].setText("This pitcher is nicknamed \"Thor\".");
		questions [0] [3] [3].setText("This player won Most Improved Player \nlast season.");
		questions [0] [3] [4].setText("This team's colours are gold and black.");
		questions [0] [3] [5].setText("This country will be hosting the next \nFIFA World Cup in 2022.");
		questions [0] [4] [0].setText("This country has currently banned Tik Tok.");
		questions [0] [4] [1].setText("This league is known as the league \nbelow the NHL.");
		questions [0] [4] [2].setText("This team made it to the World Series \nin 2017 and 2019.");
		questions [0] [4] [3].setText("This player’s first name sounds like a \nmexican food.");
		questions [0] [4] [4].setText("This trophy is awarded to the winning \nteam of the Super Bowl.");
		questions [0] [4] [5].setText("There are currently ___ professional \nsoccer leagues.");
		
		questions [1] [0] [0].setText("The most famous rivalry is between these 2 \ncountries.");
		questions [1] [0] [1].setText("The H in H-bomb.");
		questions [1] [0] [2].setText("This is the leader of Germany for most of \nthe war.");
		questions [1] [0] [3].setText("There was a temporary truce on this day in \n1914.");
		questions [1] [0] [4].setText("This Ontario based university has a mascot \nof a mustang.");
		questions [1] [0] [5].setText("This Toronto/Jamaican slang word is derived \nfrom \'youth\'.");
		questions [1] [1] [0].setText("This player is regarded as the best of all \ntime.");
		questions [1] [1] [1].setText("This wall was built in 1961.");
		questions [1] [1] [2].setText("This was the last major battle of WWII.");
		questions [1] [1] [3].setText("This term was used to refer to american \nsoldiers in WWI.");
		questions [1] [1] [4].setText("Complete the following phrase: If you can \nhold a fork, you can go to ____.");
		questions [1] [1] [5].setText("This word is used when you are wanting to \nmeet up with someone.");
		questions [1] [2] [0].setText("In a traditional game of cricket there are \n__ players on a team.");
		questions [1] [2] [1].setText("The communist leader at the start of the \nSoviet Union.");
		questions [1] [2] [2].setText("This is the longest battle in WW2 lasting for \n6 years.");
		questions [1] [2] [3].setText("This country had the most fatalities.");
		questions [1] [2] [4].setText("This university owns a large pink tie.");
		questions [1] [2] [5].setText("This slang word is used when you see \nsomeone you know, replacing hi or hello.");
		questions [1] [3] [0].setText("This team is currently the only team to win \nback to back world cups.");
		questions [1] [3] [1].setText("The communist leader of Cuba.");
		questions [1] [3] [2].setText("This american president said \"a date which \nwill live in infamy\" on December 7, 1941.");
		questions [1] [3] [3].setText("This country was the first to introduce \nflamethrowers.");
		questions [1] [3] [4].setText("Elon Musk is a alumni of this university.");
		questions [1] [3] [5].setText("This slang is used when someone gets on \nyour nerves and you want to shut them up.");
		questions [1] [4] [0].setText("Bangladesh became the tenth ICC worlds \nteam in this year.");
		questions [1] [4] [1].setText("The author of the book \n\"Nineteen Eighty-Four\".");
		questions [1] [4] [2].setText("This country had the most lives lost in \nWWII.");
		questions [1] [4] [3].setText("This secret association was responsible for \nthe assissination of the Archduke Franz \nFerdinand.");
		questions [1] [4] [4].setText("This university owns a preserved piece of \nEinsteins brain.");
		questions [1] [4] [5].setText("This is used when you're referring to one of \nyour best friends.");

		//setting the text of each answer in single and double jeopardy
		answers [0] [0] [0].setText("What is India?");
		answers [0] [0] [1].setText("Who is Wayne Gretzky?");
		answers [0] [0] [2].setText("Who are the Toronto Blue Jays?");
		answers [0] [0] [3].setText("Who are the Toronto Blue Raptors?");
		answers [0] [0] [4].setText("Who are the New England Patriots?");
		answers [0] [0] [5].setText("Who is Lionel Messi?");
		answers [0] [1] [0].setText("Who is Loren Gray?");
		answers [0] [1] [1].setText("Who are the Montreal Canadiens?");
		answers [0] [1] [2].setText("Who is Mike Trout?");
		answers [0] [1] [3].setText("Who are Steph Curry and Klay Thompson?");
		answers [0] [1] [4].setText("Who are the New England Patriots?");
		answers [0] [1] [5].setText("What is La Liga?");
		answers [0] [2] [0].setText("What is the hype house?");
		answers [0] [2] [1].setText("Who are the Toronto Maple Leafs?");
		answers [0] [2] [2].setText("Who is Aaron Judge?");
		answers [0] [2] [3].setText("Who are the OKC Thunder?");
		answers [0] [2] [4].setText("Who is Marshawn Lynch?");
		answers [0] [2] [5].setText("What is France?");
		answers [0] [3] [0].setText("What is Musical.ly?");
		answers [0] [3] [1].setText("What is Anaheim?");
		answers [0] [3] [2].setText("Who is Noah Syndergaard?");
		answers [0] [3] [3].setText("Who is Pascal Siakam?");
		answers [0] [3] [4].setText("Who are the New Orleans Saints? ");
		answers [0] [3] [5].setText("What is Qatar?");
		answers [0] [4] [0].setText("What is Indonesia?");
		answers [0] [4] [1].setText("What is the AHL?");
		answers [0] [4] [2].setText("Who are the Houston Astros?");
		answers [0] [4] [3].setText("Who is Tacko Fall?");
		answers [0] [4] [4].setText("What is the Vince Lombardi Trophy?");
		answers [0] [4] [5].setText("What is 21?");
		
		answers [1] [0] [0].setText("Who are India and Pakistan?");
		answers [1] [0] [1].setText("What is hydrogen?");
		answers [1] [0] [2].setText("Who is Adolf Hitler?");
		answers [1] [0] [3].setText("What is Christmas Day?");
		answers [1] [0] [4].setText("What is Western University?");
		answers [1] [0] [5].setText("What is yute?");
		answers [1] [1] [0].setText("Who is Sachin Tendulkar?");
		answers [1] [1] [1].setText("What is the Berlin Wall?");
		answers [1] [1] [2].setText("What is the Battle of Okinawa?");
		answers [1] [1] [3].setText("What is dough boy?");
		answers [1] [1] [4].setText("What is York?");
		answers [1] [1] [5].setText("What is link?");
		answers [1] [2] [0].setText("What is 11?");
		answers [1] [2] [1].setText("Who is Vladimir Lenin?");
		answers [1] [2] [2].setText("What is the Battle of the Atlantic?");
		answers [1] [2] [3].setText("What is Germany?");
		answers [1] [2] [4].setText("What is U of Waterloo?");
		answers [1] [2] [5].setText("What is wagwan?");
		answers [1] [3] [0].setText("What is Australia?");
		answers [1] [3] [1].setText("Who is Fidel Castro?");
		answers [1] [3] [2].setText("Who is Franklin Roosevelt?");
		answers [1] [3] [3].setText("What is Germany?");
		answers [1] [3] [4].setText("What is Queens?");
		answers [1] [3] [5].setText("What is nize it?");
		answers [1] [4] [0].setText("What is 2000?");
		answers [1] [4] [1].setText("Who is George Orwell?");
		answers [1] [4] [2].setText("What is the Soviet Union?");
		answers [1] [4] [3].setText("What is the Black Hand?");
		answers [1] [4] [4].setText("What is McMaster?");
		answers [1] [4] [5].setText("What is cronem?");

		for (int a = 0; a < 2; a ++) {
			for (int b = 0; b < 5; b ++) {
				for (int c = 0; c < 6; c ++) {
					
					//these final variables are used in the mouse listeners below 
					final int h = a;
					final int i = b;
					final int j = c;
		
					//modifying each correctPlayerOne button, correctPlayerTwo button and correctPlayerThree button in single and double jeopardy
					correctPlayerOne [a] [b] [c] = new JButton("Player 1");
					correctPlayerTwo [a] [b] [c] = new JButton("Player 2");
					correctPlayerThree [a] [b] [c] = new JButton("Player 3");
					
					correctPlayerOne [a] [b] [c].setBounds(100, 400, 150, 100);
					correctPlayerTwo [a] [b] [c].setBounds(350, 400, 150, 100);
					correctPlayerThree [a] [b] [c].setBounds(600, 400, 150, 100);
					
					correctPlayerOne [a] [b] [c].setBackground(Color.blue);
					correctPlayerTwo [a] [b] [c].setBackground(Color.blue);
					correctPlayerThree [a] [b] [c].setBackground(Color.blue);
					
					correctPlayerOne [a] [b] [c].setForeground(Color.yellow);
					correctPlayerTwo [a] [b] [c].setForeground(Color.yellow);
					correctPlayerThree [a] [b] [c].setForeground(Color.yellow);
					
					correctPlayerOne [a] [b] [c].setFont(new Font("Georgia", Font.PLAIN, 30));
					correctPlayerTwo [a] [b] [c].setFont(new Font("Georgia", Font.PLAIN, 30));
					correctPlayerThree [a] [b] [c].setFont(new Font("Georgia", Font.PLAIN, 30));
					
					correctPlayerOne [a] [b] [c].setText(playerName [0]);
					correctPlayerTwo [a] [b] [c].setText(playerName [1]);
					correctPlayerThree [a] [b] [c].setText(playerName [2]);
					
					correctPlayerOne [a] [b] [c].addMouseListener(new MouseAdapter () {
						public void mouseClicked (MouseEvent e) {
							counter ++; //adds 1 to the counter
							if (counter == 30) {
								frame.add(mainPanels [2]);
							}//if all questions in single jeopardy are done, start double jeopardy
							else if (counter == 60) {
								finalJeopardy();
								frame.add(mainPanels [3]);
							}//if all questions in double jeopardy are done, start final jeopardy
							else {
								mainPanels [h + 1].setVisible(true);
							} //if there are still questions remaining, return to the previous board
							
							//setting the question panel that was clicked as invisible
							questionPanels [h] [i] [j].setVisible(false);
							questionButton [h] [i] [j].setVisible(false);
							
							playerScores [0] += moneyAmounts [h] [i] [j]; //adding the money amount that the question has to player 1's score
							
							//printing the scores to the console (couldn't figure it out how to do it with GUI)
							System.out.println("UPDATED SCORES");
							System.out.println(playerName [0] + ": $" + playerScores [0]);
							System.out.println(playerName [1] + ": $" + playerScores [1]);
							System.out.println(playerName [2] + ": $" + playerScores [2] + "\n");
							
						}//if the button is clicked, do the things above
					});//adding a mouse listener to the correctPlayerOne button
					
					correctPlayerTwo [a] [b] [c].addMouseListener(new MouseAdapter () {
						public void mouseClicked (MouseEvent e) {
							
							counter ++; //adds 1 to the counter
							
							if (counter == 30 && h == 0) {
								frame.add(mainPanels [2]);
							} //if all questions in single jeopardy are done, start double jeopardy
							else if (counter == 60 && h == 1) {
								finalJeopardy();
								frame.add(mainPanels [3]);
							} //if all questions in double jeopardy are done, start final jeopardy
							else {
								mainPanels [h + 1].setVisible(true);
							} //if there are still questions remaining, return to the previous board
							
							//setting the question panel that was clicked as invisible
							questionPanels [h] [i] [j].setVisible(false);
							questionButton [h] [i] [j].setVisible(false);
							
							playerScores [1] += moneyAmounts [h] [i] [j]; //adding the money amount that the question has to player 1's score
							
							//printing the scores to the console (couldn't figure it out how to do it with GUI)
							System.out.println("UPDATED SCORES");
							System.out.println(playerName [0] + ": $" + playerScores [0]);
							System.out.println(playerName [1] + ": $" + playerScores [1]);
							System.out.println(playerName [2] + ": $" + playerScores [2] + "\n");
						}//if the button is clicked, do the things above
					});//adding a mouse listener to the correctPlayerOne button
					
					correctPlayerThree [a] [b] [c].addMouseListener(new MouseAdapter () {
						public void mouseClicked (MouseEvent e) {
							counter ++; //adds 1 to the counter
							if (counter == 30 && h == 0) {
								frame.add(mainPanels [2]);
							} //if all questions in single jeopardy are done, start double jeopardy
							else if (counter == 60 && h == 1) {
								finalJeopardy();
								frame.add(mainPanels [3]);
							} //if all questions in double jeopardy are done, start final jeopardy
							else {
								mainPanels [h + 1].setVisible(true);
							} //if there are still questions remaining, return to the previous board
							
							//setting the question panel that was clicked as invisible
							questionPanels [h] [i] [j].setVisible(false);
							questionButton [h] [i] [j].setVisible(false);
							
							playerScores [2] += moneyAmounts [h] [i] [j]; //adding the money amount that the question has to player 1's score
							
							//printing the scores to the console (couldn't figure it out how to do it with GUI)
							System.out.println("UPDATED SCORES");
							System.out.println(playerName [0] + ": $" + playerScores [0]);
							System.out.println(playerName [1] + ": $" + playerScores [1]);
							System.out.println(playerName [2] + ": $" + playerScores [2] + "\n");
						}//if the button is clicked, do the things above
					});//adding a mouse listener to the correctPlayerOne button
					
				} //this loop modifies each question button in the row's corresponding panel
			} //this loop modifies each column in the panel
		} //this loop modifies each panel in the game
		

 		for (int a = 0; a < 2; a ++) {
			int x = 30; //variable for the horizontal position of the text
			for (int b = 0; b < 6; b ++) {
				
				categoryTitle [a] [b] = new JLabel(); //makes each title an object
				categoryTitle [a] [b].setBounds(x, 50, 150, 100); //sets the position of each title
				categoryTitle [a] [b].setForeground(Color.yellow); //sets the color of each title as yellow
				categoryTitle [a] [b].setFont(textFont);
				mainPanels [a + 1].add(categoryTitle [a] [b]); //adds the the title to the correct panel
				x += 150; //adds 150 to the horizontal position of the text
			
			} //this loop modifies each title in a panel
		
		} //this loop modifies each panel in the project
		
 		//setting text of the category titles
		categoryTitle [0] [0].setText("Tik Tok");
		categoryTitle [0] [1].setText("Hockey");
		categoryTitle [0] [2].setText("Baseball");
		categoryTitle [0] [3].setText("Basketball");
		categoryTitle [0] [4].setText("Football");
		categoryTitle [0] [5].setText("Soccer");
		categoryTitle [1] [0].setText("Cricket");
		categoryTitle [1] [1].setText("Cold War");
		categoryTitle [1] [2].setText("WWII");
		categoryTitle [1] [3].setText("WWI");
		categoryTitle [1] [4].setText("Universities");
		categoryTitle [1] [5].setText("Slang");
		
	} //this method is for the single jeopardy panel
	
	public static void finalJeopardy() {
		
		//modifying each button, title and label
		goToFinalAnswer.setBounds(915 / 2 - 75, 400, 150, 100);
		goToFinalAnswer.setBackground(Color.blue);
		goToFinalAnswer.setForeground(Color.yellow);
		goToFinalAnswer.setFont(new Font("Georgia", Font.BOLD, 24));
		
		finalJeopardy.setBounds(915/2-490/2, 100, 490, 50);
		finalJeopardy.setForeground(Color.yellow);
		finalJeopardy.setFont(new Font("Georgia", Font.PLAIN, 36));
		
		finalQuestion.setBounds(915/2 - 600/2, 150, 600, 50);
		finalQuestion.setForeground(Color.yellow);
		finalQuestion.setFont(textFont);
		
		finalAnswer.setBounds(915/2 - 300/2, 150, 300, 50);
		finalAnswer.setForeground(Color.yellow);
		finalAnswer.setFont(textFont);
		
		correctPlayerOneFinal.setBounds(100, 400, 150, 100);
		correctPlayerTwoFinal.setBounds(350, 400, 150, 100);
		correctPlayerThreeFinal.setBounds(600, 400, 150, 100);
		
		correctPlayerOneFinal.setBackground(Color.blue);
		correctPlayerTwoFinal.setBackground(Color.blue);
		correctPlayerThreeFinal.setBackground(Color.blue);
		
		correctPlayerOneFinal.setForeground(Color.yellow);
		correctPlayerTwoFinal.setForeground(Color.yellow);
		correctPlayerThreeFinal.setForeground(Color.yellow);
		
		correctPlayerOneFinal.setFont(new Font("Georgia", Font.PLAIN, 30));
		correctPlayerTwoFinal.setFont(new Font("Georgia", Font.PLAIN, 30));
		correctPlayerThreeFinal.setFont(new Font("Georgia", Font.PLAIN, 30));
		
		//setting the text of the button to the corresponding player's name
		correctPlayerOneFinal.setText(playerName [0]);
		correctPlayerTwoFinal.setText(playerName [1]);
		correctPlayerThreeFinal.setText(playerName [2]);
		
		goToFinalAnswer.addMouseListener(new MouseAdapter () {
			public void mouseClicked(MouseEvent e) {
				//getting rid of question and go to final answer button
				finalQuestion.setVisible(false);
				goToFinalAnswer.setVisible(false);
				
				//displaying answer and buttons for who got it right
				mainPanels [3].add(finalAnswer);
				mainPanels [3].add(correctPlayerOneFinal);
				mainPanels [3].add(correctPlayerTwoFinal);
				mainPanels [3].add(correctPlayerThreeFinal);
			}//if the button is clicked, do the thing above
		}); //adding a mouse listener to the go to final answer button
		
		correctPlayerOneFinal.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				playerScores [0] += 1000; //adding 1000 to tthe player's score
				frame.add(mainPanels [4]); //starting results panel
				mainPanels [3].setVisible(false);
				scores(); //starting results panel
			} //if the button is clicked, do the things above
		});//adds a mouse listener to the player 1 correct button
		correctPlayerTwoFinal.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				playerScores [1] += 1000; //adding 1000 to tthe player's score
				frame.add(mainPanels [4]); //starting results panel
				mainPanels [3].setVisible(false);
				scores(); //starting results panel
			}//if the button is clicked, do the things above
		});//adds a mouse listener to the player 2 correct button
		correctPlayerThreeFinal.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				playerScores [2] += 1000; //adding 1000 to tthe player's score
				frame.add(mainPanels [4]); //adding results panel
				mainPanels [3].setVisible(false);
				scores(); //starting results panel
			}//if the button is clicked, do the things above
		}); //adds a mouse listener to the player 3 correct button
		
		//adding title, question and button to the final jeopardy panel
		mainPanels [3].add(finalJeopardy);
		mainPanels [3].add(finalQuestion);
		mainPanels [3].add(goToFinalAnswer);
		
	} //this method sets up the final jeopardy panel
	
	public static void scores() {
		
		int y = 150; //variable for the vertical position of the final scores label
		
		for (int a = 0; a < 3; a ++) {
			//modifying the final scores label
			finalScores [a] = new JLabel(playerName [a] + "'s final score is: $" + Integer.toString(playerScores [a]));
			finalScores [a].setBounds(250, y, 600, 50);
			finalScores [a].setFont(new Font("Georgia", Font.PLAIN, 36));
			finalScores [a].setForeground(Color.yellow);
			
			//adding the label to the last panel
			mainPanels [4].add(finalScores [a]);
			
			//adding 150 to the vertical position of the label
			y += 150;
			
		}//this loop goes through each final score label and modifies it
		
	} //this method sets up the last panel that display's each player's score
	
	public static void finalTouches() {

		//final touches on the frame
		frame.add(mainPanels [0]);
		frame.setVisible(true);
		
	} //this method is for the final touches for the program
	
	public static void main(String[] args) {
		
		frame(); //call method to set up the frame
		panels(); //call method to set up the panels
		startPanel(); //call method to set up the start panel
		finalTouches(); //call method to add the final touches to the program
		
	}//end of main

}//end of class