package core.generics.collections;

import java.util.ArrayList;
import java.util.List;

class Animal2{
	
}

class Dog2 extends Animal2{
	
}
public class WildCardExtends  {

//	public void addAnimal(? extends Animal  ){	} //#1 
	
	public void addAnimal(List<? extends Animal2> animal){	//#2
		
//		animal.add(new Dog2()); //#3.1  NotOK
//		animal.add(new Animal2());//#4.1  Not OK
	}
	
	public void addAnimal2(List<Animal2> animal){	//#2.1
		
//		animal.add(new Dog()); //#3.2
//		animal.add(new Animal());//#4.2
	}
	
	public static void main(String[] args) {
		WildCardExtends wc =new WildCardExtends();
		List<Animal2> li =new ArrayList<Animal2>();//#5
		li.add(new Animal2());//#6
		li.add(new Dog2());//#7
		List<Dog2> li2 =new ArrayList<Dog2>();//#8
		li2.add(new Dog2());//#9
		
		wc.addAnimal(li);  //#10 OK
//		wc.addAnimal2(li2);  //#11 NotOK
		wc.addAnimal(li2);  //#12 OK
		 

	}

}

/*
#1 --> is wrong, since there is no specific variable name.
#2 --> y
#3.1 -->Not ok, becuase we can't add new element of subtype. to do so, we need to use SUPER key work
*/