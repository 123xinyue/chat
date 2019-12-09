package chat1;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * 简易在线聊天程序客户端
 */
public class client {
	public static void main(String[]args) throws UnknownHostException, IOException{
		System.out.println("---client---");
		//连接建立，使用Socket创建客户端，这里要注意端口号要跟本地其它已经写过的网络程序相区分开
		Socket client =new Socket("localhost",666);
		//客户端发送消息
		BufferedReader console=new BufferedReader(new InputStreamReader(System.in));
		String msg = console.readLine();
		DataOutputStream dos= new DataOutputStream(client.getOutputStream());
		dos.writeUTF(msg);
		dos.flush();
		//接收消息
		DataInputStream dis = new DataInputStream(client.getInputStream());
		msg = dis.readUTF();
		System.out.println(msg);
		//释放资源
		dos.close();
		dis.close();
		client.close();
		}
}
