package uk.ac.ucl.cs.nterreri.mole;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Image;

import javax.swing.JButton;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.WindowAdapter;

/**
 * MainWindow JFrame, constructor definition includes calls to MainWindow
 * methods such as new_game() etc necessary for the functioning of the game.
 * 
 * @author nterreri
 *
 */
public class MainWindow {

	private JFrame frame;
	//NewHighScore instance is an extension of JDialog
	//(the author did not know how to use JOptionPane at the time,
	//so he made a new type of JDialog from scratch)
	private NewHighScore dialog;
	private ActionListener buttonPressed;

	//Timer fields:
	//A single timer instance is employed throughout.
	private double delay;
	private ActionListener taskPerformer;
	private Timer timer;

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	//Other fields:
	//GameScore

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		//First, see if a score file already exists, if not try to write one,
		//if this fails, carry on without recording anything:
		write_default_scores_to_file();

		//Initializations:
		frame = new JFrame();
		frame.setBounds(0, 0, 150*4 + 100, 150*4 + 30);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Upon closing the new high score dialog, a name for the new record
		//is fetched from a text field on the dialog 
		//(which can be null) and then calls write_score_to_file()
		dialog = new NewHighScore(frame);
		dialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {

				dialog.getName();
				write_score_to_file();
			}
		});
		dialog.setVisible(false);
		
		//A buttonPressed ActionListener partial interface implementation:
		//Registered to all buttons on the grid, it is responsible
		//for reacting to the user successfully clicking on a mole:
		buttonPressed = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					disable_mole(JButton2DGrid.grid[GameScore.randx][GameScore.randy]);
					GameScore.score += 1*(GameScore.diff_modifier * 15);
					GameScore.increment += (GameScore.diff_modifier*2.0 );
					textField.setText(Integer.toString(GameScore.score));
				
			}
		};
		

		//Initializing grid:
		JButton2DGrid.grid = new JButton[4][4];

		for(int y = 0; y < 4; y++)
		{
			for(int x = 0; x < 4; x++)
			{
				JButton2DGrid.grid[x][y] = new JButton();
				JButton2DGrid.grid[x][y].setBounds(x*150, y*150, 150, 150);
				disable_mole(JButton2DGrid.grid[x][y]);
			}
		}
		
		


		//Adding layout and content to pane:
		frame.getContentPane().setLayout(null);

		//Labels and boxes:
		JLabel lblScore = new JLabel("Score:");
		lblScore.setBounds(610, 25, 70, 15);
		frame.getContentPane().add(lblScore);

		textField = new JTextField();
		lblScore.setLabelFor(textField);
		textField.setEditable(false);
		textField.setBounds(610, 45, 80, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblTimer = new JLabel("Timer:");
		lblTimer.setBounds(610, 77, 70, 15);
		frame.getContentPane().add(lblTimer);

		textField_1 = new JTextField();
		lblTimer.setLabelFor(textField_1);
		textField_1.setEditable(false);
		textField_1.setBounds(610, 95, 80, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JLabel lblDifficulty = new JLabel("Difficulty:");
		lblDifficulty.setBounds(610, 130, 70, 15);
		frame.getContentPane().add(lblDifficulty);

		textField_2 = new JTextField();
		lblDifficulty.setLabelFor(textField_2);
		textField_2.setEditable(false);
		textField_2.setBounds(610, 150, 80, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		//side menu
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(610, 200, 150, 21);
		frame.getContentPane().add(menuBar);

		JMenu mnNewMenu = new JMenu("New game");
		menuBar.add(mnNewMenu);

		//Depending on the difficulty selected, a different modifier is
		//used to call start_game(), this affects how score is calculated
		//and how fast moles appear and disappear:
		JMenuItem mntmNewMenuItem = new JMenuItem("Easy");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Easy game start!");
				timer.stop();
				new_game();
				display_difficulty(2);
				start_game((short)2);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Medium");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Medium game start!");
				timer.stop();
				new_game();
				display_difficulty(5);
				start_game((short)5);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Hard");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Hard game start!");
				timer.stop();
				new_game();
				display_difficulty(10);
				start_game((short)10);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);

		//the grid is added to the pane last:
		for(int y = 0; y < 4; y++)
			for(int x = 0; x < 4; x++)
				frame.getContentPane().add(JButton2DGrid.grid[x][y]);

		//Begin idle animation after the grid has been setup:
		idle_game();

	}

	/**
	 * Function responsible for the idle animation while the game is not
	 * being played:
	 */
	public void idle_game() {
		//Initialize timer:
		delay = 1000;
		taskPerformer = new ActionListener() {
			short swtch = 0;
			public void actionPerformed(ActionEvent evt) {
				System.out.println("Timer action!");
				//Each timer tick, the whole grid is traversed, and selected
				//squares change status:
				swtch++;

				for(int y = 0; y < 4; y++)
					for(int x = 0; x < 4; x++)
					{
						if((y + swtch)%2 == 0 && 
								(x + swtch)%2 != 0)
							enable_mole(JButton2DGrid.grid[x][y]);
						else if((y + swtch)%2 != 0 &&
								(x + swtch)%2 == 0)
							disable_mole(JButton2DGrid.grid[x][y]);

					}
			}
		};
		timer = new Timer((int) delay, taskPerformer);

		timer.start();
	}

	/**
	 * function running while the game is being played:
	 * @param diff_modifier
	 */
	public void start_game(short diff_modifier) {

		GameScore.diff_modifier = diff_modifier;
		GameScore.increment = diff_modifier/20.0;
		//Timer listener instructions, and timer constructor details:
		delay = 5000/diff_modifier;
		taskPerformer = new ActionListener() {	
			public void actionPerformed(ActionEvent evt) {

				//evt_counter counts down to endgame:
				GameScore.evt_counter++;
				textField_1.setText(Integer.toString
						(40 - GameScore.evt_counter));

				if(GameScore.evt_counter >= 40)			
					game_over();

				if((delay - GameScore.increment) >= 0)
					delay -= GameScore.increment;
				else
					delay = 1;
				GameScore.increment += diff_modifier/2.0;
				for(int y = 0; y < 4; y++)
					for(int x = 0; x < 4; x++)
						disable_mole(JButton2DGrid.grid[x][y]);

				GameScore.generateRandomPos();
				enable_mole(JButton2DGrid.grid[GameScore.randx][GameScore.randy]);
				
				timer.setDelay((int)delay);
			}
		};
		timer = new Timer((int)delay, taskPerformer);

		timer.start();
	}

	/**
	 * Sends correct data to textbox displaying difficulty:
	 * @param diff
	 */
	public void display_difficulty(int diff) {
		switch(diff)
		{
		case 2:
			textField_2.setText("Easy");
			break;
		case 5:
			textField_2.setText("Medium");
			break;
		case 10:
			textField_2.setText("Hard");
			break;
		default:

		}
	}

	/**
	 * Sister method to disable_mole(JButton).
	 * Sets image to button and adds or removes the action listener
	 * responsible for reacting to the player clicking button.
	 * When the button has a mole icon, clicking it should increase the
	 * score.
	 * 
	 * Also if a mole button has been pressed during the game, that button
	 * should instantly become inactive.
	 * 
	 * @param square
	 */
	public void enable_mole(JButton square) {

		try {
			Image img = ImageIO.read(getClass().getResourceAsStream("mole.png"));
			square.setIcon(new ImageIcon(img));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		square.addActionListener(buttonPressed);
	}

	/**
	 * Sister to enable_mole(JButton).
	 * Sets image to button and removes the action listener
	 * responsible for reacting to the player clicking button.
	 * When the button has no mole icon, pressing it should not increase the
	 * score.
	 
	 * 
	 * @param square
	 */
	public void disable_mole(JButton square) {

		try {
			Image img = ImageIO.read(getClass().getResourceAsStream("hole.png"));
			square.setIcon(new ImageIcon(img));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		square.removeActionListener(buttonPressed);
	}

	/**
	 * Resets current game data and relevant displays. Called before
	 * calling game_start(short).
	 * 
	 */
	public void new_game() {
		GameScore.reset();
		textField.setText(Integer.toString(GameScore.score));
		textField_1.setText("0");
		textField_2.setText(null);
	}

	/**
	 * Called when the timer reaches 0, checks to see if the score qualifies
	 * as a new high score.
	 * 
	 * If so, sets the dialog window to visible. The dialog window
	 * is a modal window with the MainWindow frame as its parent, so the latter
	 * is inaccessible until the dialog is closed.
	 * 
	 * Finally, starts the idle animation again.
	 * 
	 */
	public void game_over() {
		timer.stop();
		//previously:
		//write_score_to_file();
		GameScore.rank = get_rank();

		System.err.println(GameScore.rank);
		if(GameScore.rank > 0)
			dialog.setVisible(true);
		//closing the dialog will generate an event, this is caught by a
		//WindowAdapter which triggers write_score_to_file


		idle_game();
	}

	/**
	 * Reads the highscore file to initialize a vector for the 
	 * numerical scores, and another for the recorded names.
	 * 
	 * Confronts each score with the score of the game just ended
	 * (again, game_over already does this check independently) to extract
	 * the index in the vectors into which the new high score should be inserted.
	 * 
	 * Finally, attempts writing the new score to the highscore file.
	 */
	public void write_score_to_file() {

		Vector<Integer> recorded_score = new Vector<Integer>(10);
		Vector<String> recorded_names = new Vector<String>(10);

		try {
			BufferedReader is = new BufferedReader(new FileReader("mole_scores"));
			String line = is.readLine();

			try {

				for(int i = 0; i < 10 && line != null; i++)
				{
					recorded_score.add(Integer.parseInt(line.substring(7)));
					recorded_names.add(line.substring(3, 6));
					line = is.readLine();
				}
				int i = 0;
				for(; i < 10; i++)
					if(recorded_score.elementAt(i) < GameScore.score)	
						break;	

				if(i < 10)
				{
					recorded_score.add(i, GameScore.score);

					if(GameScore.name != null)
						recorded_names.add(i, GameScore.name);
					else
						recorded_names.add(i, "   ");
				}
				//else //do nothing

			} catch (NumberFormatException e) {
				e.printStackTrace();
				System.err.println("Unable to read score target file.");
			}

			is.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Unable to open mole_score file to write scores.");

		}

		try {
			FileWriter os = new FileWriter("mole_scores");

			for(int i = 0; i < 9; i++)
				os.write((i + 1) + "  " + recorded_names.elementAt(i) 
					+ " " + recorded_score.elementAt(i) + "\n");
			os.write(10 + " " + recorded_names.elementAt(9) 
				+ " " + recorded_score.elementAt(9) + "\n");
			
			os.close();

		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Failed to save scores to file.");
		}
	}

	//Used to be:
	/*
	public void make_room(Vector<Object> recorded_score) {
		
		for(int k = (i + 1); k < 9; k++)
			recorded_score[k + 1] = copy[k];
	}

	public void make_room(Vector<String> recorded_score, int i) {
		String [] copy = new String[10];

		for(int k = (i + 1); k < 10; k++)
			copy[k] = recorded_score[k];
		for(int k = (i + 1); k < 9; k++)
			recorded_score[k + 1] = copy[k];
	}*/

	/**
	 * 
	 * @return the rank from 1 to 10 of the new score.
	 * 			or -1 where if an IOException is thrown attempting to access
	 * 			this file.
	 */
	public int get_rank(){
		try{
			BufferedReader is = new BufferedReader(new FileReader("mole_scores"));
			String line = is.readLine();

			int i = 0;
			for(; i < 10; i++)
				{
				System.out.println(GameScore.score + " " + Integer.parseInt(line.substring(7)));
					if(GameScore.score > Integer.parseInt(line.substring(7)))
						break;
					line = is.readLine();
				}
					

			//exit here if IOException was not thrown
			if(i < 10)
			{
				is.close();
				return i;
			}
			else
			{
				is.close();
				return -1;
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Unable to open mole_score file to write scores.");
			//exit here if IOException was thrown:
			return -1;
		} 
	}

	/**
	 * Attempts writing default scores to file, if no highscore file
	 * exists. If failed, program continues without a score file.
	 */
	public void write_default_scores_to_file() {
		File f = new File("mole_scores");
		if(!f.exists())
		{
			try {
				FileWriter os = new FileWriter("mole_scores");

				os.write("1  NIC 10000\n"
						+"2  SAL 5000\n"
						+"3  NTE 2500\n"
						+"4  DOB 2000\n"
						+"5  NOL 1500\n"
						+"6  GUS 1000\n"
						+"7  DEA 750\n"
						+"8  MON 500\n"
						+"9  ATM 250\n"
						+"10 DOL 100\n");
				os.close();

			} catch (IOException e) {
				e.printStackTrace();
				System.err.println("Failed to save scores to file.");
			}
		}
	}
}
