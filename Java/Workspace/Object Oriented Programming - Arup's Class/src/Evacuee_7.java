/*
 * 
 * Kelsey Cameron
 * Arup Guha's OOP Practice
 * 6/26/15
 * 
 * 
 */
public class Evacuee_7 implements Comparable<Evacuee_7> {

	private String last_name;
	private String first_name;
	private int gender;
	//1 is male
	//2 is female
	private int age;
	private int annual_inc;
	private int priority;
	public Evacuee_7(String lname, String fname, int gend, int age, int annual, int prior){
		this.last_name = lname;
		this.first_name = fname;
		this.gender = gend;
		this.age = age;
		this.annual_inc = annual;
		this.priority = prior;
		
	}
	
	
	/*
	 * What is the evacuee’s last name?
DiCaprio
What is the evacuee’s first name?
Leonardo
Is the evacuee 1)male or 2)female?
1
How old is the evacuee?
23
What is the evacuee’s annual income(US$)?
70

	 * 
	 * 
	 * 
	 */
	
	

	@Override
	public int compareTo(Evacuee_7 o) {
		// TODO Auto-generated method stub
		int which = 0;
		priority = 0;
		o.priority = 0;
	/*	if(age < 18 && o.age >=18){
			priority++;
		}
		else if(age >= 18 && o.age < 18){
			o.priority++;
		}*/
		
		// children
		if(age!=0){
		if(age < 18 && o.age < 18){
			//System.out.println("//////////////////" + o.first_name + " " + first_name);
			// For some reason it stops as soon as it finds a male
		if(age == o.age){
			which = compare(last_name, o.last_name);
			if(which == 1){
				o.priority++;
			}
			else if(which == 2){
				priority++;
			}
			else{
				which = compare(first_name, o.first_name);
				if(which == 1){
					o.priority++;
				}
				else if(which == 2){
					priority++;
				}
			}
		}
		else if(age < o.age){
			priority++;
		}
		else if(age > o.age){
			o.priority++;
		}
		}
		 if(age < 18 && o.age >= 18){
			priority++;
		}
		else if(age >= 18 && o.age < 18){
			System.out.println("//////////////////" + o.first_name);
			
			o.priority++;
		}
		
		// adults
		else if(age >= 18 && o.age >= 18){
			if(gender > o.gender){
				priority++;
			}
			else if(gender < o.gender){
				o.priority++;
			}
		else if(gender == o.gender){
				// now compare based on wealth
				
				if(annual_inc > o.annual_inc){
					priority++;
					
				}
				else if(annual_inc< o.annual_inc){
					o.priority++;
				
				}
				else if(annual_inc == o.annual_inc){
					// now compare based on lname and fname
					which = compare(last_name, o.last_name);
					if(which == 1){
						o.priority++;
					}
					else if(which == 2){
						priority++;
					}
					else{
						which = compare(first_name, o.first_name);
						if(which == 1){
							o.priority++;
						}
						else if(which == 2){
							priority++;
						}
					}
					
					
				}
				
				
			}
		}
		
		}
	//	System.out.println("Priority for: " + first_name + " " + last_name + " " + (o.priority - priority));
		return o.priority - priority;
	}


public static int compare(String name1, String name2){
	int flag = 0;
	if(name1.compareToIgnoreCase(name2) > 0){
		flag = 1;
	}
	else if(name1.compareToIgnoreCase(name2) < 0){
		flag = 2;
	}
	return flag;
}
@Override
public String toString() {
	String gend = "";
	if(this.gender == 1){
		gend = "Male";
	}
	else if(this.gender == 2){
		gend = "Female";
	}
    return "Name: " + first_name + " " + last_name + " (" + gend + ", age " + age + ", income $" + annual_inc + ")";
}
}
/*public static void main(String[] args) {
		// TODO Auto-generated method stub

	}*/
