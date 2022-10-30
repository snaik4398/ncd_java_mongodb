<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style type="text/css">
   .myTable {
      background-color: #eee;
      border-collapse: collapse;
   }

   .myTable th {
      background-color: #000;
      color: white;
      width: 50%;
   }

   .myTable td,
   .myTable th {
      padding: 5px;
      border: 1px solid #000;
   }

   table {
      border-collapse: collapse;
   }

   th,
   td {
      border: 1px solid;
      height: 70px;
      padding: 10px;
      text-align: left;
   }
</style>

<body>
<h2>
<%
//this pre tag helps to create new line refer : https://stackoverflow.com/questions/4856976/out-println-does-not-work  
out.println("<pre>");
out.println("patient id       : "+com.jcg.mongodb.servlet.Registration.pid );
out.println("patient name     : "+com.jcg.mongodb.servlet.Registration.pnm);
out.println("patient gender   : "+com.jcg.mongodb.servlet.Registration.gen);
out.println("patient aadhar no: "+com.jcg.mongodb.servlet.Registration.aadhaar);
out.println("patient email    : "+com.jcg.mongodb.servlet.Registration.emal);
out.println("patient ph       : "+com.jcg.mongodb.servlet.Registration.ph);

out.println("</pre>");
%>
</h2>
<form action="add" method="post">

<!--  
  <form action="/submit" method='post'>
