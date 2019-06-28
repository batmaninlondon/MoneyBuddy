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
@Table (name ="DAILY_INVESTMENTS")
public class DailyInvestments {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="DAILY_INVESTMENTS_ID")
    private String dailyInvestmentsId;
	
	@Column (name="CUSTOMER_ID")
    private String customerId;
    
    @Column(name="END_OF_DAY_INVESTMENT")
    private String endOfDayInvestment;
    
    @Column(name="INVESTMENT_DATE")
    private String investmentDate;

    public DailyInvestments() {
        
    }

	public DailyInvestments(String customerId, String endOfDayInvestment, String investmentDate) {
		super();
		this.customerId = customerId;
		this.endOfDayInvestment = endOfDayInvestment;
		this.investmentDate = investmentDate;
	}

	public String getDailyInvestmentsId() {
		return dailyInvestmentsId;
	}

	public void setDailyInvestmentsId(String dailyInvestmentsId) {
		this.dailyInvestmentsId = dailyInvestmentsId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getEndOfDayInvestment() {
		return endOfDayInvestment;
	}

	public void setEndOfDayInvestment(String endOfDayInvestment) {
		this.endOfDayInvestment = endOfDayInvestment;
	}

	public String getInvestmentDate() {
		return investmentDate;
	}

	public void setInvestmentDate(String investmentDate) {
		this.investmentDate = investmentDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((dailyInvestmentsId == null) ? 0 : dailyInvestmentsId.hashCode());
		result = prime * result + ((endOfDayInvestment == null) ? 0 : endOfDayInvestment.hashCode());
		result = prime * result + ((investmentDate == null) ? 0 : investmentDate.hashCode());
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
		DailyInvestments other = (DailyInvestments) obj;
		if (customerId == null) {
			if (other.customerId != null) {
				return false;
			}
		} else if (!customerId.equals(other.customerId)) {
			return false;
		}
		if (dailyInvestmentsId == null) {
			if (other.dailyInvestmentsId != null) {
				return false;
			}
		} else if (!dailyInvestmentsId.equals(other.dailyInvestmentsId)) {
			return false;
		}
		if (endOfDayInvestment == null) {
			if (other.endOfDayInvestment != null) {
				return false;
			}
		} else if (!endOfDayInvestment.equals(other.endOfDayInvestment)) {
			return false;
		}
		if (investmentDate == null) {
			if (other.investmentDate != null) {
				return false;
			}
		} else if (!investmentDate.equals(other.investmentDate)) {
			return false;
		}
		return true;
	}

	

}
