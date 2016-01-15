/**
 * The class contains all the attributes of patient like name, date of birth, etc.  
 * @author  Tuo Fang
 * @version 1.0, Dec 2015
 */
public class Userinformation {
	protected String firstname;
	protected String lastname;
	protected String dob;
	protected String address;
	protected String phone;
	protected String condition;
	protected String appointments;
	protected String billings;
	protected String comments;
	protected String imagepath;
	protected String[] conditionimagePath = new String[5];
	public Userinformation(){
		
	}
	/**
	 * constructor
	 * @param firstname string represents first name of patient
	 * @param lastname string represents last name of patient
	 * @param dob string represents date of birth of patient
	 * @param address string represents address of patient
	 * @param phone  string represents phone number of patient
	 * @param condition string represents medical condition of patient
	 * @param appointments string represents appointment dates of patient
	 * @param billings string represents billings of patient
	 * @param comments string represents other comments of patient
	 * @param imagepath string represents image path of patient's personal picture
	 * @param conditionimagePath1 string represents image path of patient's medical picture
	 * @param conditionimagePath2 string represents image path of patient's medical picture
	 * @param conditionimagePath3 string represents image path of patient's medical picture
	 * @param conditionimagePath4 string represents image path of patient's medical picture
	 * @param conditionimagePath5 string represents image path of patient's medical picture
	 */
	public Userinformation(String firstname,String lastname,String dob,
			String address,String phone, String condition, String appointments,
			String billings, String comments,String imagepath, String conditionimagePath1,
			 String conditionimagePath2, String conditionimagePath3, String conditionimagePath4,
			 String conditionimagePath5){
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
		this.address = address;
		this.phone = phone;
		this.condition = condition;
		this.appointments = appointments;
		this.billings = billings;
		this.comments = comments;
		this.imagepath = imagepath;
		this.conditionimagePath[0] = conditionimagePath1;
		this.conditionimagePath[1] = conditionimagePath2;
		this.conditionimagePath[2] = conditionimagePath3;
		this.conditionimagePath[3] = conditionimagePath4;
		this.conditionimagePath[4] = conditionimagePath5;
	}
	/**
	 * This function overrides ToString() to combine all the strings together with tab between them
	 * , which makes it convenient to load or store patient information through text file
	 * @return combined tab separated string
	 */
	public String ToString(){
		String str = this.firstname + "\t" + this.lastname + "\t" + this.dob + "\t" + 
	            this.address + "\t" + this.phone+ "\t" + this.condition + "\t" + 
				this.appointments + "\t" + this.billings + "\t" + this.comments + "\t" +
				this.imagepath + "\t"+this.conditionimagePath[0] + "\t" + 
				this.conditionimagePath[1] + "\t" + this.conditionimagePath[2] +
				"\t" + this.conditionimagePath[3] + "\t" + this.conditionimagePath[4] + "\n";
		return str;
	}

}
