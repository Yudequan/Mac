package com.java.mac;


import java.io.*;

/**
 * Created by yudequan on 16/09/29.
 */
public class Demo
{
    public static void main(String[] args) throws IOException
    {
//        OutputStream os = new FileOutputStream("/Users/yudequan/output.txt");
//        //  ByteArrayOutputStream bos = new ByteArrayOutputStream();
//
//        DataOutputStream dos = new DataOutputStream(os);
//        dos.writeInt(12);
//
//        dos.flush();
//
//        dos.close();

        InputStream is = new FileInputStream("/Users/yudequan/output.txt");
        DataInputStream dis = new DataInputStream(is);
        System.out.print(dis.readInt());
        dis.close();
    }
}
