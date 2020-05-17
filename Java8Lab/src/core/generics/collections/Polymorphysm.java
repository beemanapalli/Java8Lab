package core.generics.collections;

import static java.lang.System.*;

import java.util.ArrayList;
import java.util.List;

abstract class Animal{
	public abstract void checkup();
}


class Dog extends Animal{
	public void checkup(){
		out.println("Dog checkup");
	}
}

class Cat extends Animal{
	public void checkup(){
		out.println("Cat checkup");
	}
}
class AnimalDoctorGeneric{

	public void checkAnimal(List<Animal> animalList){  //--->1
		
		animalList.add(new Cat());
		
		for(Animal an : animalList){
			an.checkup();
		}
		
		
	}
}
public class Polymorphysm {

	
	public static void main(String[] args) {
		List<Animal> animals =new ArrayList<Animal>();
		animals.add(new Dog());
		
		AnimalDoctorGeneric ad =new AnimalDoctorGeneric();
		ad.checkAnimal(animals);

	}

}

/*
 * 1. We can't use like..
 * 	List<Animal> animals =new ArrayList<Dog>();
 *  List<Animal> animals =new ArrayList<Cat>();
 *  
 *  Since, polymorphysm can be applied only at base level i.e List -->ArrayList. But not for generics
 *  <Animal> --> <Dog>. The type should be same/match in reference variable(left hand side of = operator) and object(right hand side of = operator)
 *  
 *  2.We declared parameter type : List<Animal> animalList --> in the method.
 *   We can add sub type element to the list
 *   like: animalList.add(new Cat())--> it is legal and acceptable.
 *   
 *   3. Generic type information( between <> ) will be removed after compilation. So JVM not aware of the type we are passing at run time.
 *   
 *   4. You can't pass List<Dog> animals =new ArrayList<Dog>(); to public void checkAnimal(List<Animal> animalList){ --> though Animal is super
 *      type of Dog, since  checkAnimal(List<Animal> animalList) --> expecting only of the type 'Animal> type collection, but not sub type.
 *      Passing List<Animal> animals =new ArrayList<Animal>(); to checkAnimal(List<Animal> animalList) is valid
 *      even though animal has collection of Dog and Cat instances inside.
 */
