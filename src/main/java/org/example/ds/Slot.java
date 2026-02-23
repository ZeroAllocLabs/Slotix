package org.example.ds;

public class Slot {
    Byte[] memory=new Byte[1024];
    int next=-1;

    public void slotWrite(Byte[] data,int index){
        System.arraycopy(data,0,memory,0,index+1024);
    }
}
