package org.example.ds;

import java.awt.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class CacheUnit {

    public String name="New";

    public int size=0;

    public Slot[] storage =null;

    public Set<Integer> free = new HashSet<>();

    public Map<String,Integer> map=new HashMap<>();

    public AtomicBoolean set_lock = new AtomicBoolean(false);






    public CacheUnit(String name,int size) {

        this.name=name;
        this.size=size;
        this.storage= new Slot[size];
        while(true){
            if (set_lock.compareAndSet(false,true)){
                for(int i=0;i<size;i++){
                    free.add(i);
                }
                set_lock.set(false);
                break;
            }
        }


    }

    public int pushData(Byte[] data) {
        int slot_count = data.length / 1024 + 1;
        if (slot_count > this.size) {
            System.err.println("data is bigger than CacheUnit size");
            return -1;
        }
        else{
            while(true){
                if (set_lock.compareAndSet(false,true)){
                    handleWrite(data);
                    set_lock.set(false);
                    break;
            }}}

        return 0;
    }


    private void handleWrite(Byte[] data) {

        int slot_count = data.length / 1024 + 1;
        int cursor=0;
        int[] slots=new int[slot_count];
        int index=0;
        for(int i=0;i<size;i++){
            if (index==slot_count){break;}
            if (free.contains(i)){
                slots[index]=i;
                index++;
            }}

        for (int i=0;i<slot_count;i++){
            storage[slots[i]].slotWrite(data,index);
            //set next index.
        }

    }

}
