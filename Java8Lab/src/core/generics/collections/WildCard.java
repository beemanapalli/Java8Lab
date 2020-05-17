package core.generics.collections;

import java.util.ArrayList;
import java.util.List;

class Bar<T> //#2
{
	
	public void doInsert(List<?> list){ //#1
		//list.add(new Integer(1));
		System.out.println(list.get(0));
		
	}
}
public class WildCard {

	public static void main(String [] args) {
		// TODO Auto-generated method stub
		
		Bar br =new Bar();
		List<Integer> li =new ArrayList<Integer>();
		li.add(1);
		br.doInsert(li);

	}

}

/*
#1 -->here if we give List<T>  instead List<?>, it is compile error if there is no <T> at #2.
     with <T> at #2, we can give <?> or <T> at #1
#2 -->it accept only <T> or<E> like any <Letter> but not <?>

*/