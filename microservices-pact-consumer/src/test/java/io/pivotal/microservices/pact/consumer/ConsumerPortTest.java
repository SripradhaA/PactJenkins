package io.pivotal.microservices.pact.consumer;

import au.com.dius.pact.consumer.*;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.PactFragment;
import net.sf.json.test.JSONAssert;

import org.junit.Rule;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/*import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;*/
import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;
import static junit.framework.TestCase.assertEquals;

public class ConsumerPortTest {
	@Autowired
	ConsumerPort c;
	@Autowired
	Foo foo1 ;
	
	@Rule
	public PactProviderRule rule = new PactProviderRule("Foo_Provider",this);
	
/*SECOND VERIFICATION*/
	
	@Pact(provider = "Foo_Provider", consumer = "Foo_Consumer")
	public PactFragment createFragment2(PactDslWithProvider builder) {
	Map<String, String> headers = new HashMap<>();
	headers.put("Content-Type","application/json;charset=UTF-8");
	        return builder
	                .uponReceiving("a second request")
	                .path("/orders/getAll")
	                .headers(headers)
	                .method("GET")
	                .willRespondWith()
	                .headers(headers)	
	                .status(200)
	                .body("{\"orderId\":50, \"productId\":0,\"customerId\":0,"
							+ "\"username\":\"mani\",\"paymentMode\":null,"
							+ "\"billingAddress\":null,\"deliveryAddr\":\"chennai\","
							+ "\"orderQuantity\":5,\"totalAmt\":1000}")
	                .toFragment();
	    }
	@SuppressWarnings("deprecation")
	@Test
	@PactVerification(value = "Foo_Provider", fragment = "createFragment2")
	public void runTest2() {
		Foo foo  = new Foo();
		try {			
			
			
			//ConsumerPort obj=new ConsumerPort(rule.getConfig().url());		
		    
			JSONAssert.assertEquals(new ConsumerPort(rule.getConfig().url()).getAll(),
					"{\"orderId\":50, \"productId\":0,\"customerId\":0,"
							+ "\"username\":\"mani\",\"paymentMode\":null,"
							+ "\"billingAddress\":null,\"deliveryAddr\":\"chennai\","
							+ "\"orderQuantity\":5,\"totalAmt\":1000}");
			//JSONAssert.assertEquals(new ConsumerPort(rule.getConfig().url()).foos(),foo.expectedResponse(foo));
			
           /*JSONAssert.assertEquals(obj.getAll(),foo.expectedResponse(foo));
        		   "{\"orderId\":50, \"productId\":0,\"customerId\":0,"
					+ "\"username\":\"mani\",\"paymentMode\":null,"
					+ "\"billingAddress\":null,\"deliveryAddr\":\"chennai\","
					+ "\"orderQuantity\":5,\"totalAmt\":1000}");*/
			} catch (Exception e) {
			System.out.println("&&&&&&&foo.Foo(foo)= "+foo1.expectedResponse(foo));
			
		
			
		}

	}
	    
	
	             /*FIRST VERIFICATION*/
	@Pact(provider = "Foo_Provider", consumer = "Foo_Consumer")
	public PactFragment createFragment(PactDslWithProvider builder) {

	Map<String, String> headers = new HashMap<>();		
	headers.put("Content-Type","application/json;charset=UTF-8");
		        return builder
				.uponReceiving("a request")
				.path("/orders/create")
				.headers(headers)
				.method("POST")				
				.body("1")
				.willRespondWith()
				.headers(headers)				
				.status(200)
				.body("{\"orderId\":null, \"productId\":0,\"customerId\":0,"
						+ "\"username\":\"mani\",\"paymentMode\":null,"
						+ "\"billingAddress\":null,\"deliveryAddr\":\"chennai\","
						+ "\"orderQuantity\":0,\"totalAmt\":0}")	
						.toFragment();	
		        
						
	}
	@SuppressWarnings("deprecation")
	@Test
	@PactVerification(value = "Foo_Provider", fragment = "createFragment")
	public void runTest() {
		Foo foo = new Foo();
		try {

			// ConsumerPort obj=new ConsumerPort(rule.getConfig().url());

			JSONAssert
					.assertEquals(
							new ConsumerPort(rule.getConfig().url()).foos(),
							"{\"orderId\":null, \"productId\":0,\"customerId\":0,"
									+ "\"username\":\"mani\",\"paymentMode\":null,"
									+ "\"billingAddress\":null,\"deliveryAddr\":\"chennai\","
									+ "\"orderQuantity\":0,\"totalAmt\":0}");
			// JSONAssert.assertEquals(new
			// ConsumerPort(rule.getConfig().url()).foos(),foo.expectedResponse(foo));

		} catch (Exception e) {
			System.out.println("&&&&&&&foo.Foo(foo)= "
					+ foo1.expectedResponse(foo));

		}

	}
	
	                
	
	
	
}
