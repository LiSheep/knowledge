package com.knowledge.common;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.knowledge.arc.KnowledgeEntity;

public class ObjectToJson<T extends KnowledgeEntity> {
	private Gson gson = new Gson();
	
	public String convertObjectToJson(T t) {
		Type entityType = new TypeToken<T>() {}.getType();
		
		return gson.toJson(t, entityType);
	}
	
	public T convertJsonToObject(String json, Class<T> clazz) {
		return gson.fromJson(json, clazz);
	}
	
	public String convertObjectIncludeListToJson(T t) {
		Type entityType = new TypeToken<T>() {}.getType();
		
		return gson.toJson(t, entityType);
	}
	
	public String convertListToJson(List<T> t) {
		
		return gson.toJson(t);
	}
}
