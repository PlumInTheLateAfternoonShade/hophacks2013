package main;

import java.util.List;
import src.main.java.com.socrata.api.*;

public class Main {
    public static void main(String[] args) {
    	Soda2Consumer consumer = Soda2Consumer.newConsumer("https://sandbox.demo.socrata.com", "testuser@gmail.com", "OpenData", "D8Atrg62F2j017ZTdkMpuZ9vY");

    	//To get a raw String of the results
    	ClientResponse response = consumer.getHttpLowLevel().query("nominationsCopy", HttpLowLevel.JSON_TYPE, SoqlQuery.SELECT_ALL);
    	String payload = response.getEntity(String.class);
    	System.out.println(payload);

    	//Get get this automatically serialized into a set of Java Beans annotated with Jackson JSON annotations
    	List<Nomination> nominations = consumer.query("nominationsCopy", SoqlQuery.SELECT_ALL, Nomination.LIST_TYPE);
    	TestCase.assertTrue(nominations.size() > 0);
    	System.out.println(nominations.size());
    	System.out.println("Hello.");
    }
}
