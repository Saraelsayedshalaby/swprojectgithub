package Element;
import java.util.Date;
public class Element {
	private int Id;
	private String elementname;
	private Date date;
	private String Description;
	private String elemntphoto;
	private String category;
	public String getElementname() {
		return elementname;
	}
	public void setElementname(String elementname) {
		this.elementname = elementname;
	}

	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getElemntphoto() {
		return elemntphoto;
	}
	public void setElemntphoto(String elemntphoto) {
		this.elemntphoto = elemntphoto;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	

}
