<!DOCTYPE html>
<html>
<head>
  <title>Number one dating site</title>
  
</head>

<body>
  <h1>Please Enter Your Details for Our Dating Website!</h1>
  <form action="http://ihome.ust.hk/~rossiter/cgi-bin/show_everything.php" method="post" enctype="multipart/form-data">
  <fieldset>
		<legend>Your face  </legend>
        <label for="avatar">Your image:</label>
            <input type="file" id="avatar" name="avatar" required><br>
        <label for="imgpreview"> Image preview:</label><img src="#" id="preview">

      
  </fieldset><br>
  <fieldset>
  	<legend>Your general details</legend>

       <label for="name">Name:</label> <input type= "text" id="name" name="name" required><br>
		<label for="gender">Gender:</label><input type="radio"  name="gender" value="male" required>Male 
        <input type="radio" name="gender" value="female" required>Female <br>
       <label for="age">Age:</label> <input type="number" name="age" value="18" required><br>
       <label for="dob"> Date of birth:</label> 
        <input type="date" name="dob"><br>
        <label for="color"> Favorite color:</label>
        <input type="color" name="color"> <br>
         <label for="countries"> Which country:</label>
         <select name="countries">
       			<option value="ns">no selection</option>
       			<option value="npl">Nepal</option>
                <option value="us">USA</option>
                <option value="ca">Canada</option>
                <option value="ch">China</option>
                <option value="ind">India</option>
        </select>
  </fieldset><br>
  <fieldset><legend>Your indicators</legend>
<label for="height"> Height:</label>
  	Short <input type="range"  name="height" min="0" max="100"> Tall<br>
  <label for="salary"> Salary:</label>
  	Poor <input type="range" name="salary" min="0" max="100"> Rich

  </fieldset><br>

  <fieldset>
<legend>Your Contact Information</legend>
    <label for="email"> Email:</label>
<input type="email" name="email" required><br>
<label for="mobile"> Mobile:</label>
<input type="tel" name="mobile"><br>
<label for="address"> Address:</label>
<textarea id="txtArea" name="address"></textarea><br>
<label for="contact"> Method to contact you:</label>

<input type="checkbox" name="contact" value="email"> Email 
  <input type="checkbox" name="contact" value="whatsapp" > Whatsapp  
  <input type="checkbox" name="contact" value="inappchat" > In-app chat


  </fieldset><br>

<input type="submit" value="Submit">
</form>
  
</body>
</html>