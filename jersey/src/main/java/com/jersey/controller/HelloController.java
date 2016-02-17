package com.jersey.controller;


import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.server.mvc.Viewable;
import org.springframework.beans.factory.annotation.Autowired;

import com.jersey.service.HelloService;

@Path("/hello") 
public class HelloController {
    
	@Autowired
	private HelloService helloService;
	
    @GET
    @Path("/{param}")
    @Produces("text/plain;charset=UTF-8")
    public String sayHello(@PathParam("param") String name) {
         return "hello" + name;
    }
    
    
    @GET
    @Path("/myjsp") 
    @Produces(MediaType.TEXT_HTML)
    public Viewable myjsp() {
    	String template = "/index";
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("hello", "我来了");
        return new Viewable(template, model);
    }
    
    
    @GET
    @Path("/userHello")
    @Produces("text/plain;charset=UTF-8")
    public String sayHelloToUser(@QueryParam("userId") String userId) {
         return helloService.sayHelloToUser(userId);
    }
}
