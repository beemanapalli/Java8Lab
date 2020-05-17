package com.tools;

import static java.lang.System.out;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.test.data.Artist;
import com.test.data.SampleData;

public class ForEach {


	
	public void testForEachWithComplexMap(Stream<Artist> artists) {
		
		Map<Boolean, List<Artist>> lists=artists.collect(Collectors.partitioningBy(
				artist -> artist.isSolo()));
				
		lists.forEach((k,v) ->
		{
			out.println("Key : "+k);
			v.forEach(li -> out.println("Value from List : "+li.getName()));
		}
		
			
		);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ForEach fr =new ForEach();
		fr.testForEachWithComplexMap(SampleData.threeArtists());

	}

}
