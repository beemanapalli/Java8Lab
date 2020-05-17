package core.generics.collections;

import java.util.ArrayList;
import java.util.List;



class Animal3{
	
}

class Dog3 extends Animal3{
	
}
class Puppy3 extends Dog3{
	
}
public class WildCardSuper  {
	
	final int t =0;
	static int s =0;

//	public void addAnimal(? extends Animal  ){	} //#1 
	
	public void addAnimal(List<? super Dog3> animal){	//#2
		//t=5;
		s=8;
		
 	animal.add(new Dog3()); //#3.1    OK
 //	animal.add(new Animal3());//#4.1  Not OK
 	animal.add(new Puppy3()); //5.1    OK
	}
	
	public void addAnimal3(List<Animal3> animal){	//#2.1
		
//		animal.add(new Dog()); //#3.2
//		animal.add(new Animal());//#4.2
	}
	
	public static void main(String[] args) {
		WildCardSuper wc =new WildCardSuper();
		List<Animal3> li =new ArrayList<Animal3>();//#5
		li.add(new Animal3());//#6
		li.add(new Dog3());//#7
		List<Dog3> li2 =new ArrayList<Dog3>();//#8
		li2.add(new Dog3());//#9
		
		wc.addAnimal(li);  //#10 OK
//		wc.addAnimal3(li2);  //#11 NotOK
		wc.addAnimal(li2);  //#12 OK
		 

	}

} 

/*
 * #2 --> it accept  any of Dog3 or super type,while adding we can add only Dog or it's sub types
#4.1 is not OK, since Animal3 is super of Dog3
#11 is not OK, since the method is acception only List<Animal3>, but we are passing List<Dog3>
*/