-->
    <h2>NCD Risk Assessment Checklist</h2>
    <table>
      <tr class="myTable">
        <td>Question</td>
        <td>Range</td>
        <td>Circle Any</td>
        <td>Score</td>
      </tr>

      <tr>
        <td>
          <h1>1. What is your age? (in complete years)</h1>
        </td>
        <td>
          <table class="myTable" width="100%" border="2 solid">
            <tr>
              <td>30-39 </td>
            </tr>
            <tr>
              <td>40-49</td>
            </tr>
            <tr>
              <td>50-59</td>
              <tr>
                <td>60</td>
              </tr>
            </table>
          </td>
          <td>
            <table class="myTable" width="100%" border="2 solid">
              <tr>
                <td>0 </td>
              </tr>
              <tr>
                <td>1</td>
              </tr>
              <tr>
              <td>2</td>
            </tr>
            <tr>
              <td>3</td>
            </tr>
          </table>
        </td>
        <td>
          
          
          <div>
            <label>input 0/1/2/3</label>
            <input type="number" id="age" name="age" />
            
            
            
          </div>
        </td>
        
        
        
      </tr>
      
      
      <tr>
        <td>
          <h2>2.Do you smoke or Consume smokeless product like Gutka or Khaini</td></h2>
        <td>
          <table class="myTable" width="100%" border="2 solid">
            
            <tr>
              
              <td> Never </td>
            </tr>
            <tr>
              <td> Used to consume in past/ sometime now </td>
              
            </tr>
            <tr>
              <td> Daily</td>
              
            </table>
          </td>
          <td>
            <table class="myTable" width="100%" border="2 solid">
              <tr>
                <td>0 </td>
              </tr>
              <tr>
                <td>1</td>
              </tr>
              <tr>
                <td>2</td>
              </tr>

            </table>
          </td>
          <td>
            
            <!-- <select name="score2" id="S2val" onchange="para2()">
              <option value="0">0</option>
              <option value="1">1</option>
              <option value="2">2</option>
            </select> -->
            <div>
              <label>input 0/1/2</label>
              <input type="number" id="2pp" name="2pp" />
            </td>
          </tr>
          <!-- 3rd para -->
          
          
          <tr>
            <td><h2>
              3. Do you consume alcohol daily?</h2></td>
              <td>
                <table class="myTable" width="100%" border="2 solid">
                
                
                
                <tr>
                  
                  <td> yes </td>
                </tr>
                <tr>
                  <td> No</td>
                  
                </tr>
                
              </table>
            </td>
            <td>
          <table class="myTable" width="100%" border="2 solid">
            <tr>
              <td>0 </td>
            </tr>
            <tr>
              <td>1</td>
            </tr>
            
          </table>
        </td>
        <td>
          
          <div>
            <label>input 0/1</label>
            <input type="number" id="3pp" name="3pp" />
          </div>
          
          
          
        </td>
      </tr>
      
      <!-- 4th question -->
      
      <tr>
        <td><h2>4. Measurement of waist in (Cm)</h2></td>
        <td>
          <table class="myTable" width="100%" border="2 solid">
            <tr>
              
              <td>Female</td>
              <td> Male</td>
            </tr>
            <tr>
              
              <td>80 cm or less</td>
              <td> 90 cm or less</td>
            </tr>
            <tr>
              <td>81-90 cm</td>
              <td> 90-100 cm</td>
            </tr>
            <tr>
              
              <td>More than 90 cm</td>
              <td> More than 100 cm</td>
            </tr>
            
          </table>
        </td>
        <td>
          <table class="myTable" width="100%" height="100%" border="2 solid">
            <tr>
              <td>0 </td>
            </tr>
            <tr>
              <td>1</td>
            </tr>
            <tr>
              <td>2</td>
            </tr>
            <tr>
              <td>3</td>
            </tr>
            
            
          </table>
        </td>
        <td>
          
          <!-- <select name="score4" id="S4" onchange="para4()">
            <option value="0">0</option>
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
          </select> -->
          <div>
            <label>input 0/1/2/3</label>
            <input type="number" id="4pp" name="4pp" autocomplete="off" />
            
          </div>
        </td>
      </tr>
      
      
      <!-- 5th para -->
      <tr>
        <td><h2>5. Do you undertake any physical activities for a minimum of 150 minutes a week?
        </h2></td>
        <td>
          <table class="myTable" width="100%" border="2 solid">
            <tr>
              <td> At least 150 minutes a week
              </td>
            </tr>
            <tr>
              <td> Less than 150 min a week</td>
            </tr>
          </table>
        </td>
        <td>
          <table class="myTable" width="100%" height="100%" border="2 solid">
            <tr>
              <td>0 </td>
            </tr>
            <tr>
              <td>1</td>
            </tr>
            
          </table>
        </td>
        <td>
          
          <!-- <select name="score5" id="S5" onchange="para5()">
            <option value="0">0</option>
            <option value="1">1</option>
            
          </select> -->
          <div>
            <label>input 0/1</label>
            <input type="number" id="5pp" name="5pp" autocomplete="off" />
            
          </div>
        </td>
      </tr>
      
      <!-- 6thpara -->
      
      <tr>
        <td><h2>6. Do you have a family history (any one of your parents or siblings) of high blood pressure, diabetes
          and
          heart
          disease?
        </h2>
        </td>
        <td>
          <table class="myTable" width="100%" border="2 solid">
            <tr>
              <td> yes </td>
            </tr>
            <tr>
              <td> No</td>
              
            </tr>
          </table>
        </td>
        <td>
          <table class="myTable" width="100%" height="100%" border="2 solid">
            <tr>
              <td>0 </td>
            </tr>
            <tr>
              <td>1</td>
            </tr>
            
          </table>
        </td>
        <td>
          <div>
            <label>input 0/1</label>
            <input type="number" id="6pp" name="6pp" autocomplete="off" />
            
          </div>
        </td>
        
      </tr>
      
    </table>
   
    <button type="submit" class="btn btn-primary">Submit</button>
    <button type="reset" value="reset">Clear</button>
  


<!-- 
<input type="submit" >
 -->
</form>
 <br>
  <br>
  <h3> A score above 4 indicates that the person may be at higher risk of NCDs and needs to be prioritized for
    attending screening for following NCDs and then confirmed if there is any of them.
    Diabetes
    Hypertension
    Breast Cancer
    Cervical Cancer
    Oral Cancer
    For those who are curious - more about NCD </h3>
    <a href="https://www.who.int/news-room/fact-sheets/detail/noncommunicable-diseases ">click here</a>
    
   
</body>
</html>