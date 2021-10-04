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
@Table (name ="CUSTOMER_CART")
public class CustomerCart {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column (name="CART_ID")
    private String cartId;
    
    @Column(name="CUSTOMER_ID")
    private String customerId;

    @Column (name="FUND_ID")
    private String fundId;

    @Column (name="SCHEME_NAME")
    private String schemeName;
    
    @Column (name="MIN_UPFRONT_AMOUNT")
    private String minUpfrontAmount;
    
    @Column (name="UPFRONT_MULTIPLIER")
    private String upfrontMultiplier;
    
    @Column (name="MIN_SIP_AMOUNT")
    private String minSipAmount;
    
    @Column (name="UPFRONT_AMOUNT")
    private String upfrontAmount;
    
    @Column (name="SIP_AMOUNT")
    private String sipAmount;
    
    @Column (name="TRANSACTION_TYPE")
    private String transactionType;
    
    @Column (name="SIP_DURATION")
    private String sipDuration;
    
    @Column (name="SIP_PLAN")
    private String sipPlan;
    
    @Column (name="SIP_DATE")
    private String sipDate;
    
    @Column (name="FOLIO_NUMBER")
    private String folioNumber;
    
    @Column (name="FOLIO_NUM_LIST")
    private String folioNumList;

    @Column(name="CART_CREATION_DATE")
    private String cartCreationDate;
    
    @Column(name="STATUS")
    private String status;
    
    @Column(name="RTA")
    private String rta;
    
    @Column(name="PDF_FILE_PATH")
    private String pdfFilePath;

    public CustomerCart() {
        
    }

	public CustomerCart( String customerId, String fundId, String schemeName, String minUpfrontAmount, String upfrontMultiplier, String minSipAmount, String upfrontAmount, 
			String sipAmount, String transactionType, String sipDuration, String sipPlan, String sipDate,
			String folioNumber, String folioNumList, String cartCreationDate, String status, String rta, String pdfFilePath) {
		super();
		this.customerId = customerId;
		this.fundId = fundId;
		this.schemeName = schemeName;
		this.minUpfrontAmount = minUpfrontAmount;
		this.upfrontMultiplier = upfrontMultiplier;
		this.minSipAmount = minSipAmount;
		this.upfrontAmount = upfrontAmount;
		this.sipAmount = sipAmount;
		this.transactionType = transactionType;
		this.sipDuration = sipDuration;
		this.sipPlan = sipPlan;
		this.sipDate = sipDate;
		this.folioNumber = folioNumber;
		this.folioNumList = folioNumList;
		this.cartCreationDate = cartCreationDate;
		this.status = status;
		this.rta = rta;
		this.pdfFilePath = pdfFilePath;
	}


	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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

	public String getUpfrontAmount() {
		return upfrontAmount;
	}

	public void setUpfrontAmount(String upfrontAmount) {
		this.upfrontAmount = upfrontAmount;
	}

	public String getSipAmount() {
		return sipAmount;
	}

