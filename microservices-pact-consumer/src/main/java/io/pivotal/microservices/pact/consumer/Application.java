package io.pivotal.microservices.pact.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@RestController
public class Application {

	@Autowired
	 ConsumerPort consumerPort  ;

   @RequestMapping(value="/foos", method = RequestMethod.POST
    		,
    		consumes="application/json;charset=UTF-8"
    		,produces="application/json;charset=UTF-8")
    public String foos() {
    	
    return consumerPort.foos();
    }		
        
    
	 @RequestMapping(value="/getAll", method = RequestMethod.GET
	    		,produces="application/json;charset=UTF-8")
	    public String getAll() {
	    	
	    return consumerPort.getAll();
	    }
    @RequestMapping("/")
    public String hello() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
