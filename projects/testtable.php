
<?php
$accounts= mysql_connect("localhost", "root", "") or die(mysql_error());
$queryto=mysql_select_db("bookz", $accounts);

$sql="
INSERT INTO books (FirstName, LastName, Genre, Publisher, Title) VALUES ('Steven', 'King', 'Horror','PinguinBooks', 'Mizery');
";
$query=mysql_query($sql, $accounts);

if ($query) {
    echo "New record created successfully";
} else {
    echo "Error";
}

 
?>


