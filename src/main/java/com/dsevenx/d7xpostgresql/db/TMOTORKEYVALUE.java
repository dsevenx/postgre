package com.dsevenx.d7xpostgresql.db;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TMOTORKEYVALUE")
public class TMOTORKEYVALUE {

	@NonNull
	@Column(name = "CLUSTERDB")
	private String mClusterdb;

	@NonNull
	@Id
	@Column(name = "IDDB")
	private String mIddb;

	@NonNull
	@Column(name = "SUCHFILTERDB")
	private String mSuchfilterdb;

	@NonNull
	@Column(name = "DATENDB")
	private String mDatendb;

	public TMOTORKEYVALUE() {
		super();
	}

	public TMOTORKEYVALUE(

			@JsonProperty("clusterdb") String pClusterdb, @JsonProperty("iddb") String pIddb,
			@JsonProperty("suchfilterdb") String pSuchfilterdb, @JsonProperty("datendb") String pDatendb) {
		super();
		this.setClusterdb(pClusterdb);
		this.setIddb(pIddb);
		this.setSuchfilterdb(pSuchfilterdb);
		this.setDatendb(pDatendb);
	}

	
	public String getClusterdb() {
		return mClusterdb;
	}

	public void setClusterdb(String pClusterdb) {
		mClusterdb = pClusterdb;
	}

	public String getIddb() {
		return mIddb;
	}

	public void setIddb(String pIddb) {
		mIddb = pIddb;
	}

	public String getSuchfilterdb() {
		return mSuchfilterdb;
	}

	public void setSuchfilterdb(String pSuchfilterdb) {
		mSuchfilterdb = pSuchfilterdb;
	}

	public String getDatendb() {
		return mDatendb;
	}

	public void setDatendb(String pDatendb) {
		mDatendb = pDatendb;
	}

	@Override
	public String toString() {
		return    "Cluster                       :" + getClusterdb()

				+ "\nId                          :" + getIddb()

				+ "\nSuchfilter                  :" + getSuchfilterdb()

				+ "\nDaten                       :" + getDatendb();
	}

}
