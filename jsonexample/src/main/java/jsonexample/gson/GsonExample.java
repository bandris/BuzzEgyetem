package jsonexample.gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.Gson;

import jsonexample.model.PriceListElement;
import jsonexample.model.PriceListResponse;

public class GsonExample {

	public static void main(String[] args) {
		
		InputStreamReader reader = null;
		try {
			URL url = new URL("https://api.opskins.com/IPricing/GetPriceList/v1/?appid=730");
			reader = new InputStreamReader(url.openStream());
			Gson gson = new Gson();     
			PriceListResponse response = gson.fromJson(reader, PriceListResponse.class);
			System.out.println("Status:" + response.getStatus());
			System.out.println("Timestamp:" + response.getTime());
			
			if (response.getResponse() != null){
				int i = 1;
				for (Entry<String, Map<String, PriceListElement>> entry : response.getResponse().entrySet()){
					System.out.println("Entry " + i + " from response:");
					if (entry.getValue() != null){
						System.out.println("Key: " + entry.getKey());
						for (Entry<String, PriceListElement> elementEntry : entry.getValue().entrySet()){
							System.out.println("Price was " + elementEntry.getValue().getPrice() 
												+ " on " + elementEntry.getKey());	
						}
					} else {
						System.out.println("Key: " + entry.getKey() + " without value...");
					}
					i++;
					System.out.println();
				}
			}
			
		} catch (IOException exception){
			System.err.println("Failure in parsing:" + exception.getMessage());
		} finally {
			if (reader != null){
				try {
					reader.close();
				} catch (IOException e) {
					System.err.println("Failure in closing reader:" + e.getMessage());
				}
			}
		}
	}

}
