package com.flipkartclone.admin.model;

public class AuthResponse {
   private String reponse;
   
   AuthResponse(){}

public AuthResponse(String reponse) {
	super();
	this.reponse = reponse;
}

public String getReponse() {
	return reponse;
}

public void setReponse(String reponse) {
	this.reponse = reponse;
}

@Override
public String toString() {
	return "AuthResponse [reponse=" + reponse + "]";
}
   
   
}
