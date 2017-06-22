package io.pivotal.microservices.pact.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

@Configuration
@ComponentScan
@EnableAutoConfiguration

@RestController
public class Application {
	Foo foo ;
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

  /*  @RequestMapping(value = "/insert", method = RequestMethod.GET, consumes="text/plain;charset=ISO-8859-1",produces="text/plain;charset=ISO-8859-1")
    //public ResponseEntity<List<Foo>> foos() {
    public @ResponseBody ResponseEntity<String> foos(HttpServletResponse response) {
    	//Foo foo = new Foo().setZz("Insert Service Invoked............");
    	response.setContentType("text/plain;charset=UTF-8");
        return new ResponseEntity<>("Insert Service Invoked............", HttpStatus.OK);
    }
    */
    
    
    /*@RequestMapping(value="/insert",method = RequestMethod.GET)
    public @ResponseBody String foos(HttpServletResponse response)
    { 
    	//Foo foo = new Foo("Insert Service Invoked............");
    	foo.setZz("Insert Service Invoked............");
    	response.setContentType("text/plain;charset=ISO-8859-1");
    	return foo.getZz();
    	//return ("Insert Service Invoked............").toString();
    	//return new ResponseEntity<>(Arrays.asList(new Foo(42), new Foo(100)), HttpStatus.OK);
    	
    }*/
    /*@RequestMapping(value="/hi",method = RequestMethod.GET)
    public String himethod() {
    	return "Insert Service Invoked............";
    }*/
    
    /*@RequestMapping(value="/insert",method = RequestMethod.GET,produces="text/plain;charset=ISO-8859-1")
    public @ResponseBody ResponseEntity<String> foos(HttpServletResponse response) {
    	//response.setContentType("text/plain;charset=ISO-8859-1");
    	return new ResponseEntity<String>("Insert Service Invoked............",HttpStatus.OK);
    	//new Foo("Insert Service Invoked............"),HttpStatus.OK);
    }*/
    
    @RequestMapping(value="/orders/create",method = RequestMethod.POST/*,produces="application/json;charset=ISO-8859-1"*/)
    public @ResponseBody ResponseEntity<String> foos(HttpServletResponse response) {
    	response.setContentType("application/json;charset=ISO-8859-1");
    	return new ResponseEntity<String>("[{\"orderId\":1, \"customerId\":18,\"customerName\":\"abc\","
				+ "\"email\":\"SA00434296@TechMahindra.com\",\"phNumber\":7402434294,"
				+ "\"deliveryAddr\":\"bangalore\",\"status\":\"Shipped\","
				+ "\"shippingId\":1}]",HttpStatus.OK);
    	//new Foo("Insert Service Invoked............"),HttpStatus.OK);
    }
    
    
}
