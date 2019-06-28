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
@Table (name ="STP_CART")
public class StpCart {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column (name="STP_CART_ID")
    private String stpCartId;
    
    @Column(name="CUSTOMER_ID")
    private String customerId;

    @Column (name="WITHDRAWAL_FUND_ID")
    private String withdrawalFundId;
    
    @Column (name="WITHDRAWAL_SCHEME_NAME")
    private String withdrawalSchemeName;
    
    @Column (name="TOTAL_WITHDRAWAL_AMOUNT")
    private String totalWithdrawalAmount;
    
    @Column (name="FOLIO_NUMBER")
    private String folioNumber;
    
    @Column (name="PURCHASE_FUND_ID")
    private String purchaseFundId;
    
    @Column (name="PURCHASE_FUND_SCHEME_NAME")
    private String purchaseFundSchemeName;
        
    @Column (name="PURCHASE_SCHEME_NAME_LIST")
    private String purchaseSchemeNameList;
    
    @Column (name="MIN_STP_AMOUNT")
    private String minStpAmount;
        
    @Column (name="STP_AMOUNT")
    private String stpAmount;
        
    @Column (name="STP_DURATION")
    private String stpDuration;
        
    @Column (name="STP_DATE")
    private String stpDate;

    @Column(name="CART_CREATION_DATE")
    private String cartCreationDate;
    

    public StpCart() {
        
    }


	public StpCart(String customerId, String withdrawalFundId, String withdrawalSchemeName, String totalWithdrawalAmount, String folioNumber, String purchaseFundId, String purchaseFundSchemeName,
			String purchaseSchemeNameList, String minStpAmount, String stpAmount, String stpDuration, String stpDate,
			String cartCreationDate) {
		super();
		this.customerId = customerId;
		this.withdrawalFundId = withdrawalFundId;
		this.withdrawalSchemeName = withdrawalSchemeName;
		this.totalWithdrawalAmount = totalWithdrawalAmount;
		this.folioNumber = folioNumber;
		this.purchaseFundId = purchaseFundId;
		this.purchaseFundSchemeName = purchaseFundSchemeName;
		this.purchaseSchemeNameList = purchaseSchemeNameList;
		this.minStpAmount = minStpAmount;
		this.stpAmount = stpAmount;
		this.stpDuration = stpDuration;
		this.stpDate = stpDate;
		this.cartCreationDate = cartCreationDate;
	}


	public String getStpCartId() {
		return stpCartId;
	}


	public void setStpCartId(String stpCartId) {
		this.stpCartId = stpCartId;
	}


