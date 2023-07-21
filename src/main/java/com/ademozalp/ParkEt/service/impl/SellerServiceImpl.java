package com.ademozalp.ParkEt.service.impl;

import com.ademozalp.ParkEt.config.mapper.ModelMapperService;
import com.ademozalp.ParkEt.dto.request.CreateSellerRequest;
import com.ademozalp.ParkEt.dto.request.UpdateSellerPasswordRequest;
import com.ademozalp.ParkEt.dto.request.UpdateSellerRequest;
import com.ademozalp.ParkEt.dto.response.SellerDTO;
import com.ademozalp.ParkEt.model.Seller;
import com.ademozalp.ParkEt.repository.SellerRepository;
import com.ademozalp.ParkEt.service.SellerService;
import com.ademozalp.ParkEt.service.rules.SellerBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SellerServiceImpl implements SellerService {

    private final SellerRepository sellerRepository;
    private final ModelMapperService modelMapperService;
    private final SellerBusinessRules sellerBusinessRules;


    @Override
    public SellerDTO create(CreateSellerRequest createSellerRequest) {
        this.sellerBusinessRules.checkIfTelExists(createSellerRequest.getTelephone());

        Seller seller = this.modelMapperService.forRequest().map(createSellerRequest, Seller.class);
        Seller savedSeller = this.sellerRepository.save(seller);

        SellerDTO sellerDTO = new SellerDTO(savedSeller.getId(), savedSeller.getName(),
                savedSeller.getEmail(), savedSeller.getTelephone());

        return sellerDTO;

    }

    @Override
    public List<SellerDTO> getAll() {
        List<Seller> sellers = this.sellerRepository.findAll();

        return sellers.stream().map(seller -> this.modelMapperService.forResponse()
                .map(seller, SellerDTO.class)).toList();
    }

    @Override
    public SellerDTO getSellerById(Long id) {
        this.sellerBusinessRules.checkSaticisExists(id);

        Seller seller = this.sellerRepository.findById(id).orElseThrow();

        return this.modelMapperService.forResponse().map(seller, SellerDTO.class);
    }

    @Override
    public Seller getSellerByIdForOtherService(Long id) {
        return this.sellerRepository.findById(id).orElseThrow();
    }

    @Override
    public void delete(Long id) {
        this.sellerBusinessRules.checkSaticisExists(id);

        this.sellerRepository.deleteById(id);
    }

    @Override
    public SellerDTO update(UpdateSellerRequest updateSellerRequest) {
        this.sellerBusinessRules.checkSaticisExists(updateSellerRequest.getId());

        Seller oldSeller = this.sellerRepository.findById(updateSellerRequest.getId()).orElseThrow();
        oldSeller.setName(updateSellerRequest.getName());
        oldSeller.setEmail(updateSellerRequest.getEmail());
        oldSeller.setTelephone(updateSellerRequest.getTelephone());

        Seller updatedSeller = this.sellerRepository.save(oldSeller);

        return this.getSellerById(updatedSeller.getId());
    }

    @Override
    public SellerDTO updatePassword(UpdateSellerPasswordRequest updateSellerPasswordRequest) {
        this.sellerBusinessRules.checkSaticisExists(updateSellerPasswordRequest.getId());

        this.sellerBusinessRules.checkPassEquals(updateSellerPasswordRequest.getNewPassword(),
                updateSellerPasswordRequest.getConfirmNewPassword());

        Seller seller = this.sellerRepository.findById(updateSellerPasswordRequest.getId()).orElseThrow();

        seller.setPassword(updateSellerPasswordRequest.getNewPassword());

        this.sellerRepository.save(seller);

        return this.getSellerById(seller.getId());
    }

}
