/**
 *
 * @author ADMIN
 */

package com.myMoneyBuddy.EntityClasses;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name ="STP_DETAILS")
public class StpDetails {

    @Id
    @Column (name="TRANSACTION_DETAIL_ID")
    private String transactionDetailId;
    
    @Column(name="CUSTOMER_ID")
    private String customerId;
    
    @Column(name="BSE_REG_NUM")
    private String bseRegNum;

    @Column (name="STP_DATE")
    private String stpDate;

    @Column (name="STP_START_DATE")
    private String stpStartDate;
    
    @Column (name="STP_END_DATE")
    private String stpEndDate;
    
    @Column (name="STP_DURATION")
    private String stpDuration;

    @Column(name="STP_COMPLETION_STATUS")
    private String stpCompletionStatus;

    @Column(name="WITHDRAWAL_FUND_ID ")
    private String withdrawalFundId;
    
    @Column(name="PURCHASE_FUND_ID ")
    private String purchaseFundId;
    
    @Column(name="STP_AMOUNT ")
    private String stpAmount;

    
    public StpDetails() {
        
    }


	public StpDetails(String transactionDetailId, String customerId, String bseRegNum, String stpDate,
			String stpStartDate, String stpEndDate, String stpDuration, String stpCompletionStatus,
			String withdrawalFundId, String purchaseFundId, String stpAmount) {
		super();
		this.transactionDetailId = transactionDetailId;
		this.customerId = customerId;
		this.bseRegNum = bseRegNum;
		this.stpDate = stpDate;
		this.stpStartDate = stpStartDate;
		this.stpEndDate = stpEndDate;
		this.stpDuration = stpDuration;
		this.stpCompletionStatus = stpCompletionStatus;
		this.withdrawalFundId = withdrawalFundId;
		this.purchaseFundId = purchaseFundId;
		this.stpAmount = stpAmount;
	}


	public String getTransactionDetailId() {
		return transactionDetailId;
	}


	public void setTransactionDetailId(String transactionDetailId) {
		this.transactionDetailId = transactionDetailId;
	}


	public String getCustomerId() {
		return customerId;
	}


	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}


	public String getBseRegNum() {
		return bseRegNum;
	}


	public void setBseRegNum(String bseRegNum) {
		this.bseRegNum = bseRegNum;
	}


	public String getStpDate() {
		return stpDate;
	}


	public void setStpDate(String stpDate) {
		this.stpDate = stpDate;
	}


	public String getStpStartDate() {
		return stpStartDate;
	}


	public void setStpStartDate(String stpStartDate) {
		this.stpStartDate = stpStartDate;
	}


	public String getStpEndDate() {
		return stpEndDate;
	}


	public void setStpEndDate(String stpEndDate) {
		this.stpEndDate = stpEndDate;
	}


	public String getStpDuration() {
		return stpDuration;
	}


	public void setStpDuration(String stpDuration) {
		this.stpDuration = stpDuration;
	}


	public String getStpCompletionStatus() {
		return stpCompletionStatus;
	}


	public void setStpCompletionStatus(String stpCompletionStatus) {
		this.stpCompletionStatus = stpCompletionStatus;
	}


	public String getWithdrawalFundId() {
		return withdrawalFundId;
	}


	public void setWithdrawalFundId(String withdrawalFundId) {
		this.withdrawalFundId = withdrawalFundId;
	}


	public String getPurchaseFundId() {
		return purchaseFundId;
	}


	public void setPurchaseFundId(String purchaseFundId) {
		this.purchaseFundId = purchaseFundId;
	}


	public String getStpAmount() {
		return stpAmount;
	}


	public void setStpAmount(String stpAmount) {
		this.stpAmount = stpAmount;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bseRegNum == null) ? 0 : bseRegNum.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((purchaseFundId == null) ? 0 : purchaseFundId.hashCode());
		result = prime * result + ((stpAmount == null) ? 0 : stpAmount.hashCode());
		result = prime * result + ((stpCompletionStatus == null) ? 0 : stpCompletionStatus.hashCode());
		result = prime * result + ((stpDate == null) ? 0 : stpDate.hashCode());
		result = prime * result + ((stpDuration == null) ? 0 : stpDuration.hashCode());
		result = prime * result + ((stpEndDate == null) ? 0 : stpEndDate.hashCode());
		result = prime * result + ((stpStartDate == null) ? 0 : stpStartDate.hashCode());
		result = prime * result + ((transactionDetailId == null) ? 0 : transactionDetailId.hashCode());
		result = prime * result + ((withdrawalFundId == null) ? 0 : withdrawalFundId.hashCode());
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
		StpDetails other = (StpDetails) obj;
		if (bseRegNum == null) {
			if (other.bseRegNum != null) {
				return false;
			}
		} else if (!bseRegNum.equals(other.bseRegNum)) {
			return false;
		}
		if (customerId == null) {
			if (other.customerId != null) {
				return false;
			}
		} else if (!customerId.equals(other.customerId)) {
			return false;
		}
		if (purchaseFundId == null) {
			if (other.purchaseFundId != null) {
				return false;
			}
		} else if (!purchaseFundId.equals(other.purchaseFundId)) {
			return false;
		}
		if (stpAmount == null) {
			if (other.stpAmount != null) {
				return false;
			}
		} else if (!stpAmount.equals(other.stpAmount)) {
			return false;
		}
		if (stpCompletionStatus == null) {
			if (other.stpCompletionStatus != null) {
				return false;
			}
		} else if (!stpCompletionStatus.equals(other.stpCompletionStatus)) {
			return false;
		}
		if (stpDate == null) {
			if (other.stpDate != null) {
				return false;
			}
		} else if (!stpDate.equals(other.stpDate)) {
			return false;
		}
		if (stpDuration == null) {
			if (other.stpDuration != null) {
				return false;
			}
		} else if (!stpDuration.equals(other.stpDuration)) {
			return false;
		}
		if (stpEndDate == null) {
			if (other.stpEndDate != null) {
				return false;
			}
		} else if (!stpEndDate.equals(other.stpEndDate)) {
			return false;
		}
		if (stpStartDate == null) {
			if (other.stpStartDate != null) {
				return false;
			}
		} else if (!stpStartDate.equals(other.stpStartDate)) {
			return false;
		}
		if (transactionDetailId == null) {
			if (other.transactionDetailId != null) {
				return false;
			}
		} else if (!transactionDetailId.equals(other.transactionDetailId)) {
			return false;
		}
		if (withdrawalFundId == null) {
			if (other.withdrawalFundId != null) {
				return false;
			}
		} else if (!withdrawalFundId.equals(other.withdrawalFundId)) {
			return false;
		}
		return true;
	}


}