	public String getCustomerId() {
		return customerId;
	}


	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}


	public String getWithdrawalFundId() {
		return withdrawalFundId;
	}


	public void setWithdrawalFundId(String withdrawalFundId) {
		this.withdrawalFundId = withdrawalFundId;
	}

	public String getFolioNumber() {
		return folioNumber;
	}


	public void setFolioNumber(String folioNumber) {
		this.folioNumber = folioNumber;
	}


	public String getPurchaseFundId() {
		return purchaseFundId;
	}


	public void setPurchaseFundId(String purchaseFundId) {
		this.purchaseFundId = purchaseFundId;
	}


	public String getWithdrawalSchemeName() {
		return withdrawalSchemeName;
	}


	public void setWithdrawalSchemeName(String withdrawalSchemeName) {
		this.withdrawalSchemeName = withdrawalSchemeName;
	}


	public String getPurchaseSchemeNameList() {
		return purchaseSchemeNameList;
	}


	public void setPurchaseSchemeNameList(String purchaseSchemeNameList) {
		this.purchaseSchemeNameList = purchaseSchemeNameList;
	}


	public String getMinStpAmount() {
		return minStpAmount;
	}


	public void setMinStpAmount(String minStpAmount) {
		this.minStpAmount = minStpAmount;
	}


	public String getStpAmount() {
		return stpAmount;
	}


	public void setStpAmount(String stpAmount) {
		this.stpAmount = stpAmount;
	}


	public String getStpDuration() {
		return stpDuration;
	}


	public void setStpDuration(String stpDuration) {
		this.stpDuration = stpDuration;
	}


	public String getStpDate() {
		return stpDate;
	}


	public void setStpDate(String stpDate) {
		this.stpDate = stpDate;
	}


	public String getCartCreationDate() {
		return cartCreationDate;
	}


	public void setCartCreationDate(String cartCreationDate) {
		this.cartCreationDate = cartCreationDate;
	}


	public String getPurchaseFundSchemeName() {
		return purchaseFundSchemeName;
	}


	public void setPurchaseFundSchemeName(String purchaseFundSchemeName) {
		this.purchaseFundSchemeName = purchaseFundSchemeName;
	}


	public String getTotalWithdrawalAmount() {
		return totalWithdrawalAmount;
	}


	public void setTotalWithdrawalAmount(String totalWithdrawalAmount) {
		this.totalWithdrawalAmount = totalWithdrawalAmount;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cartCreationDate == null) ? 0 : cartCreationDate.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((folioNumber == null) ? 0 : folioNumber.hashCode());
		result = prime * result + ((minStpAmount == null) ? 0 : minStpAmount.hashCode());
		result = prime * result + ((purchaseFundId == null) ? 0 : purchaseFundId.hashCode());
		result = prime * result + ((purchaseFundSchemeName == null) ? 0 : purchaseFundSchemeName.hashCode());
		result = prime * result + ((purchaseSchemeNameList == null) ? 0 : purchaseSchemeNameList.hashCode());
		result = prime * result + ((stpAmount == null) ? 0 : stpAmount.hashCode());
		result = prime * result + ((stpCartId == null) ? 0 : stpCartId.hashCode());
		result = prime * result + ((stpDate == null) ? 0 : stpDate.hashCode());
		result = prime * result + ((stpDuration == null) ? 0 : stpDuration.hashCode());
		result = prime * result + ((totalWithdrawalAmount == null) ? 0 : totalWithdrawalAmount.hashCode());
		result = prime * result + ((withdrawalFundId == null) ? 0 : withdrawalFundId.hashCode());
		result = prime * result + ((withdrawalSchemeName == null) ? 0 : withdrawalSchemeName.hashCode());
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
		StpCart other = (StpCart) obj;
		if (cartCreationDate == null) {
			if (other.cartCreationDate != null) {
				return false;
			}
		} else if (!cartCreationDate.equals(other.cartCreationDate)) {
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
		if (minStpAmount == null) {
			if (other.minStpAmount != null) {
				return false;
			}
		} else if (!minStpAmount.equals(other.minStpAmount)) {
			return false;
		}
		if (purchaseFundId == null) {
			if (other.purchaseFundId != null) {
				return false;
			}
		} else if (!purchaseFundId.equals(other.purchaseFundId)) {
			return false;
		}
		if (purchaseFundSchemeName == null) {
			if (other.purchaseFundSchemeName != null) {
				return false;
			}
		} else if (!purchaseFundSchemeName.equals(other.purchaseFundSchemeName)) {
			return false;
		}
		if (purchaseSchemeNameList == null) {
			if (other.purchaseSchemeNameList != null) {
				return false;
			}
		} else if (!purchaseSchemeNameList.equals(other.purchaseSchemeNameList)) {
			return false;
		}
		if (stpAmount == null) {
			if (other.stpAmount != null) {
				return false;
			}
		} else if (!stpAmount.equals(other.stpAmount)) {
			return false;
		}
		if (stpCartId == null) {
			if (other.stpCartId != null) {
				return false;
			}
		} else if (!stpCartId.equals(other.stpCartId)) {
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
		if (totalWithdrawalAmount == null) {
			if (other.totalWithdrawalAmount != null) {
				return false;
			}
		} else if (!totalWithdrawalAmount.equals(other.totalWithdrawalAmount)) {
			return false;
		}
		if (withdrawalFundId == null) {
			if (other.withdrawalFundId != null) {
				return false;
			}
		} else if (!withdrawalFundId.equals(other.withdrawalFundId)) {
			return false;
		}
		if (withdrawalSchemeName == null) {
			if (other.withdrawalSchemeName != null) {
				return false;
			}
		} else if (!withdrawalSchemeName.equals(other.withdrawalSchemeName)) {
			return false;
		}
		return true;
	}


}
