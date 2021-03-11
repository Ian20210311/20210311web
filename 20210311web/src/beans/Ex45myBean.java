package beans;
import java.util.*;

public class Ex45myBean {
	
	ArrayList<String> al=new ArrayList<String>();
	String item=null;
	String submit=null;
	
	
	private void addItem(String name) {
		al.add(name);
	}
	
	private void removeItem(String name) {
		al.remove(name);
	}
	
	public void setItem(String name) {
		item=name;
	}
	
	public void setSubmit(String submit) {
		this.submit=submit;
	}
	
	public String[] getItems() {
		String[] temp=null;
		temp=new String[al.size()];
		for(int i=0;i<temp.length;i++) {
			temp[i]=al.get(i);
		}
		return temp;
	}
	
	public void processRequest() {
		if(submit==null) {
			addItem(item);
		}
		
		if(submit.equals("add")) {
			addItem(item);
		}
		
		if(submit.equals("remove")) {
			removeItem(item);
		}
		reset();
	}
	
	private void reset() {
		submit=null;
		item=null;
	}

}
