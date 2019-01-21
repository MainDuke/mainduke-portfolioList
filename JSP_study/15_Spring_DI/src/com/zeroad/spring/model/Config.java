package com.zeroad.spring.model;

public class Config {

	String httpUrl;
	String httpsUrl;
	String imageUrl;
	String tempDir;
	
	public String getHttpUrl() {
		return httpUrl;
	}
	public void setHttpUrl(String httpUrl) {
		this.httpUrl = httpUrl;
	}
	public String getHttpsUrl() {
		return httpsUrl;
	}
	public void setHttpsUrl(String httpsUrl) {
		this.httpsUrl = httpsUrl;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getTempDir() {
		return tempDir;
	}
	public void setTempDir(String tempDir) {
		this.tempDir = tempDir;
	}
	
	
	public String toString(){
		
		StringBuffer buf= new StringBuffer();
		buf.append("httpUrl : "+ httpUrl + "\n");
		buf.append("httpsUrl : "+ httpsUrl + "\n");
		buf.append("imageUrl : "+ imageUrl + "\n");
		buf.append("tempDir : "+ tempDir + "\n");
		
		
		return buf.toString();
	}
	
}//class end
