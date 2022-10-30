package com.jcg.mongodb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;



@WebServlet("/add")
public class Result extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

	// This method is called by the servlet container to process a 'post' request
		public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
		{
			
			handleRequest(request, response);
		}

		public void handleRequest(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
		{

			res.setContentType("text/html;charset=UTF-8");
			 PrintWriter out=res.getWriter();
			  out.println("<!DOCTYPE html>");
		      out.println("<html>");
		      out.println("<head>");
		      out.println("<title>NCD Risk Assessment Checklist</title> ");
		      out.println("</head>");
		      out.println("<body>");
		      out.println("<pre>");
		      out.println("<h2>");
		      
		      out.println("patient id       : "+com.jcg.mongodb.servlet.Registration.pid );
		      out.println("patient name     : "+com.jcg.mongodb.servlet.Registration.pnm);
		      out.println("patient gender   : "+com.jcg.mongodb.servlet.Registration.gen);
		      out.println("patient aadhar no: "+com.jcg.mongodb.servlet.Registration.aadhaar);
		      out.println("patient email    : "+com.jcg.mongodb.servlet.Registration.emal);
		      out.println("patient ph       : "+com.jcg.mongodb.servlet.Registration.ph);

		      out.println("</h2>");
		      out.println("<br>");
		      out.println("<br>");
		      out.println("<br>");
		      out.println("<br>");
		      

		      out.println("<h2>");

			  int i=Integer.parseInt(req.getParameter("age"));
			  
			  int j1=Integer.parseInt(req.getParameter("2pp"));
			  int j2=Integer.parseInt(req.getParameter("3pp"));
			  int j3=Integer.parseInt(req.getParameter("4pp"));
			  int j4=Integer.parseInt(req.getParameter("5pp"));
			  int j5=Integer.parseInt(req.getParameter("6pp"));
			  
			  int k=i+j1+j2+j3+j4+j5;
			  String result;
			  out.println("result is :"+k);
			  if(k >= 4)
			  {
				  result="NEED TO SCRINNING";
				  out.println("NEED TO SCRINNING");
			  }
			  else{
				  
				  result=" NO NEED TO SCRINNING";
				  out.println(" NO NEED TO SCRINNING");
			  }
			  out.println("</h2>");
			  out.println("</h2><br><br><button onclick=\"location.href = 'signup.jsp';\" id=\"myButton\" class=\"float-left submit-button\" >Home</button>\r\n"
			  		+ "");
			  
			  out.println("</h2><br><br><button type=\"reset\"  onclick=history.back() align=center>Go Back</button>");
			  out.println("</pre>");
		      out.println("</body>");
		      out.println("</html>");
		     
		      try (MongoClient mongo = new MongoClient( "localhost" , 27017 ))
			    {
			    	// Accessing the database 
				    MongoDatabase database = mongo.getDatabase("java_NCD_database"); 
				    
				    
				    try
				    {
				    	// Creating a collection
						database.createCollection("pinfo");
				    } catch (Exception exception) 
				    {
				        System.err.println("Collection:- PatientInfo already Exists");
				    }
				    
				    // Retrieving a collection
				    MongoCollection<Document> collection = database.getCollection("pinfo"); 
				    System.out.println("Collection PatientInfo selected successfully"); 
				    
				    try
				    {
				    	BasicDBObject searchQuery = new BasicDBObject("Aadhaar UID",Registration.aadhaar);
				    	
				    	BasicDBObject updateFields = new BasicDBObject();
				       	updateFields.append("Score", k);
				    	updateFields.append("Result", result);

				    	BasicDBObject setQuery = new BasicDBObject();
				    	setQuery.append("$set", updateFields);
				    	collection.updateMany(searchQuery, setQuery);
				    
				    	
				    }
				    catch (MongoException me) {
		                System.err.println("Unable to insert due to an error: " + me);
		            }
//				end of try  global    
			    }
		      
			    
			  

//end of handel function
		    }
		    
		   
//		end of http function   	    
	   }


//
//
//// Creating a Mongo client
//
//try (MongoClient mongo = new MongoClient( "localhost" , 27017 ))
//{
//	// Accessing the database 
//    MongoDatabase database = mongo.getDatabase("NcdDb"); 
//    
//    
//    try
//    {
//    	// Creating a collection
//		database.createCollection("PatientInfo");
//    } catch (Exception exception) 
//    {
//        System.err.println("Collection:- PatientInfo already Exists");
//    }
//    
//    // Retrieving a collection
//    MongoCollection<Document> collection = database.getCollection("PatientInfo"); 
//    System.out.println("Collection PatientInfo selected successfully"); 
//    
//    try
//    {
//    	BasicDBObject searchQuery = new BasicDBObject("Aadhaar UID",Registration.aadhaar);
//    	
//    	BasicDBObject updateFields = new BasicDBObject();
//    	updateFields.append("Smoke", smoke);
//    	updateFields.append("Alcohol", alcohol);
//    	updateFields.append("Waist", waist);
//    	updateFields.append("Physical Activity", phy_act);
//    	updateFields.append("Family History", fam_his);
//    	updateFields.append("Total Score", total);
//    	updateFields.append("Screening", screening);
//    	BasicDBObject setQuery = new BasicDBObject();
//    	setQuery.append("$set", updateFields);
//    	collection.updateMany(searchQuery, setQuery);
//    	
//    	
    	/*collection.updateMany(Filters.eq("Aadhaar UID",Registration.aadhaar), Updates.combine(
    	        Updates.set("Smoke", smoke),
    	        Updates.set("Alcohol", alcohol),
    	        Updates.set("Waist", waist),
    	        Updates.set("Physical Activity", phy_act),
		    	Updates.set("Family History", fam_his),
		    	Updates.set("Total Score", total),
		    	Updates.set("Screening", screening)
		    	
    	    ));*/
    	
//    }
//    catch (MongoException me) {
//        System.err.println("Unable to insert due to an error: " + me);
//    }
    

