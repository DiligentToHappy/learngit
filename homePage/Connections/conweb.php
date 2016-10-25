<?php
# FileName="Connection_php_mysql.htm"
# Type="MYSQL"
# HTTP="true"
$hostname_conweb = "localhost";
$database_conweb = "phpweb";
$username_conweb = "root";
$password_conweb = "";
$conweb = mysql_pconnect($hostname_conweb, $username_conweb, $password_conweb) or trigger_error(mysql_error(),E_USER_ERROR); 
?>