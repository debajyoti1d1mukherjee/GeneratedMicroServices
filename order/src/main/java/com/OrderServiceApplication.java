package com;

import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import java.lang.reflect.Method;
import org.springframework.web.bind.annotation.RequestBody;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableHystrix
public class OrderServiceApplication {
    public static void main(String[] args){
		SpringApplication.run(OrderServiceApplication.class, args);
		}
}

	
	
@RestController
class orderRestController {

	public orderRestController(){}

  

//TEMPLATE_GET_METHOD_START
   @RequestMapping(value="getOrder/{id}", method = RequestMethod.GET,produces = { "application/json"})
   @HystrixCommand(fallbackMethod = "getOrderFallBack",commandProperties ={
				@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000")
			})			
			
    public com.order.GetOrderResponse getOrder(@PathVariable("id") String id) throws Exception{
		  com.order.GetOrderResponse resp = new com.order.GetOrderResponse();
		  System.out.println("Get Method Invoked--------------------------");
		  Class respClass = resp.getClass();
		  Method[] methods = respClass.getMethods();
		  for(Method method : methods){			    
			    if(isSetter(method)) {
			    	System.out.println("setter: " + method);
			    	method.invoke(resp, new Object[] { "100M" });
			    }
			  }
	      return resp;
    }
    
//TEMPLATE_FALLBACK_GET_METHOD_START
   public com.order.GetOrderResponse getOrderFallBack(@PathVariable("id") String id) throws Exception{
		  com.order.GetOrderResponse resp = new com.order.GetOrderResponse();
		  System.out.println("Fallback Get Method Invoked--------------------------");
		  Class respClass = resp.getClass();
		  Method[] methods = respClass.getMethods();
		  for(Method method : methods){			    
			    if(isSetter(method)) {
			    	System.out.println("setter: " + method);
			    	method.invoke(resp, new Object[] { "100M" });
			    }
			  }
	      return resp;
    }
   
//TEMPLATE_POST_METHOD_START
   @RequestMapping(value="saveOrder/save", method = RequestMethod.POST,produces = { "application/json"})
   @HystrixCommand(fallbackMethod = "saveOrderFallBack",commandProperties ={
				@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000")
			})			
			
    public com.order.SaveOrderResponse saveOrder(@RequestBody com.order.SaveOrderRequest request) throws Exception{
		  com.order.SaveOrderResponse resp = new com.order.SaveOrderResponse();
		  System.out.println("Post Method Invoked--------------------------");
		  Class respClass = resp.getClass();
		  Method[] methods = respClass.getMethods();
		  for(Method method : methods){			    
			    if(isSetter(method)) {
			    	System.out.println("setter: " + method);
			    	method.invoke(resp, new Object[] { "100M" });
			    }
			  }
	      return resp;
    }
   
//TEMPLATE_FALLBACK_POST_METHOD_START
   public com.order.SaveOrderResponse saveOrderFallBack(@RequestBody com.order.SaveOrderRequest request) throws Exception{
		  com.order.SaveOrderResponse resp = new com.order.SaveOrderResponse();
		  System.out.println("Post Fallback Method Invoked--------------------------");
		  Class respClass = resp.getClass();
		  Method[] methods = respClass.getMethods();
		  for(Method method : methods){			    
			    if(isSetter(method)) {
			    	System.out.println("setter: " + method);
			    	method.invoke(resp, new Object[] { "100M" });
			    }
			  }
	      return resp;
    }
   
   
//TEMPLATE_POST_METHOD_START
   @RequestMapping(value="updateOrderRequest/save", method = RequestMethod.POST,produces = { "application/json"})
   @HystrixCommand(fallbackMethod = "updateOrderRequestFallBack",commandProperties ={
				@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000")
			})			
			
    public com.order.UpdateOrderResponse updateOrderRequest(@RequestBody com.order.UpdateOrderRequest request) throws Exception{
		  com.order.UpdateOrderResponse resp = new com.order.UpdateOrderResponse();
		  System.out.println("Post Method Invoked--------------------------");
		  Class respClass = resp.getClass();
		  Method[] methods = respClass.getMethods();
		  for(Method method : methods){			    
			    if(isSetter(method)) {
			    	System.out.println("setter: " + method);
			    	method.invoke(resp, new Object[] { "100M" });
			    }
			  }
	      return resp;
    }
   
//TEMPLATE_FALLBACK_POST_METHOD_START
   public com.order.UpdateOrderResponse updateOrderRequestFallBack(@RequestBody com.order.UpdateOrderRequest request) throws Exception{
		  com.order.UpdateOrderResponse resp = new com.order.UpdateOrderResponse();
		  System.out.println("Post Fallback Method Invoked--------------------------");
		  Class respClass = resp.getClass();
		  Method[] methods = respClass.getMethods();
		  for(Method method : methods){			    
			    if(isSetter(method)) {
			    	System.out.println("setter: " + method);
			    	method.invoke(resp, new Object[] { "100M" });
			    }
			  }
	      return resp;
    }
   
   
//TEMPLATE_FALLBACK_POST_METHOD_END
   
      public static boolean isSetter(Method method){
	   if(!method.getName().startsWith("set")) return false;
	   if(method.getParameterTypes().length != 1) return false;
	   return true;
	 }

}	

