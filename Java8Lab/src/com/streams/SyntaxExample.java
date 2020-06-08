package com.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static java.util.Arrays.asList;

import lombok.NonNull;


import static java.lang.System.*;
//import org.checkerframework.checker.nullness.qual.NonNull;
import static org.junit.Assert.assertEquals;

import com.test.data.SampleData;
import com.test.data.Track;
import com.test.data.Artist;
import com.test.data.Product;



public class SyntaxExample
 {
	
	List<Track> trackList =asList(new Track("Rehman",10),new Track("Mani",5),new Track("Harish",8));
	 
	
	
	public long  countInternalIteration() {
		long count;
		 
		return count =SampleData.getThreeArtists().stream().count();
		
	}
	
	public long getArtistCountByLocation(String location) {
		String artistName;
		long count;
		count =SampleData.getThreeArtists().stream().filter(as -> as.isFrom(location)).count();;
		return count;
	}
	
	public List<String> collect() {
		 List<String> listofStrings =Stream.of("A","B").collect(Collectors.toList());
		 assertEquals(Arrays.asList("A","B"),listofStrings);
		 return listofStrings;
	}
	
	public void map() {
		/*
		 * This is way of creating a stream from input values or existing array of values
		 * here map functional interface is: Function
		 */
		List<String> strList =Stream.of("a","b","1kl").map(str ->str.toUpperCase()).collect(toList());
		//assertEquals(Arrays.asList("A","B"),strList);
		
		/*
		 * This is the way to apply stream on existing List/Map etc
		 * Applying filter on List:
		 */
		List<String> numbList  =strList.stream().filter(value ->Character.isDigit(value.charAt(0))).collect(toList());
		
	}
	
	public void flatMapTest() {
		/*
		 * Here it is to combine all lists to a single list by using streams
		 * flatMap does this
		 * flatMap functional interface is: Function
		 */
		//Method 1:
		List <String> l1 =new ArrayList();
		List <String> l2 =new ArrayList();
		l1.add("A");
		l2.add("B");
		
		List <String> final1 =Stream.of(l1,l2).flatMap(str ->str.stream()).collect(toList());
		assertEquals(asList("A","B"),final1);
		
		//Method 2:
	      List <String> final2 = Stream.of(asList("A"),asList("B"),asList("C")).flatMap(str -> str.stream()).collect(toList());
	      assertEquals(asList("A","B","C"),final2);
		
	}
	
	public void testMinMaxByComparing() {
		
		
	    Track minTrack = trackList.stream().min(Comparator.comparing(Track::getLength)).get();
	    //Track minTrack = trackList.stream().min(Comparator.comparing(tr ->tr.getLenght())).get();
	    out.println("Min Track : "+minTrack.getName() +", Length: "+minTrack.getLength());
	    
	    Track maxTrack =trackList.stream().max(Comparator.comparing(Track::getLength)).get();
	    out.println("Max Track : "+maxTrack.getName() +", Length: "+maxTrack.getLength());
	    		
	}
	
	public void testReduce(){
		int result =Stream.of(-1).reduce(5, (acc,ele)->acc-ele);
		out.println("Reduce to Minus operation, with -ve input(-1) and +ve initial vaue(5) : "+result);
		
		result =Stream.of(-1).reduce(-5, (acc,ele)->acc-ele);
		out.println("Reduce to Minus operation  with -ve input and -ve initial value: "+result);
		
		result =Stream.of(1).reduce(5, (acc,ele)->acc-ele);
		out.println("Reduce to Minus operation  with +ve input and +ve initial value: "+result);
		
		result =Stream.of(1,2,3).reduce(5, (acc,ele)->acc+ele);
		out.println("Reduce to Plus operation  with +ve input and +ve innitial value "+result);
		
		result =Stream.of(-1).reduce(5, (acc,ele)->acc+ele);
		out.println("Reduce to Plus operation  with -ve input and +ve initial value: "+result);
		
		/*
		 * here the first value in reduce(), is considered as initial value, that will be
		 * applied on the iterations of the operation.
		 * Ex: initial value 6, then 6 will be applied on the final result of - operation
		 *  like: stream of values considered based on their -ve or +ve sign and reduced
		 *  to a single value that will be applied on to initial value and opration given .
		 * 
		 */
	}
	
	public void testCombiner() {
		int reducedParams =Stream.of(1, 2, 3)
				  .reduce(10, (a, b) -> a + b, (a, b) -> {
				     
				     return a + b;
				  });
		
		out.println("Combiner without parallel : "+ reducedParams);
	}
	
	public void testReduceToList() {
		List<Artist> artists =SampleData.getThreeArtists();
		
		int count =artists.stream().map(artist->artist.getMembers().count()).reduce(0L,Long::sum).intValue();
		
	out.println("testReduceToList: COUNT : "+count);
	}
	
	public void testForEachWithStreams() {
		Set ar =trackList.stream().filter(art -> art.getName().contains("a"))
				.map(art -> art.getName()).collect(toSet());
				
		ar.stream().forEach(a ->out.println("For each print: Artist names : "+a));
	}
	
	public void testChainedStreams() {
		/*
		 * It is always good to use chained streams, instead of seperate stream, because..
		 * 1.It is harder to read what is going on  because of boiler plate code to acual business logic is worse
		 * 2.less efficient because it requires eagerly creating new collection objects at each intermediate step.
		 * 3.It clutters your method with meaningless garbage variables
		 * 4.It makes operations harder to automatically parallelize.
		 * 
		 */
		
		/*
		 * Scenario: get set of artists whos score is 10, get their names
		 */
		
		Set<String> artists =trackList.stream().filter(track -> track.getLength() >= 10)
				.map(tr -> tr.getName()).collect(toSet());
		artists.forEach(ar ->out.println("Artists who's score is= 10 > : "+ar));
		/*
		 * here ar is plain string, hence we need to print, there is Track method to call.
		 */
	}
	
	public void testPrimitiveStream() {
		IntStream ist =IntStream.range(1, 4);
		out.println("IntStream elements : " + ist.sum());
	}
	
	public void testReduceToString() {
		
		String stringProducts =SampleData.productList.stream().map(Product::getName)
				               .collect(Collectors.joining(",","[","]"));
		out.println("Product list of strings "+","+" seperated : "+stringProducts);
	}
	
	public void testNumberAveraging() {
		double priceAvg =SampleData.productList.stream().collect(Collectors.averagingInt(Product::getPrice));
		out.println("Average Price: "+priceAvg);
	}
	public void testNumberSumm() {
		int sum =SampleData.productList.stream().collect(Collectors.summingInt(Product::getPrice));
		out.println("Sum of price : "+sum);
		
	}
	public void testGroupingBy() {
		Map<Integer,List<Product>> productMapByPrice =SampleData.productList.stream()
				                                      .collect(Collectors.groupingBy(Product::getPrice));
		
		productMapByPrice.forEach((k,v)->
		{
			out.println("Product price : "+k);
			v.forEach(product -> out.println("  Product name : "+product.getName()) );
		});
				
				;
	}
	
	public void testGroupByPredicate() {
		Map<Boolean,List<Product>> productMapByPrice =SampleData.productList.stream()
				.collect(Collectors.partitioningBy(element -> element.getPrice() >15));	
		
		productMapByPrice.forEach((k,v) ->
		{
				out.println("Status : "+k);
				v.forEach(element -> out.println("Value : "+element.getName()));
		}
				);
	}
	public static void main(String args[]) {
		SyntaxExample se =new SyntaxExample();
		
		se.testGroupByPredicate();
		/*se.testGroupingBy();
		se.testNumberSumm();
		se.testNumberAveraging();
		
		out.println("List count : "+se.countInternalIteration());
		out.println("Count by location : "+se.getArtistCountByLocation("UK"));
		out.println("Collect list size : "+(se.collect()).size());
		se.map();
		se.flatMapTest();
		se.testMinMaxByComparing();
		se.testReduce();
		se.testForEachWithStreams();
		se.testChainedStreams();
		se.testReduceToList();
		se.testPrimitiveStream();
		se.testCombiner();
		se.testReduceToString();
		*/
		}
	

}
