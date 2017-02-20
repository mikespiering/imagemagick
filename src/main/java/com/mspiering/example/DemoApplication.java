package com.mspiering.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootApplication
public class DemoApplication {


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


    public static boolean resizeImage(String image_path, String quality, String size, String output_image) {
	// absolute path to ImageMagick: Command-line Tools: Convert
	String convert_path = "/usr/bin/convert";
	// Build process to execute convert
	ProcessBuilder pb = new ProcessBuilder(
					       convert_path,
					       image_path, 
					       "-quality", 
					       quality, 
					       "-resize",
					       size, 
					       output_image);  

	pb.redirectErrorStream(true);  

	try {
	    Process p = pb.start();
	    BufferedReader br = new BufferedReader( new InputStreamReader(p.getInputStream() ));
	    String line = null;  
	    while((line=br.readLine())!=null){  
		System.out.println(line);  
	    }
	}catch(Exception e) {  
	    System.out.println(e);
	    return false;
	}

	return true;
    }


}
