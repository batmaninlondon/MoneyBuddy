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
@Table (name ="ORDER_STATUS")
public class OrderStatus {

    @Id
    @Column(name="ORDER_STATUS")
    private String orderStatus;
    
    @Column (name="STATUS_DETAIL")
    private String statusDetail;
    
    @Column (name="USER_STATUS")
    private String userStatus;
    
    public OrderStatus() {
        
    }

	public OrderStatus(String orderStatus, String statusDetail, String userStatus) {
		super();
		this.orderStatus = orderStatus;
		this.statusDetail = statusDetail;
		this.userStatus = userStatus;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getStatusDetail() {
		return statusDetail;
	}

	public void setStatusDetail(String statusDetail) {
		this.statusDetail = statusDetail;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	@Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }	

        final OrderStatus other = (OrderStatus) obj;
        if ((this.orderStatus == null) ? (other.orderStatus != null) : !this.orderStatus.equals(other.orderStatus)) {
            return false;
        }
        if ((this.statusDetail == null) ? (other.statusDetail != null) : !this.statusDetail.equals(other.statusDetail)) {
            return false;
        }
        if ((this.userStatus == null) ? (other.userStatus != null) : !this.userStatus.equals(other.userStatus)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.orderStatus != null ? this.orderStatus.hashCode() : 0);
        hash = 79 * hash + (this.statusDetail != null ? this.statusDetail.hashCode() : 0);
        hash = 79 * hash + (this.userStatus != null ? this.userStatus.hashCode() : 0);
        return hash;
    }

    public String toString()  {
    	return "OrderStatus [orderStatus="+orderStatus+", statusDetail="+statusDetail+",userStatus="+userStatus+"]";
    }

}
