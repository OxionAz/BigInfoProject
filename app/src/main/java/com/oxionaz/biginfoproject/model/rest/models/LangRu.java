package com.oxionaz.biginfoproject.model.rest.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class LangRu {

    @SerializedName("value")
    @Expose
    private String value;

    /**
     * 
     * @return
     *     The value
     */
    public String getValue() {
        return value;
    }

    /**
     * 
     * @param value
     *     The value
     */
    public void setValue(String value) {
        this.value = value;
    }

}
