package Element;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

import user.User;
import util.NitriteDatabaseHelper;


public class Elementcontroller {
	public Elementcontroller(){
		
	}
	ArrayList<Element> elements=new ArrayList<>();
	public void insertElemnet(Element e) {
		NitriteDatabaseHelper.insert(e, Element.class);
	}
	/*
	public void viewAllElements() {
		elements=getAllElements();
		sortElements();
		for(Element e : elements) {
			System.out.println("ID"+e.getId()+" name "+e.getElementname()+" discription "+e.getDescription()+" category "+e.getCategory()+" date "+e.getDate());
		}
	}*/
	public void showElement()
	{
		
	}
	public void selectElement()
	{
		
	}
	public void uploadphoto()
	{
		
	}
	public int getLastId() {
		int i=-1;
		for(Element e : elements) {
			if(e.getId()>i)
				i=e.getId();
		}
		return i;
	}
	
	public ArrayList<Element> getAllElements() {
		elements=NitriteDatabaseHelper.all(Element.class);
		sortElements();
		return elements;
	}
	public void sortElements() {
		elements.sort(new elementComparator());
	}
	public class elementComparator implements Comparator<Element> {
	    @Override
	    public int compare(Element e1, Element e2) {
	        return e1.getDate().compareTo(e2.getDate());
	    }
	}
}

