package com.dsevenx.d7xpostgresql.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dsevenx.d7xpostgresql.db.KeyValueRepo;
import com.dsevenx.d7xpostgresql.db.TMOTORKEYVALUE;

@RequestMapping("api/db")
@RestController
public class KeyvaluedbController {

	private static final String K_NOT_FOUND_BY_IDDB = "not Found by IDDB:";
	@Autowired
	private KeyValueRepo mKeyValueRepo;

	@Autowired
	public KeyvaluedbController() {
		super();
	}

	@RequestMapping("/version")
	@GetMapping
	public String getVersion() {

		String lVersion = "KeyValue 24.6.001";

		return "Version :" + lVersion;
	}

	@PostMapping
	@RequestMapping("/put")
	public ReturnObjekt putSatz(@RequestBody @NonNull TMOTORKEYVALUE pTMOTORKEYVALUE) {
		ReturnObjekt lReturnObjektGet = getSatzById(pTMOTORKEYVALUE);

		if (!lReturnObjektGet.getMessage().contains(K_NOT_FOUND_BY_IDDB)) {
			return lReturnObjektGet;
		}

		TMOTORKEYVALUE lTMOTORKEYVALUE = mKeyValueRepo.save(pTMOTORKEYVALUE);

		ReturnObjekt lReturnObjekt = ReturnObjekt.erzeugeOK("save mit IDDB:" + lTMOTORKEYVALUE.getIddb());
		lReturnObjekt.getTMOTORKEYVALUEList().add(lTMOTORKEYVALUE);
		return lReturnObjekt;
	}

	@RequestMapping("/getid")
	@PostMapping
	public ReturnObjekt getSatzById(@RequestBody @NonNull TMOTORKEYVALUE pTMOTORKEYVALUE) {

		if (pTMOTORKEYVALUE.getIddb() == null || pTMOTORKEYVALUE.getIddb().isEmpty()) {
			return ReturnObjekt.erzeugeFEHLER("IDDB fehlt");
		}

		Optional<TMOTORKEYVALUE> lTMOTORKEYVALUE = mKeyValueRepo.findById(pTMOTORKEYVALUE.getIddb());

		if (lTMOTORKEYVALUE.isEmpty()) {
			return ReturnObjekt.erzeugeFEHLER(K_NOT_FOUND_BY_IDDB + pTMOTORKEYVALUE.getIddb());
		} else {
			ReturnObjekt lReturnObjekt = ReturnObjekt.erzeugeOK("found mit IDDB:" + pTMOTORKEYVALUE.getIddb());
			lReturnObjekt.getTMOTORKEYVALUEList().add(lTMOTORKEYVALUE.get());
			return lReturnObjekt;

		}
	}

	@RequestMapping("/getsuch")
	@PostMapping
	public ReturnObjekt getSatzByFilter(@RequestBody @NonNull TMOTORKEYVALUE pTMOTORKEYVALUE) {

		if (pTMOTORKEYVALUE.getClusterdb() == null || pTMOTORKEYVALUE.getClusterdb().isEmpty()) {
			return ReturnObjekt.erzeugeFEHLER("Cluster fehlt");
		}
		if (pTMOTORKEYVALUE.getSuchfilterdb() == null || pTMOTORKEYVALUE.getSuchfilterdb().isEmpty()) {
			return ReturnObjekt.erzeugeFEHLER("Suchfilter fehlt");
		}

		List<TMOTORKEYVALUE> lMotorKeyValueList = mKeyValueRepo
				.findByClusterAndSuchFilter(pTMOTORKEYVALUE.getClusterdb(), pTMOTORKEYVALUE.getSuchfilterdb());

		if (lMotorKeyValueList.size() == 0) {
			return ReturnObjekt.erzeugeFEHLER("Not Found mit Cluster:" + pTMOTORKEYVALUE.getClusterdb() + " Filter:"
					+ pTMOTORKEYVALUE.getSuchfilterdb());
		}

		ReturnObjekt lErg = ReturnObjekt.erzeugeOK(lMotorKeyValueList.size() + " gefunden");
		lErg.getTMOTORKEYVALUEList().addAll(lMotorKeyValueList);

		return lErg;
	}

}
