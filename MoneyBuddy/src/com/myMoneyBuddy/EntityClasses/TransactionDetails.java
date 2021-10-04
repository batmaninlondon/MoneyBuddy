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
@Table (name="TRANSACTION_DETAILS")
public class TransactionDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="TRANSACTION_DETAIL_ID")
    private String transactionDetailId;

    @Column(name="TRANSACTION_ID")
    private String transactionId;
    
    @Column(name="BSE_ORDER_ID")
    private String bseOrderId;
    
    @Column(name="BSE_REGISTRATION_NUMBER")
    private String bseRegistrationNumber;
    
    @Column(name="UNIQUE_REFERENCE_NUMBER")
    private String uniqueReferenceNumber;
    
    @Column(name="CUSTOMER_ID")
    private String customerId;
  
    @Column(name="TRANSACTION_TYPE")
    private String transactionType;
    
    @Column(name="SEL_OPTION")
    private String selOption;
    
    @Column(name="SEL_TYPE")
    private String selType;
    
    @Column(name="TRANSACTION_CODE")
    private String transactionCode;
    
    @Column(name="BUY_SELL")
    private String buySell;
    
    @Column(name="BUY_SELL_TYPE")
    private String buySellType;
    
    @Column(name="TRANSACTION_AMOUNT")
    private String transactionAmount;
    
    @Column(name="TRANSACTION_UNIT")
    private String transactionUnit;

    @Column(name="TRANSACTION_STATUS")
    private String transactionStatus;
    
    @Column(name="BSE_REMARKS")
    private String bseRemarks;
    
    @Column(name="BSE_SUCCESS_FLAG")
    private String bseSuccessFlag;
    
    @Column(name="REVERSE_FEED")
    private String reverseFeed;
    
    @Column(name="FUND_ID")
    private String fundId;

    @Column(name="QUANTITY")
    private String quantity;
    
    @Column(name="UNIT_PRICE")
    private String unitPrice;
    
    @Column(name="TRANSACTION_DATE")
    private String transactionDate;
    
    @Column(name="UPDATE_DATE")
    private String updateDate;
    
    @Column(name="RTA_FILE_GENERATED ")
    private String rtaFileGenerated;
    
    @Column(name="TRANSACTION_FOLIO_NUM ")
    private String transactionFolioNum;
    
    @Column(name="REMAINING_QUANTITY")
    private String remainingQuantity;
    
    @Column(name="REVERSAL_ORDER")
    private String reversalOrder;
    
    public TransactionDetails() {

    }

    public TransactionDetails(String transactionId, String bseOrderId, String bseRegistrationNumber, String uniqueReferenceNumber, String customerId, String transactionType,
    		String selOption, String selType, String transactionCode, String buySell, String buySellType, String transactionAmount, String transactionUnit, 
    		String transactionStatus, String bseRemarks, String bseSuccessFlag, String reverseFeed, String fundId, String quantity,String unitPrice, 
    		String transactionDate, String updateDate, String rtaFileGenerated, String transactionFolioNum, String remainingQuantity, String reversalOrder) {
		super();
		this.transactionId = transactionId;
		this.bseOrderId = bseOrderId;
		this.bseRegistrationNumber = bseRegistrationNumber;
		this.uniqueReferenceNumber = uniqueReferenceNumber;
		this.customerId = customerId;
		this.transactionType = transactionType;
		this.selOption = selOption;
		this.selType = selType;
		this.transactionCode = transactionCode;
		this.buySell = buySell;
		this.buySellType = buySellType;
		this.transactionAmount = transactionAmount;
		this.transactionUnit = transactionUnit;
		this.transactionStatus = transactionStatus;
		this.bseRemarks = bseRemarks;
		this.bseSuccessFlag = bseSuccessFlag;
		this.reverseFeed = reverseFeed;
		this.fundId = fundId;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.transactionDate = transactionDate;
		this.updateDate = updateDate;
		this.rtaFileGenerated = rtaFileGenerated;
		this.transactionFolioNum = transactionFolioNum;
		this.remainingQuantity = remainingQuantity;
		this.reversalOrder = reversalOrder;
	}

	public String getTransactionDetailId() {
		return transactionDetailId;
	}

	public void setTransactionDetailId(String transactionDetailId) {
		this.transactionDetailId = transactionDetailId;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getBseOrderId() {
		return bseOrderId;
	}

	public void setBseOrderId(String bseOrderId) {
		this.bseOrderId = bseOrderId;
	}
	
	public String getBseRegistrationNumber() {
		return bseRegistrationNumber;
	}

	public void setBseRegistrationNumber(String bseRegistrationNumber) {
		this.bseRegistrationNumber = bseRegistrationNumber;
	}

	public String getUniqueReferenceNumber() {
		return uniqueReferenceNumber;
	}

	public void setUniqueReferenceNumber(String uniqueReferenceNumber) {
		this.uniqueReferenceNumber = uniqueReferenceNumber;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getSelOption() {
		return selOption;
	}

	public void setSelOption(String selOption) {
		this.selOption = selOption;
	}

	public String getSelType() {
		return selType;
	}

	public void setSelType(String selType) {
		this.selType = selType;
	}

	public String getTransactionCode() {
		return transactionCode;
	}
	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}
	public String getBuySell() {
		return buySell;
	}
	public void setBuySell(String buySell) {
		this.buySell = buySell;
	}
	
	public String getBuySellType() {
		return buySellType;
	}

	public void setBuySellType(String buySellType) {
		this.buySellType = buySellType;
	}

	public String getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getTransactionUnit() {
		return transactionUnit;
	}

	public void setTransactionUnit(String transactionUnit) {
		this.transactionUnit = transactionUnit;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public String getBseRemarks() {
		return bseRemarks;
	}

	public void setBseRemarks(String bseRemarks) {
		this.bseRemarks = bseRemarks;
	}

	public String getBseSuccessFlag() {
		return bseSuccessFlag;
	}

	public void setBseSuccessFlag(String bseSuccessFlag) {
		this.bseSuccessFlag = bseSuccessFlag;
	}

	public String getReverseFeed() {
		return reverseFeed;
	}

	public void setReverseFeed(String reverseFeed) {
		this.reverseFeed = reverseFeed;
	}

	public String getFundId() {
		return fundId;
	}

	public void setFundId(String fundId) {
		this.fundId = fundId;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getRtaFileGenerated() {
		return rtaFileGenerated;
	}

	public void setRtaFileGenerated(String rtaFileGenerated) {
		this.rtaFileGenerated = rtaFileGenerated;
	}

	public String getTransactionFolioNum() {
		return transactionFolioNum;
	}

	public void setTransactionFolioNum(String transactionFolioNum) {
		this.transactionFolioNum = transactionFolioNum;
	}

	public String getRemainingQuantity() {
		return remainingQuantity;
	}

	public void setRemainingQuantity(String remainingQuantity) {
		this.remainingQuantity = remainingQuantity;
	}

	public String getReversalOrder() {
		return reversalOrder;
	}

	public void setReversalOrder(String reversalOrder) {
		this.reversalOrder = reversalOrder;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bseOrderId == null) ? 0 : bseOrderId.hashCode());
		result = prime * result + ((bseRegistrationNumber == null) ? 0 : bseRegistrationNumber.hashCode());
		result = prime * result + ((bseRemarks == null) ? 0 : bseRemarks.hashCode());
		result = prime * result + ((bseSuccessFlag == null) ? 0 : bseSuccessFlag.hashCode());
		result = prime * result + ((buySell == null) ? 0 : buySell.hashCode());
		result = prime * result + ((buySellType == null) ? 0 : buySellType.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((fundId == null) ? 0 : fundId.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((remainingQuantity == null) ? 0 : remainingQuantity.hashCode());
		result = prime * result + ((reverseFeed == null) ? 0 : reverseFeed.hashCode());
		result = prime * result + ((rtaFileGenerated == null) ? 0 : rtaFileGenerated.hashCode());
		result = prime * result + ((transactionAmount == null) ? 0 : transactionAmount.hashCode());
		result = prime * result + ((transactionUnit == null) ? 0 : transactionUnit.hashCode());
		result = prime * result + ((transactionCode == null) ? 0 : transactionCode.hashCode());
		result = prime * result + ((transactionDate == null) ? 0 : transactionDate.hashCode());
		result = prime * result + ((transactionDetailId == null) ? 0 : transactionDetailId.hashCode());
		result = prime * result + ((transactionFolioNum == null) ? 0 : transactionFolioNum.hashCode());
		result = prime * result + ((transactionId == null) ? 0 : transactionId.hashCode());
		result = prime * result + ((transactionStatus == null) ? 0 : transactionStatus.hashCode());
		result = prime * result + ((transactionType == null) ? 0 : transactionType.hashCode());
		result = prime * result + ((selOption == null) ? 0 : selOption.hashCode());
		result = prime * result + ((selType == null) ? 0 : selType.hashCode());
		result = prime * result + ((uniqueReferenceNumber == null) ? 0 : uniqueReferenceNumber.hashCode());
		result = prime * result + ((unitPrice == null) ? 0 : unitPrice.hashCode());
		result = prime * result + ((updateDate == null) ? 0 : updateDate.hashCode());
		result = prime * result + ((reversalOrder == null) ? 0 : reversalOrder.hashCode());
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
		TransactionDetails other = (TransactionDetails) obj;
		if (bseOrderId == null) {
			if (other.bseOrderId != null) {
				return false;
			}
		} else if (!bseOrderId.equals(other.bseOrderId)) {
			return false;
		}
		if (bseRegistrationNumber == null) {
			if (other.bseRegistrationNumber != null) {
				return false;
			}
		} else if (!bseRegistrationNumber.equals(other.bseRegistrationNumber)) {
			return false;
		}
		if (bseRemarks == null) {
			if (other.bseRemarks != null) {
				return false;
			}
		} else if (!bseRemarks.equals(other.bseRemarks)) {
			return false;
		}
		if (bseSuccessFlag == null) {
			if (other.bseSuccessFlag != null) {
				return false;
			}
		} else if (!bseSuccessFlag.equals(other.bseSuccessFlag)) {
			return false;
		}
		if (buySell == null) {
			if (other.buySell != null) {
				return false;
			}
		} else if (!buySell.equals(other.buySell)) {
			return false;
		}
		if (buySellType == null) {
			if (other.buySellType != null) {
				return false;
			}
		} else if (!buySellType.equals(other.buySellType)) {
			return false;
		}
		if (customerId == null) {
			if (other.customerId != null) {
				return false;
			}
		} else if (!customerId.equals(other.customerId)) {
			return false;
		}
		if (fundId == null) {
			if (other.fundId != null) {
				return false;
			}
		} else if (!fundId.equals(other.fundId)) {
			return false;
		}
		if (quantity == null) {
			if (other.quantity != null) {
				return false;
			}
		} else if (!quantity.equals(other.quantity)) {
			return false;
		}
		if (remainingQuantity == null) {
			if (other.remainingQuantity != null) {
				return false;
			}
		} else if (!remainingQuantity.equals(other.remainingQuantity)) {
			return false;
		}
		if (reverseFeed == null) {
			if (other.reverseFeed != null) {
				return false;
			}
		} else if (!reverseFeed.equals(other.reverseFeed)) {
			return false;
		}
		if (rtaFileGenerated == null) {
			if (other.rtaFileGenerated != null) {
				return false;
			}
		} else if (!rtaFileGenerated.equals(other.rtaFileGenerated)) {
			return false;
		}
		if (transactionAmount == null) {
			if (other.transactionAmount != null) {
				return false;
			}
		} else if (!transactionAmount.equals(other.transactionAmount)) {
			return false;
		}
		if (transactionUnit == null) {
			if (other.transactionUnit != null) {
				return false;
			}
		} else if (!transactionUnit.equals(other.transactionUnit)) {
			return false;
		}
		if (transactionCode == null) {
			if (other.transactionCode != null) {
				return false;
			}
		} else if (!transactionCode.equals(other.transactionCode)) {
			return false;
		}
		if (transactionDate == null) {
			if (other.transactionDate != null) {
				return false;
			}
		} else if (!transactionDate.equals(other.transactionDate)) {
			return false;
		}
		if (transactionDetailId == null) {
			if (other.transactionDetailId != null) {
				return false;
			}
		} else if (!transactionDetailId.equals(other.transactionDetailId)) {
			return false;
		}
		if (transactionFolioNum == null) {
			if (other.transactionFolioNum != null) {
				return false;
			}
		} else if (!transactionFolioNum.equals(other.transactionFolioNum)) {
			return false;
		}
		if (transactionId == null) {
			if (other.transactionId != null) {
				return false;
			}
		} else if (!transactionId.equals(other.transactionId)) {
			return false;
		}
		if (transactionStatus == null) {
			if (other.transactionStatus != null) {
				return false;
			}
		} else if (!transactionStatus.equals(other.transactionStatus)) {
			return false;
		}
		if (transactionType == null) {
			if (other.transactionType != null) {
				return false;
			}
		} else if (!transactionType.equals(other.transactionType)) {
			return false;
		}
		if (selOption == null) {
			if (other.selOption != null) {
				return false;
			}
		} else if (!selOption.equals(other.selOption)) {
			return false;
		}
		if (selType == null) {
			if (other.selType != null) {
				return false;
			}
		} else if (!selType.equals(other.selType)) {
			return false;
		}
		if (uniqueReferenceNumber == null) {
			if (other.uniqueReferenceNumber != null) {
				return false;
			}
		} else if (!uniqueReferenceNumber.equals(other.uniqueReferenceNumber)) {
			return false;
		}
		if (unitPrice == null) {
			if (other.unitPrice != null) {
				return false;
			}
		} else if (!unitPrice.equals(other.unitPrice)) {
			return false;
		}
		if (updateDate == null) {
			if (other.updateDate != null) {
				return false;
			}
		} else if (!updateDate.equals(other.updateDate)) {
			return false;
		}
		if (reversalOrder == null) {
			if (other.reversalOrder != null) {
				return false;
			}
		} else if (!reversalOrder.equals(other.reversalOrder)) {
			return false;
		}
		return true;
	}

	

}