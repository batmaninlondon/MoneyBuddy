/**
 *
 * @author Savita Wadhwani
 */

package com.myMoneyBuddy.EntityClasses;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="PRIMARY_FUND_DETAILS")
public class PrimaryFundDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="FUND_ID")
    private String fundId;

    @Column(name="SCHEME_NAME")
    private String schemeName;

    @Column(name="SCHEME_TYPE")
    private String schemeType;
    
    @Column(name="CATEGORY")
    private String category;
    
    @Column(name="START_DATE")
    private String startDate;
    
    @Column(name="RATING")
    private String rating;

    @Column(name="RISK")
    private String risk;

    @Column(name="RETURNS_ONE_YEAR")
    private String returnsOneYear;
    
    @Column(name="RETURNS_THREE_YEARS")
    private String returnsThreeYears;
    
    @Column(name="RETURNS_FIVE_YEARS")
    private String returnsFiveYears;
    
    @Column(name="RETURNS_SINCE_INCEPTION")
    private String returnsSinceInception;
    
    @Column(name="MIN_SIP_AMOUNT")
    private String minSipAmount;
    
    @Column(name="MIN_PURCHASE_AMOUNT")
    private String minPurchaseAmount;
    
    @Column(name="MIN_SIP_DURATION")
    private String minSipDuration;
    
    @Column(name="PDF_FILE_PATH")
    private String pdfFilePath;
    
    @Column(name="MOST_POPULAR_FUND")
    private String mostPopularFund;

    @Column(name="SIP_FLAG")
    private String sipFlag;
    
    @Column(name="STP_FLAG")
    private String stpFlag;
    
    @Column(name="SWP_FLAG")
    private String swpFlag;
    
    @Column(name="SWITCH_FLAG")
    private String switchFlag;
    
    public PrimaryFundDetails() {

    }
    
	public PrimaryFundDetails(String schemeName, String schemeType, String category, String startDate, String rating,
			String risk, String returnsThreeYears, String minSipAmount, String minPurchaseAmount, String minSipDuration, 
			String pdfFilePath, String mostPopularFund,String sipFlag, String stpFlag, String swpFlag, String switchFlag ) {
		super();
		this.schemeName = schemeName;
		this.schemeType = schemeType;
		this.category = category;
		this.startDate = startDate;
		this.rating = rating;
		this.risk = risk;
		this.returnsThreeYears = returnsThreeYears;
		this.minSipAmount = minSipAmount;
		this.minPurchaseAmount = minPurchaseAmount;
		this.minSipDuration = minSipDuration;
		this.pdfFilePath = pdfFilePath;
		this.mostPopularFund = mostPopularFund;
		this.sipFlag = sipFlag;
		this.stpFlag = stpFlag;
		this.swpFlag = swpFlag;
		this.switchFlag = switchFlag;
	}

	public String getFundId() {
		return fundId;
	}

	public void setFundId(String fundId) {
		this.fundId = fundId;
	}

	public String getSchemeName() {
		return schemeName;
	}

	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}



	public String getSchemeType() {
		return schemeType;
	}



	public void setSchemeType(String schemeType) {
		this.schemeType = schemeType;
	}


	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}


	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
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



	public String getReturnsOneYear() {
		return returnsOneYear;
	}

	public void setReturnsOneYear(String returnsOneYear) {
		this.returnsOneYear = returnsOneYear;
	}

	public String getReturnsThreeYears() {
		return returnsThreeYears;
	}



	public void setReturnsThreeYears(String returnsThreeYears) {
		this.returnsThreeYears = returnsThreeYears;
	}



	public String getReturnsFiveYears() {
		return returnsFiveYears;
	}

	public void setReturnsFiveYears(String returnsFiveYears) {
		this.returnsFiveYears = returnsFiveYears;
	}

	public String getReturnsSinceInception() {
		return returnsSinceInception;
	}

	public void setReturnsSinceInception(String returnsSinceInception) {
		this.returnsSinceInception = returnsSinceInception;
	}

	public String getMinSipAmount() {
		return minSipAmount;
	}



	public void setMinSipAmount(String minSipAmount) {
		this.minSipAmount = minSipAmount;
	}


	public String getMinPurchaseAmount() {
		return minPurchaseAmount;
	}

	public void setMinPurchaseAmount(String minPurchaseAmount) {
		this.minPurchaseAmount = minPurchaseAmount;
	}

	public String getMinSipDuration() {
		return minSipDuration;
	}



	public void setMinSipDuration(String minSipDuration) {
		this.minSipDuration = minSipDuration;
	}

	public String getPdfFilePath() {
		return pdfFilePath;
	}

	public void setPdfFilePath(String pdfFilePath) {
		this.pdfFilePath = pdfFilePath;
	}

	public String getMostPopularFund() {
		return mostPopularFund;
	}

	public void setMostPopularFund(String mostPopularFund) {
		this.mostPopularFund = mostPopularFund;
	}

	public String getSipFlag() {
		return sipFlag;
	}

	public void setSipFlag(String sipFlag) {
		this.sipFlag = sipFlag;
	}

	public String getStpFlag() {
		return stpFlag;
	}

	public void setStpFlag(String stpFlag) {
		this.stpFlag = stpFlag;
	}

	public String getSwpFlag() {
		return swpFlag;
	}

	public void setSwpFlag(String swpFlag) {
		this.swpFlag = swpFlag;
	}

	public String getSwitchFlag() {
		return switchFlag;
	}

	public void setSwitchFlag(String switchFlag) {
		this.switchFlag = switchFlag;
	}

	@Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        final PrimaryFundDetails other = (PrimaryFundDetails) obj;
        if ((this.fundId == null) ? (other.fundId != null) : !this.fundId.equals(other.fundId)) {
            return false;
        }
        if ((this.schemeName == null) ? (other.schemeName != null) : !this.schemeName.equals(other.schemeName)) {
            return false;
        }
        if ((this.schemeType == null) ? (other.schemeType != null) : !this.schemeType.equals(other.schemeType)) {
            return false;
        }
        if ((this.category == null) ? (other.category != null) : !this.category.equals(other.category)) {
            return false;
        }
        if ((this.startDate == null) ? (other.startDate != null) : !this.startDate.equals(other.startDate)) {
            return false;
        }
        if ((this.rating == null) ? (other.rating != null) : !this.rating.equals(other.rating)) {
            return false;
        }
        if ((this.risk == null) ? (other.risk != null) : !this.risk.equals(other.risk)) {
            return false;
        }
        if ((this.returnsOneYear == null) ? (other.returnsOneYear != null) : !this.returnsOneYear.equals(other.returnsOneYear)) {
            return false;
        }
        if ((this.returnsThreeYears == null) ? (other.returnsThreeYears != null) : !this.returnsThreeYears.equals(other.returnsThreeYears)) {
            return false;
        }
        if ((this.returnsFiveYears == null) ? (other.returnsFiveYears != null) : !this.returnsFiveYears.equals(other.returnsFiveYears)) {
            return false;
        }
        if ((this.returnsSinceInception == null) ? (other.returnsSinceInception != null) : !this.returnsSinceInception.equals(other.returnsSinceInception)) {
            return false;
        }
        if ((this.minSipAmount == null) ? (other.minSipAmount != null) : !this.minSipAmount.equals(other.minSipAmount)) {
            return false;
        }
        if ((this.minPurchaseAmount == null) ? (other.minPurchaseAmount != null) : !this.minPurchaseAmount.equals(other.minPurchaseAmount)) {
            return false;
        }
        if ((this.minSipDuration == null) ? (other.minSipDuration != null) : !this.minSipDuration.equals(other.minSipDuration)) {
            return false;
        }
        if ((this.pdfFilePath == null) ? (other.pdfFilePath != null) : !this.pdfFilePath.equals(other.pdfFilePath)) {
            return false;
        }
        if ((this.mostPopularFund == null) ? (other.mostPopularFund != null) : !this.mostPopularFund.equals(other.mostPopularFund)) {
            return false;
        }
        if ((this.sipFlag == null) ? (other.sipFlag != null) : !this.sipFlag.equals(other.sipFlag)) {
            return false;
        }
        if ((this.stpFlag == null) ? (other.stpFlag != null) : !this.stpFlag.equals(other.stpFlag)) {
            return false;
        }
        if ((this.swpFlag == null) ? (other.swpFlag != null) : !this.swpFlag.equals(other.swpFlag)) {
            return false;
        }
        if ((this.switchFlag == null) ? (other.switchFlag != null) : !this.switchFlag.equals(other.switchFlag)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + (this.fundId != null ? this.fundId.hashCode() : 0);
        hash = 83 * hash + (this.schemeName != null ? this.schemeName.hashCode() : 0);
        hash = 83 * hash + (this.schemeType != null ? this.schemeType.hashCode() : 0);
        hash = 83 * hash + (this.category != null ? this.category.hashCode() : 0);
        hash = 83 * hash + (this.startDate != null ? this.startDate.hashCode() : 0);
        hash = 83 * hash + (this.rating != null ? this.rating.hashCode() : 0);
        hash = 83 * hash + (this.risk != null ? this.risk.hashCode() : 0);
        hash = 83 * hash + (this.returnsOneYear != null ? this.returnsOneYear.hashCode() : 0);
        hash = 83 * hash + (this.returnsThreeYears != null ? this.returnsThreeYears.hashCode() : 0);
        hash = 83 * hash + (this.returnsFiveYears != null ? this.returnsFiveYears.hashCode() : 0);
        hash = 83 * hash + (this.returnsSinceInception != null ? this.returnsSinceInception.hashCode() : 0);
        hash = 83 * hash + (this.minSipAmount != null ? this.minSipAmount.hashCode() : 0);
        hash = 83 * hash + (this.minPurchaseAmount != null ? this.minPurchaseAmount.hashCode() : 0);
        hash = 83 * hash + (this.minSipDuration != null ? this.minSipDuration.hashCode() : 0);
        hash = 83 * hash + (this.pdfFilePath != null ? this.pdfFilePath.hashCode() : 0);
        hash = 83 * hash + (this.mostPopularFund != null ? this.mostPopularFund.hashCode() : 0);
        hash = 83 * hash + (this.sipFlag != null ? this.sipFlag.hashCode() : 0);
        hash = 83 * hash + (this.stpFlag != null ? this.stpFlag.hashCode() : 0);
        hash = 83 * hash + (this.swpFlag != null ? this.swpFlag.hashCode() : 0);
        hash = 83 * hash + (this.switchFlag != null ? this.switchFlag.hashCode() : 0);
        return hash;
    }
    
    

}