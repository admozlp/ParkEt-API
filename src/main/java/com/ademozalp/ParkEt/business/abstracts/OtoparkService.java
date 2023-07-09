package com.ademozalp.ParkEt.business.abstracts;

import java.util.List;

import com.ademozalp.ParkEt.business.requests.CreateOtoparkRequest;
import com.ademozalp.ParkEt.business.requests.UpdateOtoparkRequest;
import com.ademozalp.ParkEt.business.responses.GetAllOtoparkByPostaKodId;
import com.ademozalp.ParkEt.business.responses.GetAllOtoparkBySaticiId;
import com.ademozalp.ParkEt.business.responses.GetAllOtoparkKapasiteGreaterThanEqual;
import com.ademozalp.ParkEt.business.responses.GetAllOtoparkResponse;
import com.ademozalp.ParkEt.business.responses.GetOtoparkById;
import com.ademozalp.ParkEt.business.responses.GetByUcretLessThanEqual;

public interface OtoparkService {
	void add(CreateOtoparkRequest createOtoparkRequest);
	
	List<GetAllOtoparkResponse> getAllOtopark();
	GetOtoparkById getOtoparkById(int id);
	List<GetAllOtoparkBySaticiId> getAllOtoparkBySaticiId(int id);
	List<GetAllOtoparkByPostaKodId> getAllOtoparkByPostaKodId(int id);
	List<GetAllOtoparkKapasiteGreaterThanEqual> getByKapasite(int kapasite);
	List<GetByUcretLessThanEqual> getByUcret(double maxUcret);
	
	void delete(int id);
	void deleteBySaticiId(int id);
	
	void update(UpdateOtoparkRequest updateOtoparkRequest);
	
}
