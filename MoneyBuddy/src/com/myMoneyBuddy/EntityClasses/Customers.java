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
@Table (name ="CUSTOMERS")
public class Customers {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="CUSTOMER_ID")
    private String customerId;
    
    @Column (name="CUSTOMER_NAME")
    private String customerName;

    @Column(name="EMAIL_ID")
    private String emailId;

    @Column(name="MOBILE_NUMBER")
    private String mobileNumber;

    @Column(name="PASSWORD")
    private String password;

    @Column(name="VERIFICATION_STATUS")
    private String verificationStatus;

    @Column(name="PAN_CARD")
    private String panCard;
    
    @Column(name="KYC_STATUS")
    private String kycStatus;
    
    @Column(name="KARVY_FILE_GENERATED")
    private String karvyFileGenerated;
    
    @Column(name="CAMS_FILE_GENERATED")
    private String camsFileGenerated;
    
    @Column(name="SUBSCRIBER_TYPE")
    private String subscriberType;
    
    @Column(name="CUS_DETAILS_UPLOADED")
    private String cusDetailsUploaded;
    
    @Column(name="ADD_CUS_DETAILS_UPLOADED")
    private String addCusDetailsUploaded;
    
    @Column(name="BSE_CLIENT_CREATED")
    private String bseClientCreated;
    
    @Column(name="ISIP_MANDATE_ID")
    private String isipMandateId;
    
    @Column(name="USER_TYPE")
    private String userType;
    
    @Column(name="AOF_FORM_STATUS")
    private String aofFormStatus;
    
    @Column(name="MANDATE_AMOUNT")
    private String mandateAmount;
    
    @Column(name="MANDATE_CREATION_DATE")
    private String mandateCreationDate;
    
    @Column(name="AOF_CREATION_DATE")
    private String aofCreationDate;
    
    @Column(name="MANDATE_ID_STATUS")
    private String mandateIdStatus;

    public Customers() {
        
    }

	public Customers(String emailId, String customerName, String mobileNumber, String password, String verificationStatus, 
			String panCard, String kycStatus, String karvyFileGenerated, String camsFileGenerated, String subscriberType, 
			String cusDetailsUploaded, String addCusDetailsUploaded, String bseClientCreated, String isipMandateId, String userType, 
			String aofFormStatus, String mandateAmount, String mandateCreationDate, String aofCreationDate, String mandateIdStatus) {
		super();
		this.emailId = emailId;
		this.customerName = customerName;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.verificationStatus = verificationStatus;
		this.panCard = panCard;
		this.kycStatus = kycStatus;
		this.karvyFileGenerated = karvyFileGenerated;
		this.camsFileGenerated = camsFileGenerated;
		this.subscriberType = subscriberType;
		this.cusDetailsUploaded = cusDetailsUploaded;
		this.addCusDetailsUploaded = addCusDetailsUploaded;
		this.bseClientCreated = bseClientCreated;
		this.isipMandateId = isipMandateId;
		this.userType = userType;
		this.aofFormStatus = aofFormStatus;
		this.mandateAmount = mandateAmount;
		this.mandateCreationDate = mandateCreationDate;
		this.aofCreationDate = aofCreationDate;
		this.mandateIdStatus = mandateIdStatus;
	}



	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVerificationStatus() {
		return verificationStatus;
	}

	public void setVerificationStatus(String verificationStatus) {
		this.verificationStatus = verificationStatus;
	}

	public String getPanCard() {
		return panCard;
	}

	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}

	public String getKycStatus() {
		return kycStatus;
	}

	public void setKycStatus(String kycStatus) {
		this.kycStatus = kycStatus;
	}

	public String getKarvyFileGenerated() {
		return karvyFileGenerated;
	}

	public void setKarvyFileGenerated(String karvyFileGenerated) {
		this.karvyFileGenerated = karvyFileGenerated;
	}

	public String getCamsFileGenerated() {
		return camsFileGenerated;
	}

	public void setCamsFileGenerated(String camsFileGenerated) {
		this.camsFileGenerated = camsFileGenerated;
	}

	public String getSubscriberType() {
		return subscriberType;
	}

	public void setSubscriberType(String subscriberType) {
		this.subscriberType = subscriberType;
	}

	public String getCusDetailsUploaded() {
		return cusDetailsUploaded;
	}

	public void setCusDetailsUploaded(String cusDetailsUploaded) {
		this.cusDetailsUploaded = cusDetailsUploaded;
	}

	public String getAddCusDetailsUploaded() {
		return addCusDetailsUploaded;
	}

	public void setAddCusDetailsUploaded(String addCusDetailsUploaded) {
		this.addCusDetailsUploaded = addCusDetailsUploaded;
	}

	public String getBseClientCreated() {
		return bseClientCreated;
	}

	public void setBseClientCreated(String bseClientCreated) {
		this.bseClientCreated = bseClientCreated;
	}

	public String getIsipMandateId() {
		return isipMandateId;
	}

	public void setIsipMandateId(String isipMandateId) {
		this.isipMandateId = isipMandateId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getAofFormStatus() {
		return aofFormStatus;
	}

	public void setAofFormStatus(String aofFormStatus) {
		this.aofFormStatus = aofFormStatus;
	}

	public String getMandateAmount() {
		return mandateAmount;
	}

	public void setMandateAmount(String mandateAmount) {
		this.mandateAmount = mandateAmount;
	}

	public String getMandateCreationDate() {
		return mandateCreationDate;
	}

	public void setMandateCreationDate(String mandateCreationDate) {
		this.mandateCreationDate = mandateCreationDate;
	}

	public String getAofCreationDate() {
		return aofCreationDate;
	}

	public void setAofCreationDate(String aofCreationDate) {
		this.aofCreationDate = aofCreationDate;
	}

	public String getMandateIdStatus() {
		return mandateIdStatus;
	}

	public void setMandateIdStatus(String mandateIdStatus) {
		this.mandateIdStatus = mandateIdStatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mandateIdStatus == null) ? 0 : mandateIdStatus.hashCode());
		result = prime * result + ((addCusDetailsUploaded == null) ? 0 : addCusDetailsUploaded.hashCode());
		result = prime * result + ((aofCreationDate == null) ? 0 : aofCreationDate.hashCode());
		result = prime * result + ((aofFormStatus == null) ? 0 : aofFormStatus.hashCode());
		result = prime * result + ((bseClientCreated == null) ? 0 : bseClientCreated.hashCode());
		result = prime * result + ((camsFileGenerated == null) ? 0 : camsFileGenerated.hashCode());
		result = prime * result + ((cusDetailsUploaded == null) ? 0 : cusDetailsUploaded.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + ((isipMandateId == null) ? 0 : isipMandateId.hashCode());
		result = prime * result + ((karvyFileGenerated == null) ? 0 : karvyFileGenerated.hashCode());
		result = prime * result + ((kycStatus == null) ? 0 : kycStatus.hashCode());
		result = prime * result + ((mandateAmount == null) ? 0 : mandateAmount.hashCode());
		result = prime * result + ((mandateCreationDate == null) ? 0 : mandateCreationDate.hashCode());
		result = prime * result + ((mobileNumber == null) ? 0 : mobileNumber.hashCode());
		result = prime * result + ((panCard == null) ? 0 : panCard.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((subscriberType == null) ? 0 : subscriberType.hashCode());
		result = prime * result + ((userType == null) ? 0 : userType.hashCode());
		result = prime * result + ((verificationStatus == null) ? 0 : verificationStatus.hashCode());
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
		Customers other = (Customers) obj;
		if (addCusDetailsUploaded == null) {
			if (other.addCusDetailsUploaded != null) {
				return false;
			}
		} else if (!addCusDetailsUploaded.equals(other.addCusDetailsUploaded)) {
			return false;
		}
		if (aofCreationDate == null) {
			if (other.aofCreationDate != null) {
				return false;
			}
		} else if (!aofCreationDate.equals(other.aofCreationDate)) {
			return false;
		}
		if (aofFormStatus == null) {
			if (other.aofFormStatus != null) {
				return false;
			}
		} else if (!aofFormStatus.equals(other.aofFormStatus)) {
			return false;
		}
		if (bseClientCreated == null) {
			if (other.bseClientCreated != null) {
				return false;
			}
		} else if (!bseClientCreated.equals(other.bseClientCreated)) {
			return false;
		}
		if (camsFileGenerated == null) {
			if (other.camsFileGenerated != null) {
				return false;
			}
		} else if (!camsFileGenerated.equals(other.camsFileGenerated)) {
			return false;
		}
		if (cusDetailsUploaded == null) {
			if (other.cusDetailsUploaded != null) {
				return false;
			}
		} else if (!cusDetailsUploaded.equals(other.cusDetailsUploaded)) {
			return false;
		}
		if (customerId == null) {
			if (other.customerId != null) {
				return false;
			}
		} else if (!customerId.equals(other.customerId)) {
			return false;
		}
		if (customerName == null) {
			if (other.customerName != null) {
				return false;
			}
		} else if (!customerName.equals(other.customerName)) {
			return false;
		}
		if (emailId == null) {
			if (other.emailId != null) {
				return false;
			}
		} else if (!emailId.equals(other.emailId)) {
			return false;
		}
		if (isipMandateId == null) {
			if (other.isipMandateId != null) {
				return false;
			}
		} else if (!isipMandateId.equals(other.isipMandateId)) {
			return false;
		}
		if (karvyFileGenerated == null) {
			if (other.karvyFileGenerated != null) {
				return false;
			}
		} else if (!karvyFileGenerated.equals(other.karvyFileGenerated)) {
			return false;
		}
		if (kycStatus == null) {
			if (other.kycStatus != null) {
				return false;
			}
		} else if (!kycStatus.equals(other.kycStatus)) {
			return false;
		}
		if (mandateAmount == null) {
			if (other.mandateAmount != null) {
				return false;
			}
		} else if (!mandateAmount.equals(other.mandateAmount)) {
			return false;
		}
		if (mandateCreationDate == null) {
			if (other.mandateCreationDate != null) {
				return false;
			}
		} else if (!mandateCreationDate.equals(other.mandateCreationDate)) {
			return false;
		}
		if (mobileNumber == null) {
			if (other.mobileNumber != null) {
				return false;
			}
		} else if (!mobileNumber.equals(other.mobileNumber)) {
			return false;
		}
		if (panCard == null) {
			if (other.panCard != null) {
				return false;
			}
		} else if (!panCard.equals(other.panCard)) {
			return false;
		}
		if (password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!password.equals(other.password)) {
			return false;
		}
		if (subscriberType == null) {
			if (other.subscriberType != null) {
				return false;
			}
		} else if (!subscriberType.equals(other.subscriberType)) {
			return false;
		}
		if (userType == null) {
			if (other.userType != null) {
				return false;
			}
		} else if (!userType.equals(other.userType)) {
			return false;
		}
		if (verificationStatus == null) {
			if (other.verificationStatus != null) {
				return false;
			}
		} else if (!verificationStatus.equals(other.verificationStatus)) {
			return false;
		}
		if (mandateIdStatus == null) {
			if (other.mandateIdStatus != null) {
				return false;
			}
		} else if (!mandateIdStatus.equals(other.mandateIdStatus)) {
			return false;
		}
		return true;
	}



}
