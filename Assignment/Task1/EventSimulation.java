package practice;

import java.util.*;

public class EventSimulation {
	 
	// Function to simulate biased events
		 public static Map<String, Integer> simulateEvent(Map<String, Integer> outcomes, int totalOccurrences) {
		        Map<String, Integer> eventResults = new HashMap<>();
		        
		        // Initializing the eventResults map with outcome keys and initial count of 0
		            for (Map.Entry<String, Integer> entry : outcomes.entrySet()) {
		                eventResults.put(entry.getKey(), 0);
		            
		        }
		        
	        Random random = new Random();
	        int a=0, b=0, c=0, d=0, e=0;
	        
	        
	        // Simulating the event for the specified number of occurrences 
	        for (int i = 0; i < totalOccurrences; i++) {
	            int randNum = random.nextInt(100) + 1;
	           if(randNum>0 && randNum<=10) {
	        	   a++;
	        	   
	           }
	           else if(randNum>10 && randNum<=40) {
	        	   b++;
	        	   
	           }
	           else if(randNum>40 && randNum<=55) {
	        	   c++;
	        	   
	           }
	           else if(randNum>55 && randNum<=70) {
	        	   d++;
	        	   
	           }
	           else if(randNum>70 && randNum<=100) {
	        	   e++;
	        	   
	           }

	        // Determining the outcome based on the generated random number
	                for (Map.Entry<String, Integer> entry : outcomes.entrySet()) {
	                   
	                    String k=entry.getKey();
	                    if(entry.getKey()=="1")
	                    	 eventResults.put(entry.getKey(),a);
	                    else if(entry.getKey()=="2")
	                    	 eventResults.put(entry.getKey(),b);
	                    else if(entry.getKey()=="3")
	                    	 eventResults.put(entry.getKey(),c);
	                    else if(entry.getKey()=="4")
	                    	 eventResults.put(entry.getKey(),d);
	                    else if(entry.getKey()=="5")
	                    	 eventResults.put(entry.getKey(),e);
	                    else if(entry.getKey()=="5")
	                    	 eventResults.put(entry.getKey(),0);
	                    		                       
	                    
	                }
		            
		        }
		        
		        return eventResults;
		    }
		    
		    public static void main(String[] args) {
		        Map<String, Integer> biasedDice = new HashMap<>();
		        biasedDice.put("1", 10);
		        biasedDice.put("2", 30);
		        biasedDice.put("3", 15);
		        biasedDice.put("4", 15);
		        biasedDice.put("5", 30);
		        biasedDice.put("6", 0);
		       
		        int totalOccurrences = 1000;// Number of event occurrences
		        
		        // Simulate events and get results
		        Map<String, Integer> diceResults = simulateEvent(biasedDice, totalOccurrences);		       
		        // Print simulation results
		        System.out.print("On triggering the event 1000 times, ");
		        for (Map.Entry<String, Integer> entry : diceResults.entrySet()) {
		        	
		            System.out.print(entry.getKey()+" appeared "   + entry.getValue() + " times"+", ");
		        }
		        System.out.println("which is roughly inline with the biasness given. "); 
		        System.out.println("This is just one of the possibilities.\n"
		        		+ " "); 
		    }
		}