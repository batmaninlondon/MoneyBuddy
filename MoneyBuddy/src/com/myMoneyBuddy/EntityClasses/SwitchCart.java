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
@Table (name ="SWITCH_CART")
public class SwitchCart {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column (name="SWITCH_CART_ID")
    private String switchCartId;
    
    @Column(name="CUSTOMER_ID")
    private String customerId;

    @Column (name="WITHDRAWAL_FUND_ID")
    private String withdrawalFundId;
    
    @Column (name="WITHDRAWAL_SCHEME_NAME")
    private String withdrawalSchemeName;
    
    @Column (name="TOTAL_WITHDRAWAL_AMOUNT")
    private String totalWithdrawalAmount;
    
    @Column (name="TOTAL_WITHDRAWAL_UNIT")
    private String totalWithdrawalUnit;
    
    @Column (name="FOLIO_NUMBER")
    private String folioNumber;
    
    @Column (name="PURCHASE_FUND_ID")
    private String purchaseFundId;
    
    @Column (name="PURCHASE_FUND_SCHEME_NAME")
    private String purchaseFundSchemeName;
        
    @Column (name="PURCHASE_SCHEME_NAME_LIST")
    private String purchaseSchemeNameList;
    
    @Column (name="MIN_SWITCH_AMOUNT")
    private String minSwitchAmount;
        
    @Column (name="SWITCH_AMOUNT")
    private String switchAmount;
    
    @Column (name="SWITCH_UNIT")
    private String switchUnit;

    @Column (name="SWITCH_OPTION")
    private String switchOption;
    
    @Column (name="SWITCH_TYPE")
    private String switchType;

    @Column(name="CART_CREATION_DATE")
    private String cartCreationDate;
    
    @Column(name="LATEST_NAV")
    private String latestNav;

    public SwitchCart() {
        
    }

	public SwitchCart(String customerId, String withdrawalFundId, String withdrawalSchemeName,
			String totalWithdrawalAmount, String totalWithdrawalUnit, String folioNumber, String purchaseFundId,
			String purchaseFundSchemeName, String purchaseSchemeNameList, String minSwitchAmount, String switchAmount,
			String switchUnit, String switchOption, String switchType, String cartCreationDate, String latestNav) {
		super();
		this.customerId = customerId;
		this.withdrawalFundId = withdrawalFundId;
		this.withdrawalSchemeName = withdrawalSchemeName;
		this.totalWithdrawalAmount = totalWithdrawalAmount;
		this.totalWithdrawalUnit = totalWithdrawalUnit;
		this.folioNumber = folioNumber;
		this.purchaseFundId = purchaseFundId;
		this.purchaseFundSchemeName = purchaseFundSchemeName;
		this.purchaseSchemeNameList = purchaseSchemeNameList;
		this.minSwitchAmount = minSwitchAmount;
		this.switchAmount = switchAmount;
		this.switchUnit = switchUnit;
		this.switchOption = switchOption;
		this.switchType = switchType;
		this.cartCreationDate = cartCreationDate;
		this.latestNav = latestNav;
	}

	public String getTotalWithdrawalUnit() {
		return totalWithdrawalUnit;
	}

	public void setTotalWithdrawalUnit(String totalWithdrawalUnit) {
		this.totalWithdrawalUnit = totalWithdrawalUnit;
	}

	public String getSwitchOption() {
		return switchOption;
	}

	public void setSwitchOption(String switchOption) {
		this.switchOption = switchOption;
	}

	public String getSwitchType() {
		return switchType;
	}

	public void setSwitchType(String switchType) {
		this.switchType = switchType;
	}

	public String getSwitchCartId() {
		return switchCartId;
	}

