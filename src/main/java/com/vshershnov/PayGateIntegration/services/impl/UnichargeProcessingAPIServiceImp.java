package com.vshershnov.PayGateIntegration.services.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;

import com.vshershnov.PayGateIntegration.domain.Transaction;
import com.vshershnov.PayGateIntegration.services.UnichargeProcessingAPIService;

public class UnichargeProcessingAPIServiceImp implements UnichargeProcessingAPIService {
    
    private static int CONNECT_TIMEOUT = 10 * 1000;
    private static int READ_TIMEOUT = 1 * 60 * 1000;
    private static String EMPTY = "";
    private static String GATE_TEST_URL = "https://sandbox-portal.unitedthinkers.com/gates/xurl?"
    										+ "requestType=ping"
    										+ "&password=1sPlP291P3GVJCD1b3vtU07B1i2bOJKt"
    										+ "&userName=TestServiceUser";
    private static String GATE_URL = "https://sandbox-secure.unitedthinkers.com/gates/xurl?";
    private static String GATE_AUTHORIZATION_INFO = "&userName=829000"
			 									+ "&password=TestNt62400~"
			 									+ "&accountId=829001"
			 									+ "&transactionIndustryType=RE"
			 									+ "&transactionCode=0000000001"
			 									+ "&customerAccountCode=829001";
    
    
    public String sendSaleTransaction(Transaction transaction) throws IOException {
		testGate();
    	String handle = GATE_AUTHORIZATION_INFO + convertToHandleString(transaction);
		String response = sendPOST (GATE_URL, handle);
		return parseResponse(response);
	}
	
    private void testGate() throws IOException {
		String response = sendPOST(GATE_TEST_URL, "");
		System.out.println(response);
	}

	private String parseResponse(String response) throws UnsupportedEncodingException {
		
		String[] pairs = response.split("\\&");
		for (int i = 0; i < pairs.length; i++) {
		      String[] fields = pairs[i].split("=");
		      String name = URLDecoder.decode(fields[0], "UTF-8");
		     
		      if(name.equals("failureMessage") || name.equals("responseMessage")){
		    	  return URLDecoder.decode(fields[1], "UTF-8");
		      }
		}
		return response;
	}

	private String convertToHandleString(Transaction transaction) {
		String handle = "&requestType=sale" 
						 + "&amount=" + transaction.getAmount()
						 + "&holderType=P"
						 + "&holderName=" + transaction.getHolderName()
						 + "&street=" + transaction.getStreet()
						 + "&city=" + transaction.getCity()
						 + "&state=" + transaction.getState()
						 + "&zipCode=" + transaction.getZipCode()
						 + "&accountType=R"
						 + "&accountNumber=" + transaction.getCard().getCradNumber()
						 + "&accountAccessory=" + transaction.getCard().getExpDate();
		return handle;
	}
    
    private String sendPOST(String url, String data) throws IOException{
		
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
    
	private String stream2String(InputStream is) throws IOException{
		StringBuilder sb = new StringBuilder(8192);
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String line = null;
		while ((line = br.readLine())!= null){
		    sb.append(line);
		}
		return sb.toString();
    }	
}