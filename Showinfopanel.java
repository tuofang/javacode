/**
 * This class is a panel to show patient information and provide operations like registration of a
 * new patient, searching patient's record and export or import of records
 * @author tuofang
 * @version 1.0 Dec, 2015
 */
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class Showinfopanel extends JPanel{
	protected JTable jTable;
	/**
	 * Constructor
	 */
	public Showinfopanel(){
		this.setBounds(100, 100,  1000, 800);
		this.setLayout(null);
		
		DefaultTableModel model = new DefaultTableModel(){
	    	@Override
	        public boolean isCellEditable(int row, int column) {
	            return false; 
	        }
	    };
	    model.addColumn("First Name");
        model.addColumn("Last Name");
        model.addColumn("DOB");
        model.addColumn("Address");
        model.addColumn("Phone Number");
        model.addColumn("Condition");
        model.addColumn("Appointments");
        model.addColumn("Billings");
        model.addColumn("Comments");
        model.addColumn("ImagePath");
	    jTable = new JTable(model);
	    
	}
	

}
