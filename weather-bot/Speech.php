<?php
	extract($_POST);
	/*echo $voice;*/
	$f=fopen("Speech.txt",'w');
	fwrite($f,$voice);
	fclose($f);
	
?>
