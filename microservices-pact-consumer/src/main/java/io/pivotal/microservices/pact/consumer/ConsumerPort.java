package io.pivotal.microservices.pact.consumer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Configuration
@Component
public class ConsumerPort {

	private String url;
	private RestTemplate restTemplate;
	public ConsumerPort() {
		
	}
	@Autowired
	public ConsumerPort(String url) {
		this.url = url;	
		System.out.println("printing url-------"+url);
		this.restTemplate = new RestTemplate();
	}

	/*public Foo foos() {
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
		HttpEntity<Object> httpEntity = new HttpEntity<Object>("1",requestHeaders);			
		ParameterizedTypeReference<Foo> responseType = new ParameterizedTypeReference<Foo>(){};
		Foo res =restTemplate.exchange(url + "/orders/create", HttpMethod.POST, httpEntity,responseType).getBody();
		return res;

	}*/
	public String foos() {
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
		HttpEntity<Object> httpEntity = new HttpEntity<Object>("1",requestHeaders);			
		ParameterizedTypeReference<String> responseType = new ParameterizedTypeReference<String>(){};
		String res =restTemplate.exchange(url + "/orders/create", HttpMethod.POST, httpEntity,responseType).getBody();
		return res;

	}
	/*public Foo getAll()
	{
		
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(requestHeaders);
		ParameterizedTypeReference<Foo> responseType = new ParameterizedTypeReference<Foo>(){};
		Foo res =restTemplate.exchange(url + "/orders/getAll", HttpMethod.GET, httpEntity,responseType).getBody();
		return res;
	}*/
	public String getAll()
	{
		
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(requestHeaders);
		ParameterizedTypeReference<String> responseType = new ParameterizedTypeReference<String>(){};
		String res =restTemplate.exchange(url + "/orders/getAll", HttpMethod.GET, httpEntity,responseType).getBody();
		return res;
	}
}
