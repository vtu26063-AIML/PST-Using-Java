import java.lang.reflect.*;
import java.util.*;


class Singleton {
    // 1. Static variable to hold the single instance
    private static Singleton single_instance = null;

    // 2. Public String instance variable
    public String str;

    // 3. Private constructor
    private Singleton() {
        // nothing here
    }

    // 4. Static method to get the single instance
    public static Singleton getSingleInstance() {
        if (single_instance == null) {
            single_instance = new Singleton();
        }
        return single_instance;
    }
}
public class Task3 {

 public static void main(String args[])throws Exception{
	
	Scanner sc=new Scanner(System.in);
	Singleton s1 = Singleton.getSingleInstance(); //retrive the single instance
    Singleton s2=Singleton.getSingleInstance();
    assert(s1==s2);
    
	//verify that the constructor is private
	Class c=s1.getClass();
	Constructor[] allConstructors = c.getDeclaredConstructors();
	assert allConstructors.length==1;
	for (Constructor ctor : allConstructors) 
	{
		if(ctor.getModifiers()!=2 || !ctor.toString().equals("private Singleton()")) //The constructor must be private
		{
			System.out.println("Wrong class!");
		}
	}
    String str=sc.nextLine();
	s1.str=str;
    s2.str=str;
    System.out.println("Hello I am a singleton! Let me say "+str+" to you");
	
 }

}