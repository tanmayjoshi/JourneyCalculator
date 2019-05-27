package com.test.Model;

public enum CustomerTypes {
	
	VIP("VIP"), 
	NORMAL("Normal"),
	PERSONA_NON_GRANTA("Persona Non Grata");
	
    private String type;

    CustomerTypes(String type) {
        this.type = type;
    }

    public String type() {
        return type;
    }

}
