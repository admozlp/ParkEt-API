package com.ademozalp.ParkEt.service;

import com.ademozalp.ParkEt.dto.request.CreatePostalCodeRequest;
import com.ademozalp.ParkEt.dto.response.PostalCodeDTO;
import com.ademozalp.ParkEt.model.PostalCode;

import java.util.List;

public interface PostalCodeService {
    PostalCodeDTO create(CreatePostalCodeRequest createPostalCodeRequest);

    List<PostalCodeDTO> getAllPostalCodes();

    PostalCode getPostalCodeByIdForOtherService(Long id);

    PostalCodeDTO getPostalCodeById(Long id);
}
