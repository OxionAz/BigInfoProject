package com.oxionaz.biginfoproject.model.rest.models;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("request")
    @Expose
    private List<Request> request = new ArrayList<Request>();
    @SerializedName("current_condition")
    @Expose
    private List<CurrentCondition> currentCondition = new ArrayList<CurrentCondition>();

    /**
     * 
     * @return
     *     The request
     */
    public List<Request> getRequest() {
        return request;
    }

    /**
     * 
     * @param request
     *     The request
     */
    public void setRequest(List<Request> request) {
        this.request = request;
    }

    /**
     * 
     * @return
     *     The currentCondition
     */
    public List<CurrentCondition> getCurrentCondition() {
        return currentCondition;
    }

    /**
     * 
     * @param currentCondition
     *     The current_condition
     */
    public void setCurrentCondition(List<CurrentCondition> currentCondition) {
        this.currentCondition = currentCondition;
    }
}