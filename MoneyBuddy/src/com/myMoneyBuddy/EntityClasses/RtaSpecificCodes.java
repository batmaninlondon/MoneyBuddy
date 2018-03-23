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
@Table (name="RTA_SPECIFIC_CODES")
public class RtaSpecificCodes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="RTA_SPECIFIC_CODES_ID")
    private String rtaSpecificCodesId;

    @Column(name="FIELD_TYPE")
    private String fieldType;

    @Column(name="FIELD_VALUE")
    private String fieldValue;
    
    @Column(name="KARVY_CODE")
    private String karvyCode;
    
    @Column(name="CAMS_CODE")
    private String camsCode;
    
    @Column(name="BSE_CODE")
    private String bseCode;


    public RtaSpecificCodes() {

    }

	public RtaSpecificCodes(String fieldType, String fieldValue, String karvyCode, String camsCode, String bseCode) {
		super();
		this.fieldType = fieldType;
		this.fieldValue = fieldValue;
		this.karvyCode = karvyCode;
		this.camsCode = camsCode;
		this.bseCode = bseCode;
	}

	public String getRtaSpecificCodesId() {
		return rtaSpecificCodesId;
	}

	public void setRtaSpecificCodesId(String rtaSpecificCodesId) {
		this.rtaSpecificCodesId = rtaSpecificCodesId;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public String getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}

	public String getKarvyCode() {
		return karvyCode;
	}

	public void setKarvyCode(String karvyCode) {
		this.karvyCode = karvyCode;
	}

	public String getCamsCode() {
		return camsCode;
	}

	public void setCamsCode(String camsCode) {
		this.camsCode = camsCode;
	}
	

	public String getBseCode() {
		return bseCode;
	}

	public void setBseCode(String bseCode) {
		this.bseCode = bseCode;
	}

	@Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        final RtaSpecificCodes other = (RtaSpecificCodes) obj;
        if ((this.rtaSpecificCodesId == null) ? (other.rtaSpecificCodesId != null) : !this.rtaSpecificCodesId.equals(other.rtaSpecificCodesId)) {
            return false;
        }
        if ((this.fieldType == null) ? (other.fieldType != null) : !this.fieldType.equals(other.fieldType)) {
            return false;
        }
        if ((this.fieldValue == null) ? (other.fieldValue != null) : !this.fieldValue.equals(other.fieldValue)) {
            return false;
        }
        if ((this.karvyCode == null) ? (other.karvyCode != null) : !this.karvyCode.equals(other.karvyCode)) {
            return false;
        }
        if ((this.camsCode == null) ? (other.camsCode != null) : !this.camsCode.equals(other.camsCode)) {
            return false;
        }
        if ((this.bseCode == null) ? (other.bseCode != null) : !this.bseCode.equals(other.bseCode)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + (this.rtaSpecificCodesId != null ? this.rtaSpecificCodesId.hashCode() : 0);
        hash = 83 * hash + (this.fieldType != null ? this.fieldType.hashCode() : 0);
        hash = 83 * hash + (this.fieldValue != null ? this.fieldValue.hashCode() : 0);
        hash = 83 * hash + (this.karvyCode != null ? this.karvyCode.hashCode() : 0);
        hash = 83 * hash + (this.camsCode != null ? this.camsCode.hashCode() : 0);
        hash = 83 * hash + (this.bseCode != null ? this.bseCode.hashCode() : 0);
        return hash;
    }

}