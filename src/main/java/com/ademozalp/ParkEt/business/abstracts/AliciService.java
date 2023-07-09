package com.ademozalp.ParkEt.business.abstracts;

import java.util.List;

import com.ademozalp.ParkEt.business.requests.CreateAliciRequest;
import com.ademozalp.ParkEt.business.requests.UpdateAliciPassRequest;
import com.ademozalp.ParkEt.business.requests.UpdateAliciRequest;
import com.ademozalp.ParkEt.business.responses.GetAliciByEmailResponse;
import com.ademozalp.ParkEt.business.responses.GetAliciByIdResponse;
import com.ademozalp.ParkEt.business.responses.GetAllAliciResponse;

public interface AliciService {
	public void add(CreateAliciRequest createAliciRequest);
	public List<GetAllAliciResponse> getAllAlici();
	public GetAliciByIdResponse getAliciById(int id);
	public GetAliciByEmailResponse getAliciByEmail(String email);
	
	public void delete(int id);
	
	public void update(UpdateAliciRequest updateAliciRequest); 
	public void updatePass(UpdateAliciPassRequest aliciPassRequest);
}
