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
 * @author ADMIN
 */
@Entity
@Table (name ="CUSTOMER_CART")
public class CustomerCart {

    @Id
    @Column (name="CART_ID")
    private String cartId;
    
    @Column(name="CUSTOMER_ID")
    private String customerId;

    @Column (name="PRODUCT_ID")
    private String productId;

    @Column (name="PRODUCT_NAME")
    private String productName;
    
    @Column (name="AMOUNT")
    private String amount;

    @Column(name="CART_CREATION_DATE")
    private String cartCreationDate;


    
    public CustomerCart() {
        
    }

	public CustomerCart(String cartId, String customerId, String productId, String productName, String amount,
			String cartCreationDate) {
		super();
		this.cartId = cartId;
		this.customerId = customerId;
		this.productId = productId;
		this.productName = productName;
		this.amount = amount;
		this.cartCreationDate = cartCreationDate;
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

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getCartCreationDate() {
		return cartCreationDate;
	}

	public void setCartCreationDate(String cartCreationDate) {
		this.cartCreationDate = cartCreationDate;
	}

	@Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CustomerCart other = (CustomerCart) obj;
        if ((this.cartId == null) ? (other.cartId != null) : !this.cartId.equals(other.cartId)) {
            return false;
        }
        if ((this.customerId == null) ? (other.customerId != null) : !this.customerId.equals(other.customerId)) {
            return false;
        }
        if ((this.productId == null) ? (other.productId != null) : !this.productId.equals(other.productId)) {
            return false;
        }
        if ((this.productName == null) ? (other.productName != null) : !this.productName.equals(other.productName)) {
            return false;
        }
        if ((this.amount == null) ? (other.amount != null) : !this.amount.equals(other.amount)) {
            return false;
        }
        if ((this.cartCreationDate == null) ? (other.cartCreationDate != null) : !this.cartCreationDate.equals(other.cartCreationDate)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.cartId != null ? this.cartId.hashCode() : 0);
        hash = 79 * hash + (this.customerId != null ? this.customerId.hashCode() : 0);
        hash = 79 * hash + (this.productId != null ? this.productId.hashCode() : 0);
        hash = 79 * hash + (this.productName != null ? this.productName.hashCode() : 0);
        hash = 79 * hash + (this.amount != null ? this.amount.hashCode() : 0);
        hash = 79 * hash + (this.cartCreationDate != null ? this.cartCreationDate.hashCode() : 0);
        
        return hash;
    }



}
