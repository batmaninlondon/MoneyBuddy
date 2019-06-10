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
@Table (name ="REDEMPTION_CART")
public class RedemptionCart {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column (name="RED_CART_ID")
    private String redCartId;
    
    @Column(name="CUSTOMER_ID")
    private String customerId;

    @Column (name="PRODUCT_ID")
    private String productId;

    @Column (name="PRODUCT_NAME")
    private String productName;
    
    @Column (name="MIN_RED_AMOUNT")
    private String minRedAmount;
    
    @Column (name="RED_AMOUNT")
    private String redAmount;
    
    @Column (name="RED_UNITS")
    private String redUnits;
    
    @Column (name="TOATL_AMOUNT")
    private String totalAmount;
    
    @Column (name="TOTAL_UNITS")
    private String totalUnits;
    
    @Column (name="REDEMTION_OPTION")
    private String redemptionOption;
    
    @Column (name="REDEMTION_TYPE")
    private String redemptionType;
    
    @Column (name="FOLIO_NUMBER")
    private String folioNumber;

    @Column(name="RED_CART_CREATION_DATE")
    private String redCartCreationDate;
    
    @Column(name="STATUS")
    private String status;

    public RedemptionCart() {
        
    }

	public RedemptionCart(String customerId, String productId, String productName, String minRedAmount, String redAmount, String redUnits,
			String totalAmount, String totalUnits, String redemptionOption, String redemptionType, String folioNumber,
			String redCartCreationDate, String status) {
		super();
		this.customerId = customerId;
		this.productId = productId;
		this.productName = productName;
		this.minRedAmount = minRedAmount;
		this.redAmount = redAmount;
		this.redUnits = redUnits;
		this.totalAmount = totalAmount;
		this.totalUnits = totalUnits;
		this.redemptionOption = redemptionOption;
		this.redemptionType = redemptionType;
		this.folioNumber = folioNumber;
		this.redCartCreationDate = redCartCreationDate;
		this.status = status;
	}

	public String getRedCartId() {
		return redCartId;
	}

	public void setRedCartId(String redCartId) {
		this.redCartId = redCartId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getMinRedAmount() {
		return minRedAmount;
	}

	public void setMinRedAmount(String minRedAmount) {
		this.minRedAmount = minRedAmount;
	}

	public String getRedAmount() {
		return redAmount;
	}

	public void setRedAmount(String redAmount) {
		this.redAmount = redAmount;
	}

	public String getRedUnits() {
		return redUnits;
	}

	public void setRedUnits(String redUnits) {
		this.redUnits = redUnits;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getTotalUnits() {
		return totalUnits;
	}

	public void setTotalUnits(String totalUnits) {
		this.totalUnits = totalUnits;
	}

	public String getRedemptionOption() {
		return redemptionOption;
	}

	public void setRedemptionOption(String redemptionOption) {
		this.redemptionOption = redemptionOption;
	}

	public String getRedemptionType() {
		return redemptionType;
	}

	public void setRedemptionType(String redemptionType) {
		this.redemptionType = redemptionType;
	}

	public String getFolioNumber() {
		return folioNumber;
	}

	public void setFolioNumber(String folioNumber) {
		this.folioNumber = folioNumber;
	}

	public String getRedCartCreationDate() {
		return redCartCreationDate;
	}

	public void setRedCartCreationDate(String redCartCreationDate) {
		this.redCartCreationDate = redCartCreationDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((folioNumber == null) ? 0 : folioNumber.hashCode());
		result = prime * result + ((minRedAmount == null) ? 0 : minRedAmount.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + ((redAmount == null) ? 0 : redAmount.hashCode());
		result = prime * result + ((redCartCreationDate == null) ? 0 : redCartCreationDate.hashCode());
		result = prime * result + ((redCartId == null) ? 0 : redCartId.hashCode());
		result = prime * result + ((redUnits == null) ? 0 : redUnits.hashCode());
		result = prime * result + ((redemptionOption == null) ? 0 : redemptionOption.hashCode());
		result = prime * result + ((redemptionType == null) ? 0 : redemptionType.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((totalAmount == null) ? 0 : totalAmount.hashCode());
		result = prime * result + ((totalUnits == null) ? 0 : totalUnits.hashCode());
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
		RedemptionCart other = (RedemptionCart) obj;
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
		if (minRedAmount == null) {
			if (other.minRedAmount != null) {
				return false;
			}
		} else if (!minRedAmount.equals(other.minRedAmount)) {
			return false;
		}
		if (productId == null) {
			if (other.productId != null) {
				return false;
			}
		} else if (!productId.equals(other.productId)) {
			return false;
		}
		if (productName == null) {
			if (other.productName != null) {
				return false;
			}
		} else if (!productName.equals(other.productName)) {
			return false;
		}
		if (redAmount == null) {
			if (other.redAmount != null) {
				return false;
			}
		} else if (!redAmount.equals(other.redAmount)) {
			return false;
		}
		if (redCartCreationDate == null) {
			if (other.redCartCreationDate != null) {
				return false;
			}
		} else if (!redCartCreationDate.equals(other.redCartCreationDate)) {
			return false;
		}
		if (redCartId == null) {
			if (other.redCartId != null) {
				return false;
			}
		} else if (!redCartId.equals(other.redCartId)) {
			return false;
		}
		if (redUnits == null) {
			if (other.redUnits != null) {
				return false;
			}
		} else if (!redUnits.equals(other.redUnits)) {
			return false;
		}
		if (redemptionOption == null) {
			if (other.redemptionOption != null) {
				return false;
			}
		} else if (!redemptionOption.equals(other.redemptionOption)) {
			return false;
		}
		if (redemptionType == null) {
			if (other.redemptionType != null) {
				return false;
			}
		} else if (!redemptionType.equals(other.redemptionType)) {
			return false;
		}
		if (status == null) {
			if (other.status != null) {
				return false;
			}
		} else if (!status.equals(other.status)) {
			return false;
		}
		if (totalAmount == null) {
			if (other.totalAmount != null) {
				return false;
			}
		} else if (!totalAmount.equals(other.totalAmount)) {
			return false;
		}
		if (totalUnits == null) {
			if (other.totalUnits != null) {
				return false;
			}
		} else if (!totalUnits.equals(other.totalUnits)) {
			return false;
		}
		return true;
	}



}
