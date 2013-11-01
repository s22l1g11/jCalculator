<?php
	echo $_SERVER['REMOTE_ADDR'];
	$users = simplexml_load_file('java.xml');
	$newuser = $users->addChild('user');
	$newuser->addChild('time',date('d.m.Y H:i:s'));
	$newuser->addChild('ipaddress', $_SERVER['REMOTE_ADDR']);
	$newuser->addChild('os',$_SERVER['HTTP_USER_AGENT']);
	if ($_GET['os'] != "")
	{
		$newuser->addChild('os2',$_GET['os']);
	}
	if ($_GET['osv'] != "")
	{
		$newuser->addChild('os_version',$_GET['osv']);
	}
	$users->asXML('java.xml');
	
?>