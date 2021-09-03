package HQL;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Student {
	private String name;
	
	@Id
	private int rollno;
	private int mark;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", rollno=" + rollno + ", mark=" + mark + "]";
	}
	
	
	
	
}
