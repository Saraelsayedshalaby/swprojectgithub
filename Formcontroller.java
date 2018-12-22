package Form;

import java.util.ArrayList;

import user.User;
import util.NitriteDatabaseHelper;

public class Formcontroller {
	
	ArrayList<Form> forms =new ArrayList<>();
    
    public ArrayList<Form> getAllForms() {
    	forms=NitriteDatabaseHelper.all(Form.class);
		return forms;
	}

	public void insertForm(Form form )
    {
		NitriteDatabaseHelper.insert(form, Form.class);
    }
    
}