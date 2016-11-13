package jsonexample.model;

import java.util.List;
import java.util.Map;

public class PriceListResponse {

	private Integer status;
	
	private Long time;
	
	private Map<String,Map<String,PriceListElement>> response;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public Map<String, Map<String, PriceListElement>> getResponse() {
		return response;
	}
	
	public void setResponse(Map<String, Map<String, PriceListElement>> response) {
		this.response = response;
	}
	
	
}
