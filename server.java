package chat1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * �������������������
 */
public class server {
	public static void main(String[]args) throws UnknownHostException,IOException{
		System.out.println("---server---");
		//ָ���˿� ʹ��ServerSocket����������
		ServerSocket server = new ServerSocket(666);
		//����ʽ�ȴ�����
		Socket client = server.accept();
		System.out.println("һ���ͻ������ӽ���");
		//������Ϣ
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String msg = dis.readUTF();
		System.out.println("client say:"+msg);
		//������Ϣ
		DataOutputStream dos= new DataOutputStream(client.getOutputStream());
		dos.writeUTF(msg);
		//�ͷ���Դ
		dos.flush();
		dos.close();
		dis.close();
		client.close();
	}
}
