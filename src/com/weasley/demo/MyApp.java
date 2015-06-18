package com.weasley.demo;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest")
public class MyApp extends Application {
	Set<Class<?>> myResources = new HashSet<Class<?>>();
	@Override
	public Set<Class<?>> getClasses() {
		myResources.add(CustomerREST.class);
		return myResources;
	}
}