	public void setSipAmount(String sipAmount) {
		this.sipAmount = sipAmount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getSipDuration() {
		return sipDuration;
	}

	public void setSipDuration(String sipDuration) {
		this.sipDuration = sipDuration;
	}

	public String getSipPlan() {
		return sipPlan;
	}

	public void setSipPlan(String sipPlan) {
		this.sipPlan = sipPlan;
	}

	public String getSipDate() {
		return sipDate;
	}

	public void setSipDate(String sipDate) {
		this.sipDate = sipDate;
	}

	public String getFolioNumber() {
		return folioNumber;
	}

	public void setFolioNumber(String folioNumber) {
		this.folioNumber = folioNumber;
	}

	public String getFolioNumList() {
		return folioNumList;
	}

	public void setFolioNumList(String folioNumList) {
		this.folioNumList = folioNumList;
	}

	public String getCartCreationDate() {
		return cartCreationDate;
	}

	public void setCartCreationDate(String cartCreationDate) {
		this.cartCreationDate = cartCreationDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRta() {
		return rta;
	}

	public void setRta(String rta) {
		this.rta = rta;
	}

	public String getPdfFilePath() {
		return pdfFilePath;
	}

	public void setPdfFilePath(String pdfFilePath) {
		this.pdfFilePath = pdfFilePath;
	}

	public String getMinUpfrontAmount() {
		return minUpfrontAmount;
	}

	public void setMinUpfrontAmount(String minUpfrontAmount) {
		this.minUpfrontAmount = minUpfrontAmount;
	}

	public String getUpfrontMultiplier() {
		return upfrontMultiplier;
	}

	public void setUpfrontMultiplier(String upfrontMultiplier) {
		this.upfrontMultiplier = upfrontMultiplier;
	}

	public String getMinSipAmount() {
		return minSipAmount;
	}

	public void setMinSipAmount(String minSipAmount) {
		this.minSipAmount = minSipAmount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cartCreationDate == null) ? 0 : cartCreationDate.hashCode());
		result = prime * result + ((cartId == null) ? 0 : cartId.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((folioNumList == null) ? 0 : folioNumList.hashCode());
		result = prime * result + ((folioNumber == null) ? 0 : folioNumber.hashCode());
		result = prime * result + ((minSipAmount == null) ? 0 : minSipAmount.hashCode());
		result = prime * result + ((minUpfrontAmount == null) ? 0 : minUpfrontAmount.hashCode());
		result = prime * result + ((upfrontMultiplier == null) ? 0 : upfrontMultiplier.hashCode());
		result = prime * result + ((pdfFilePath == null) ? 0 : pdfFilePath.hashCode());
		result = prime * result + ((fundId == null) ? 0 : fundId.hashCode());
		result = prime * result + ((schemeName == null) ? 0 : schemeName.hashCode());
		result = prime * result + ((rta == null) ? 0 : rta.hashCode());
		result = prime * result + ((sipAmount == null) ? 0 : sipAmount.hashCode());
		result = prime * result + ((sipDate == null) ? 0 : sipDate.hashCode());
		result = prime * result + ((sipDuration == null) ? 0 : sipDuration.hashCode());
		result = prime * result + ((sipPlan == null) ? 0 : sipPlan.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((transactionType == null) ? 0 : transactionType.hashCode());
		result = prime * result + ((upfrontAmount == null) ? 0 : upfrontAmount.hashCode());
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
		CustomerCart other = (CustomerCart) obj;
		if (cartCreationDate == null) {
			if (other.cartCreationDate != null) {
				return false;
			}
		} else if (!cartCreationDate.equals(other.cartCreationDate)) {
			return false;
		}
		if (cartId == null) {
			if (other.cartId != null) {
				return false;
			}
		} else if (!cartId.equals(other.cartId)) {
			return false;
		}
		if (customerId == null) {
			if (other.customerId != null) {
				return false;
			}
		} else if (!customerId.equals(other.customerId)) {
			return false;
		}
		if (folioNumList == null) {
			if (other.folioNumList != null) {
				return false;
			}
		} else if (!folioNumList.equals(other.folioNumList)) {
			return false;
		}
		if (folioNumber == null) {
			if (other.folioNumber != null) {
				return false;
			}
		} else if (!folioNumber.equals(other.folioNumber)) {
			return false;
		}
		if (minSipAmount == null) {
			if (other.minSipAmount != null) {
				return false;
			}
		} else if (!minSipAmount.equals(other.minSipAmount)) {
			return false;
		}
		if (minUpfrontAmount == null) {
			if (other.minUpfrontAmount != null) {
				return false;
			}
		} else if (!minUpfrontAmount.equals(other.minUpfrontAmount)) {
			return false;
		}
		if (upfrontMultiplier == null) {
			if (other.upfrontMultiplier != null) {
				return false;
			}
		} else if (!upfrontMultiplier.equals(other.upfrontMultiplier)) {
			return false;
		}
		if (pdfFilePath == null) {
			if (other.pdfFilePath != null) {
				return false;
			}
		} else if (!pdfFilePath.equals(other.pdfFilePath)) {
			return false;
		}
		if (fundId == null) {
			if (other.fundId != null) {
				return false;
			}
		} else if (!fundId.equals(other.fundId)) {
			return false;
		}
		if (schemeName == null) {
			if (other.schemeName != null) {
				return false;
			}
		} else if (!schemeName.equals(other.schemeName)) {
			return false;
		}
		if (rta == null) {
			if (other.rta != null) {
				return false;
			}
		} else if (!rta.equals(other.rta)) {
			return false;
		}
		if (sipAmount == null) {
			if (other.sipAmount != null) {
				return false;
			}
		} else if (!sipAmount.equals(other.sipAmount)) {
			return false;
		}
		if (sipDate == null) {
			if (other.sipDate != null) {
				return false;
			}
		} else if (!sipDate.equals(other.sipDate)) {
			return false;
		}
		if (sipDuration == null) {
			if (other.sipDuration != null) {
				return false;
			}
		} else if (!sipDuration.equals(other.sipDuration)) {
			return false;
		}
		if (sipPlan == null) {
			if (other.sipPlan != null) {
				return false;
			}
		} else if (!sipPlan.equals(other.sipPlan)) {
			return false;
		}
		if (status == null) {
			if (other.status != null) {
				return false;
			}
		} else if (!status.equals(other.status)) {
			return false;
		}
		if (transactionType == null) {
			if (other.transactionType != null) {
				return false;
			}
		} else if (!transactionType.equals(other.transactionType)) {
			return false;
		}
		if (upfrontAmount == null) {
			if (other.upfrontAmount != null) {
				return false;
			}
		} else if (!upfrontAmount.equals(other.upfrontAmount)) {
			return false;
		}
		return true;
	}

	
}
