/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myMoneyBuddy.ActionClasses;

import com.myMoneyBuddy.queryClasses.QueryKycStatus;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author Savita Wadhwani
 */
public class KycCheckAction extends ActionSupport{

    private String panCard;
    QueryKycStatus kyc = new QueryKycStatus();

    public void validate() {
        if(StringUtils.isEmpty(getPanCard()) )
            addFieldError("panCard","PAN Card number can't be blank!");

        else if (!kyc.existsPanCard(getPanCard()))
            addFieldError("panCard"," PAN Card does not exists.");

    }
    public String execute() {

            if (kyc.getStatusForPanCard(getPanCard()).equalsIgnoreCase("NO"))  {
                return ERROR;
            }

            return SUCCESS;
    }

    public String getPanCard() {
        return panCard;
    }

    public void setPanCard(String panCard) {
        this.panCard = panCard;
    }

}
