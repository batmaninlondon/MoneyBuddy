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
@Table (name="FUND_DETAILS")
public class FundDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="FUND_ID")
    private String fundId;

    @Column(name="FUND_NAME")
    private String fundName;

    @Column(name="SECTOR")
    private String sector;
    
    @Column(name="SUB_SECTOR")
    private String subSector;
    
    @Column(name="FUND_START_DATE")
    private String fundStartDate;
    
    @Column(name="RATING")
    private String rating;

    @Column(name="RISK")
    private String risk;

    @Column(name="RETURNS_THREE_YEARS")
    private String returnsThreeYears;
    
    @Column(name="MIN_SIP_AMOUNT")
    private String minSipAmount;
    
    @Column(name="MIN_LUMSUM_AMOUNT")
    private String minLumsumAmount;
    
    @Column(name="MIN_SIP_DURATION")
    private String minSipDuration;
    
    @Column(name="FUND_CATEGORY")
    private String fundCategory;


    public FundDetails() {

    }



	public FundDetails(String fundName, String sector, String subSector, String fundStartDate, String rating,
			String risk, String returnsThreeYears, String minSipAmount, String minLumsumAmount, String minSipDuration, String fundCategory) {
		super();
		this.fundName = fundName;
		this.sector = sector;
		this.subSector = subSector;
		this.fundStartDate = fundStartDate;
		this.rating = rating;
		this.risk = risk;
		this.returnsThreeYears = returnsThreeYears;
		this.minSipAmount = minSipAmount;
		this.minLumsumAmount = minLumsumAmount;
		this.minSipDuration = minSipDuration;
		this.fundCategory = fundCategory;
	}



	public String getFundId() {
		return fundId;
	}



	public void setFundId(String fundId) {
		this.fundId = fundId;
	}



	public String getFundName() {
		return fundName;
	}



	public void setFundName(String fundName) {
		this.fundName = fundName;
	}



	public String getSector() {
		return sector;
	}



	public void setSector(String sector) {
		this.sector = sector;
	}



	public String getSubSector() {
		return subSector;
	}



	public void setSubSector(String subSector) {
		this.subSector = subSector;
	}



	public String getFundStartDate() {
		return fundStartDate;
	}



	public void setFundStartDate(String fundStartDate) {
		this.fundStartDate = fundStartDate;
	}



	public String getRating() {
		return rating;
	}



	public void setRating(String rating) {
		this.rating = rating;
	}



	public String getRisk() {
		return risk;
	}



	public void setRisk(String risk) {
		this.risk = risk;
	}



	public String getReturnsThreeYears() {
		return returnsThreeYears;
	}



	public void setReturnsThreeYears(String returnsThreeYears) {
		this.returnsThreeYears = returnsThreeYears;
	}



	public String getMinSipAmount() {
		return minSipAmount;
	}



	public void setMinSipAmount(String minSipAmount) {
		this.minSipAmount = minSipAmount;
	}



	public String getMinLumsumAmount() {
		return minLumsumAmount;
	}



	public void setMinLumsumAmount(String minLumsumAmount) {
		this.minLumsumAmount = minLumsumAmount;
	}




	public String getMinSipDuration() {
		return minSipDuration;
	}



	public void setMinSipDuration(String minSipDuration) {
		this.minSipDuration = minSipDuration;
	}



	public String getFundCategory() {
		return fundCategory;
	}



	public void setFundCategory(String fundCategory) {
		this.fundCategory = fundCategory;
	}



	@Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        final FundDetails other = (FundDetails) obj;
        if ((this.fundId == null) ? (other.fundId != null) : !this.fundId.equals(other.fundId)) {
            return false;
        }
        if ((this.fundName == null) ? (other.fundName != null) : !this.fundName.equals(other.fundName)) {
            return false;
        }
        if ((this.sector == null) ? (other.sector != null) : !this.sector.equals(other.sector)) {
            return false;
        }
        if ((this.subSector == null) ? (other.subSector != null) : !this.subSector.equals(other.subSector)) {
            return false;
        }
        if ((this.fundStartDate == null) ? (other.fundStartDate != null) : !this.fundStartDate.equals(other.fundStartDate)) {
            return false;
        }
        if ((this.rating == null) ? (other.rating != null) : !this.rating.equals(other.rating)) {
            return false;
        }
        if ((this.risk == null) ? (other.risk != null) : !this.risk.equals(other.risk)) {
            return false;
        }
        if ((this.returnsThreeYears == null) ? (other.returnsThreeYears != null) : !this.returnsThreeYears.equals(other.returnsThreeYears)) {
            return false;
        }
        if ((this.minSipAmount == null) ? (other.minSipAmount != null) : !this.minSipAmount.equals(other.minSipAmount)) {
            return false;
        }
        if ((this.minLumsumAmount == null) ? (other.minLumsumAmount != null) : !this.minLumsumAmount.equals(other.minLumsumAmount)) {
            return false;
        }
        if ((this.minSipDuration == null) ? (other.minSipDuration != null) : !this.minSipDuration.equals(other.minSipDuration)) {
            return false;
        }
        if ((this.fundCategory == null) ? (other.fundCategory != null) : !this.fundCategory.equals(other.fundCategory)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + (this.fundId != null ? this.fundId.hashCode() : 0);
        hash = 83 * hash + (this.fundName != null ? this.fundName.hashCode() : 0);
        hash = 83 * hash + (this.sector != null ? this.sector.hashCode() : 0);
        hash = 83 * hash + (this.subSector != null ? this.subSector.hashCode() : 0);
        hash = 83 * hash + (this.fundStartDate != null ? this.fundStartDate.hashCode() : 0);
        hash = 83 * hash + (this.rating != null ? this.rating.hashCode() : 0);
        hash = 83 * hash + (this.risk != null ? this.risk.hashCode() : 0);
        hash = 83 * hash + (this.returnsThreeYears != null ? this.returnsThreeYears.hashCode() : 0);
        hash = 83 * hash + (this.minSipAmount != null ? this.minSipAmount.hashCode() : 0);
        hash = 83 * hash + (this.minLumsumAmount != null ? this.minLumsumAmount.hashCode() : 0);
        hash = 83 * hash + (this.minSipDuration != null ? this.minSipDuration.hashCode() : 0);
        hash = 83 * hash + (this.fundCategory != null ? this.fundCategory.hashCode() : 0);
        return hash;
    }
    
    

}