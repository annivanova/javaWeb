  <html>
<head>
<link rel="stylesheet" type="text/css" href="booksandauthors.css" media="screen">
</head>
<body background="image.jpg">
 
<?php
   echo "<h2>You are about to submit some data</h2>";
 
    if (isset($_POST['submit'])) {
	$firstName=$_POST['FirstName'];
	$lastName=$_POST['LastName'];
	$genre=$_POST['Genre'];
	$publisher=$_POST['Publisher'];
	$title=$_POST['Title'];
        echo "<h2>Submit was set</h2>";
 
        $accounts = mysql_connect("localhost", "root", "");
        if (!$accounts) {
            echo "<h2>Failed to connect to DB server: " + mysql_error() + "</h2>";
        }
        else {
            echo "<h2>Connected to DB server</h2>";
 
            if (!mysql_select_db("bookz", $accounts)) {
                echo "<h2>Failed to select DB: " + mysql_error() + "</h2>";
            }
            else {
                echo "<h2>DB selected</h2>";
 
                $sql="INSERT INTO books (FirstName, LastName,Genre, Publisher, Title) VALUES ('$firstName', '$lastName', '$genre', '$publisher', '$title');";
                $query=mysql_query($sql, $accounts);
                if (!$query) {
                    echo "<h2>Cannot insert data" + mysql_error() + "</h2>";
                }
                else {
                    echo "<h2>Data inserted</h2>";
                }
            }
        }
    }
    else {
        echo "<h2> Submit was not set</h2>";
    }
?>
 
 <h2 align="center">Authors and Books` World</h2>
 
<p><b>Fill information here</b> </p>
 <form action="index.php" method="post">
<b>FirstName</b> <br><input type="text" name="FirstName"><br>
<b>LastName</b><br><input type="text" name="LastName"><br>
<b>Genre</b><br><input type="text" name="Genre"><br>
<b>Publisher</b><br><input type="text" name="Publisher"><br>
<b>Title</b><br> <input type="text" name="Title"><br>
<br>
<input type="submit" name="submit" value="Submit">
</form>
<p2><Here you can read all about your fav authors and books</p2>
</body>
</html>