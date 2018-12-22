package Form;
import java.util.ArrayList;
public class Formservices {
	Formcontroller fc ;

	public void setFc(Formcontroller fc) {
		this.fc = fc;
	}
	public Form getFormByElementid(int ElementId )
	{
		for(Form f: fc.getAllForms()) {
			if(f.getElementId()==ElementId) {
				return f;
			}
		}
	    return null;
	}
	public void submitForm(Form f) {
		fc.insertForm(f);
	}
	public boolean CompareAnswers(Form f,ArrayList<String>answers) {
		for(int i=0;i<f.getAnswers().size();++i) {
			if(!(answers.get(i).equals(f.getAnswers().get(i)))){
				return false;
			}
		}
		return true;
	}

}
