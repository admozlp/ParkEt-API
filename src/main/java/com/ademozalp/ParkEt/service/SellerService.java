package com.ademozalp.ParkEt.service;

import com.ademozalp.ParkEt.dto.request.CreateSellerRequest;
import com.ademozalp.ParkEt.dto.request.UpdateSellerPasswordRequest;
import com.ademozalp.ParkEt.dto.request.UpdateSellerRequest;
import com.ademozalp.ParkEt.dto.response.SellerDTO;
import com.ademozalp.ParkEt.model.Seller;

import java.util.List;

public interface SellerService {
    SellerDTO create(CreateSellerRequest createSellerRequest);

    List<SellerDTO> getAll();

    SellerDTO getSellerById(Long id);

    Seller getSellerByIdForOtherService(Long id);

    void delete(Long id);

    SellerDTO update(UpdateSellerRequest updateSellerRequest);

    SellerDTO updatePassword(UpdateSellerPasswordRequest updateSellerPasswordRequest);
}
