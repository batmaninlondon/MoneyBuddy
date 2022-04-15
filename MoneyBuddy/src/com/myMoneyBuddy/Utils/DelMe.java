package com.myMoneyBuddy.Utils;

import java.util.Comparator;

public class DelMe implements Runnable  {
	
	public void divide ( int a, int b)  {
		
		try {
			String arr[] = new String[10];
			
			arr[0] = "one";
			System.out.println("arr[0] : "+arr[0]);
		}catch ( Exception e)  {
			System.out.println("Exception "+e);
		}
		finally {
			System.out.println(" finally ");
		}
	}
	
	/*static int x[] = new int[10];
	
	static {
		x[0] = 1;
	}*/
	
	public void run()  {
		System.out.println(" Thread created ");
	}
	
	public DelMe()  {
		Thread t = new Thread(this);
		t.start();
	}
	public static void main(String... args) throws Exception  {
		
		System.out.println(" DelMe mail sending start ");
		SendMail sendMail = new SendMail();
		
		String mailLink = "http://moneybuddy.co.in/resetPassword";
		System.out.println("mailLink is : "+mailLink);
		
		sendMail.MailSending("savita.wadhwani@gmail.com", "HI there", "ForgotPasswordMail", "ForgotPasswordMail.txt",
				mailLink, "Reset your password please", "Savita", "");
	
		System.out.println(" DelMe mail sending end ");

		/*Base obj= new Derived();
		obj.display();
		obj.print();
		
		inter i =  System.out::println ;
		
		i.hello("hello");*/
		
		
		/*String a = "meau"; /// this wil be created in String pool
		String ab = a+"deal"; // this will be created in the heap 
		String abc = "meaudeal"; // this will be created in the String pool 
		System.out.println(ab == abc); // false --- how ??
		
		
		String str1 = "Hello";
		String str2 = "World";
		String str3 = new String("HelloWorld");
		String str4 = str1 + str2;
		
		
		String str5="HelloWorld"; //This line will create one more String Constant Pool object because we are using variable name as str5.
		 String str6="HelloWorld";////This line will not create any object, this will refer the same object str5.
		 
		 System.out.println(str3==str4); //false
		 System.out.println(str4==str5);//false
		 System.out.println(str5==str6);//true
*/		 
		
		
		 
		
		/*Dep d1 = new Dep (14,1000);
		Dep d2 = new Dep (13,600);

		ArrayList<Dep> l2 = new ArrayList<Dep>();
		l2.add(d1);
		l2.add(d2);*/
		
		/*for ( Dep e : l2)  {
			System.out.println("before"+e.age);
		}
		
		AgeCom ageCom = new AgeCom();
		Collections.sort(l2,ageCom);
		
		for ( Dep d : l2)  {
			System.out.println("after"+d.age);
		}
		*/
		
		/*for ( Dep e : l2)  {
			System.out.println("before : sal : "+e.sal);
		}
		
		SalCom salCom = new SalCom();
		Collections.sort(l2,salCom);
		
		for ( Dep d : l2)  {
			System.out.println("after sal : "+d.sal);
		}*/
		
		
		/*
		
		
		Emp e1 = new Emp (14,"a");
		Emp e2 = new Emp (13,"s");
		
		ArrayList<Emp> l1 = new ArrayList<Emp>();
		l1.add(e1);
		l1.add(e2);
		
		for ( Emp e : l1)  {
			System.out.println("before"+e.age);
		}
		
		
		Collections.sort(l1);
		
		for ( Emp e : l1)  {
			System.out.println("after"+e.age);
		}
		
		System.out.println("hello"+e1.compareTo(e2));*/
		
		/*byte a = 10;   
        byte b = 15;  
        DelMe test = new DelMe(a,b);  */
		

}
	
/*	static boolean findPnlTerm ( Date d1, Date d2 )  {
		
		
	      
	      long duration = d2.getTime() - d1.getTime();
	      long diffInDays = TimeUnit.MILLISECONDS.toDays(duration);
	      
	      int remainingDays = d2.getYear()% 4;
	      int numOfDaysOfYear = 0;
	      if (remainingDays == 0 )  
	    	  numOfDaysOfYear = 366;
	      else 
	    	  numOfDaysOfYear = 365;
	      
	      if (diffInDays > numOfDaysOfYear) {
	    	  
	         return true;
	      } else {
	         return false;
	      } 
	      
	}*/
	
	static int calculate ()   {
		
		return (7/2);
		
	}

	/*DelMe(int a, float b)  
    {  
        System.out.println(" called test with float : a = "+a+" b = "+b);  
    }
	
	DelMe(int a, int b)  
    {  
        System.out.println(" called test with int : a = "+a+" b = "+b);  
    }  */
     

	
	
}

class Person {
	public void talk() {}
}

interface inter {
	public void hello(String s);
}
class Base {
	static void display() {
		System.out.println("Static or class method from Base");
	}
	public void print() {
		
		System.out.println("Non-static or instance method from Base");
	}
}
class Derived extends Base {
	static void display() {
		System.out.println("Static or class method from Derived");
	}
	public void print() {
		
		System.out.println("Non-static or instance method from Derived");
	}
}


class Dep {
	
	int age;
	int sal;
	public Dep(int age, int sal) {
		
		this.age = age;
		this.sal = sal;
	}
	
}

class Per {
	
	int age;
	int name;
	public Per(int age, int name) {
		
		this.age = age;
		this.name = name;
	}
	
}


class AgeCom implements Comparator<Dep>   {
	
	@Override
	public int compare(Dep o1, Dep o2) {
		
		return (o1.age-o2.age);
	}
	
	
}



class SalCom implements Comparator<Dep>   {
	
	@Override
	public int compare(Dep o1, Dep o2) {
		
		return (o1.sal-o2.sal);
	}
	
	
}


class Emp implements Comparable<Emp> {
	
	int age;
	String name;
	public Emp(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	

	@Override
	public int compareTo(Emp o) {

		
		return (this.age - o.age);
	}
	
}




