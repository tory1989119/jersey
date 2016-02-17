package com.jersey.common;

import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.jsp.JspMvcFeature;

public class MyResourceConfig extends ResourceConfig {
	 public MyResourceConfig() {
		//扫描controller
		packages("com.jersey.controller");
		//jsp
	    property(JspMvcFeature.TEMPLATE_BASE_PATH, "/WEB-INF/jsp");
	    register(JspMvcFeature.class);
	    //文件上传
	    register(MultiPartFeature.class);
	 }
}
