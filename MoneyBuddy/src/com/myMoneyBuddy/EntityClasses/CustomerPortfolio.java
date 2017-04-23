/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myMoneyBuddy.EntityClasses;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Savita Wadhwani
 */
@Entity
@Table (name="CUSTOMER_PORTFOLIO")
public class CustomerPortfolio {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="CUSTOMER_PORTFOLIO_ID")
    private String customerPortfolioId;

    @Column(name="CUSTOMER_ID")
    private String customerId;

    @Column(name="PRODUCT_ID")
    private String productId;

    @Column(name="TOTAL_QUANTITY")
    private String totalQuantity;

    @Column(name="PENDING_ORDERS")
    private String pendingOrders;
    
    @Column(name="TRANSACTION_DETAIL_ID")
    private String transactionDetailId;
    
    @Column(name="INVESTMENT_TYPE_ID")
    private String investmentTypeId;
    
    @Column(name="INVESTMENT_TYPE_NAME")
    private String investmentTypeName;
    
    @Column(name="PROJECTED_VALUE")
    private String projectedValue;
    
    @Column(name="TRANSACTION_DATE")
    private String transactionDate;
    
    @Column(name="UPDATE_DATE")
    private String updateDate;

    public CustomerPortfolio() {

    }

	public CustomerPortfolio(String customerId, String productId,
			String totalQuantity, String pendingOrders,
			String transactionDetailId, String investmentTypeId,
			String investmentTypeName, String projectedValue,
			String transactionDate, String updateDate) {
		super();
		this.customerId = customerId;
		this.productId = productId;
		this.totalQuantity = totalQuantity;
		this.pendingOrders = pendingOrders;
		this.transactionDetailId = transactionDetailId;
		this.investmentTypeId = investmentTypeId;
		this.investmentTypeName = investmentTypeName;
		this.projectedValue = projectedValue;
		this.transactionDate = transactionDate;
		this.updateDate = updateDate;
	}



	public String getCustomerPortfolioId() {
		return customerPortfolioId;
	}


	public void setCustomerPortfolioId(String customerPortfolioId) {
		this.customerPortfolioId = customerPortfolioId;
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


	public String getTotalQuantity() {
		return totalQuantity;
	}


	public void setTotalQuantity(String totalQuantity) {
		this.totalQuantity = totalQuantity;
	}


	public String getPendingOrders() {
		return pendingOrders;
	}


	public void setPendingOrders(String pendingOrders) {
		this.pendingOrders = pendingOrders;
	}


	public String getTransactionDetailId() {
		return transactionDetailId;
	}

	public void setTransactionDetailId(String transactionDetailId) {
		this.transactionDetailId = transactionDetailId;
	}

	public String getInvestmentTypeId() {
		return investmentTypeId;
	}

	public void setInvestmentTypeId(String investmentTypeId) {
		this.investmentTypeId = investmentTypeId;
	}

	public String getInvestmentTypeName() {
		return investmentTypeName;
	}

	public void setInvestmentTypeName(String investmentTypeName) {
		this.investmentTypeName = investmentTypeName;
	}

	public String getProjectedValue() {
		return projectedValue;
	}

	public void setProjectedValue(String projectedValue) {
		this.projectedValue = projectedValue;
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

	@Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        final CustomerPortfolio other = (CustomerPortfolio) obj;
        if ((this.customerPortfolioId == null) ? (other.customerPortfolioId != null) : !this.customerPortfolioId.equals(other.customerPortfolioId)) {
            return false;
        }
        if ((this.customerId == null) ? (other.customerId != null) : !this.customerId.equals(other.customerId)) {
            return false;
        }
        if ((this.productId == null) ? (other.productId != null) : !this.productId.equals(other.productId)) {
            return false;
        }
        if ((this.totalQuantity == null) ? (other.totalQuantity != null) : !this.totalQuantity.equals(other.totalQuantity)) {
            return false;
        }
        if ((this.pendingOrders == null) ? (other.pendingOrders != null) : !this.pendingOrders.equals(other.pendingOrders)) {
            return false;
        }
        if ((this.transactionDetailId == null) ? (other.transactionDetailId != null) : !this.transactionDetailId.equals(other.transactionDetailId)) {
            return false;
        }
        if ((this.investmentTypeId == null) ? (other.investmentTypeId != null) : !this.investmentTypeId.equals(other.investmentTypeId)) {
            return false;
        }
        if ((this.investmentTypeName == null) ? (other.investmentTypeName != null) : !this.investmentTypeName.equals(other.investmentTypeName)) {
            return false;
        }
        if ((this.projectedValue == null) ? (other.projectedValue != null) : !this.projectedValue.equals(other.projectedValue)) {
            return false;
        }
        if ((this.transactionDate == null) ? (other.transactionDate != null) : !this.transactionDate.equals(other.transactionDate)) {
            return false;
        }
        if ((this.updateDate == null) ? (other.updateDate != null) : !this.updateDate.equals(other.updateDate)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + (this.customerPortfolioId != null ? this.customerPortfolioId.hashCode() : 0);
        hash = 83 * hash + (this.customerId != null ? this.customerId.hashCode() : 0);
        hash = 83 * hash + (this.productId != null ? this.productId.hashCode() : 0);
        hash = 83 * hash + (this.totalQuantity != null ? this.totalQuantity.hashCode() : 0);
        hash = 83 * hash + (this.pendingOrders != null ? this.pendingOrders.hashCode() : 0);
        hash = 83 * hash + (this.transactionDetailId != null ? this.transactionDetailId.hashCode() : 0);
        hash = 83 * hash + (this.investmentTypeId != null ? this.investmentTypeId.hashCode() : 0);
        hash = 83 * hash + (this.investmentTypeName != null ? this.investmentTypeName.hashCode() : 0);
        hash = 83 * hash + (this.projectedValue != null ? this.projectedValue.hashCode() : 0);
        hash = 83 * hash + (this.transactionDate != null ? this.transactionDate.hashCode() : 0);
        hash = 83 * hash + (this.updateDate != null ? this.updateDate.hashCode() : 0);
        return hash;
    }

}