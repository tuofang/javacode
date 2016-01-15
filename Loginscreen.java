/**
* <h1>Patient Registry Management System</h1>
* 
* <p>
* This is a simple patient management system that can control the registration, edit and delete
* of patient information as well as import and export information in and out through text file.
* </p>
*
* @author Tuo Fang
* @version 1.0

*/
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Desktop;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextArea;

import java.awt.Color;

/**
 * The class contains all the components of login screen and main control of all the button and table listeners
 * ,display information and file management functions
 * @author  Tuo Fang
 * @version 1.0, Dec 2015
 */
public class Loginscreen {

	private JFrame frame;
	private JPanel cards;
	final static String LOGINPANEL = "Login panel";
	final static String REGISTRATIONPANEL = "Registration panel";
	final static String SHOWINFOPANEL = "Showinfo panel";
	final static String SHOWSPECIPANEL = "Showspeci panel";
	final static String SHOWEDITPANEL = "Showedit panel";
	final static String SHOWRESULTPANEL = "Showresult panel";
	final static int LABELWIDTH = 130;
	final static int BUTTONWIDTH = 130;
	final static int BUTTONHEIGHT = 30;
	final static int TEXTFIELDX = 180;
	final static int LABELX = 50;
	final static int FIELDX = 170;
	private int selectedrow;
	private int selectedrowresult;
	private boolean isFromSearch = false;
	private String currentdirectory;
	private File file;
	private Userinformation userinformation;
	private Showeditpanel showeditcard;
	private Showsearchresultpanel showresultcard;
	private Registerpanel registercard;
	private Showinfopanel showinfocard;
	private JTextField usertextField;
	private JPasswordField pswtextField;
	private JTextArea infolog;
	private JComboBox jComboBox;
	private JTextField searchField;
	private JLabel showpicLabel;
	private JLabel showpicLabel1;
	private JLabel showpicLabel2;
	private JLabel showpicLabel3;
	private JLabel showpicLabel4;
	private JLabel showpicLabel5;
	private JLabel conditionLink;
	private String imagePath;
	private String conditionimagePath1;
	private String conditionimagePath2;
	private String conditionimagePath3;
	private String conditionimagePath4;
	private String conditionimagePath5;
	private String firstName;
	private String userName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loginscreen window = new Loginscreen();
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
	public Loginscreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		// get the path 
		try{
		    File file = new File(".");
		    this.currentdirectory = file.getCanonicalPath();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		addComponentToPane(frame.getContentPane());
		
		
	}
	/**
	 * Card layout is used to switch among different panels. There are totally six panels 
	 * including login panel, register panel, edit panel, search result panel, information
	 * panel and specific information panel. All panels are added to pane. We can manage which
	 * to display and hide according to the need.
	 * @param pane initial pane that is added
	 */
	public void addComponentToPane(Container pane){
		
		// Login panel
		JPanel logincard = new JPanel();
		logincard.setBounds(100, 100,  1000, 800);
		logincard.setLayout(null);
		JLabel welcome = new JLabel("Welcome to Patient Registry");
		JLabel welcome1 = new JLabel("Management System");
		welcome.setBounds(250, 200, 480, 76);
		welcome1.setBounds(320,250,480,76);
		welcome.setFont(welcome.getFont().deriveFont(34.0f));
		welcome1.setFont(welcome1.getFont().deriveFont(34.0f));
		JLabel userlabel = new JLabel("Username");
		userlabel.setAlignmentY(Component.TOP_ALIGNMENT);
		userlabel.setVerticalAlignment(SwingConstants.BOTTOM);
		userlabel.setBounds(340, 380, LABELWIDTH, 20);
		logincard.add(userlabel);
	    logincard.add(welcome);
	    logincard.add(welcome1);
		//login panel
	    usertextField = new JTextField();
	    usertextField.setBounds(450, 380, 130, 20);
	    logincard.add(usertextField);
	    
	    pswtextField = new JPasswordField();
	    pswtextField.setBounds(450, 420, 130, 20);
	    logincard.add(pswtextField);
	    
	    JButton loginButton = new JButton("Login");
	    loginButton.setBounds(430, 480, 100, 30);
	    
	    loginButton.addActionListener(new ActionListener() {
	    	/**
		     * This is login button listener. Once clicked, all the accounts are searched to match
		     * the typed one, if so, jump to information panel, if not, show message dialog asking
		     *  to type username/password pair again.
		     */
	    	public void actionPerformed(ActionEvent e) {
	    		matchToFile();
	    		
	    	}
	    });
	    logincard.add(loginButton);
	    
	    
	    
	    JLabel pswlabel = new JLabel("Password");
	    pswlabel.setBounds(340, 420, 80, 20);
	    logincard.add(pswlabel);
	    cards = new JPanel(new CardLayout()); //definition of card layout
	    
	    
	    // register panel
	    registercard = new Registerpanel();
		
		JButton homeButton = new JButton("Back");
	    homeButton.setBounds(40, 10, 60, 30);
	    
	    homeButton.addActionListener(new ActionListener() {
	    	/**
	    	 * This a back-to-information-panel listener. Jump back to information panel
	    	 * once clicked.
	    	 */
	    	public void actionPerformed(ActionEvent e) {
	    		displayInfo();
	    		CardLayout cl = (CardLayout)(cards.getLayout());
	            cl.show(cards, SHOWINFOPANEL);
	    	}
	    });
	    registercard.add(homeButton);
		
	    JButton confirmButton = new JButton("Confirm");
	    confirmButton.setBounds(310, 630, BUTTONWIDTH, 30);
	    confirmButton.addActionListener(new ActionListener() {
	    	/**
	    	 * This is a confirm button listener. Typed information in the fields will be stored
	    	 * in the given text file once clicked.
	    	 */
	    	public void actionPerformed(ActionEvent e) {
	    		writeToFile();
	    		JOptionPane.showMessageDialog(null, "Patient Information Saved! Please Click Back Button");
	    	}
	    });
	    
	    JButton uploadButton = new JButton("Upload");
	    uploadButton.setBounds(560, 250, BUTTONWIDTH, 30);
	    uploadButton.addActionListener(new ActionListener() {
	    	/**
	    	 * This listener is used to upload personal picture from local. Only images with
	    	 * file extension of .jpg, .jpeg, .gif, .png can be choosed
	    	 */
	    	public void actionPerformed(ActionEvent e) {
	    		JFileChooser jfile = new JFileChooser();
	    		jfile.setCurrentDirectory(new File(System.getProperty("user.home")));
	    		jfile.setAcceptAllFileFilterUsed(false);
	    		FileNameExtensionFilter filter = new FileNameExtensionFilter("Images","jpg","gif","png","jpeg");
	    		jfile.addChoosableFileFilter(filter);
	    		int result = jfile.showOpenDialog(null);
	    		if(result == JFileChooser.APPROVE_OPTION){
	    			File selectedFile = jfile.getSelectedFile();
	    			String path = selectedFile.getAbsolutePath();
	    			imagePath = path;
	    			registercard.picLabel.setIcon(ResizeImage(path,registercard.picLabel));
	    		}
	    		else if (result == JFileChooser.CANCEL_OPTION){
	    			JOptionPane.showMessageDialog(null, "No File Selected!");
	    		}
	    	}
	    });
	    
	    
	    registercard.add(confirmButton);
	    registercard.add(uploadButton);
	    
	    
	    JButton uploadButton1 = new JButton("Upload");
	    uploadButton1.setBounds(50, 550, 100, 30);
	    uploadButton1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		JFileChooser jfile = new JFileChooser();
	    		jfile.setCurrentDirectory(new File(System.getProperty("user.home")));
	    		jfile.setAcceptAllFileFilterUsed(false);
	    		FileNameExtensionFilter filter = new FileNameExtensionFilter("Images","jpg","gif","png","jpeg");
	    		jfile.addChoosableFileFilter(filter);
	    		int result = jfile.showOpenDialog(null);
	    		if(result == JFileChooser.APPROVE_OPTION){
	    			File selectedFile = jfile.getSelectedFile();
	    			String path = selectedFile.getAbsolutePath();
	    			conditionimagePath1 = path;
	    			registercard.picLabel1.setIcon(ResizeImage(path,registercard.picLabel1));
	    		}
	    		else if (result == JFileChooser.CANCEL_OPTION){
	    			JOptionPane.showMessageDialog(null, "No File Selected!");
	    		}
	    	}
	    });
	    
	    registercard.add(uploadButton1);
	    
	    JButton uploadButton2 = new JButton("Upload");
	    uploadButton2.setBounds(170, 550, 100, 30);
	    uploadButton2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		JFileChooser jfile = new JFileChooser();
	    		jfile.setCurrentDirectory(new File(System.getProperty("user.home")));
	    		jfile.setAcceptAllFileFilterUsed(false);
	    		FileNameExtensionFilter filter = new FileNameExtensionFilter("Images","jpg","gif","png","jpeg");
	    		jfile.addChoosableFileFilter(filter);
	    		int result = jfile.showOpenDialog(null);
	    		if(result == JFileChooser.APPROVE_OPTION){
	    			File selectedFile = jfile.getSelectedFile();
	    			String path = selectedFile.getAbsolutePath();
	    			conditionimagePath2 = path;
	    			registercard.picLabel2.setIcon(ResizeImage(path,registercard.picLabel2));
	    		}
	    		else if (result == JFileChooser.CANCEL_OPTION){
	    			JOptionPane.showMessageDialog(null, "No File Selected!");
	    		}
	    	}
	    });
	    
	    registercard.add(uploadButton2);
	    
	    
	    JButton uploadButton3 = new JButton("Upload");
	    uploadButton3.setBounds(290, 550, 100, 30);
	    uploadButton3.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		JFileChooser jfile = new JFileChooser();
	    		jfile.setCurrentDirectory(new File(System.getProperty("user.home")));
	    		jfile.setAcceptAllFileFilterUsed(false);
	    		FileNameExtensionFilter filter = new FileNameExtensionFilter("Images","jpg","gif","png","jpeg");
	    		jfile.addChoosableFileFilter(filter);
	    		int result = jfile.showOpenDialog(null);
	    		if(result == JFileChooser.APPROVE_OPTION){
	    			File selectedFile = jfile.getSelectedFile();
	    			String path = selectedFile.getAbsolutePath();
	    			conditionimagePath3 = path;
	    			registercard.picLabel3.setIcon(ResizeImage(path,registercard.picLabel3));
	    		}
	    		else if (result == JFileChooser.CANCEL_OPTION){
	    			JOptionPane.showMessageDialog(null, "No File Selected!");
	    		}
	    	}
	    });
	    
	    registercard.add(uploadButton3);
	    
	    
	    JButton uploadButton4 = new JButton("Upload");
	    uploadButton4.setBounds(410, 550, 100, 30);
	    uploadButton4.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		JFileChooser jfile = new JFileChooser();
	    		jfile.setCurrentDirectory(new File(System.getProperty("user.home")));
	    		jfile.setAcceptAllFileFilterUsed(false);
	    		FileNameExtensionFilter filter = new FileNameExtensionFilter("Images","jpg","gif","png","jpeg");
	    		jfile.addChoosableFileFilter(filter);
	    		int result = jfile.showOpenDialog(null);
	    		if(result == JFileChooser.APPROVE_OPTION){
	    			File selectedFile = jfile.getSelectedFile();
	    			String path = selectedFile.getAbsolutePath();
	    			conditionimagePath4 = path;
	    			registercard.picLabel4.setIcon(ResizeImage(path,registercard.picLabel4));
	    		}
	    		else if (result == JFileChooser.CANCEL_OPTION){
	    			JOptionPane.showMessageDialog(null, "No File Selected!");
	    		}
	    	}
	    });
	    
	    registercard.add(uploadButton4);
	    
	    JButton uploadButton5 = new JButton("Upload");
	    uploadButton5.setBounds(530, 550, 100, 30);
	    uploadButton5.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		JFileChooser jfile = new JFileChooser();
	    		jfile.setCurrentDirectory(new File(System.getProperty("user.home")));
	    		jfile.setAcceptAllFileFilterUsed(false);
	    		FileNameExtensionFilter filter = new FileNameExtensionFilter("Images","jpg","gif","png","jpeg");
	    		jfile.addChoosableFileFilter(filter);
	    		int result = jfile.showOpenDialog(null);
	    		if(result == JFileChooser.APPROVE_OPTION){
	    			File selectedFile = jfile.getSelectedFile();
	    			String path = selectedFile.getAbsolutePath();
	    			conditionimagePath5 = path;
	    			registercard.picLabel5.setIcon(ResizeImage(path,registercard.picLabel5));
	    		}
	    		else if (result == JFileChooser.CANCEL_OPTION){
	    			JOptionPane.showMessageDialog(null, "No File Selected!");
	    		}
	    	}
	    });
	    
	    registercard.add(uploadButton5);
	    
	    
	    cards.add(logincard, LOGINPANEL);
	    cards.add(registercard, REGISTRATIONPANEL);
	    // show information panel
	    showinfocard = new Showinfopanel();
	    cards.add(showinfocard,SHOWINFOPANEL);
	   
	    
        
	    showinfocard.jTable.addMouseListener(new MouseAdapter() {
	    	/**
	    	 * When a row is clicked, it jumps to information panel refers to selected record
	    	 */
	    	public void mouseClicked(MouseEvent e) {
	    		if (e.getClickCount() == 2){
	    			JTable target = (JTable)e.getSource();
	    		    selectedrow = target.getSelectedRow();
	    		    firstName = showinfocard.jTable.getValueAt(selectedrow, 0).toString();
	    		    infolog.setText(null);
	    		    infolog.append("First Name: " + showinfocard.jTable.getValueAt(selectedrow, 0).toString() + "\n");
	    		    infolog.append("Last Name: " + showinfocard.jTable.getValueAt(selectedrow, 1).toString() + "\n");
	    		    infolog.append("Date of Birth: " + showinfocard.jTable.getValueAt(selectedrow, 2).toString() + "\n");
	    		    infolog.append("Address: " + showinfocard.jTable.getValueAt(selectedrow, 3).toString() + "\n");
	    		    infolog.append("Emergency Phone Number: " + showinfocard.jTable.getValueAt(selectedrow, 4).toString() + "\n");
	    		    infolog.append("Medical Condition: " + showinfocard.jTable.getValueAt(selectedrow, 5).toString() + "\n");
	    		    infolog.append("Appointments: " + showinfocard.jTable.getValueAt(selectedrow, 6).toString() + "\n");
	    		    infolog.append("Billings: " + showinfocard.jTable.getValueAt(selectedrow, 7).toString() + "\n");
	    		    infolog.append("Comments: " + showinfocard.jTable.getValueAt(selectedrow, 8).toString() + "\n");
	    		    String[] conditions = showinfocard.jTable.getValueAt(selectedrow, 9).toString().split("\t");
	    		    if (conditions[0] == null){
	    		    	showpicLabel.setText("No picture, please upload!");
	    		    }
	    		    else{
	    		        showpicLabel.setIcon(ResizeImage(conditions[0],showpicLabel));
	    		    }
	    		    showpicLabel1.setIcon(ResizeImage(conditions[1],showpicLabel1));
	    		    showpicLabel2.setIcon(ResizeImage(conditions[2],showpicLabel2));
	    		    showpicLabel3.setIcon(ResizeImage(conditions[3],showpicLabel3));
	    		    showpicLabel4.setIcon(ResizeImage(conditions[4],showpicLabel4));
	    		    showpicLabel5.setIcon(ResizeImage(conditions[5],showpicLabel5));
	    		    conditionLink.setText(showinfocard.jTable.getValueAt(selectedrow, 5).toString());
	    		    conditionLink.addMouseListener(new MouseAdapter() {
	    		    	/**
	    		    	 * Clickable label and link to wikipedia page.
	    		    	 */
	    		        public void mouseClicked(MouseEvent e) {
	    		             if (e.getClickCount() > 0) {
	    		                 if (Desktop.isDesktopSupported()) {
	    		                       Desktop desktop = Desktop.getDesktop();
	    		                       try {
	    		                    	   String[] conditions = showinfocard.jTable.getValueAt(selectedrow, 5).toString().split(" ");
	    		                    	   String condition = conditions[0];
	    		                    	   for (int i =1; i< conditions.length;i++){
	    		                    		   condition = condition + "_" + conditions[i];
	    		                    	   }
	    		                    		   
	    		                           URI uri = new URI("http://en.wikipedia.org/wiki/" 
	    		                                      + condition);
	    		                           desktop.browse(uri);
	    		                           System.out.println("sdf");
	    		                       } catch (IOException ex) {
	    		                           ex.printStackTrace();
	    		                       } catch (URISyntaxException ex) {
	    		                           ex.printStackTrace();
	    		                       }
	    		               }
	    		             }
	    		          }
	    		        });
	    		    isFromSearch = false;
	    		    CardLayout cl = (CardLayout)(cards.getLayout());
	                cl.show(cards, SHOWSPECIPANEL);
	    		}
	    	}
	    	});
		JScrollPane logScrollPane = new JScrollPane(showinfocard.jTable);
        logScrollPane.setBounds(50, 50, 900, 500);
        showinfocard.setLayout(null);
        
        JButton registerButton = new JButton("Register");
	    registerButton.setBounds(450, 570, BUTTONWIDTH, 30);
	    registerButton.addActionListener(new ActionListener() {
	    	/**
	    	 * When register button is clicked, it jumps to register panel and ask for information
	    	 */
	    	public void actionPerformed(ActionEvent e) {
	    		registercard.regisnameField.setText(null);
	    		registercard.regislnameField.setText(null);
	    		registercard.regisdobField.setText(null);
	    		registercard.regisaddressField.setText(null);
	    		registercard.regisphoneField.setText(null);
	    		registercard.regisconField.setText(null);
	    		registercard.regisappField.setText(null);
	    		registercard.regisbillField.setText(null);
	    		registercard.regiscomField.setText(null);
	    		registercard.picLabel.setIcon(null);
	    		registercard.picLabel1.setIcon(null);
	    		registercard.picLabel2.setIcon(null);
	    		registercard.picLabel3.setIcon(null);
	    		registercard.picLabel4.setIcon(null);
	    		registercard.picLabel5.setIcon(null);
	    		imagePath = null;
	    		conditionimagePath1 = null;
	    		conditionimagePath2 = null;
	    		conditionimagePath3 = null;
	    		conditionimagePath4 = null;
	    		conditionimagePath5 = null;
	    		CardLayout cl = (CardLayout)(cards.getLayout());
	            cl.show(cards, REGISTRATIONPANEL);
	    	}
	    });
	    showinfocard.add(registerButton);
	    
        JButton backtohomeButton = new JButton("Logout");
	    backtohomeButton.setBounds(40, 10, 130, 30);
	    backtohomeButton.addActionListener(new ActionListener() {
	    	/**
	    	 * Back to login panel button listener
	    	 */
	    	public void actionPerformed(ActionEvent e) {
	    		int reply = JOptionPane.showConfirmDialog(
		                null,
		                "Do you confirm to logout?",
		                "Logout Confirmation",
		                JOptionPane.YES_NO_OPTION);
	    		if (reply == JOptionPane.YES_OPTION){
	    		    usertextField.setText(null);
	    		    pswtextField.setText(null);
	    		    CardLayout cl = (CardLayout)(cards.getLayout());
	                cl.show(cards, LOGINPANEL);
	    		}
	    	}
	    });
	    
	    JButton searchButton = new JButton("Search");
	    searchButton.setBounds(670, 610, 130, 30);
	    searchButton.addActionListener(new ActionListener(){
	    	/**
	    	 * Search all the corresponding records based on the stored field
	    	 */
	    	public void actionPerformed(ActionEvent e){
	    		int index = jComboBox.getSelectedIndex();
	    		int rows = showinfocard.jTable.getRowCount();
	    		DefaultTableModel model = (DefaultTableModel) showresultcard.jTable.getModel();
				int rowsintable = model.getRowCount(); 
				for(int i = rowsintable - 1; i >=0; i--)
				{
				   model.removeRow(i); 
				}
	    		for (int i = 0;i < rows; i++){
	    			if (showinfocard.jTable.getValueAt(i, index).toString().toLowerCase().contains(searchField.getText().toLowerCase())){
	    				Vector row = new Vector();
						for (int j = 0; j < showinfocard.jTable.getColumnCount();j++){
							row.add(showinfocard.jTable.getValueAt(i, j).toString());
						}
						model.addRow(row);
	    			}
	    		}
	    		CardLayout cl = (CardLayout)(cards.getLayout());
	            cl.show(cards, SHOWRESULTPANEL);
	    		
	    	}
	    });
	    
	    JLabel basedonLabel = new JLabel("Based on");
	    basedonLabel.setBounds(240, 610, 100, 30);
	    
	    jComboBox = new JComboBox ();
	    jComboBox.setBounds(350, 610, 130, 30);
	    
	    String[] items = {"First Name", "Last Name", "Date of Birth", "Address","Phone Number","Condition"};
	    for (int i = 0; i < 6; i++){
	    	jComboBox.addItem(items[i]);
	    }
	    JButton importButton = new JButton("Import");
	    importButton.setBounds(250, 650, BUTTONWIDTH, 30);
	    importButton.addActionListener(new ActionListener(){
	    	/**
	    	 * Import local text file to system and show records to information panel
	    	 * immediately that are in the imported file
	    	 */
	    	public void actionPerformed(ActionEvent e){
	    		JFileChooser jFile = new JFileChooser();
	    		jFile.setCurrentDirectory(new File(System.getProperty("user.home")));
	    		int result = jFile.showOpenDialog(null);
	    		if (result == JFileChooser.APPROVE_OPTION){
	    			File openedFile = jFile.getSelectedFile();
	    			String openpath = openedFile.getAbsolutePath();
	    			File openfile = new File(openpath);
	    			try{
	    				BufferedWriter writer;
	    			    writer = new BufferedWriter(new FileWriter(currentdirectory+"/UserInformation.txt",true));
	    				if (openfile.exists() && openfile.isFile()){
	    					InputStream is = new FileInputStream(openfile);
	    					BufferedReader in = new BufferedReader(new InputStreamReader(is));
	    					String line;
	    					while((line = in.readLine()) != null){
	    						writer.write(line + "\n");
	    					}
	    					in.close();
	    					writer.close();
	    				}
	    			}
	    			catch(Exception ex){
	    				System.out.println("readFile() exception:" + ex.getMessage());
	    		    	ex.printStackTrace();
	    			}
	    			displayInfo();
	    			CardLayout cl = (CardLayout)(cards.getLayout());
		            cl.show(cards, SHOWINFOPANEL);
	    		}
	    		else if (result == JFileChooser.CANCEL_OPTION){
	    			JOptionPane.showMessageDialog(null, "No File Selected!");
	    		}
	    	}
	    });
	    JButton exportButton = new JButton("Export");
	    exportButton.setBounds(550, 650, BUTTONWIDTH, 30);
	    exportButton.addActionListener(new ActionListener() {
	    	/**
	    	 * Export selected records to a custom file.
	    	 */
	    	public void actionPerformed(ActionEvent e) {
	    		int[] row = showinfocard.jTable.getSelectedRows();
	    		if (row.length ==0){
	    			JOptionPane.showMessageDialog(null, "No record selected! Please selecte at least one");
	    		}
	    		else{
	    		JFileChooser jfile = new JFileChooser();
	    		jfile.setCurrentDirectory(new File(System.getProperty("user.home")));
	    		FileNameExtensionFilter filter = new FileNameExtensionFilter("*.txt","*.csv","*.dat");
	    		jfile.addChoosableFileFilter(filter);
	    		int result = jfile.showSaveDialog(null);
	    		if(result == JFileChooser.APPROVE_OPTION){
	    			File selectedFile = jfile.getSelectedFile();
	    			String path = selectedFile.getAbsolutePath();
	    			File newFile = new File(path);
	    			try {
	    		        newFile.createNewFile();
	    		    } catch (IOException ex) {
	    		        // TODO Auto-generated catch block
	    		        ex.printStackTrace();
	    		    }
	    			try{
	    			    BufferedWriter writer;
	    			    writer = new BufferedWriter(new FileWriter(path,true));
	    			    int[] rows = showinfocard.jTable.getSelectedRows();
	    			    for (int i = 0; i < rows.length; i++){
	    			    	String[] conditions = showinfocard.jTable.getValueAt(rows[i], 9).toString().split("\t");
	    			        userinformation = new Userinformation(showinfocard.jTable.getValueAt(rows[i], 0).toString(),
	    			        		showinfocard.jTable.getValueAt(rows[i], 1).toString(), showinfocard.jTable.getValueAt(rows[i], 2).toString(), 
	    			        		showinfocard.jTable.getValueAt(rows[i], 3).toString(),showinfocard.jTable.getValueAt(rows[i], 4).toString(),
	    			        		showinfocard.jTable.getValueAt(rows[i], 5).toString(),showinfocard.jTable.getValueAt(rows[i], 6).toString(),
	    			        		showinfocard.jTable.getValueAt(rows[i], 7).toString(),showinfocard.jTable.getValueAt(rows[i], 8).toString(),
	    			        	conditions[0], conditions[1], conditions[2], conditions[3], conditions[4], conditions[5]);
	    			        String string = userinformation.ToString();
	    			        writer.write(string);
	    			    }
	                writer.close();
	    			}
	    			catch(Exception excep){
	    				excep.printStackTrace();
	    			}
	    			System.out.println(path);
	    		}
	    		else if (result == JFileChooser.CANCEL_OPTION){
	    			JOptionPane.showMessageDialog(null, "No File Created or Selected!");
	    		}
	    	}
	    	}
	    });
	    
	    searchField = new JTextField();
	    searchField.setBounds(520, 610, 100, 30);
	    showinfocard.add(searchField);
	    showinfocard.add(jComboBox);
	    showinfocard.add(basedonLabel);
	    showinfocard.add(searchButton);
	    showinfocard.add(backtohomeButton);
	    showinfocard.add(exportButton);
	    showinfocard.add(importButton);
	    showinfocard.add(logScrollPane);
	    
	    
	    //show search result panel
	    
	    showresultcard = new Showsearchresultpanel();
	    JButton backtoinfomButton = new JButton("Back");
	    backtoinfomButton.setBounds(40, 10, 60, 30);
	    backtoinfomButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		displayInfo();
	    		CardLayout cl = (CardLayout)(cards.getLayout());
	            cl.show(cards, 	SHOWINFOPANEL);
	    		
	    		
	    	}
	    });
	    
	    JButton exportButtonSearch = new JButton("Export");
	    exportButtonSearch.setBounds(450, 600, 130, 30);
	    exportButtonSearch.addActionListener(new ActionListener(){
	    	
	    	public void actionPerformed(ActionEvent e){
	    		int[] row = showresultcard.jTable.getSelectedRows();
	    		if (row.length ==0){
	    			JOptionPane.showMessageDialog(null, "No record selected! Please selecte at least one");
	    		}
	    		else{
	    		JFileChooser jfile = new JFileChooser();
	    		jfile.setCurrentDirectory(new File(System.getProperty("user.home")));
	    		FileNameExtensionFilter filter = new FileNameExtensionFilter("*.txt","*.csv","*.dat");
	    		jfile.addChoosableFileFilter(filter);
	    		int result = jfile.showSaveDialog(null);
	    		if(result == JFileChooser.APPROVE_OPTION){
	    			File selectedFile = jfile.getSelectedFile();
	    			String path = selectedFile.getAbsolutePath();
	    			File newFile = new File(path);
	    			try {
	    		        newFile.createNewFile();
	    		    } catch (IOException ex) {
	    		        // TODO Auto-generated catch block
	    		        ex.printStackTrace();
	    		    }
	    			try{
	    			    BufferedWriter writer;
	    			    writer = new BufferedWriter(new FileWriter(path,true));
	    			    int[] rows = showresultcard.jTable.getSelectedRows();
	    			    for (int i = 0; i < rows.length; i++){
	    			    	String[] conditions = showresultcard.jTable.getValueAt(rows[i], 9).toString().split("\t");
	    			        userinformation = new Userinformation(showresultcard.jTable.getValueAt(rows[i], 0).toString(),
	    			        		showresultcard.jTable.getValueAt(rows[i], 1).toString(), showresultcard.jTable.getValueAt(rows[i], 2).toString(), 
	    			        		showresultcard.jTable.getValueAt(rows[i], 3).toString(),showresultcard.jTable.getValueAt(rows[i], 4).toString(),
	    			        		showresultcard.jTable.getValueAt(rows[i], 5).toString(),showresultcard.jTable.getValueAt(rows[i], 6).toString(),
	    			        		showresultcard.jTable.getValueAt(rows[i], 7).toString(),showresultcard.jTable.getValueAt(rows[i], 8).toString(),
	    			        	conditions[0], conditions[1], conditions[2], conditions[3], conditions[4], conditions[5]);
	    			        String string = userinformation.ToString();
	    			        writer.write(string);
	    			    }
	                writer.close();
	    			}
	    			catch(Exception excep){
	    				excep.printStackTrace();
	    			}
	    			System.out.println(path);
	    		}
	    		else if (result == JFileChooser.CANCEL_OPTION){
	    			JOptionPane.showMessageDialog(null, "No File Created or Selected!");
	    		}
	    	}
	    	}
	    });
	    
	    showresultcard.add(exportButtonSearch);
	    showresultcard.jTable.addMouseListener(new MouseAdapter() {
	    	public void mouseClicked(MouseEvent e) {
	    		if (e.getClickCount() == 2){
	    		selectedrowresult = showresultcard.jTable.getSelectedRow();
	    		firstName = showresultcard.jTable.getValueAt(selectedrowresult, 0).toString();
	    		infolog.setText(null);
	    		infolog.append("First Name: " + showresultcard.jTable.getValueAt(showresultcard.jTable.getSelectedRow(), 0).toString() + "\n");
	    		infolog.append("Last Name: " + showresultcard.jTable.getValueAt(showresultcard.jTable.getSelectedRow(), 1).toString() + "\n");
	    		infolog.append("Date of Birth: " + showresultcard.jTable.getValueAt(showresultcard.jTable.getSelectedRow(), 2).toString() + "\n");
	    		infolog.append("Address: " + showresultcard.jTable.getValueAt(showresultcard.jTable.getSelectedRow(), 3).toString() + "\n");
	    		infolog.append("Emergency Phone Number: " + showresultcard.jTable.getValueAt(showresultcard.jTable.getSelectedRow(), 4).toString() + "\n");
	    		infolog.append("Medical Condition: " + showresultcard.jTable.getValueAt(showresultcard.jTable.getSelectedRow(), 5).toString() + "\n");
	    		infolog.append("Appointments: " + showresultcard.jTable.getValueAt(showresultcard.jTable.getSelectedRow(), 6).toString() + "\n");
	    		infolog.append("Billings: " + showresultcard.jTable.getValueAt(showresultcard.jTable.getSelectedRow(), 7).toString() + "\n");
	    		infolog.append("Comments: " + showresultcard.jTable.getValueAt(showresultcard.jTable.getSelectedRow(), 8).toString() + "\n");
	    		String[] conditions = showresultcard.jTable.getValueAt(selectedrowresult, 9).toString().split("\t");
	    		
	    		showpicLabel.setIcon(ResizeImage(conditions[0],showpicLabel));
	    		showpicLabel1.setIcon(ResizeImage(conditions[1],showpicLabel1));
	    		showpicLabel2.setIcon(ResizeImage(conditions[2],showpicLabel2));
	    		showpicLabel3.setIcon(ResizeImage(conditions[3],showpicLabel3));
	    		showpicLabel4.setIcon(ResizeImage(conditions[4],showpicLabel4));
	    		showpicLabel5.setIcon(ResizeImage(conditions[5],showpicLabel5));
	    		isFromSearch = true;
	    		CardLayout cl = (CardLayout)(cards.getLayout());
	            cl.show(cards, SHOWSPECIPANEL);
	    	}
	    	}
	    	});
	    showresultcard.add(backtoinfomButton);
	    cards.add(showresultcard,SHOWRESULTPANEL);
	    
	    //show specific information panel
	    
	    
	    JPanel showspecicard = new JPanel();
	    infolog = new JTextArea();
	    
	    JScrollPane infologScrollPane = new JScrollPane(infolog);
	    infologScrollPane.setBounds(160, 50, 580, 300);
	    showspecicard.setLayout(null);
	    
	    JButton backButton = new JButton("Back");
	    backButton.setBounds(40, 10, 60, 30);
	    backButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if (isFromSearch == true){
	    			int index = jComboBox.getSelectedIndex();
		    		int rows = showinfocard.jTable.getRowCount();
		    		DefaultTableModel model = (DefaultTableModel) showresultcard.jTable.getModel();
					int rowsintable = model.getRowCount(); 
					for(int i = rowsintable - 1; i >=0; i--)
					{
					   model.removeRow(i); 
					}
		    		for (int i = 0;i < rows; i++){
		    			if (showinfocard.jTable.getValueAt(i, index).toString().toLowerCase().contains(searchField.getText().toLowerCase())){
		    				Vector row = new Vector();
							for (int j = 0; j < showinfocard.jTable.getColumnCount();j++){
								row.add(showinfocard.jTable.getValueAt(i, j).toString());
							}
							model.addRow(row);
		    			}
		    		}
		    		CardLayout cl = (CardLayout)(cards.getLayout());
		            cl.show(cards, SHOWRESULTPANEL);
	    		}
	    		else{
	    		displayInfo();
	    		CardLayout cl = (CardLayout)(cards.getLayout());
	            cl.show(cards, SHOWINFOPANEL);
	    		}
	    	}
	    });
	    showspecicard.add(backButton);
	    
	    showpicLabel = new JLabel("No picture!");
        showpicLabel.setBounds(50,50,100,100);
        showspecicard.add(showpicLabel);
        
        JLabel conditionLabel = new JLabel("Medical Condition: ");
        conditionLabel.setBounds(160, 360, 130, 30);
        showspecicard.add(conditionLabel);
        JLabel conditionLabel2 = new JLabel("Medical Condition (Pictures): ");
        conditionLabel2.setBounds(160, 400, 200, 30);
        showspecicard.add(conditionLabel2);
        
        showpicLabel1 = new JLabel();
        showpicLabel1.setBounds(160,450,100,100);
        showspecicard.add(showpicLabel1);
        
        showpicLabel2 = new JLabel();
        showpicLabel2.setBounds(280,450,100,100);
        showspecicard.add(showpicLabel2);
        
        showpicLabel3 = new JLabel();
        showpicLabel3.setBounds(400,450,100,100);
        showspecicard.add(showpicLabel3);
        
        showpicLabel4 = new JLabel();
        showpicLabel4.setBounds(520,450,100,100);
        showspecicard.add(showpicLabel4);
        
        showpicLabel5 = new JLabel();
        showpicLabel5.setBounds(640,450,100,100);
        showspecicard.add(showpicLabel5);
        
        conditionLink = new JLabel();
        conditionLink.setBounds(300,360,100,30);
        //conditionLink.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        conditionLink.addMouseListener(new MouseAdapter(){
        	public void mouseEntered(MouseEvent e){
        		conditionLink.setForeground(Color.BLUE.darker());
        		conditionLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        	}
        });
        showspecicard.add(conditionLink);
	    JButton editButton = new JButton("Edit");
	    editButton.setBounds(200, 570, 130, 30);
	    editButton.addActionListener(new ActionListener() {
	    	/**
	    	 * It jumps to edit panel when clicking edit button.
	    	 */
	    	public void actionPerformed(ActionEvent e) {
	    		Userinformation patient = searchInfo(firstName, currentdirectory + "/Userinformation.txt");
	    		showeditcard.regisnameField.setText(patient.firstname);
	    		showeditcard.regislnameField.setText(patient.lastname);
	    		showeditcard.regisdobField.setText(patient.dob);
	    		showeditcard.regisaddressField.setText(patient.address);
	    		showeditcard.regisphoneField.setText(patient.phone);
	    		showeditcard.regisconField.setText(patient.condition);
	    		showeditcard.regisappField.setText(patient.appointments);
	    		showeditcard.regisbillField.setText(patient.billings);
	    		showeditcard.regiscomField.setText(patient.comments);
	    		String[] conditions = new String[6];
	    		conditions[0] = patient.imagepath;
	    		for (int i = 1; i<6;i++){
	    			conditions[i]= patient.conditionimagePath[i-1];
	    		}
	    		if (conditions[0].equals("null")){
	    			showeditcard.editpicLabel.setText("***Upload picture***");
	    		}
	    		else{
	    		    showeditcard.editpicLabel.setIcon(ResizeImage(conditions[0],
	    				showeditcard.editpicLabel));
	    		}
	    		if (conditions[1].equals("null")){
	    			showeditcard.editpicLabel1.setText("Upload picture");
	    			
	    		}
	    		else{
	    		    showeditcard.editpicLabel1.setIcon(ResizeImage(conditions[1],
	    				showeditcard.editpicLabel1));
	    		    
	    		}
	    		if (conditions[2] == null){
	    			showeditcard.editpicLabel2.setText("Upload picture");
	    		}
	    		showeditcard.editpicLabel2.setIcon(ResizeImage(conditions[2],
	    				showeditcard.editpicLabel2));
	    		if (conditions[3] == null){
	    			showeditcard.editpicLabel3.setText("Upload picture");
	    		}
	    		showeditcard.editpicLabel3.setIcon(ResizeImage(conditions[3],
	    				showeditcard.editpicLabel3));
	    		if (conditions[4] == null){
	    			showeditcard.editpicLabel4.setText("Upload picture");
	    		}
	    		showeditcard.editpicLabel4.setIcon(ResizeImage(conditions[4],
	    				showeditcard.editpicLabel4));
	    		if (conditions[5] == null){
	    			showeditcard.editpicLabel5.setText("Upload picture");
	    		}
	    		showeditcard.editpicLabel5.setIcon(ResizeImage(conditions[5],
	    				showeditcard.editpicLabel5));
	    		imagePath = conditions[0];
	    		conditionimagePath1 = conditions[1];
	    		conditionimagePath2 = conditions[2];
	    		conditionimagePath3 = conditions[3];
	    		conditionimagePath4 = conditions[4];
	    		conditionimagePath5 = conditions[5];
	    		CardLayout cl = (CardLayout)(cards.getLayout());
	            cl.show(cards, SHOWEDITPANEL);
	    	}
	    });
	    
	    JButton deleteButton = new JButton("Delete");
	    deleteButton.setBounds(440, 570, 130, 30);
	    deleteButton.addActionListener(new ActionListener(){
	    	/**
	    	 * Delete the patient's record after confirmation.
	    	 */
	    	public void actionPerformed(ActionEvent e){
	    		Userinformation patient = searchInfo(firstName, currentdirectory + "/Userinformation.txt");
	            int reply = JOptionPane.showConfirmDialog(
	                null,
	                "Are you sure to delete the record for patient:" + 
	                		patient.firstname + " " + patient.lastname,
	                "Delete Confirmation",
	                JOptionPane.YES_NO_OPTION);

	            if(reply == JOptionPane.YES_OPTION){
	            	removeLineFromFile(currentdirectory+"/Userinformation.txt",
	            			patient.firstname);
	            	displayInfo();
		    		CardLayout cl = (CardLayout)(cards.getLayout());
		            cl.show(cards, SHOWINFOPANEL);
	            }
	            
	    		
	    	}
	    });
	    showspecicard.add(deleteButton);
	    showspecicard.add(backButton);
	    showspecicard.add(editButton);
	    showspecicard.add(infologScrollPane);
	    cards.add(showspecicard,SHOWSPECIPANEL);
	    
	    //edit information panel
	    showeditcard = new Showeditpanel();
	    JButton backtoinfoButton = new JButton("Back");
	    backtoinfoButton.setBounds(40, 10, 60, 30);
	    backtoinfoButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		CardLayout cl = (CardLayout)(cards.getLayout());
	            cl.show(cards, SHOWSPECIPANEL);
	    	}
	    });
	    showeditcard.add(backtoinfoButton);
	    JButton editconfirmButton = new JButton("Confirm");
	    editconfirmButton.setBounds(310, 630, BUTTONWIDTH, 30);
	    editconfirmButton.addActionListener(new ActionListener() {
	    	/**
	    	 * Save changes to existed record after clicking confirm button
	    	 */
	    	public void actionPerformed(ActionEvent e) {
	    		editToFile();
	    		JOptionPane.showMessageDialog(null, "Change to patient information is saved!");
	    		//add info
	    		infolog.setText(null);
	    		infolog.append("First Name: " + showeditcard.regisnameField.getText() + "\n");
	    		infolog.append("Last Name: " + showeditcard.regislnameField.getText() + "\n");
	    		infolog.append("Date of Birth: " + showeditcard.regisdobField.getText()+ "\n");
	    		infolog.append("Address: " + showeditcard.regisaddressField.getText() + "\n");
	    		infolog.append("Emergency Phone Number: " + showeditcard.regisphoneField.getText() + "\n");
	    		infolog.append("Password: " + showeditcard.regisconField.getText() + "\n");
	    		infolog.append("Medical Condition: " + showeditcard.regisconField.getText() + "\n");
	    		infolog.append("Appointments: " + showeditcard.regisappField.getText() + "\n");
	    		infolog.append("Billings: " + showeditcard.regisbillField.getText() + "\n");
	    		infolog.append("Comments: " + showeditcard.regiscomField.getText() + "\n");
	    		showpicLabel.setIcon(ResizeImage(imagePath,showpicLabel));
	    		showpicLabel1.setIcon(ResizeImage(conditionimagePath1,showpicLabel1));
	    		showpicLabel2.setIcon(ResizeImage(conditionimagePath2,showpicLabel2));
	    		showpicLabel3.setIcon(ResizeImage(conditionimagePath3,showpicLabel3));
	    		showpicLabel4.setIcon(ResizeImage(conditionimagePath4,showpicLabel4));
	    		showpicLabel5.setIcon(ResizeImage(conditionimagePath5,showpicLabel5));
	    		CardLayout cl = (CardLayout)(cards.getLayout());
	            cl.show(cards, SHOWSPECIPANEL);
	    	}
	    });
	    showeditcard.add(editconfirmButton);
	    
	    JButton changeButton = new JButton("Switch");
	    changeButton.setBounds(460, 250, BUTTONWIDTH, 30);
	    changeButton.addActionListener(new ActionListener() {
	    	/**
	    	 * Switch pictures by uploading local pictures.
	    	 */
	    	public void actionPerformed(ActionEvent e) {
	    		JFileChooser jfile = new JFileChooser();
	    		jfile.setCurrentDirectory(new File(System.getProperty("user.home")));
	    		jfile.setAcceptAllFileFilterUsed(false);
	    		FileFilter filter = new FileNameExtensionFilter("Images","jpg","gif","png","jpeg");
	    		//FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images","jpg","gif","png");
	    		jfile.addChoosableFileFilter(filter);
	    		int result = jfile.showOpenDialog(null);
	    		if(result == JFileChooser.APPROVE_OPTION){
	    			File selectedFile = jfile.getSelectedFile();
	    			String path = selectedFile.getAbsolutePath();
	    			imagePath = path;
	    			showeditcard.editpicLabel.setIcon(ResizeImage(path,showeditcard.editpicLabel));
	    		}
	    		else if (result == JFileChooser.CANCEL_OPTION){
	    			JOptionPane.showMessageDialog(null, "No File Selected!");
	    		}
	    	}
	    });
	    showeditcard.add(changeButton);
	    
	    showeditcard.changeButton1 = new JButton("Upload");
	    showeditcard.changeButton1.setBounds(50, 550, 100, 30);
	    showeditcard.changeButton1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		JFileChooser jfile = new JFileChooser();
	    		jfile.setCurrentDirectory(new File(System.getProperty("user.home")));
	    		jfile.setAcceptAllFileFilterUsed(false);
	    		FileFilter filter = new FileNameExtensionFilter("Images","jpg","gif","png","jpeg");
	    		//FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images","jpg","gif","png");
	    		jfile.addChoosableFileFilter(filter);
	    		int result = jfile.showOpenDialog(null);
	    		if(result == JFileChooser.APPROVE_OPTION){
	    			File selectedFile = jfile.getSelectedFile();
	    			String path = selectedFile.getAbsolutePath();
	    			conditionimagePath1 = path;
	    			showeditcard.editpicLabel1.setIcon(ResizeImage(path,showeditcard.editpicLabel1));
	    		}
	    		else if (result == JFileChooser.CANCEL_OPTION){
	    			JOptionPane.showMessageDialog(null, "No File Selected!");
	    		}
	    	}
	    });
	    showeditcard.add(showeditcard.changeButton1);
	    JButton deleteButton1 = new JButton("Delete");
	    deleteButton1.setBounds(50, 580, 100, 30);
	    deleteButton1.addActionListener(new ActionListener(){
	    	/**
	    	 * Delete existing pictures
	    	 */
	    	public void actionPerformed(ActionEvent e){
	    		conditionimagePath1 = null;
	    		showeditcard.editpicLabel1.setIcon(null);
	    		JOptionPane.showMessageDialog(null, "Picture deleted!");
	    	}
	    });
	    showeditcard.add(deleteButton1);
	    
	    showeditcard.changeButton2 = new JButton("Upload");
	    showeditcard.changeButton2.setBounds(170, 550, 100, 30);
	    showeditcard.changeButton2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		JFileChooser jfile = new JFileChooser();
	    		jfile.setCurrentDirectory(new File(System.getProperty("user.home")));
	    		jfile.setAcceptAllFileFilterUsed(false);
	    		FileFilter filter = new FileNameExtensionFilter("Images","jpg","gif","png","jpeg");
	    		//FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images","jpg","gif","png");
	    		jfile.addChoosableFileFilter(filter);
	    		int result = jfile.showOpenDialog(null);
	    		if(result == JFileChooser.APPROVE_OPTION){
	    			File selectedFile = jfile.getSelectedFile();
	    			String path = selectedFile.getAbsolutePath();
	    			conditionimagePath2 = path;
	    			showeditcard.editpicLabel2.setIcon(ResizeImage(path,showeditcard.editpicLabel2));
	    		}
	    		else if (result == JFileChooser.CANCEL_OPTION){
	    			JOptionPane.showMessageDialog(null, "No File Selected!");
	    		}
	    	}
	    });
	    showeditcard.add(showeditcard.changeButton2);
	    JButton deleteButton2 = new JButton("Delete");
	    deleteButton2.setBounds(170, 580, 100, 30);
	    deleteButton2.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		conditionimagePath2 = null;
	    		showeditcard.editpicLabel2.setIcon(null);
	    		JOptionPane.showMessageDialog(null, "Picture deleted!");
	    	}
	    });
	    showeditcard.add(deleteButton2);
	    
	    showeditcard.changeButton3 = new JButton("Upload");
	    showeditcard.changeButton3.setBounds(290, 550, 100, 30);
	    showeditcard.changeButton3.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		JFileChooser jfile = new JFileChooser();
	    		jfile.setCurrentDirectory(new File(System.getProperty("user.home")));
	    		jfile.setAcceptAllFileFilterUsed(false);
	    		FileFilter filter = new FileNameExtensionFilter("Images","jpg","gif","png","jpeg");
	    		//FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images","jpg","gif","png");
	    		jfile.addChoosableFileFilter(filter);
	    		int result = jfile.showOpenDialog(null);
	    		if(result == JFileChooser.APPROVE_OPTION){
	    			File selectedFile = jfile.getSelectedFile();
	    			String path = selectedFile.getAbsolutePath();
	    			conditionimagePath3 = path;
	    			showeditcard.editpicLabel3.setIcon(ResizeImage(path,showeditcard.editpicLabel3));
	    		}
	    		else if (result == JFileChooser.CANCEL_OPTION){
	    			JOptionPane.showMessageDialog(null, "No File Selected!");
	    		}
	    	}
	    });
	    showeditcard.add(showeditcard.changeButton3);
	    JButton deleteButton3 = new JButton("Delete");
	    deleteButton3.setBounds(290, 580, 100, 30);
	    deleteButton3.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		conditionimagePath3 = null;
	    		showeditcard.editpicLabel3.setIcon(null);
	    		JOptionPane.showMessageDialog(null, "Picture deleted!");
	    	}
	    });
	    showeditcard.add(deleteButton3);
	    
	    showeditcard.changeButton4 = new JButton("Upload");
	    showeditcard.changeButton4.setBounds(410, 550, 100, 30);
	    showeditcard.changeButton4.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		JFileChooser jfile = new JFileChooser();
	    		jfile.setCurrentDirectory(new File(System.getProperty("user.home")));
	    		jfile.setAcceptAllFileFilterUsed(false);
	    		FileFilter filter = new FileNameExtensionFilter("Images","jpg","gif","png","jpeg");
	    		//FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images","jpg","gif","png");
	    		jfile.addChoosableFileFilter(filter);
	    		int result = jfile.showOpenDialog(null);
	    		if(result == JFileChooser.APPROVE_OPTION){
	    			File selectedFile = jfile.getSelectedFile();
	    			String path = selectedFile.getAbsolutePath();
	    			conditionimagePath4 = path;
	    			showeditcard.editpicLabel4.setIcon(ResizeImage(path,showeditcard.editpicLabel4));
	    		}
	    		else if (result == JFileChooser.CANCEL_OPTION){
	    			JOptionPane.showMessageDialog(null, "No File Selected!");
	    		}
	    	}
	    });
	    showeditcard.add(showeditcard.changeButton4);
	    JButton deleteButton4 = new JButton("Delete");
	    deleteButton4.setBounds(410, 580, 100, 30);
	    deleteButton4.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		conditionimagePath4 = null;
	    		showeditcard.editpicLabel4.setIcon(null);
	    		JOptionPane.showMessageDialog(null, "Picture deleted!");
	    	}
	    });
	    showeditcard.add(deleteButton4);
	    showeditcard.changeButton5 = new JButton("Upload");
	    showeditcard.changeButton5.setBounds(530, 550, 100, 30);
	    showeditcard.changeButton5.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		JFileChooser jfile = new JFileChooser();
	    		jfile.setCurrentDirectory(new File(System.getProperty("user.home")));
	    		jfile.setAcceptAllFileFilterUsed(false);
	    		FileFilter filter = new FileNameExtensionFilter("Images","jpg","gif","png","jpeg");
	    		//FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images","jpg","gif","png");
	    		jfile.addChoosableFileFilter(filter);
	    		int result = jfile.showOpenDialog(null);
	    		if(result == JFileChooser.APPROVE_OPTION){
	    			File selectedFile = jfile.getSelectedFile();
	    			String path = selectedFile.getAbsolutePath();
	    			conditionimagePath5 = path;
	    			showeditcard.editpicLabel5.setIcon(ResizeImage(path,showeditcard.editpicLabel5));
	    		}
	    		else if (result == JFileChooser.CANCEL_OPTION){
	    			JOptionPane.showMessageDialog(null, "No File Selected!");
	    		}
	    	}
	    });
	    showeditcard.add(showeditcard.changeButton5);
	    JButton deleteButton5 = new JButton("Delete");
	    deleteButton5.setBounds(530, 580, 100, 30);
	    deleteButton5.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		conditionimagePath5 = null;
	    		showeditcard.editpicLabel5.setIcon(null);
	    		JOptionPane.showMessageDialog(null, "Picture deleted!");
	    	}
	    });
	    showeditcard.add(deleteButton5);
	    cards.add(showeditcard,SHOWEDITPANEL);
	    
	    pane.add(cards);
	}
	
	/**
	 * Write all the patient information to given file in fixed format
	 */
	public void writeToFile(){
		try{
			removeLineFromFile(currentdirectory+"/Userinformation.txt",registercard.regisnameField.getText());
			BufferedWriter writer;
			writer = new BufferedWriter(new FileWriter(currentdirectory+"/Userinformation.txt",
                    true));
			userinformation = new Userinformation(registercard.regisnameField.getText(), 
					registercard.regislnameField.getText(), 
					registercard.dates[registercard.birthDate.getSelectedIndex()] + " " + 
					registercard.months[registercard.birthMonth.getSelectedIndex()] + "," +
					registercard.years[registercard.birthYear.getSelectedIndex()],
					registercard.regisaddressField.getText() +"," + registercard.regisaddressField1.getText()
					, registercard.regisphoneField.getText(),
					registercard.regisconField.getText(), 
					registercard.hours[registercard.appHour.getSelectedIndex()] + ":" +
					registercard.minutes[registercard.appMinute.getSelectedIndex()] + "," +
					registercard.dates[registercard.appDate.getSelectedIndex()] + " " +
					registercard.months[registercard.appMonth.getSelectedIndex()] + "," +
					registercard.appyears[registercard.appYear.getSelectedIndex()],
					registercard.regisbillField.getText(), registercard.regiscomField.getText(),
					imagePath, conditionimagePath1, conditionimagePath2,
					conditionimagePath3, conditionimagePath4, conditionimagePath5);
			String string = userinformation.ToString();
            writer.write(string);
            writer.close();
			
		}
		catch(Exception ex){
			ex.printStackTrace();
	    }
	}
	/**
	 * Edit a existed record and save all the changes
	 */
	public void editToFile(){
		try{
			removeLineFromFile(currentdirectory+"/Userinformation.txt",showeditcard.regisnameField.getText());
			BufferedWriter writer;
			writer = new BufferedWriter(new FileWriter(currentdirectory+"/Userinformation.txt",
                    true));
			userinformation = new Userinformation(showeditcard.regisnameField.getText(), 
					showeditcard.regislnameField.getText(), showeditcard.regisdobField.getText(),
					showeditcard.regisaddressField.getText(),showeditcard.regisphoneField.getText(),
					showeditcard.regisconField.getText(), showeditcard.regisappField.getText(),
					showeditcard.regisbillField.getText(), showeditcard.regiscomField.getText(),
					imagePath, conditionimagePath1, conditionimagePath2, conditionimagePath3,
					conditionimagePath4, conditionimagePath5);
			String string = userinformation.ToString();
            writer.write(string);
            writer.close();
			
		}
		catch(Exception ex){
			ex.printStackTrace();
	    }
	}
	/**
	 * Delete the line based on the given string in the file
	 * @param file file path which are handled
	 * @param lineToRemove the first string of line to remove
	 */
	public void removeLineFromFile(String file, String lineToRemove) {

	    try {

	      File inFile = new File(file);

	      if (!inFile.isFile()) {
	        System.out.println("Parameter is not an existing file");
	        return;
	      }

	      //Construct the new file that will later be renamed to the original filename.
	      File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

	      BufferedReader br = new BufferedReader(new FileReader(file));
	      PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

	      String line = null;

	      //Read from the original file and write to the new
	      //unless content matches data to be removed.
	      while ((line = br.readLine()) != null) {
	    	  String[] info = line.split("\t"); 

	        if (!info[0].equals(lineToRemove)) {

	          pw.println(line);
	          pw.flush();
	        }
	      }
	      pw.close();
	      br.close();

	      //Delete the original file
	      if (!inFile.delete()) {
	        System.out.println("Could not delete file");
	        return;
	      }

	      //Rename the new file to the filename the original file had.
	      if (!tempFile.renameTo(inFile))
	        System.out.println("Could not rename file");

	    }
	    catch (FileNotFoundException ex) {
	      ex.printStackTrace();
	    }
	    catch (IOException ex) {
	      ex.printStackTrace();
	    }
	  }
	/**
	 * Set the scaling icon of label as the image at given image path
	 * @param ImagePath Image path of given picture
	 * @param jLabel label that is handled
	 * @return The scaling icon of label
	 */
	public ImageIcon ResizeImage(String ImagePath, JLabel jLabel){
		ImageIcon myImage = new ImageIcon(ImagePath);
		Image image = myImage.getImage();
		Image newImage = image.getScaledInstance(jLabel.getWidth(), jLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon img = new ImageIcon(newImage);
		return img;
	}
	/**
	 * Search patient record based on first name and return a object refer to patient information
	 * @param firstname Given first name as a search reference
	 * @param file Searched file path
	 * @return object contains corresponding patient information
	 */
	public Userinformation searchInfo(String firstname, String file){
		File inFile = new File(file);
	      Userinformation information=new Userinformation();
		try {

		      

		      if (!inFile.isFile()) {
		        System.out.println("Parameter is not an existing file");
		        return null;
		      }
		      BufferedReader br = new BufferedReader(new FileReader(file));
		      String line = null;

		      while ((line = br.readLine()) != null) {
		    	  String[] info = line.split("\t"); 

		        if (info[0].equals(firstname)) {

		         information = new Userinformation(info[0], info[1], info[2],
		        		 info[3], info[4], info[5], info[6], info[7], info[8], info[9],
		        		 info[10],info[11], info[12],info[13], info[14]);
		         
		        }
		      }
		      br.close();
		}
		catch (FileNotFoundException ex) {
		      ex.printStackTrace();
		}
		catch (IOException ex) {
		      ex.printStackTrace();
		}
		return information;
	}
	/**
	 * Display all the stored patient records in a table in information panel
	 */
	public void displayInfo(){
		File file = new File(currentdirectory+"/Userinformation.txt");
		try{
			if (file.exists() && file.isFile()){
				InputStream is = new FileInputStream(file);
				BufferedReader in = new BufferedReader(new InputStreamReader(is));
				String line;
				String[] infos;
				DefaultTableModel model = (DefaultTableModel) showinfocard.jTable.getModel();
				int rows = model.getRowCount(); 
				for(int i = rows - 1; i >=0; i--)
				{
				   model.removeRow(i); 
				}
				while((line = in.readLine()) != null){
					infos = line.split("\t");
					Vector row = new Vector();
					for (int i = 0; i<10;i++){
						row.add(infos[i]);
					}
					for (int i = 10; i<infos.length;i++){
						row.set(9, row.get(9).toString()+"\t" + infos[i]);
					}
					model.addRow(row);
						
						
						
					
				}
				in.close();
			}
		}
		catch(Exception e){
			System.out.println("readFile() exception:" + e.getMessage());
	    	e.printStackTrace();
		}
	}
	/**
	 * First match the practitioner's username/password pair, if so, jump to information
	 * panel and show all the records in a table, if not, ask for a new type.
	 */
	public void matchToFile(){
		File file = new File(currentdirectory+"/Userinformation.txt");
		File fileinfo = new File(currentdirectory+"/PractitionerInfo.txt");
		try{
			if (file.isFile() && file.exists() && fileinfo.isFile() && fileinfo.exists()){
				InputStream is = new FileInputStream(file);
				InputStream isinfo = new FileInputStream(fileinfo);
				BufferedReader in =  new BufferedReader(new InputStreamReader(is));
				BufferedReader ininfo = new BufferedReader(new InputStreamReader(isinfo));
				String line;
				String lineinfo;
				String[] infos;
				String[] userinfos;
				boolean ismatch = false;
				while((line = ininfo.readLine()) != null){
					infos = line.split(" ");
					System.out.println(pswtextField.getPassword());
					if (infos[0].equals(usertextField.getText()) && infos[1].equals(new String(pswtextField.getPassword()))){
						ismatch = true;
						DefaultTableModel model = (DefaultTableModel) showinfocard.jTable.getModel();
						int rows = model.getRowCount(); 
						for(int i = rows - 1; i >=0; i--)
						{
						   model.removeRow(i); 
						}
						while((lineinfo = in.readLine()) != null){
							userinfos = lineinfo.split("\t");
							Vector row = new Vector();
							for (int i = 0; i<10;i++){
								row.add(userinfos[i]);
							}
							for (int i = 10; i<userinfos.length;i++){
								row.set(9, row.get(9).toString()+"\t" + userinfos[i]);
							}
							model.addRow(row);
						}
						//showpicLabel.setIcon(ResizeImage(infos[7],showpicLabel));
						break;
						
					}
				}
				in.close();
				ininfo.close();
				if (ismatch){
					JOptionPane.showMessageDialog(frame, "Login successful!");
					//insert info panel
					userName = usertextField.getText();
		    		CardLayout cl = (CardLayout)(cards.getLayout());
		            cl.show(cards, SHOWINFOPANEL);
				}
				else{
					JOptionPane.showMessageDialog(frame, "Invalid username or password, please try again!");
					pswtextField.setText(null);
				}
				
			}
			
		}
		catch(Exception e){
			System.out.println("readFile() exception:" + e.getMessage());
	    	e.printStackTrace();
	    	
		}
	}

}
