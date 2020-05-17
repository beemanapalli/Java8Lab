package com.advanced.collector;

import static java.util.Arrays.asList;
import static java.lang.System.out;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.test.data.Album;
import com.test.data.Artist;
import com.test.data.SampleData;

import static java.util.stream.Collectors.toCollection;

import java.util.Comparator;
import java.util.IntSummaryStatistics;

public class CollectorsTest {

	List<Integer> numbers = asList(1,2,3,4);
	
	public void testTreeSet() {
		TreeSet ts =numbers.stream().collect(toCollection(TreeSet::new));
		
		ts.forEach(ele->System.out.println("TreeSet element : "+ele));
	}
	
	public int testSummingInt(Stream<Album> albums) {
		
		int sum=0;
		
		sum =albums.collect(Collectors.summingInt(album -> album.getTrackList().size()));
		return sum;
	}
	public IntSummaryStatistics testSummarizingInt(Stream<Album> albums) {
		
		IntSummaryStatistics sum =albums.collect(Collectors.summarizingInt(album -> album.getTrackList().size()));
		return sum; 
	}
	
	public Double testAveraging(Stream<Album> albums) {
		
		
		 Double avg = albums.collect(Collectors.averagingInt(album ->album.getTrackList().size()));
		 return avg;
	}
	public Optional<Artist> testMinBy(Stream<Artist> artists) {
		
		Function<Artist,Long> getCount =artist ->artist.getMembers().count();
		return artists.collect(Collectors.minBy(Comparator.comparing(getCount)));
	}
	
	public Optional<Artist> testMaxBy(Stream<Artist> artists) {
		Function<Artist, Long> getCount = artist ->artist.getMembers().count();
				
				
		/*here we are defining a lambda expression, which works based on the object
		 * type being declared in<>, hence 'artist' able to show the members of the
		 * class/type which defined in<>. ex: Function<Artist,Long> change to
		 * Function<Long, Long> will not show the method 'getMembers'.
		 * 
		 */
		
		return artists.collect(Collectors.maxBy(Comparator.comparing(getCount)));
		/*
		 * here we are passing a methods 'getCount' definition as argument to 'comparing' method,
		 * which getCount we already defined above as Function.
		 */
		
	}
	
	public void testPartitionBy(Stream<Artist> artists){
		
		Map<Boolean, List<Artist>> lists=artists.collect(Collectors.partitioningBy(
				artist -> artist.isSolo()));
		callTestPartitionBy(lists);
		 
	}
	
	public void testGroupBy(Stream<Album> albums) {
		
		Map<Artist, List<Album>> artAl =
				albums.collect(Collectors.groupingBy(al -> al.getMainMusician()));
			
		callTestGroupBy(artAl);
		
	}
	
	public void callTestGroupBy(Map<Artist, List<Album>> artAl) {
		artAl.forEach((k,v) ->
		{
		out.println("Key :"+k);
		v.forEach( al -> out.println("Value from List : "+al.getName()));
		}
		);
	}
	public void callTestPartitionBy(Map<Boolean, List<Artist>> lists) {
		 
		
		lists.forEach((k,v) ->
		{
			out.println("Key : "+k);
			v.forEach(li -> out.println("Value from List : "+li.getName()));
		}
		
			
		);
		
	}
	
	public static void main(String args[]) {
		CollectorsTest ct =new CollectorsTest();
		
		ct.testTreeSet();
		Optional<Artist> ar =ct.testMaxBy(SampleData.threeArtists());
		System.out.println("Max return : "+ ar.get().getName());
		/*
		 * Artist 'The Beatles' has 3 members hence it is max. Rest other are 0 members
		 * 
		 */
		
		ar =ct.testMinBy(SampleData.threeArtists());
		System.out.println("Min return : "+ar.get().getName());
		/*
		 * Double avg =ct.testAveraging(SampleData.albums);
		 * out.println("Avg return : "+avg);
		 */
		
		
		/*
		 * IntSummaryStatistics is =ct.testSummarizingInt(SampleData.albums);
		 out.println("IntSummaryStatistics :All "+is); 
		 out.println("IntSummaryStatistics :Average "+is.getAverage());
		 out.println("IntSummaryStatistics :Max "+is.getMax());
		 * 
		 * If we uncomment above  can cause: 
		 * Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed
		 */
	
		
		 int sum =ct.testSummingInt(SampleData.albums);
		 out.println("Summing data : "+sum);
		 
		 ct.testPartitionBy(SampleData.threeArtists());
		 
		 ct.testGroupBy(SampleData.albums);
		 
	
	}
}
