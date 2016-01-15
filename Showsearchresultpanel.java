/**
 * The class is a panel to show the search result based on stored fields
 * @author Tuo Fang
 * @version 1.0 Dec, 2015
 */
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Showsearchresultpanel extends JPanel{
	protected JTable jTable;
	/**
	 * Constructor
	 */
	public Showsearchresultpanel(){
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
	    JScrollPane logScrollPane = new JScrollPane(jTable);
        logScrollPane.setBounds(50, 50, 900, 500);
        this.add(logScrollPane);
	}

}
