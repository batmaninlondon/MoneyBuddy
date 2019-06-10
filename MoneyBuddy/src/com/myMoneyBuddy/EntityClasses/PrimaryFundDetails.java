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
    
    @Column(name="MIN_RED_AMOUNT")
    private String minRedAmount;
    
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
    
    @Column(name="AUM")
    private String aum;
    
    public PrimaryFundDetails() {

    }
    
	public PrimaryFundDetails(String schemeName, String schemeType, String category, String startDate, String rating,
			String risk, String returnsThreeYears, String minSipAmount, String minPurchaseAmount, String minRedAmount,String minSipDuration, 
			String pdfFilePath, String mostPopularFund,String sipFlag, String stpFlag, String swpFlag, String switchFlag,String aum ) {
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
		this.minRedAmount = minRedAmount;
		this.minSipDuration = minSipDuration;
		this.pdfFilePath = pdfFilePath;
		this.mostPopularFund = mostPopularFund;
		this.sipFlag = sipFlag;
		this.stpFlag = stpFlag;
		this.swpFlag = swpFlag;
		this.switchFlag = switchFlag;
		this.aum = aum;
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

	public String getAum() {
		return aum;
	}

	public void setAum(String aum) {
		this.aum = aum;
	}

	public String getMinRedAmount() {
		return minRedAmount;
	}

	public void setMinRedAmount(String minRedAmount) {
		this.minRedAmount = minRedAmount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aum == null) ? 0 : aum.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((fundId == null) ? 0 : fundId.hashCode());
		result = prime * result + ((minPurchaseAmount == null) ? 0 : minPurchaseAmount.hashCode());
		result = prime * result + ((minRedAmount == null) ? 0 : minRedAmount.hashCode());
		result = prime * result + ((minSipAmount == null) ? 0 : minSipAmount.hashCode());
		result = prime * result + ((minSipDuration == null) ? 0 : minSipDuration.hashCode());
		result = prime * result + ((mostPopularFund == null) ? 0 : mostPopularFund.hashCode());
		result = prime * result + ((pdfFilePath == null) ? 0 : pdfFilePath.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + ((returnsFiveYears == null) ? 0 : returnsFiveYears.hashCode());
		result = prime * result + ((returnsOneYear == null) ? 0 : returnsOneYear.hashCode());
		result = prime * result + ((returnsSinceInception == null) ? 0 : returnsSinceInception.hashCode());
		result = prime * result + ((returnsThreeYears == null) ? 0 : returnsThreeYears.hashCode());
		result = prime * result + ((risk == null) ? 0 : risk.hashCode());
		result = prime * result + ((schemeName == null) ? 0 : schemeName.hashCode());
		result = prime * result + ((schemeType == null) ? 0 : schemeType.hashCode());
		result = prime * result + ((sipFlag == null) ? 0 : sipFlag.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((stpFlag == null) ? 0 : stpFlag.hashCode());
		result = prime * result + ((switchFlag == null) ? 0 : switchFlag.hashCode());
		result = prime * result + ((swpFlag == null) ? 0 : swpFlag.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		PrimaryFundDetails other = (PrimaryFundDetails) obj;
		if (aum == null) {
			if (other.aum != null) {
				return false;
			}
		} else if (!aum.equals(other.aum)) {
			return false;
		}
		if (category == null) {
			if (other.category != null) {
				return false;
			}
		} else if (!category.equals(other.category)) {
			return false;
		}
		if (fundId == null) {
			if (other.fundId != null) {
				return false;
			}
		} else if (!fundId.equals(other.fundId)) {
			return false;
		}
		if (minPurchaseAmount == null) {
			if (other.minPurchaseAmount != null) {
				return false;
			}
		} else if (!minPurchaseAmount.equals(other.minPurchaseAmount)) {
			return false;
		}
		if (minRedAmount == null) {
			if (other.minRedAmount != null) {
				return false;
			}
		} else if (!minRedAmount.equals(other.minRedAmount)) {
			return false;
		}
		if (minSipAmount == null) {
			if (other.minSipAmount != null) {
				return false;
			}
		} else if (!minSipAmount.equals(other.minSipAmount)) {
			return false;
		}
		if (minSipDuration == null) {
			if (other.minSipDuration != null) {
				return false;
			}
		} else if (!minSipDuration.equals(other.minSipDuration)) {
			return false;
		}
		if (mostPopularFund == null) {
			if (other.mostPopularFund != null) {
				return false;
			}
		} else if (!mostPopularFund.equals(other.mostPopularFund)) {
			return false;
		}
		if (pdfFilePath == null) {
			if (other.pdfFilePath != null) {
				return false;
			}
		} else if (!pdfFilePath.equals(other.pdfFilePath)) {
			return false;
		}
		if (rating == null) {
			if (other.rating != null) {
				return false;
			}
		} else if (!rating.equals(other.rating)) {
			return false;
		}
		if (returnsFiveYears == null) {
			if (other.returnsFiveYears != null) {
				return false;
			}
		} else if (!returnsFiveYears.equals(other.returnsFiveYears)) {
			return false;
		}
		if (returnsOneYear == null) {
			if (other.returnsOneYear != null) {
				return false;
			}
		} else if (!returnsOneYear.equals(other.returnsOneYear)) {
			return false;
		}
		if (returnsSinceInception == null) {
			if (other.returnsSinceInception != null) {
				return false;
			}
		} else if (!returnsSinceInception.equals(other.returnsSinceInception)) {
			return false;
		}
		if (returnsThreeYears == null) {
			if (other.returnsThreeYears != null) {
				return false;
			}
		} else if (!returnsThreeYears.equals(other.returnsThreeYears)) {
			return false;
		}
		if (risk == null) {
			if (other.risk != null) {
				return false;
			}
		} else if (!risk.equals(other.risk)) {
			return false;
		}
		if (schemeName == null) {
			if (other.schemeName != null) {
				return false;
			}
		} else if (!schemeName.equals(other.schemeName)) {
			return false;
		}
		if (schemeType == null) {
			if (other.schemeType != null) {
				return false;
			}
		} else if (!schemeType.equals(other.schemeType)) {
			return false;
		}
		if (sipFlag == null) {
			if (other.sipFlag != null) {
				return false;
			}
		} else if (!sipFlag.equals(other.sipFlag)) {
			return false;
		}
		if (startDate == null) {
			if (other.startDate != null) {
				return false;
			}
		} else if (!startDate.equals(other.startDate)) {
			return false;
		}
		if (stpFlag == null) {
			if (other.stpFlag != null) {
				return false;
			}
		} else if (!stpFlag.equals(other.stpFlag)) {
			return false;
		}
		if (switchFlag == null) {
			if (other.switchFlag != null) {
				return false;
			}
		} else if (!switchFlag.equals(other.switchFlag)) {
			return false;
		}
		if (swpFlag == null) {
			if (other.swpFlag != null) {
				return false;
			}
		} else if (!swpFlag.equals(other.swpFlag)) {
			return false;
		}
		return true;
	}

	

}