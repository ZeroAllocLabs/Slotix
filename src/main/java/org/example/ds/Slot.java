package org.example.ds;

public class Slot {
    Byte[] memory=new Byte[1024*1024];
    int next=-1;

    public void slotWrite(Byte[] data,int index){
        //add locking feature to avoid same file being altered multiple times.
        System.arraycopy(data,0,memory,0,index+1024);
    }
}
