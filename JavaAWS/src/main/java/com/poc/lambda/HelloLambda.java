package  com.poc.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

 

import java.util.Map;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

// Handler value: example.Handler

  public class HelloLambda implements RequestHandler<Map<String, String>,  String>{
  
  @Override 
  public String handleRequest(Map<String, String> event , Context  context) {
 
/*
 * public class HelloLambda implements RequestHandler<Object, String>{
 * 
 * @Override public String handleRequest(Object event , Context context) {
 */
 
    LambdaLogger logger = context.getLogger();
    String lambdaResponse =  "GANESHA"+event.get("number1");
   // String lambdaResponse =  "GANESHA";
    // log execution details
    
    logger.log("EVENT TYPE: " + event.getClass().toString());
    return lambdaResponse;
  }
}