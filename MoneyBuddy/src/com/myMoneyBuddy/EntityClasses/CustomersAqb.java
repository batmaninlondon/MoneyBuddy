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
@Table (name ="CUSTOMERS_AQB")
public class CustomersAqb {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="CUSTOMERS_AQB_ID")
    private String customersAqbId;
	
	@Column (name="CUSTOMER_ID")
    private String customerId;
    
    @Column(name="AQB")
    private String aqb;
    
    @Column(name="QUATERLY_FEES")
    private String quaterlyFess;
    
    @Column(name="QUARTER_OF_YEAR")
    private String quarterOfYear;

    public CustomersAqb() {
        
    }

	public CustomersAqb(String customerId, String aqb, String quaterlyFess, String quarterOfYear) {
		super();
		this.customerId = customerId;
		this.aqb = aqb;
		this.quaterlyFess = quaterlyFess;
		this.quarterOfYear = quarterOfYear;
	}

	public String getCustomersAqbId() {
		return customersAqbId;
	}

	public void setCustomersAqbId(String customersAqbId) {
		this.customersAqbId = customersAqbId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getAqb() {
		return aqb;
	}

	public void setAqb(String aqb) {
		this.aqb = aqb;
	}

	public String getQuaterlyFess() {
		return quaterlyFess;
	}

	public void setQuaterlyFess(String quaterlyFess) {
		this.quaterlyFess = quaterlyFess;
	}

	public String getQuarterOfYear() {
		return quarterOfYear;
	}

	public void setQuarterOfYear(String quarterOfYear) {
		this.quarterOfYear = quarterOfYear;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aqb == null) ? 0 : aqb.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((customersAqbId == null) ? 0 : customersAqbId.hashCode());
		result = prime * result + ((quarterOfYear == null) ? 0 : quarterOfYear.hashCode());
		result = prime * result + ((quaterlyFess == null) ? 0 : quaterlyFess.hashCode());
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
		CustomersAqb other = (CustomersAqb) obj;
		if (aqb == null) {
			if (other.aqb != null) {
				return false;
			}
		} else if (!aqb.equals(other.aqb)) {
			return false;
		}
		if (customerId == null) {
			if (other.customerId != null) {
				return false;
			}
		} else if (!customerId.equals(other.customerId)) {
			return false;
		}
		if (customersAqbId == null) {
			if (other.customersAqbId != null) {
				return false;
			}
		} else if (!customersAqbId.equals(other.customersAqbId)) {
			return false;
		}
		if (quarterOfYear == null) {
			if (other.quarterOfYear != null) {
				return false;
			}
		} else if (!quarterOfYear.equals(other.quarterOfYear)) {
			return false;
		}
		if (quaterlyFess == null) {
			if (other.quaterlyFess != null) {
				return false;
			}
		} else if (!quaterlyFess.equals(other.quaterlyFess)) {
			return false;
		}
		return true;
	}


	
}
