/**
 * The class is a panel to edit patient's record. Practitioner can edit information in text field
 * , add new pictures and delete existed ones and save the changes. 
 * @author Tuo Fang
 * @version 1.0 Dec, 2015
 */
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Showeditpanel extends JPanel{
	protected JTextField regisnameField;
	protected JTextField regislnameField;
	protected JTextField regisdobField;
	protected JTextField regisaddressField;
	protected JTextField regisphoneField;
	protected JTextField regisconField;
	protected JTextField regisappField;
	protected JTextField regisbillField;
	protected JTextField regiscomField;
	protected JLabel editpicLabel;
	protected JLabel editpicLabel1;
	protected JLabel editpicLabel2;
	protected JLabel editpicLabel3;
	protected JLabel editpicLabel4;
	protected JLabel editpicLabel5;
	protected JButton changeButton;
	protected JButton changeButton1;
	protected JButton changeButton2;
	protected JButton changeButton3;
	protected JButton changeButton4;
	protected JButton changeButton5;
	final static int LABELWIDTH = 130;
	final static int BUTTONWIDTH = 130;
	final static int BUTTONHEIGHT = 30;
	final static int FIELDWIDTH = 180;
	final static int TEXTFIELDX = 200;
	final static int LABELX = 50;
	
	/**
	 * Constructor. Add all the component like labels, buttons, and text fields to panel
	 */
	public Showeditpanel(){
		this.setBounds(100, 100,  1000, 800);
		this.setLayout(null);
		
		JLabel regisnameLabel = new JLabel("First Name:");
		regisnameLabel.setBounds(LABELX, 70, LABELWIDTH, 20);
		this.add(regisnameLabel);
		
		regisnameField = new JTextField();
		regisnameField.setBounds(TEXTFIELDX, 70, FIELDWIDTH, 20);
		this.add(regisnameField);
		
		JLabel regislnameLabel = new JLabel("Last Name:");
		regislnameLabel.setBounds(LABELX, 100, LABELWIDTH, 20);
		this.add(regislnameLabel);
		
		regislnameField = new JTextField();
		regislnameField.setBounds(TEXTFIELDX, 100, FIELDWIDTH, 20);
		this.add(regislnameField);
		
		JLabel regisdobLabel = new JLabel("Date of Birth:");
	    regisdobLabel.setBounds(LABELX, 130, LABELWIDTH, 20);
	    this.add(regisdobLabel);
	    
	    regisdobField = new JTextField();
		regisdobField.setBounds(TEXTFIELDX, 130, FIELDWIDTH, 20);
		this.add(regisdobField);
		
		JLabel regisaddressLabel = new JLabel("Address:");
	    regisaddressLabel.setBounds(LABELX, 160, LABELWIDTH, 20);
	    this.add(regisaddressLabel);
	    
	    regisaddressField = new JTextField();
		regisaddressField.setBounds(TEXTFIELDX, 160, FIELDWIDTH, 20);
		this.add(regisaddressField);
		
		JLabel regisphoneLabel = new JLabel("Emergency Phone NUmber:");
	    regisphoneLabel.setBounds(LABELX, 190, LABELWIDTH, 20);
	    this.add(regisphoneLabel);
	    
	    regisphoneField = new JTextField();
		regisphoneField.setBounds(TEXTFIELDX, 190, FIELDWIDTH, 20);
		this.add(regisphoneField);
		
		JLabel regisconLabel = new JLabel("Medical Condition:");
	    regisconLabel.setBounds(LABELX, 220, LABELWIDTH, 20);
	    this.add(regisconLabel);
	    
	    regisconField = new JTextField();
		regisconField.setBounds(TEXTFIELDX, 220, FIELDWIDTH, 20);
		this.add(regisconField);
		
		JLabel regisappLabel = new JLabel("Appointments:");
	    regisappLabel.setBounds(LABELX, 250, LABELWIDTH, 20);
	    this.add(regisappLabel);
	    
	    regisappField = new JTextField();
		regisappField.setBounds(TEXTFIELDX, 250, FIELDWIDTH, 20);
		this.add(regisappField);
		
		JLabel regisbillLabel = new JLabel("Billings:");
	    regisbillLabel.setBounds(LABELX, 280, LABELWIDTH, 20);
	    this.add(regisbillLabel);
	    
	    regisbillField = new JTextField();
		regisbillField.setBounds(TEXTFIELDX, 280, FIELDWIDTH, 20);
		this.add(regisbillField);
		
		JLabel regiscomLabel = new JLabel("Comments:");
	    regiscomLabel.setBounds(LABELX, 310, LABELWIDTH, 20);
	    this.add(regiscomLabel);
	    
	    regiscomField = new JTextField();
		regiscomField.setBounds(TEXTFIELDX, 310, FIELDWIDTH, 20);
		this.add(regiscomField);
	    
		
		editpicLabel = new JLabel("*******Upload Picture Here*******");
	    editpicLabel.setBounds(430,70,200,150);
	    editpicLabel.setIcon(null);
	    this.add(editpicLabel);
	    
	    editpicLabel1 = new JLabel("Upload Picture Here");
	    editpicLabel1.setBounds(50,430,100,100);
	    editpicLabel1.setIcon(null);
	    this.add(editpicLabel1);
	    
	    editpicLabel2 = new JLabel("Upload Picture Here");
	    editpicLabel2.setBounds(170,430,100,100);
	    editpicLabel2.setIcon(null);
	    this.add(editpicLabel2);
	    
	    editpicLabel3 = new JLabel("Upload Picture Here");
	    editpicLabel3.setBounds(290,430,100,100);
	    editpicLabel3.setIcon(null);
	    this.add(editpicLabel3);
	    
	    editpicLabel4 = new JLabel("Upload Picture Here");
	    editpicLabel4.setBounds(410,430,100,100);
	    editpicLabel4.setIcon(null);
	    this.add(editpicLabel4);
		
	    editpicLabel5 = new JLabel("Upload Picture Here");
	    editpicLabel5.setBounds(530,430,100,100);
	    editpicLabel5.setIcon(null);
	    this.add(editpicLabel5);
	}

}
