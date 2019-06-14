/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.EntityClasses;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="SECONDARY_FUND_DETAILS")
public class SecondaryFundDetails {

    @Id
    @Column (name="FUND_ID")
    private String fundId;

    @Column(name="AMC_CODE")
    private String amcCode;

    @Column(name="RTA")
    private String rta;
    
    @Column(name="SCHEME_CODE")
    private String schemeCode;
    
    @Column(name="ISIN")
    private String isin;
    
    public SecondaryFundDetails() {

    }

	public SecondaryFundDetails(String fundId, String amcCode, String rta, String schemeCode,String isin) {
		super();
		this.fundId = fundId;
		this.amcCode = amcCode;
		this.rta = rta;
		this.schemeCode = schemeCode;
		this.isin = isin;
	}

	public String getFundId() {
		return fundId;
	}

	public void setFundId(String fundId) {
		this.fundId = fundId;
	}

	public String getAmcCode() {
		return amcCode;
	}

	public void setAmcCode(String amcCode) {
		this.amcCode = amcCode;
	}

	public String getRta() {
		return rta;
	}

	public void setRta(String rta) {
		this.rta = rta;
	}

	public String getSchemeCode() {
		return schemeCode;
	}

	public void setSchemeCode(String schemeCode) {
		this.schemeCode = schemeCode;
	}

	public String getIsin() {
		return isin;
	}

	public void setIsin(String isin) {
		this.isin = isin;
	}

	@Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        final SecondaryFundDetails other = (SecondaryFundDetails) obj;
        if ((this.fundId == null) ? (other.fundId != null) : !this.fundId.equals(other.fundId)) {
            return false;
        }
        if ((this.amcCode == null) ? (other.amcCode != null) : !this.amcCode.equals(other.amcCode)) {
            return false;
        }
        if ((this.rta == null) ? (other.rta != null) : !this.rta.equals(other.rta)) {
            return false;
        }
        if ((this.schemeCode == null) ? (other.schemeCode != null) : !this.schemeCode.equals(other.schemeCode)) {
            return false;
        }
        if ((this.isin == null) ? (other.isin != null) : !this.isin.equals(other.isin)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + (this.fundId != null ? this.fundId.hashCode() : 0);
        hash = 83 * hash + (this.amcCode != null ? this.amcCode.hashCode() : 0);
        hash = 83 * hash + (this.rta != null ? this.rta.hashCode() : 0);
        hash = 83 * hash + (this.schemeCode != null ? this.schemeCode.hashCode() : 0);
        hash = 83 * hash + (this.isin != null ? this.isin.hashCode() : 0);
        return hash;
    }
    
    

}