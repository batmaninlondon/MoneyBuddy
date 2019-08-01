/**
 *
 * @author ADMIN
 */

package com.myMoneyBuddy.EntityClasses;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name ="OLD_PORTFOLIO_RECORDS")
public class OldPortfolioRecords {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="OLD_PORTFOLIO_RECORDS_ID")
    private String oldPortfolioRecordsId;
    
    @Column (name="CUSTOMER_ID")
    private String customerId;

    @Column(name="SCHEME_NAME")
    private String schemeName;

    @Column(name="ISIN")
    private String isin;

    @Column(name="INVESTED_VALUE")
    private String investedValue;

    @Column(name="UNITS")
    private String units;
    
    @Column(name="FOLIO_NUMBER")
    private String folioNumber;

    @Column(name="CURRENT_VALUE")
    private String currentValue;
    
    @Column(name="PROFIT")
    private String profit;
    
    @Column(name="CURRENT_NAV")
    private String currentNav;
    
    @Column(name="CREATE_DATE")
    private String createDate;

    public OldPortfolioRecords() {
        
    }



	public OldPortfolioRecords(String customerId, String schemeName, String isin, String investedValue, String units, String folioNumber, 
			String currentValue, String profit, String currentNav, String createDate) {
		super();
		this.customerId = customerId;
		this.schemeName = schemeName;
		this.isin = isin;
		this.investedValue = investedValue;
		this.units = units;
		this.folioNumber = folioNumber;
		this.currentValue = currentValue;
		this.profit = profit;
		this.currentNav = currentNav;
		this.createDate = createDate;
	}




	public String getOldPortfolioRecordsId() {
		return oldPortfolioRecordsId;
	}



	public void setOldPortfolioRecordsId(String oldPortfolioRecordsId) {
		this.oldPortfolioRecordsId = oldPortfolioRecordsId;
	}



	public String getCustomerId() {
		return customerId;
	}



	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}



	public String getSchemeName() {
		return schemeName;
	}



	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}



	public String getIsin() {
		return isin;
	}



	public void setIsin(String isin) {
		this.isin = isin;
	}



	public String getInvestedValue() {
		return investedValue;
	}



	public void setInvestedValue(String investedValue) {
		this.investedValue = investedValue;
	}



	public String getUnits() {
		return units;
	}



	public void setUnits(String units) {
		this.units = units;
	}



	public String getCurrentValue() {
		return currentValue;
	}



	public void setCurrentValue(String currentValue) {
		this.currentValue = currentValue;
	}



	public String getProfit() {
		return profit;
	}



	public void setProfit(String profit) {
		this.profit = profit;
	}



	public String getCurrentNav() {
		return currentNav;
	}



	public void setCurrentNav(String currentNav) {
		this.currentNav = currentNav;
	}



	public String getCreateDate() {
		return createDate;
	}



	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}



	public String getFolioNumber() {
		return folioNumber;
	}



	public void setFolioNumber(String folioNumber) {
		this.folioNumber = folioNumber;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((currentNav == null) ? 0 : currentNav.hashCode());
		result = prime * result + ((currentValue == null) ? 0 : currentValue.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((folioNumber == null) ? 0 : folioNumber.hashCode());
		result = prime * result + ((investedValue == null) ? 0 : investedValue.hashCode());
		result = prime * result + ((isin == null) ? 0 : isin.hashCode());
		result = prime * result + ((oldPortfolioRecordsId == null) ? 0 : oldPortfolioRecordsId.hashCode());
		result = prime * result + ((profit == null) ? 0 : profit.hashCode());
		result = prime * result + ((schemeName == null) ? 0 : schemeName.hashCode());
		result = prime * result + ((units == null) ? 0 : units.hashCode());
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
		OldPortfolioRecords other = (OldPortfolioRecords) obj;
		if (createDate == null) {
			if (other.createDate != null) {
				return false;
			}
		} else if (!createDate.equals(other.createDate)) {
			return false;
		}
		if (currentNav == null) {
			if (other.currentNav != null) {
				return false;
			}
		} else if (!currentNav.equals(other.currentNav)) {
			return false;
		}
		if (currentValue == null) {
			if (other.currentValue != null) {
				return false;
			}
		} else if (!currentValue.equals(other.currentValue)) {
			return false;
		}
		if (customerId == null) {
			if (other.customerId != null) {
				return false;
			}
		} else if (!customerId.equals(other.customerId)) {
			return false;
		}
		if (folioNumber == null) {
			if (other.folioNumber != null) {
				return false;
			}
		} else if (!folioNumber.equals(other.folioNumber)) {
			return false;
		}
		if (investedValue == null) {
			if (other.investedValue != null) {
				return false;
			}
		} else if (!investedValue.equals(other.investedValue)) {
			return false;
		}
		if (isin == null) {
			if (other.isin != null) {
				return false;
			}
		} else if (!isin.equals(other.isin)) {
			return false;
		}
		if (oldPortfolioRecordsId == null) {
			if (other.oldPortfolioRecordsId != null) {
				return false;
			}
		} else if (!oldPortfolioRecordsId.equals(other.oldPortfolioRecordsId)) {
			return false;
		}
		if (profit == null) {
			if (other.profit != null) {
				return false;
			}
		} else if (!profit.equals(other.profit)) {
			return false;
		}
		if (schemeName == null) {
			if (other.schemeName != null) {
				return false;
			}
		} else if (!schemeName.equals(other.schemeName)) {
			return false;
		}
		if (units == null) {
			if (other.units != null) {
				return false;
			}
		} else if (!units.equals(other.units)) {
			return false;
		}
		return true;
	}




}
