package com.application.cors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CORSUrl implements Serializable{

	private static final long serialVersionUID = 1L;
	private static List<String> urls = new ArrayList<>();

	public static List<String> getUrls(){
		urls.add("http://localhost:8080");
		urls.add("http://192.168.25.56/");
		return urls;
	}

}
