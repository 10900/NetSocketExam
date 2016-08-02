package com.hand;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class App {

	public static void main(String[] args) {
		try {
			URL url = new URL(
					"http://files.saas.hand-china.com/java/target.pdf");
			URLConnection con = url.openConnection();
			con.connect();
			InputStream is = con.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(is, 100000);
			
			File file = new File("new_target.pdf");
			BufferedOutputStream bw = new BufferedOutputStream(
					new FileOutputStream("new_target.pdf"), 100000);
			byte[] t = new byte[10];

			while (bis.read(t) != -1) {
				bw.write(t);
			}

			bw.flush();
			bw.close();
			bis.close();
			is.close();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}