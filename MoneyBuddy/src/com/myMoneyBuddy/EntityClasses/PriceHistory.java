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
@Table (name="PRICE_HISTORY")
public class PriceHistory {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column (name="PRICE_HISTORY_ID")
    private String priceHistoryId;

    @Column(name="PRODUCT_ID")
    private String productId;
    
    @Column(name="PRICE")
    private String price;
    
    @Column(name="DATE")
    private String date;
    
    
    public PriceHistory() {

    }

	public PriceHistory(String productId, String price) {
		super();
		this.productId = productId;
		this.price = price;
	}

	public String getPriceHistoryId() {
		return priceHistoryId;
	}

	public void setPriceHistoryId(String priceHistoryId) {
		this.priceHistoryId = priceHistoryId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PriceHistory other = (PriceHistory) obj;
        if ((this.priceHistoryId == null) ? (other.priceHistoryId != null) : !this.priceHistoryId.equals(other.priceHistoryId)) {
            return false;
        }
        if ((this.productId == null) ? (other.productId != null) : !this.productId.equals(other.productId)) {
            return false;
        }
        if ((this.price == null) ? (other.price != null) : !this.price.equals(other.price)) {
            return false;
        }
        if ((this.date == null) ? (other.date != null) : !this.date.equals(other.date)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + (this.priceHistoryId != null ? this.priceHistoryId.hashCode() : 0);
        hash = 83 * hash + (this.productId != null ? this.productId.hashCode() : 0);
        hash = 83 * hash + (this.price != null ? this.price.hashCode() : 0);
        hash = 83 * hash + (this.date != null ? this.date.hashCode() : 0);

        return hash;
    }



}