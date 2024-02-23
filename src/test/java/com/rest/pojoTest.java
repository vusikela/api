package com.rest;


import com.rest.pojo.collection.newPojo.Event;
import com.rest.pojo.collection.newPojo.Script;
import org.testng.annotations.Test;

public class pojoTest {

    @Test
    public void testing(){
        Event event=new Event();

        event.setListen("dsfsd");
        Script script=new Script();
        event.setScript(script);


    }
}
