package com.accenture.lkm.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class MyService {
  @HystrixCommand(fallbackMethod = "cstFallbackDoSomething")
  public void compute(int input) {
      System.out.println("compute: input: " + input);
      //in case of exception fallbackMethod is called
      System.out.println("compute: 10/"+input+", output: " + 10 / input);
  }

  @HystrixCommand(fallbackMethod = "cstFallbackDoSomething")
  public void compute2(int input) {
      try {
          TimeUnit.MILLISECONDS.sleep(3000);// timeout scenario
      } catch (InterruptedException e) {
          return;
      }
      System.out.println("compute2: input: " + input);
      System.out.println("compute2: 10/"+input+", output: " + 10 / input);
  }
  
  public void cstFallbackDoSomething(int input,Throwable th) {
	  System.out.println("************************FallBack***************************************");
	  System.out.println("***FallBackLog: cstFallbackDoSomething, The input number is: " + input+"***");
      System.out.println(th.getMessage());
      System.out.println("************************FallBack***************************************");
  }
  
}