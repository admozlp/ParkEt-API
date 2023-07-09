package com.ademozalp.ParkEt.business.abstracts;

import java.util.List;

import com.ademozalp.ParkEt.business.requests.CreateSaticiRequest;
import com.ademozalp.ParkEt.business.requests.UpdateSaticiPassRequest;
import com.ademozalp.ParkEt.business.requests.UpdateSaticiRequest;
import com.ademozalp.ParkEt.business.responses.GetAllSaticiResponse;
import com.ademozalp.ParkEt.business.responses.GetSaticiById;

public interface SaticiService {
	void add(CreateSaticiRequest createSaticiRequest);
	List<GetAllSaticiResponse> getAll();
	GetSaticiById getSaticiById(int id);
	void delete(int id);
	void update(UpdateSaticiRequest updateSaticiRequest);
	void updatePass(UpdateSaticiPassRequest updateSaticiRequest);
}
