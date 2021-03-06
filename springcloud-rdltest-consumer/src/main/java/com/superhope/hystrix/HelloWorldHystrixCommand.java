package com.superhope.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class HelloWorldHystrixCommand extends HystrixCommand<String>{
    private final String name;
    public HelloWorldHystrixCommand(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.name = name;
    }
 
    @Override
    protected String run() throws Exception {
        //Thread.sleep(100);
        return "hello"+name;
    }
    
    public static void main(String[] args){
        String result = new HelloWorldHystrixCommand("test").execute();
        System.out.println(result);
    }
}