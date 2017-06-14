package com.project.common.persistence;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public abstract class BaseMongoDao<T> {

//	@Autowired
//	protected MongoTemplate mongoTemplate;
//
//	public void insert(T t,String collectionName){
//		mongoTemplate.insert(t,collectionName);
//	}

}
