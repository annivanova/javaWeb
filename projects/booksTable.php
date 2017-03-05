<?php

$accounts= mysql_connect("localhost", "root", "") or die(mysql_error());
mysql_select_db("bookz", $accounts);
$sql="CREATE TABLE books
(
ID int NOT NULL AUTO_INCREMENT,
PRIMARY KEY(ID),
FirstName varchar (20),
LastName varchar (20) , 
Genre varchar (20),
Publisher varchar (20), 
Title varchar (20)
)";
mysql_query($sql, $accounts);







?>