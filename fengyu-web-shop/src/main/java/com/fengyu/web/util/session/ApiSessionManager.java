package com.fengyu.web.util.session;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;


public class ApiSessionManager {
	
	private Map<String, ApiSession> sessions=new HashMap<String, ApiSession>();
	private static ApiSessionManager instance;
	
	private ApiSessionManager(){
		
	}
	
	public static ApiSessionManager getInstance(){
		if (instance==null)
			instance=new ApiSessionManager();
		return instance;
	}
	
	public ApiSession getSession(String key, boolean create){
		ApiSession session =sessions.get(key);
		if (session==null && create) {
			session=new ApiSession(key);
			sessions.put(key, session);
		}
		
		return session;
	}

	public static void dumpSession() {
		Gson gson=new Gson();
		System.out.println(gson.toJson(getInstance()));
		
	}
}
