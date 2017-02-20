package com.mspiering.example;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class DemoApplicationController {

@RequestMapping("/convert")
    public String convert( ) {
    System.out.println("Gotta convert!");
    String oldImg="/home/vcap/app/BOOT-INF/classes/public/image.jpg";
    String newImg="/home/vcap/app/BOOT-INF/classes/public/converted.jpg";
    
    DemoApplication.resizeImage(oldImg,"90%","200x",newImg);
    System.out.println("Done!");
    return "Original at /image.jpg new image at /converted.jpg";
}





}