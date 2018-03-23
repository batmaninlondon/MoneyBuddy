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
@Table (name ="DBF_FILE_STATUS_DETAILS")
public class DbfFileStatusDetails {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="DBF_FILE_STATUS_ID")
    private String dbfFileStatusId;
    
    @Column(name="RTA")
    private String rta;
    
    @Column (name="DBF_FILE_TYPE")
    private String dbfFileType;

    @Column (name="DBF_DATA_DATE")
    private String dbfDataDate;

    @Column(name="UPLOADED_STATUS")
    private String uploadedStatus;


    public DbfFileStatusDetails() {
        
    }

	public DbfFileStatusDetails(String rta, String dbfFileType, String dbfDataDate, String uploadedStatus) {
		super();
		this.rta = rta;
		this.dbfFileType = dbfFileType;
		this.dbfDataDate = dbfDataDate;
		this.uploadedStatus = uploadedStatus;
	}



	public String getDbfFileStatusId() {
		return dbfFileStatusId;
	}

	public void setDbfFileStatusId(String dbfFileStatusId) {
		this.dbfFileStatusId = dbfFileStatusId;
	}

	public String getRta() {
		return rta;
	}

	public void setRta(String rta) {
		this.rta = rta;
	}

	public String getDbfFileType() {
		return dbfFileType;
	}

	public void setDbfFileType(String dbfFileType) {
		this.dbfFileType = dbfFileType;
	}

	public String getDbfDataDate() {
		return dbfDataDate;
	}

	public void setDbfDataDate(String dbfDataDate) {
		this.dbfDataDate = dbfDataDate;
	}

	public String getUploadedStatus() {
		return uploadedStatus;
	}

	public void setUploadedStatus(String uploadedStatus) {
		this.uploadedStatus = uploadedStatus;
	}

	@Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }	
		
        final DbfFileStatusDetails other = (DbfFileStatusDetails) obj;
        if ((this.dbfFileStatusId == null) ? (other.dbfFileStatusId != null) : !this.dbfFileStatusId.equals(other.dbfFileStatusId)) {
            return false;
        }
        if ((this.rta == null) ? (other.rta != null) : !this.rta.equals(other.rta)) {
            return false;
        }
        if ((this.dbfFileType == null) ? (other.dbfFileType != null) : !this.dbfFileType.equals(other.dbfFileType)) {
            return false;
        }
        if ((this.dbfDataDate == null) ? (other.dbfDataDate != null) : !this.dbfDataDate.equals(other.dbfDataDate)) {
            return false;
        }
        if ((this.uploadedStatus == null) ? (other.uploadedStatus != null) : !this.uploadedStatus.equals(other.uploadedStatus)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.dbfFileStatusId != null ? this.dbfFileStatusId.hashCode() : 0);
        hash = 79 * hash + (this.rta != null ? this.rta.hashCode() : 0);
        hash = 79 * hash + (this.dbfFileType != null ? this.dbfFileType.hashCode() : 0);
        hash = 79 * hash + (this.dbfDataDate != null ? this.dbfDataDate.hashCode() : 0);
        hash = 79 * hash + (this.uploadedStatus != null ? this.uploadedStatus.hashCode() : 0);
        return hash;
    }



}
