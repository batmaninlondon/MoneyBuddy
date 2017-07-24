/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myMoneyBuddy.EntityClasses;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Savita Wadhwani
 */
@Entity
@Table (name="NAV_HISTORY")
public class NavHistory {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="NAV_HISTORY_ID")
    private String navHistoryId;

    @Column(name="NAV_DATE")
    private String navDate;
    
    @Column(name="SCHEME_CODE")
    private String schemeCode;
    
    @Column(name="SCHEME_NAME")
    private String schemeName;
    
    @Column(name="RTA_SCHEME_CODE")
    private String rtaSchemeCode;
    
    @Column(name="DIVIDEND_REINVEST_FLAG")
    private String dividendReinvestFlag;
    
    @Column(name="ISIN")
    private String isin;
    
    @Column(name="NAV_VALUE")
    private String navValue;
    
    @Column(name="RTA_CODE")
    private String rtaCode;
    

    public NavHistory() {

    }

    public NavHistory(String navHistoryId, String navDate, String schemeCode, String schemeName, String rtaSchemeCode,
			String dividendReinvestFlag, String isin, String navValue, String rtaCode) {
		super();
		
		this.navDate = navDate;
		this.schemeCode = schemeCode;
		this.schemeName = schemeName;
		this.rtaSchemeCode = rtaSchemeCode;
		this.dividendReinvestFlag = dividendReinvestFlag;
		this.isin = isin;
		this.navValue = navValue;
		this.rtaCode = rtaCode;
	}

	public String getNavHistoryId() {
		return navHistoryId;
	}

	public void setNavHistoryId(String navHistoryId) {
		this.navHistoryId = navHistoryId;
	}

	public String getNavDate() {
		return navDate;
	}

	public void setNavDate(String navDate) {
		this.navDate = navDate;
	}

	public String getSchemeCode() {
		return schemeCode;
	}

	public void setSchemeCode(String schemeCode) {
		this.schemeCode = schemeCode;
	}

	public String getSchemeName() {
		return schemeName;
	}

	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	public String getRtaSchemeCode() {
		return rtaSchemeCode;
	}

	public void setRtaSchemeCode(String rtaSchemeCode) {
		this.rtaSchemeCode = rtaSchemeCode;
	}

	public String getDividendReinvestFlag() {
		return dividendReinvestFlag;
	}

	public void setDividendReinvestFlag(String dividendReinvestFlag) {
		this.dividendReinvestFlag = dividendReinvestFlag;
	}

	public String getIsin() {
		return isin;
	}

	public void setIsin(String isin) {
		this.isin = isin;
	}

	public String getNavValue() {
		return navValue;
	}

	public void setNavValue(String navValue) {
		this.navValue = navValue;
	}

	public String getRtaCode() {
		return rtaCode;
	}

	public void setRtaCode(String rtaCode) {
		this.rtaCode = rtaCode;
	}

	@Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NavHistory other = (NavHistory) obj;
        if ((this.navHistoryId == null) ? (other.navHistoryId != null) : !this.navHistoryId.equals(other.navHistoryId)) {
            return false;
        }
        if ((this.navDate == null) ? (other.navDate != null) : !this.navDate.equals(other.navDate)) {
            return false;
        }
        if ((this.schemeCode == null) ? (other.schemeCode != null) : !this.schemeCode.equals(other.schemeCode)) {
            return false;
        }
        if ((this.schemeName == null) ? (other.schemeName != null) : !this.schemeName.equals(other.schemeName)) {
            return false;
        }
        if ((this.rtaSchemeCode == null) ? (other.rtaSchemeCode != null) : !this.rtaSchemeCode.equals(other.rtaSchemeCode)) {
            return false;
        }
        if ((this.dividendReinvestFlag == null) ? (other.dividendReinvestFlag != null) : !this.dividendReinvestFlag.equals(other.dividendReinvestFlag)) {
            return false;
        }
        if ((this.isin == null) ? (other.isin != null) : !this.isin.equals(other.isin)) {
            return false;
        }
        if ((this.navValue == null) ? (other.navValue != null) : !this.navValue.equals(other.navValue)) {
            return false;
        }
        if ((this.rtaCode == null) ? (other.rtaCode != null) : !this.rtaCode.equals(other.rtaCode)) {
            return false;
        }
        return true;
    }


    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + (this.navHistoryId != null ? this.navHistoryId.hashCode() : 0);
        hash = 83 * hash + (this.navDate != null ? this.navDate.hashCode() : 0);
        hash = 83 * hash + (this.schemeCode != null ? this.schemeCode.hashCode() : 0);
        hash = 83 * hash + (this.schemeName != null ? this.schemeName.hashCode() : 0);
        hash = 83 * hash + (this.rtaSchemeCode != null ? this.rtaSchemeCode.hashCode() : 0);
        hash = 83 * hash + (this.dividendReinvestFlag != null ? this.dividendReinvestFlag.hashCode() : 0);
        hash = 83 * hash + (this.isin != null ? this.isin.hashCode() : 0);
        hash = 83 * hash + (this.navValue != null ? this.navValue.hashCode() : 0);
        hash = 83 * hash + (this.rtaCode != null ? this.rtaCode.hashCode() : 0);
        
        return hash;
    }



}