package com.ademozalp.ParkEt.business.abstracts;

import java.util.List;

import com.ademozalp.ParkEt.business.requests.CreateFavoriRequest;
import com.ademozalp.ParkEt.business.responses.GetAllFavoriResponse;
import com.ademozalp.ParkEt.business.responses.GetFavoriByAliciIdResponse;
import com.ademozalp.ParkEt.business.responses.GetFavoriByIdResponse;
import com.ademozalp.ParkEt.business.responses.GetFavoriByOtoparkIdResponse;

public interface FavoriService {
	public void add(CreateFavoriRequest createFavoriRequest);
	public List<GetAllFavoriResponse> getAll();
	public GetFavoriByIdResponse getById(int id);
	public List<GetFavoriByAliciIdResponse> getByAliciId(int id);
	public List<GetFavoriByOtoparkIdResponse> getByOtoparkId(int id);
	
	public void delete(int id);
}
