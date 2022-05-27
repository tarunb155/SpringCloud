package com.accenture.lkm;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.client.RestTemplate;

import com.accenture.lkm.service.CustomHystrixStateNotifier;
import com.accenture.lkm.service.MyService;
import com.netflix.hystrix.strategy.HystrixPlugins;

@SpringBootApplication
@EnableCircuitBreaker
public class Application {

    public static void main(String[] args) throws Exception {
       HystrixPlugins.getInstance().registerEventNotifier(new CustomHystrixStateNotifier());
       ConfigurableApplicationContext actx= SpringApplication.run(Application.class, args);
       MyService myService = actx.getBean(MyService.class);
       
       //testMethod1(myService);
       
       testMethod2(myService);
       actx.close();
    }
    
    public static void testMethod1(MyService myService){
     	System.out.println("\n\n– Initial circuit status is:");
 		getCircuitHealthStatus();
 		System.out.println("\n\n-- Testing Semi Open For Error: Invoking compute(0) --");
     	myService.compute(0);  getCircuitHealthStatus();
        System.out.println("\n\n-- Testing Semi Open Time Out: Invoking compute(1) --");
        myService.compute2(2); getCircuitHealthStatus();
        System.out.println("Final Status:");
        getCircuitHealthStatus();
    }    

     // gets short circuited with in 2.4 seconds
    public static void testMethod2(MyService myService) throws Exception{
    	System.out.println("\n\nInitial Circuit Status is:");
    	getCircuitHealthStatus();
    	
    	System.out.println("\n\n-- Invoking: compute() 40 times --");
         int n = 40;
         for (int i = 0; i < n; i++) {
        	 int num=i < (n * 0.6) ? 0 : 2; //returning 0 for the 60% of the total calls
             myService.compute(num);
             System.out.println("\n\n");
             TimeUnit.MILLISECONDS.sleep(100);
         } 
         TimeUnit.SECONDS.sleep(2);
         getCircuitHealthStatus();
         System.out.println("\n\n-- Normal call After 2 seconds --");
         myService.compute(2);
         
         TimeUnit.SECONDS.sleep(3);
         getCircuitHealthStatus();
         System.out.println("\n\n-- Normal call After 5 seconds --");
         myService.compute(2);
         TimeUnit.SECONDS.sleep(1);
         System.out.println("\n\nFinal Circuit Status is:");
         getCircuitHealthStatus();
    }
    
    //Following method is used to print the circuit status on console
    static public void getCircuitHealthStatus(){
    	RestTemplate restTemplate= new RestTemplate();
    	System.out.println("Circuit Status:"+restTemplate.getForObject("http://localhost:7093/health", Object.class));
    }
}
//https://www.logicbig.com/tutorials/spring-framework/spring-cloud/spring-circuit-breaker-hystrix-basics.html