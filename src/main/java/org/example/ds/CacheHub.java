package org.example.ds;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class CacheHub {

    static AtomicBoolean set_lock=new AtomicBoolean(false);

    static Map<String,CacheUnit> Units=new HashMap<>();


    //This function adds new Cacheunit to this hub
    public CacheUnit NewUnit(String name,int size){
        while (true){
            if(CacheHub.set_lock.compareAndSet(false,true)){
                CacheUnit unit=new CacheUnit(name,size);
                CacheHub.Units.put(name,unit);
                CacheHub.set_lock.set(false);
                return unit;
            }
        }}


    public CacheUnit getUnit(String name){

        while (true){
            if(CacheHub.set_lock.compareAndSet(false,true)){
                CacheUnit unit=CacheHub.Units.get(name);
                CacheHub.set_lock.set(false);
                return unit;
            }
        }}

    public void deleteUnit(String name){
        while (true){
            if(CacheHub.set_lock.compareAndSet(false,true)){
                CacheHub.Units.remove(name);
                break;
            }
        }}

}

