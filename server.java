package chat1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * 简易在线聊天程序服务端
 */
public class server {
	public static void main(String[]args) throws UnknownHostException,IOException{
		System.out.println("---server---");
		//指定端口 使用ServerSocket创建服务器
		ServerSocket server = new ServerSocket(666);
		//阻塞式等待连接
		Socket client = server.accept();
		System.out.println("一个客户端连接建立");
		//接收消息
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String msg = dis.readUTF();
		System.out.println("client say:"+msg);
		//返回消息
		DataOutputStream dos= new DataOutputStream(client.getOutputStream());
		dos.writeUTF(msg);
		//释放资源
		dos.flush();
		dos.close();
		dis.close();
		client.close();
	}
}
