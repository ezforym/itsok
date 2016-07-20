package com.cth.utils;

import java.util.ResourceBundle;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ChatManager;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;

public class OpenfireXmpp implements ErrorCode {
	public static XMPPConnection con;
	public static Chat newChat;
	public static ChatManager chatmanager;

	@SuppressWarnings("finally")
	public Integer sendmsg(String name, String password, String subject, String body, String to)
			throws InterruptedException {
		ResourceBundle resourceBundle = ResourceBundle.getBundle("Message");
		String host = resourceBundle.getString("openfire.host");
		int port = Integer.parseInt(resourceBundle.getString("openfire.port"));
		try {
			ConnectionConfiguration config = new ConnectionConfiguration(host, port);
			con = new XMPPConnection(config);
			con.connect();
			con.login(name, password);
			System.out.println("Authenticated = " + con.isAuthenticated());
			chatmanager = con.getChatManager();
			newChat = chatmanager.createChat(to, new MessageListener() {
				public void processMessage(Chat chat, Message message) {
					System.out.println("I'm sending: " + message.getBody());
				}
			});
			Message m = new Message();
			m.setSubject(subject);
			m.setBody(subject);
			newChat.sendMessage(m);
		} catch (XMPPException e) {
			e.printStackTrace();
			return FAILED;
		} finally {
			con.disconnect();
			return SUCCESS;
		}
	}

}
