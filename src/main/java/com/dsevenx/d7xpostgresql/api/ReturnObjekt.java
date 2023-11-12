package com.dsevenx.d7xpostgresql.api;

import java.util.ArrayList;
import java.util.List;

import com.dsevenx.d7xpostgresql.db.TMOTORKEYVALUE;

public class ReturnObjekt {
	private String mMessage;

	private List<String> mDebugInfoList;

	private List<TMOTORKEYVALUE> mTMOTORKEYVALUEList;

	public static final String K_FEHLER = "Fehler: ";

	private ReturnObjekt(String pMessage) {
		super();
		this.mMessage = pMessage;
		this.mDebugInfoList = new ArrayList<String>();
		this.mTMOTORKEYVALUEList = new ArrayList<TMOTORKEYVALUE>();
	}

	public static ReturnObjekt erzeugeOK(String pDebugInfoText) {
		ReturnObjekt lErg =  new ReturnObjekt("");
		lErg.getDebugInfoList().add(pDebugInfoText);
		return lErg;
	}

	public static ReturnObjekt erzeugeFEHLER(String pFehler) {
		ReturnObjekt lErg =  new ReturnObjekt(K_FEHLER + pFehler);
		lErg.getDebugInfoList().add(K_FEHLER+pFehler);
		lErg.getTMOTORKEYVALUEList().add(new TMOTORKEYVALUE("BeispielCluster","BeispielID","BeispielFilterXX","<BEISPIEL>EXAMPLE</BEISPIEL>"));
		return lErg;
	}

	
	public String getMessage() {
		return mMessage;
	}

	public List<String> getDebugInfoList() {
		return mDebugInfoList;
	}

	public List<TMOTORKEYVALUE> getTMOTORKEYVALUEList() {
		return mTMOTORKEYVALUEList;
	}

}
