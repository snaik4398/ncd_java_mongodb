package com.jcg.mongodb.servlet;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.swing.text.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;



import org.bson.Document; 



@WebServlet("/signup")
public class Registration extends HttpServlet {
	public static String pid;
	public static String aadhaar;
	public static String pnm;
	public static String emal;
	public static String gen;
	public static String pin;
	public static String dob;
	public static String ph;



	private static final long serialVersionUID = 1L;

	// This method is called by the servlet container to process a 'post' request
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		handleRequest(request, response);
	}

	public void handleRequest(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		  PrintWriter out=res.getWriter();
		  out.println("<!DOCTYPE html>");
	      out.println("<html>");
	      out.println("<head>");
	      out.println("<title>NCD Risk Assessment Checklist</title> ");
	      out.println("</head>");
	      out.println("<body>");
	      
	      	      String fnm=req.getParameter("fname");
	      String lnm=req.getParameter("lname");
	      pnm=fnm.concat(lnm); 
		  	 emal=req.getParameter("email");
		  	 gen=req.getParameter("gender");
		  	 pin=req.getParameter("gender");
		  	 dob=req.getParameter("birthday");
		  	 ph=req.getParameter("phno");
		  aadhaar=req.getParameter("adhar");
		  
		    
	    long  min = 99999999999999L;
	    long  max = 10000000000000L;
//the value of (max-min+1)+min is 10^^14+1
	    long random_int = (long)(Math.random() * (max - min + 1) + min);
	     pid = Long.toString(random_int);
	
		  
		  
		  
		  // Creating a Mongo client
		  
		  
		  try (MongoClient mongo = new MongoClient( "localhost" , 27017 ))
		  {
			  
			  // Accessing the database 
			  MongoDatabase database = mongo.getDatabase("java_NCD_database"); 
			  
			  
			  try
			  {
				  // Creating a collection
				  database.createCollection("pinfo");
			  } 
			  catch (Exception exception) 
			  {
				  System.err.println("Collection:- PatientInfo already Exists");
			  }
			  
			  // Retrieving a collection
//			  MongoCollection collection = database.getCollection("pinfo"); 
//			  System.out.println("Collection PatientInfo selected successfully"); 
//			    // Retrieving a collection
			    MongoCollection<Document> collection = database.getCollection("pinfo"); 
			    System.out.println("Collection PatientInfo selected successfully"); 
			    


	  try
	  {
		  Document document = new Document("patient_id", pid)
				  .append("First Name", fnm)
				  .append("Last Name", lnm)
				  .append("Gender", gen)
				  .append("Aadhaar UID",aadhaar)
				  .append("Phone No", ph)
				  .append("DOB", dob)
				  .append("Pincode", pin);
	  	  
				  //Inserting document into the collection
				  collection.insertOne(document);	
				  
				  req.getRequestDispatcher("/index.jsp").forward(req, res);
			  }
			  catch (MongoException me) {
				  System.err.println("Unable to insert due to an error: " + me);
			  }
		  }
//		  displaying the data in the data base
		  out.println("Name: "+fnm+" "+lnm);

		  out.println("<br><br>");
		  out.println("Gender: " +gen);

		  out.println("<br><br>");
		  out.println("Email:"+emal);

		  out.println("<br><br>");
		  out.println("DOB:"+dob);

		  out.println("<br><br>");
		  out.println("PINCODE:"+pin);
		  
		  out.println("<br><br>");
//		  birthday
		  out.println("<a href=\"index.html\" class=\"sign\">calculate data </a>");
		  
		  out.println("</h2><br><br><button onclick=\"location.href = 'index.jsp';\" id=\"myButton\" class=\"float-left submit-button\" >CALCULATE</button>\r\n"
			  		+ "");
		  out.println("</h2><br><br><button onclick=\"location.href = 'signup.jsp';\" id=\"myButton\" class=\"float-left submit-button\" >Home</button>\r\n"
			  		+ "");
			  
			/* int j1=Integer.parseInt(req.getParameter("2pp")); */
	      out.println("</h2><br><br><button type=\"reset\"  onclick=history.back() align=center>Go Back</button>");
	      out.println("</body>");
	      out.println("</html>");
	
			    
		    
//	 ending of handel request function     
	}
	
//	final block ending bracket
}



