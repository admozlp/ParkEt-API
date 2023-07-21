package com.ademozalp.ParkEt.service.impl;

import com.ademozalp.ParkEt.config.mapper.ModelMapperService;
import com.ademozalp.ParkEt.dto.request.CreatePostalCodeRequest;
import com.ademozalp.ParkEt.dto.response.PostalCodeDTO;
import com.ademozalp.ParkEt.model.PostalCode;
import com.ademozalp.ParkEt.repository.PostalCodeRepository;
import com.ademozalp.ParkEt.service.PostalCodeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostalCodeServiceImpl implements PostalCodeService {
    private final PostalCodeRepository postalCodeRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public PostalCodeDTO create(CreatePostalCodeRequest createPostalCodeRequest) {
        PostalCode postalCode = new PostalCode();
        postalCode.setCode(createPostalCodeRequest.getCode());
        PostalCode savedPostalCode = this.postalCodeRepository.save(postalCode);

        PostalCodeDTO postalCodeDTO = new PostalCodeDTO(savedPostalCode.getId(), savedPostalCode.getCode());

        return postalCodeDTO;
    }

    @Override
    public List<PostalCodeDTO> getAllPostalCodes() {
        List<PostalCode> postalCodes = this.postalCodeRepository.findAll();

        return postalCodes.stream()
                .map(postalCode -> this.modelMapperService.forResponse().
                        map(postalCode, PostalCodeDTO.class)).toList();
    }

    @Override
    public PostalCode getPostalCodeByIdForOtherService(Long id) {
        return this.postalCodeRepository.findById(id).orElseThrow();
    }

    @Override
    public PostalCodeDTO getPostalCodeById(Long id) {
        PostalCode postalCode = this.postalCodeRepository.findById(id).orElseThrow();

        PostalCodeDTO postalCodeDTO =
                new PostalCodeDTO(postalCode.getId(), postalCode.getCode());

        return postalCodeDTO;
    }

}
