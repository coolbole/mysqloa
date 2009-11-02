package com.smb.MMUtil.handler.notify.mail;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.smb.MMUtil.pojo.email.Email;
 

public class SendSMTPMailClient {
	/**
	 *<br>
	 * 方法说明：发送邮件 <br>
	 * 输入参数：String mailServer 邮件接收服务器 <br>
	 * 输入参数：String recipient 接收邮件的地址 <br>
	 * 返回类型：
	 */
	
	public static void main (String [] agres){
		Email email = new Email();
		email.setEmailAccount(  "smbopensoft@sina.com" );
		email.setUsername("smbopensoft"  );
		email.setPassword( "config5566" );
		email.setPort("25");
		email.setRecipient( "njthnet@gmail.com" );
		email.setMailServer( "smtp.sina.com" );
		new SendSMTPMailClient().sendMail(email);
	}
	 
	private static Log logger = LogFactory.getLog(SendSMTPMailClient.class);
	
	public void sendMail(Email email) {
		logger.info( "sendMail .................................." );
		try {
			// 有Socket打开25端口
			Integer port= new Integer(email.getPort() );
			
			Socket socket = new Socket(email.getMailServer() , port.intValue() );
			// 缓存输入和输出
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"));
			// 发出“HELO”命令，表示对服务器的问候
			send(in, out, "HELO "+email.getMailServer());
			// 发出“AUTH LOGIN”命令，表示发出SMTP认证
			send(in, out, "AUTH LOGIN");    
			send(in, out,  email.getUsername());   //用户名
			send(in, out, email.getPassword() );  // 密码
			
			// 告诉服务器我的邮件地址，有些服务器要校验这个地址
			send(in, out, "MAIL FROM: <"+ email.getEmailAccount() +">");    
			// 使用“RCPT TO”命令告诉服务器解释邮件的邮件地址
			send(in, out, "RCPT TO: <" + email.getRecipient()+">");
			// 发送一个“DATA”表示下面将是邮件主体
			send(in, out, "DATA");
			// 使用Subject命令标注邮件主题
			send(out, "Subject: 你好this is mail Subject   ");   // 邮件主题
			send(out, "Content-Type:   text/html;   charset=utf-8 ");   // 邮件主题
			
			// 使用“From”标注邮件的来源
			send(out, "From: riverwind <"+email.getEmailAccount() +">");      // 设置邮件发送人
			send(out, "\n");
			// 邮件主体
			send(out, "This <br> is <br>mail  <br>context<br><br>");  // 邮件内容
			send(out, "\n.\n");
			// 发送“QUIT”端口邮件的通讯
			send(in, out, "QUIT");
			socket.close();
		} 
		catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		}
	}

	/**
	 *<br>
	 * 方法说明：发送信息，并接收回信 <br>
	 * 输入参数： <br>
	 * 返回类型：
	 */
	public void send(BufferedReader in, BufferedWriter out, String s) {
		try {
			out.write(s + "\n");
			out.flush();
			System.out.println(s);
			s = in.readLine();
			System.out.println(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 *<br>
	 * 方法说明：重载方法。向socket写入信息 <br>
	 * 输入参数：BufferedWriter out 输出缓冲器 <br>
	 * 输入参数：String s 写入的信息 <br>
	 * 返回类型：
	 */
	public void send(BufferedWriter out, String s) {
		try {
			out.write(s + "\n");
			out.flush();
			System.out.println(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}