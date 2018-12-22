package Form;
import java.util.ArrayList;

import user.User;
public class Form {
	private User creator ;
    private ArrayList<String> questions ;
    private ArrayList<String> Answers;
    private int elementId;
    
	public User getCreator() {
		return creator;
	}
	public void setCreator(User creator) {
		this.creator = creator;
	}
	
	public ArrayList<String> getQuestions() {
		return questions;
	}
	public void setQuestions(ArrayList<String> questions) {
		this.questions = questions;
	}
	public ArrayList<String> getAnswers() {
		return Answers;
	}
	public void setAnswers(ArrayList<String> answers) {
		Answers = answers;
	}
	public int getElementId() {
		return elementId;
	}
	public void setElementId(int elementId) {
		this.elementId = elementId;
	}
   
     

}
