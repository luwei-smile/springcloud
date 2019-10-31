package com.algorithm;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Auther 卢伟
 * 
 * @Time 2019年9月21日上午10:10:25
 * 
 * @Todo: 网络编程案例一
 */
public class Socket01 {

	public void gethostInfo(){
		try {
			InetAddress address = InetAddress.getByName("192.168.137.1");
			System.out.println(address.getHostAddress());
			System.out.println(address.getHostName());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
