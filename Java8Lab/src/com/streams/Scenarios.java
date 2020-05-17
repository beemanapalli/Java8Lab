package com.streams;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toList;
import static java.lang.System.out;

import java.util.List;
import java.util.Set;

import com.test.data.Track;

public class Scenarios {
	
	List<Track> trackList =asList(new Track("Rehman",10),new Track("Rehman",7),new Track("Mani",5),new Track("Harish",8));
	
	public void getSetFromBusinessDomain() {
		/*Get all Rehman tracks into List, using Streams all operations
		 * 
		 */
		long count  =trackList.stream().filter(ar ->ar.getName().startsWith("R"))
				.count();
		
		out.println("Count of artists starts with R :"+count);
		
		Set ar =trackList.stream().filter(art -> art.getName().contains("a"))
				.map(art -> art.getName()).collect(toSet());
				
		ar.stream().forEach(a ->out.println("Artist names : "+a));
		
		Set ar2 =trackList.stream().filter(art -> art.getName().contains("R"))
				.map(art -> art.getName()).collect(toSet());
		
		ar2.stream().forEach(a ->out.println("Artist names , siince it is Set, eleminates duplicates: "+a));	
		
	}
	
	public void geMaptFromBusinessDomain(){
		
		/*
		 * Map m =trackList.stream().filter(tr ->tr.getName().startsWith("R"))
		 * .collect(toMap(tr->tr.getName(), tr->tr.getName()));
		 */
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scenarios sc =new Scenarios();
		
		sc.getSetFromBusinessDomain();

	}

}
