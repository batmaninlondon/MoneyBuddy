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
@Table (name="NAV_HISTORY")
public class NavHistory {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="NAV_HISTORY_ID")
    private String navHistoryId;

    @Column(name="NAV_DATE")
    private String navDate;
    
    @Column(name="NAV_VALUE")
    private String navValue;
    
    @Column(name="FUND_ID")
    private String fundId;
    

    public NavHistory() {

    }

	public NavHistory(String navDate, String navValue, String fundId) {
		super();
		this.navDate = navDate;
		this.navValue = navValue;
		this.fundId = fundId;
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

	public String getNavValue() {
		return navValue;
	}

	public void setNavValue(String navValue) {
		this.navValue = navValue;
	}

	public String getFundId() {
		return fundId;
	}

	public void setFundId(String fundId) {
		this.fundId = fundId;
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
        if ((this.navValue == null) ? (other.navValue != null) : !this.navValue.equals(other.navValue)) {
            return false;
        }
        if ((this.fundId == null) ? (other.fundId != null) : !this.fundId.equals(other.fundId)) {
            return false;
        }
        return true;
    }


    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + (this.navHistoryId != null ? this.navHistoryId.hashCode() : 0);
        hash = 83 * hash + (this.navDate != null ? this.navDate.hashCode() : 0);
        hash = 83 * hash + (this.navValue != null ? this.navValue.hashCode() : 0);
        hash = 83 * hash + (this.fundId != null ? this.fundId.hashCode() : 0);
        
        return hash;
    }



}