	public void setSwitchCartId(String switchCartId) {
		this.switchCartId = switchCartId;
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

	public String getMinSwitchAmount() {
		return minSwitchAmount;
	}

	public void setMinSwitchAmount(String minSwitchAmount) {
		this.minSwitchAmount = minSwitchAmount;
	}

	public String getSwitchAmount() {
		return switchAmount;
	}

	public void setSwitchAmount(String switchAmount) {
		this.switchAmount = switchAmount;
	}

	public String getSwitchUnit() {
		return switchUnit;
	}

	public void setSwitchUnit(String switchUnit) {
		this.switchUnit = switchUnit;
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

	public String getLatestNav() {
		return latestNav;
	}

	public void setLatestNav(String latestNav) {
		this.latestNav = latestNav;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cartCreationDate == null) ? 0 : cartCreationDate.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((folioNumber == null) ? 0 : folioNumber.hashCode());
		result = prime * result + ((minSwitchAmount == null) ? 0 : minSwitchAmount.hashCode());
		result = prime * result + ((purchaseFundId == null) ? 0 : purchaseFundId.hashCode());
		result = prime * result + ((purchaseFundSchemeName == null) ? 0 : purchaseFundSchemeName.hashCode());
		result = prime * result + ((purchaseSchemeNameList == null) ? 0 : purchaseSchemeNameList.hashCode());
		result = prime * result + ((switchOption == null) ? 0 : switchOption.hashCode());
		result = prime * result + ((switchType == null) ? 0 : switchType.hashCode());
		result = prime * result + ((switchAmount == null) ? 0 : switchAmount.hashCode());
		result = prime * result + ((switchCartId == null) ? 0 : switchCartId.hashCode());
		result = prime * result + ((switchUnit == null) ? 0 : switchUnit.hashCode());
		result = prime * result + ((totalWithdrawalAmount == null) ? 0 : totalWithdrawalAmount.hashCode());
		result = prime * result + ((totalWithdrawalUnit == null) ? 0 : totalWithdrawalUnit.hashCode());
		result = prime * result + ((withdrawalFundId == null) ? 0 : withdrawalFundId.hashCode());
		result = prime * result + ((withdrawalSchemeName == null) ? 0 : withdrawalSchemeName.hashCode());
		result = prime * result + ((latestNav == null) ? 0 : latestNav.hashCode());
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
		SwitchCart other = (SwitchCart) obj;
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
		if (minSwitchAmount == null) {
			if (other.minSwitchAmount != null) {
				return false;
			}
		} else if (!minSwitchAmount.equals(other.minSwitchAmount)) {
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
		if (switchOption == null) {
			if (other.switchOption != null) {
				return false;
			}
		} else if (!switchOption.equals(other.switchOption)) {
			return false;
		}
		if (switchType == null) {
			if (other.switchType != null) {
				return false;
			}
		} else if (!switchType.equals(other.switchType)) {
			return false;
		}
		if (switchAmount == null) {
			if (other.switchAmount != null) {
				return false;
			}
		} else if (!switchAmount.equals(other.switchAmount)) {
			return false;
		}
		if (switchCartId == null) {
			if (other.switchCartId != null) {
				return false;
			}
		} else if (!switchCartId.equals(other.switchCartId)) {
			return false;
		}
		if (switchUnit == null) {
			if (other.switchUnit != null) {
				return false;
			}
		} else if (!switchUnit.equals(other.switchUnit)) {
			return false;
		}
		if (totalWithdrawalAmount == null) {
			if (other.totalWithdrawalAmount != null) {
				return false;
			}
		} else if (!totalWithdrawalAmount.equals(other.totalWithdrawalAmount)) {
			return false;
		}
		if (totalWithdrawalUnit == null) {
			if (other.totalWithdrawalUnit != null) {
				return false;
			}
		} else if (!totalWithdrawalUnit.equals(other.totalWithdrawalUnit)) {
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
		if (latestNav == null) {
			if (other.latestNav != null) {
				return false;
			}
		} else if (!latestNav.equals(other.latestNav)) {
			return false;
		}
		return true;
	}

}
