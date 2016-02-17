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
import org.springframework.stereotype.Component;

import com.jersey.model.User;
import com.jersey.service.UserService;

@Component
@Path("/hello")
public class HelloController {
	
	@Autowired
	private UserService userService;
	
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
    
    /**
     * 获取user
     * @param id
     * @return
     */
    @GET
    @Path("/getUser")
    @Produces("text/plain;charset=UTF-8")
    public String getUser(@QueryParam("id") String id) {
         return userService.getUser(id);
    }
    
    /**
     * 新增user
     * @param name
     */
    @GET
    @Path("/addUser")
    @Produces("text/plain;charset=UTF-8")
    public void addUser(@QueryParam("name") String name) {
         userService.addUser(name);
    }
    
    /**
     * 修改user
     * @param name
     * @param id
     */
    @GET
    @Path("/updateUser")
    @Produces("text/plain;charset=UTF-8")
    public void updateUser(@QueryParam("name") String name,@QueryParam("id") Long id) {
    	User user = new User();
    	user.setId(id);
    	user.setName(name);
         userService.updateUser(user);
    }
}
