package de.zimmerpforte.dev.JCalculator.Tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.*;
import java.io.*;
import java.net.URL;

public class IpChecker {

	public static void main(String[] args) throws IOException
	{
		URL whatismyip = new URL("http://checkip.amazonaws.com");
		BufferedReader in = new BufferedReader(new InputStreamReader(
		                whatismyip.openStream()));

		String ip = in.readLine(); //you get the IP as a String
		System.out.println(ip);
	}
}
