package chat1;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * ���������������ͻ���
 */
public class client {
	public static void main(String[]args) throws UnknownHostException, IOException{
		System.out.println("---client---");
		//���ӽ�����ʹ��Socket�����ͻ��ˣ�����Ҫע��˿ں�Ҫ�����������Ѿ�д����������������ֿ�
		Socket client =new Socket("localhost",666);
		//�ͻ��˷�����Ϣ
		BufferedReader console=new BufferedReader(new InputStreamReader(System.in));
		String msg = console.readLine();
		DataOutputStream dos= new DataOutputStream(client.getOutputStream());
		dos.writeUTF(msg);
		dos.flush();
		//������Ϣ
		DataInputStream dis = new DataInputStream(client.getInputStream());
		msg = dis.readUTF();
		System.out.println(msg);
		//�ͷ���Դ
		dos.close();
		dis.close();
		client.close();
		}
}
