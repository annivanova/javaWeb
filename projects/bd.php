<?php

$accounts= mysql_connect("localhost", "root", "") or die(mysql_error());

$sql="CREATE DATABASE bookz";

$query=mysql_query($sql, $accounts);
if($query){
echo "BD CREATED";
}
else{
	echo"DB Error";
}





?>