/**
 * The class is registration panel that grab patient's personal information including medical
 * pictures and store to a text file.
 * @author Tuo Fang
 * @version 1.0 Dec, 2015
 */
import java.util.Calendar;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

public class Registerpanel extends JPanel{
	final static int LABELWIDTH = 130;
	final static int BUTTONWIDTH = 130;
	final static int BUTTONHEIGHT = 30;
	final static int TEXTFIELDX = 200;
	final static int FIELDWIDTH = 280;
	final static int LABELX = 50;
	protected JTextField regisnameField;
	protected JTextField regislnameField;
	protected JTextField regisdobField;
	protected JTextField regisaddressField;
	protected JTextField regisaddressField1;
	protected JTextField regisphoneField;
	protected JTextField regisconField;
	protected JTextField regisappField;
	protected JTextField regisbillField;
	protected JTextField regiscomField;
	protected JLabel picLabel;
	protected JLabel picLabel1;
	protected JLabel picLabel2;
	protected JLabel picLabel3;
	protected JLabel picLabel4;
	protected JLabel picLabel5;
	protected JComboBox birthDate, birthMonth, birthYear;
	protected String[] dates, years, hours,appyears;
	protected String[] months = {"Jan", "Feb", "Mar",
			"Apr", "May", "Jun","Jul", "Aug","Sep",
			"Oct","Nov","Dec"};
	protected String[] minutes = {"00", "15","30","45"};
	protected JComboBox appDate, appMonth, appYear, appHour, appMinute;
	private Calendar startDate = Calendar.getInstance();
	/**
	 * Constructor.Add all the component like labels, buttons, and text fields to panel
	 */
	public Registerpanel(){
		this.setLayout(null);
		JLabel regisnameLabel = new JLabel("First Name:");
		regisnameLabel.setBounds(LABELX, 70, LABELWIDTH, 20);
		this.add(regisnameLabel);
		
		regisnameField = new JTextField();
		regisnameField.setBounds(TEXTFIELDX, 70, FIELDWIDTH, 20);
		regisnameField.setText(null);
		this.add(regisnameField);
		
		JLabel regislnameLabel = new JLabel("Last Name:");
		regislnameLabel.setBounds(LABELX, 100, LABELWIDTH, 20);
		this.add(regislnameLabel);
		
		regislnameField = new JTextField();
		regislnameField.setBounds(TEXTFIELDX, 100, FIELDWIDTH, 20);
		regislnameField.setText(null);
		this.add(regislnameField);
		
		birthYear = new JComboBox();
		years = new String [100];
        for (int i=0;i<100;i++){
        	years[i] = String.valueOf(2015 - i); 
        	birthYear.addItem(years[i]);
        }
        birthYear.setSelectedIndex(5);
        birthMonth = new JComboBox();
        for (int i=0;i<12;i++){
        	
        	birthMonth.addItem(months[i]);
        }
        birthMonth.setSelectedIndex(startDate.get(Calendar.MONTH));
        birthDate = new JComboBox();
        dates = new String [31];
        for (int i=0;i<31;i++){
        	dates[i] = String.valueOf(i+1);
        	birthDate.addItem(dates[i]);
        }
        birthDate.setSelectedIndex(1);
		JLabel regisdobLabel = new JLabel("Date of Birth:");
	    regisdobLabel.setBounds(LABELX, 130, LABELWIDTH, 20);
	    this.add(regisdobLabel);
	    
	    birthDate.setBounds(TEXTFIELDX, 130, 60, 30);
	    birthMonth.setBounds(TEXTFIELDX+70, 130, 100, 30);
	    birthYear.setBounds(TEXTFIELDX+180, 130, 100, 30);
	    this.add(birthDate);
	    this.add(birthMonth);
	    this.add(birthYear);
	    regisdobField = new JTextField();
		regisdobField.setBounds(TEXTFIELDX, 130, FIELDWIDTH, 20);
		regisdobField.setText(null);
		
		
		JLabel regisaddressLabel = new JLabel("Address (Line1):");
	    regisaddressLabel.setBounds(LABELX, 160, LABELWIDTH, 20);
	    this.add(regisaddressLabel);
	    
	    regisaddressField = new JTextField();
		regisaddressField.setBounds(TEXTFIELDX, 160, FIELDWIDTH, 20);
		regisaddressField.setText(null);
		this.add(regisaddressField);
		
		JLabel regisaddressLabel1 = new JLabel("Address (Line2):");
	    regisaddressLabel1.setBounds(LABELX, 190, LABELWIDTH, 20);
	    this.add(regisaddressLabel1);
	    
	    regisaddressField1 = new JTextField();
		regisaddressField1.setBounds(TEXTFIELDX, 190, FIELDWIDTH, 20);
		regisaddressField1.setText(null);
		this.add(regisaddressField1);
		
		JLabel regisphoneLabel = new JLabel("Emergency Phone NUmber:");
	    regisphoneLabel.setBounds(LABELX, 220, LABELWIDTH, 20);
	    this.add(regisphoneLabel);
	    
	    regisphoneField = new JTextField();
		regisphoneField.setBounds(TEXTFIELDX, 220, FIELDWIDTH, 20);
		regisphoneField.setText(null);
		this.add(regisphoneField);
		
		JLabel regisconLabel = new JLabel("Medical Condition:");
	    regisconLabel.setBounds(LABELX, 250, LABELWIDTH, 20);
	    this.add(regisconLabel);
	    
	    regisconField = new JTextField();
		regisconField.setBounds(TEXTFIELDX, 250, FIELDWIDTH, 20);
		regisconField.setText(null);
		this.add(regisconField);
		
		JLabel regisappLabel = new JLabel("Appointments:");
	    regisappLabel.setBounds(LABELX, 280, LABELWIDTH, 20);
	    this.add(regisappLabel);
	    
	    appYear = new JComboBox();
		appyears = new String [20];
        for (int i=0;i<20;i++){
        	appyears[i] = String.valueOf(2015 + i); 
        	appYear.addItem(appyears[i]);
        }
        appYear.setSelectedIndex(0);
        appMonth = new JComboBox();
        for (int i=0;i<12;i++){
        	
        	appMonth.addItem(months[i]);
        }
        appMonth.setSelectedIndex(startDate.get(Calendar.MONTH));
        appDate = new JComboBox();
        
        for (int i=0;i<31;i++){
        	
        	appDate.addItem(dates[i]);
        }
        
        appDate.setSelectedIndex(1);
        appDate.setBounds(TEXTFIELDX, 280, 60, 30);
	    appMonth.setBounds(TEXTFIELDX+70, 280, 100, 30);
	    appYear.setBounds(TEXTFIELDX+180, 280, 100, 30);
	    this.add(appDate);
	    this.add(appMonth);
	    this.add(appYear);
	    
	    appHour = new JComboBox();
	    appMinute = new JComboBox();
	    hours = new String [24];
	    for (int i = 0; i<24; i++){
	    	hours[i] = String.valueOf(i);
	    	appHour.addItem(hours[i]);
	    }
	    for (int i = 0; i<4; i++){
	    	
	    	appMinute.addItem(minutes[i]);
	    }
	    appHour.setBounds(TEXTFIELDX+50, 310, 60, 30);
	    appMinute.setBounds(TEXTFIELDX+200, 310, 80, 30);
	    this.add(appHour);
	    this.add(appMinute);
	    JLabel hourlabel = new JLabel("Hour:");
	    hourlabel.setBounds(TEXTFIELDX,310,60,30);
	    this.add(hourlabel);
	    JLabel minutelabel = new JLabel("Minute:");
	    minutelabel.setBounds(TEXTFIELDX + 140, 310,60,30);
	    this.add(minutelabel);
	    regisappField = new JTextField();
		regisappField.setBounds(TEXTFIELDX, 280, FIELDWIDTH, 20);
		regisappField.setText(null);
		//this.add(regisappField);
		
		JLabel regisbillLabel = new JLabel("Billings:");
	    regisbillLabel.setBounds(LABELX, 340, LABELWIDTH, 20);
	    this.add(regisbillLabel);
	    
	    regisbillField = new JTextField();
		regisbillField.setBounds(TEXTFIELDX, 340, FIELDWIDTH, 20);
		regisbillField.setText(null);
		this.add(regisbillField);
		
		JLabel regiscomLabel = new JLabel("Comments:");
	    regiscomLabel.setBounds(LABELX, 370, LABELWIDTH, 20);
	    this.add(regiscomLabel);
	    
	    regiscomField = new JTextField();
		regiscomField.setBounds(TEXTFIELDX, 370, FIELDWIDTH, 20);
		regiscomField.setText(null);
		this.add(regiscomField);
		
		picLabel = new JLabel("Upload Personal Picture Here");
	    picLabel.setBounds(530,70,200,150);
	    picLabel.setIcon(null);
	    this.add(picLabel);
	    
	    JLabel conlabel = new JLabel("Upload condition pictures below:");
	    conlabel.setBounds(LABELX, 400, LABELWIDTH*2, 20);
	    this.add(conlabel);
	    picLabel1 = new JLabel("Upload Here");
	    picLabel1.setBounds(50,430,100,100);
	    picLabel1.setIcon(null);
	    this.add(picLabel1);
	    
	    picLabel2 = new JLabel("Upload Here");
	    picLabel2.setBounds(170,430,100,100);
	    picLabel2.setIcon(null);
	    
	    this.add(picLabel2);
	    
	    picLabel3 = new JLabel("Upload Here");
	    picLabel3.setBounds(290,430,100,100);
	    picLabel3.setIcon(null);
	    
	    this.add(picLabel3);
	    
	    picLabel4 = new JLabel("Upload Here");
	    picLabel4.setBounds(410,430,100,100);
	    picLabel4.setIcon(null);
	    
	    this.add(picLabel4);
	    
	    picLabel5 = new JLabel("Upload Here");
	    picLabel5.setBounds(530,430,100,100);
	    picLabel5.setIcon(null);
	    
	    this.add(picLabel5);
	}
	

}
