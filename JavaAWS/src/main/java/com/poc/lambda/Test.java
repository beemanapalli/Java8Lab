package com.poc.lambda;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
public class Test {

	public static void main(String[] args) {
		 String lambdaResponse = new String("It is AWS Lambda --HELLO");
		 Gson gson = new Gson();
		    // log execution details
		    String JsonRes =gson.toJson(lambdaResponse);
System.out.println("JSON Output : "+gson.toString());
	}

}
