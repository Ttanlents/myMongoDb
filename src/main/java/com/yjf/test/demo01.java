package com.yjf.test;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;
import org.junit.Test;

/**
 * @author 余俊锋
 * @date 2020/11/25 10:42
 * @Description
 */
public class demo01 {

    @Test
    public void myTest(){
        MongoClient client = new MongoClient("192.168.190.130", 27017);
        MongoDatabase spitdb = client.getDatabase("spitdb");
        MongoCollection<Document> spit = spitdb.getCollection("spit");
        //查询
        FindIterable<Document> documents = spit.find();
        for (Document document : documents) {
            System.out.println(document.get("_id"));
            System.out.println(document.get("title"));
        }
        Document document = new Document();
        document.put("title","今天天气特别好");
        FindIterable<Document> documents1 = spit.find(document);
        for (Document doc : documents1) {
            System.out.println("我是谁？"+doc.get("_id"));
            System.out.println(doc.get("title"));
        }
        //添加
        Document document3 = new Document();
        document.put("title","今天天气特别好，哈哈");
        spit.insertOne(document3);

        //多条件查询


    }

    @Test
    public void myTest2(){
        MongoClient client = new MongoClient("192.168.190.130", 27017);
        MongoDatabase spitdb = client.getDatabase("spitdb");
        MongoCollection<Document> spit = spitdb.getCollection("spit");
        //多条件查询  利用bson套娃
        //db.spit.find({$and: [{userId:"1"},{title:{$in:["今天天气特别好"]}}]})
            String[] a=new String[]{"今天天气特别好","天气"};
        BasicDBObject[] dbObject = new BasicDBObject[]{new BasicDBObject("userId","1"),
                new BasicDBObject("title",new BasicDBObject("$in",a))};
        BasicDBObject bson = new BasicDBObject("$and",dbObject);
        FindIterable<Document> documents = spit.find(bson);
        for (Document document : documents) {
            System.out.println(document.get("_id"));
            System.out.println(document.get("title"));
            System.out.println(document.get("userId"));
            System.out.println(document.get("visits"));
        }

        //删除
        //spit.deleteOne()
        client.close();
    }
}
