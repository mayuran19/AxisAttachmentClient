package com.mayuran19.axisattachment.client;

import java.net.MalformedURLException;
import java.security.Security;

import org.apache.axis.utils.Options;

public class Main {
	public static void main(String[] args) {
		System.out.println("111111111111");
		Options options;
		try {
			System.setProperty("javax.net.debug", "all");
			System.setProperty("javax.net.ssl.trustStore", "/home/mayuran/workspace/openssl/two/client.jks");
//			System.setProperty("javax.net.ssl.trustStorePassword", "welcome");
			System.setProperty("java.protocol.handler.pkgs",
					"com.sun.net.ssl.internal.www.protocol");
			Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
			options = new Options(new String[] { "", "" });
			options.setDefaultURL("https://localhost:8443/axisattachmentservice/services/urn:EchoAttachmentsService");
			EchoAttachment echoAttachment = new EchoAttachment(options);
			echoAttachment.echo(true, "/home/mayuran/Documents/aaa/test.txt");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
