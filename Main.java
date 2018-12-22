import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import Element.*;
import Form.*;
import user.*;
import util.Lib;

public class Main {
	
	
	public static void main(String[] args) {
    Lib.Platform.persist();	
		
	Userservices us=new Userservices ();
	Usercontroller uc=new Usercontroller();
	us.setUc(uc);
	
	Elementcontroller ec =new Elementcontroller();
	
	Formcontroller fc =new Formcontroller();
	Formservices fs=new Formservices();
	fs.setFc(fc);
	
	Scanner in=new Scanner (System.in);
	
	while(true){
	System.out.println("1.signin\n2.signup\n3.Exit");
	int c ;
	c=in.nextInt();
	if (c==1)
	{
		User user =new User ();
		System.out.println("please enter your name :");
		user.setName(in.next());
		
		System.out.println("please enter your password:");
		user.setPassword(in.next());
		
		boolean success=us.signin(user);
		if(success) {
			while(true ) {
				System.out.println("1.post \n2.search\n3.logout");
				int c1 ;
				c1=in.nextInt();
				if(c1==1) {
					Element e =new Element();
					e.setId(ec.getLastId()+1);
					System.out.println("enter element name : ");
					e.setElementname(in.next());
					System.out.println("enter element category : ");
					e.setCategory(in.next());
					System.out.println("enter element discription : ");
					in.nextLine();
					e.setDescription(in.nextLine());
					System.out.println("enter day : ");
					int day =in.nextInt();
					System.out.println("enter month : ");
					int month=in.nextInt();
					System.out.println("enter year : ");
					int year=in.nextInt();
					Date d=new Date(year-1900,month-1,day);
					e.setDate(d);
					System.out.println("does the element has conflict 1)yes 2)no ...? ");
					int c2=in.nextInt();
					if(c2==1) {
						ArrayList<String> q=new ArrayList<>();
						ArrayList<String> a=new ArrayList<>();
						System.out.println("enter number of questions : ");
						int num = in.nextInt();
						in.nextLine();
						Form f= new Form();
						for(int i=0;i<num;++i) {
							System.out.println("enter question : ");
							q.add(in.nextLine());
							System.out.println("enter answer : ");
							a.add(in.nextLine());
						}
						f.setQuestions(q);
						f.setAnswers(a);
						f.setCreator(user);
						f.setElementId(e.getId());
						fs.submitForm(f);
					}
					ec.insertElemnet(e);
					System.out.println("posted successfully");
				}
				else if (c1==2) {
					ArrayList<Element> res=new ArrayList<>();
					
					System.out.println("Enter category of the element : ");
					String cat=in.next();
					System.out.println("enter day : ");
					int day =in.nextInt();
					System.out.println("enter month : ");
					int month=in.nextInt();
					System.out.println("enter year : ");
					int year=in.nextInt();
					Date d=new Date(year-1900,month-1,day);
					int k=1;
					for(Element e : ec.getAllElements()) {
						if(e.getCategory().equals(cat) && (e.getDate().compareTo(d)>0)) {
							res.add(e);
							System.out.println(k+") name :"+e.getElementname()+"\ndiscription : "+e.getDescription()+"\ncategory : "+e.getCategory()+"\ndate : "+e.getDate());
							++k;
						}
					}
					if(res.size()>0) {
					System.out.println("Enter number of your element : ");
					int n=in.nextInt();
					in.nextLine();
					Form f = fs.getFormByElementid(res.get(--n).getId());
					if(f!=null) {
						ArrayList<String> myanswers= new ArrayList<>();
						System.out.println("that element has conflict you have to answer questions first : ");
						for(String q : f.getQuestions()) {
							System.out.println(q+" ?");
							myanswers.add(in.nextLine());
						}
						if(fs.CompareAnswers(f, myanswers)) {
							System.out.println("you will receive your element");
						}else {
							System.out.println("you cant take that element");
						}
					}else {
						System.out.println("you will receive your element");
					}
					}else {
						System.out.println("no resluts");
					}
				}
				else if(c1==3)
				{
					break;
				}
			}
		}
	}else if(c==2) {
		User user =new User ();
		System.out.println("please enter your name :");
		user.setName(in.next());
		System.out.println("please enter your email :");
		user.setEmail(in.next());
		System.out.println("please enter your password:");
		user.setPassword(in.next());
		boolean success=us.signup(user);
		if(success)
		{
			Lib.Platform.commit();
			System.out.println("signed up succesfully");	
		}
		else 
			System.out.println("your data is not correct ");	
		
	}else if(c==3)
		break;
	}
	
	Lib.Platform.commit();
	}

	
}
