package com.vshershnov.PayGateIntegration.services.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class UnichargeProcessingAPIServiceImp {
    
    private static int CONNECT_TIMEOUT = 10 * 1000;
    private static int READ_TIMEOUT = 1 * 60 * 1000;
    private static String EMPTY = "";	  
	
    public static void main (String[] args) throws IOException{
            System.out.println(sendPOST("https://sandbox-secure.unitedthinkers.com/gates/xurl?", 
		
	  "&requestType=sale-auth"
	 + "&userName=myUsername"
	 + "&password=myP@ssword"
	 + "&accountId=2001"
	 + "&transactionIndustryType=RE"
	 + "&transactionCode=0000000001"
	 + "&amount=5000"
	 + "&holderType=P"
	 + "&holderName=John Smith"
	 + "&street=12 Main St"
	 + "&city=Denver"
	 + "&state=CO"
	 + "&zipCode=30301"
	 + "&accountType=R"
	 + "&accountNumber=4111111111111111"
	 + "&accountAccessory=0422"
	 + "&customerAccountCode=0000000001"
               ));	
    }    
    
    public static String sendPOST(String url, String data) throws IOException{
		
      HttpURLConnection conn = null;
      InputStream stream = null;
      URL urlLink = new URL(url);
      OutputStreamWriter writer = null;
	
      conn = (HttpURLConnection)urlLink.openConnection();
      conn.setDoInput(true);
      conn.setDoOutput(true);
      conn.setUseCaches(false);
      conn.setConnectTimeout(CONNECT_TIMEOUT);
      conn.setReadTimeout(READ_TIMEOUT);
      conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
      conn.setRequestMethod("POST");
        
      writer = new OutputStreamWriter(conn.getOutputStream());
      writer.write(data);
      writer.flush();
      writer.close();      
      
      if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
          stream = conn.getInputStream();
      } else { 
          stream = conn.getErrorStream();
      }
      if (stream == null){
          System.out.println("Response code is " + conn.getResponseCode());
          return EMPTY;
      }       
     
       return stream2String(stream);	
    }	 
    
    private static String stream2String(InputStream is) throws IOException{
	StringBuilder sb = new StringBuilder(8192);
	BufferedReader br = new BufferedReader(new InputStreamReader(is));
	String line = null;
	while ((line = br.readLine())!= null){
	    sb.append(line);
	}
	return sb.toString();
    }
}