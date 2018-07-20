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
    
    @Column(name="UNIQUE_REFERENCE_NUMBER")
    private String uniqueReferenceNumber;
    
    @Column(name="CUSTOMER_ID")
    private String customerId;
  
    @Column(name="TRANSACTION_TYPE")
    private String transactionType;
    
    @Column(name="TRANSACTION_CODE")
    private String transactionCode;
    
    @Column(name="BUY_SELL")
    private String buySell;
    
    @Column(name="BUY_SELL_TYPE")
    private String buySellType;
    
    @Column(name="TRANSACTION_AMOUNT")
    private String transactionAmount;

    @Column(name="TRANSACTION_STATUS")
    private String transactionStatus;
    
    @Column(name="BSE_REMARKS")
    private String bseRemarks;
    
    @Column(name="BSE_SUCCESS_FLAG")
    private String bseSuccessFlag;
    
    @Column(name="REVERSE_FEED")
    private String reverseFeed;
    
    @Column(name="PRODUCT_ID")
    private String productId;

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
    
    public TransactionDetails() {

    }

    public TransactionDetails(String transactionId, String bseOrderId, String uniqueReferenceNumber, String customerId, String transactionType,
			String transactionCode, String buySell, String buySellType, String transactionAmount, String transactionStatus,
			String bseRemarks, String bseSuccessFlag, String reverseFeed, String productId, String quantity,
			String unitPrice, String transactionDate, String updateDate, String rtaFileGenerated, String transactionFolioNum) {
		super();
		this.transactionId = transactionId;
		this.bseOrderId = bseOrderId;
		this.uniqueReferenceNumber = uniqueReferenceNumber;
		this.customerId = customerId;
		this.transactionType = transactionType;
		this.transactionCode = transactionCode;
		this.buySell = buySell;
		this.buySellType = buySellType;
		this.transactionAmount = transactionAmount;
		this.transactionStatus = transactionStatus;
		this.bseRemarks = bseRemarks;
		this.bseSuccessFlag = bseSuccessFlag;
		this.reverseFeed = reverseFeed;
		this.productId = productId;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.transactionDate = transactionDate;
		this.updateDate = updateDate;
		this.rtaFileGenerated = rtaFileGenerated;
		this.transactionFolioNum = transactionFolioNum;
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

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
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


	@Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        final TransactionDetails other = (TransactionDetails) obj;
        if ((this.transactionDetailId == null) ? (other.transactionDetailId != null) : !this.transactionDetailId.equals(other.transactionDetailId)) {
            return false;
        }
        if ((this.transactionId == null) ? (other.transactionId != null) : !this.transactionId.equals(other.transactionId)) {
            return false;
        }
        if ((this.bseOrderId == null) ? (other.bseOrderId != null) : !this.bseOrderId.equals(other.bseOrderId)) {
            return false;
        }
        if ((this.uniqueReferenceNumber == null) ? (other.uniqueReferenceNumber != null) : !this.uniqueReferenceNumber.equals(other.uniqueReferenceNumber)) {
            return false;
        }       
        if ((this.customerId == null) ? (other.customerId != null) : !this.customerId.equals(other.customerId)) {
            return false;
        }
        if ((this.transactionAmount == null) ? (other.transactionAmount != null) : !this.transactionAmount.equals(other.transactionAmount)) {
            return false;
        }
        if ((this.transactionType == null) ? (other.transactionType != null) : !this.transactionType.equals(other.transactionType)) {
            return false;
        }
        if ((this.transactionCode == null) ? (other.transactionCode != null) : !this.transactionCode.equals(other.transactionCode)) {
            return false;
        }
        if ((this.buySell == null) ? (other.buySell != null) : !this.buySell.equals(other.buySell)) {
            return false;
        }
        if ((this.buySellType == null) ? (other.buySellType != null) : !this.buySellType.equals(other.buySellType)) {
            return false;
        }
        if ((this.transactionStatus == null) ? (other.transactionStatus != null) : !this.transactionStatus.equals(other.transactionStatus)) {
            return false;
        }
        if ((this.bseRemarks == null) ? (other.bseRemarks != null) : !this.bseRemarks.equals(other.bseRemarks)) {
            return false;
        }
        if ((this.bseSuccessFlag == null) ? (other.bseSuccessFlag != null) : !this.bseSuccessFlag.equals(other.bseSuccessFlag)) {
            return false;
        }
        if ((this.reverseFeed == null) ? (other.reverseFeed != null) : !this.reverseFeed.equals(other.reverseFeed)) {
            return false;
        }
        if ((this.productId == null) ? (other.productId != null) : !this.productId.equals(other.productId)) {
            return false;
        }
        if ((this.quantity == null) ? (other.quantity != null) : !this.quantity.equals(other.quantity)) {
            return false;
        }
        if ((this.unitPrice == null) ? (other.unitPrice != null) : !this.unitPrice.equals(other.unitPrice)) {
            return false;
        }
        if ((this.transactionDate == null) ? (other.transactionDate != null) : !this.transactionDate.equals(other.transactionDate)) {
            return false;
        }
        if ((this.updateDate == null) ? (other.updateDate != null) : !this.updateDate.equals(other.updateDate)) {
            return false;
        }
        if ((this.rtaFileGenerated == null) ? (other.rtaFileGenerated != null) : !this.rtaFileGenerated.equals(other.rtaFileGenerated)) {
            return false;
        }
        if ((this.transactionFolioNum == null) ? (other.transactionFolioNum != null) : !this.transactionFolioNum.equals(other.transactionFolioNum)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + (this.transactionDetailId != null ? this.transactionDetailId.hashCode() : 0);
        hash = 83 * hash + (this.transactionId != null ? this.transactionId.hashCode() : 0);
        hash = 83 * hash + (this.bseOrderId != null ? this.bseOrderId.hashCode() : 0);
        hash = 83 * hash + (this.uniqueReferenceNumber != null ? this.uniqueReferenceNumber.hashCode() : 0);
        hash = 83 * hash + (this.customerId != null ? this.customerId.hashCode() : 0);
        hash = 83 * hash + (this.transactionAmount != null ? this.transactionAmount.hashCode() : 0);
        hash = 83 * hash + (this.transactionType != null ? this.transactionType.hashCode() : 0);
        hash = 83 * hash + (this.transactionCode != null ? this.transactionCode.hashCode() : 0);
        hash = 83 * hash + (this.buySell != null ? this.buySell.hashCode() : 0);
        hash = 83 * hash + (this.buySellType != null ? this.buySellType.hashCode() : 0);
        hash = 83 * hash + (this.transactionStatus != null ? this.transactionStatus.hashCode() : 0);
        hash = 83 * hash + (this.bseRemarks != null ? this.bseRemarks.hashCode() : 0);
        hash = 83 * hash + (this.bseSuccessFlag != null ? this.bseSuccessFlag.hashCode() : 0);
        hash = 83 * hash + (this.reverseFeed != null ? this.reverseFeed.hashCode() : 0);
        hash = 83 * hash + (this.productId != null ? this.productId.hashCode() : 0);
        hash = 83 * hash + (this.quantity != null ? this.quantity.hashCode() : 0);
        hash = 83 * hash + (this.unitPrice != null ? this.unitPrice.hashCode() : 0);
        hash = 83 * hash + (this.transactionDate != null ? this.transactionDate.hashCode() : 0);
        hash = 83 * hash + (this.updateDate != null ? this.updateDate.hashCode() : 0);
        hash = 83 * hash + (this.rtaFileGenerated != null ? this.rtaFileGenerated.hashCode() : 0);
        hash = 83 * hash + (this.transactionFolioNum != null ? this.transactionFolioNum.hashCode() : 0);
        return hash;
    }

}