package com.ademozalp.ParkEt.service.impl;

import com.ademozalp.ParkEt.config.mapper.ModelMapperService;
import com.ademozalp.ParkEt.dto.request.CreateFavoriteRequest;
import com.ademozalp.ParkEt.dto.response.CustomerDTO;
import com.ademozalp.ParkEt.dto.response.FavoriteDTO;
import com.ademozalp.ParkEt.dto.response.ParkingLotDTO;
import com.ademozalp.ParkEt.dto.response.SellerDTO;
import com.ademozalp.ParkEt.model.Favorite;
import com.ademozalp.ParkEt.repository.FavoriteRepository;
import com.ademozalp.ParkEt.service.CustomerService;
import com.ademozalp.ParkEt.service.FavoriteService;
import com.ademozalp.ParkEt.service.ParkingLotService;
import com.ademozalp.ParkEt.service.rules.CustomerBusinessRules;
import com.ademozalp.ParkEt.service.rules.FavoriteBusinessRules;
import com.ademozalp.ParkEt.service.rules.ParkingLotBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class FavoriteServiceImpl implements FavoriteService {
    private final FavoriteRepository favoriteRepository;
    private final ModelMapperService modelMapperService;
    private final FavoriteBusinessRules favoriteBusinessRules;
    private final CustomerBusinessRules customerBusinessRules;
    private final ParkingLotBusinessRules parkingLotBusinessRules;
    private final CustomerService customerService;
    private final ParkingLotService parkingLotService;

    @Override
    public FavoriteDTO create(CreateFavoriteRequest createFavoriteRequest) {
        this.parkingLotBusinessRules.existsById(createFavoriteRequest.getParkingLotId());

        this.customerBusinessRules.existsById(createFavoriteRequest.getCustomerId());

        this.favoriteBusinessRules.checkExistsByAliciId(createFavoriteRequest.getCustomerId(),
                createFavoriteRequest.getParkingLotId());

        Favorite favorite = this.modelMapperService.forRequest()
                .map(createFavoriteRequest, Favorite.class);

        Favorite savedFavorite = this.favoriteRepository.save(favorite);

        CustomerDTO customerDTO = this.customerService
                .getCustomerById(createFavoriteRequest.getCustomerId());

        ParkingLotDTO parkingLotDTO = this.parkingLotService
                .getParkingLotById(createFavoriteRequest.getParkingLotId());

        SellerDTO sellerDTO = parkingLotDTO.getSellerDTO();

        FavoriteDTO favoriteDTO =
                new FavoriteDTO(savedFavorite.getId(), LocalDateTime.now(),
                        customerDTO, parkingLotDTO, sellerDTO);

        return favoriteDTO;

    }

    @Override
    public List<FavoriteDTO> getAll() {
        List<Favorite> favorites = this.favoriteRepository.findAll();

        return favorites.stream()
                .map(favorite -> this.modelMapperService.forResponse()
                        .map(favorite, FavoriteDTO.class)).toList();
    }

    @Override
    public FavoriteDTO getById(Long id) {
        this.favoriteBusinessRules.existsById(id);

        Favorite favorite = this.favoriteRepository.findById(id).orElseThrow();

        return this.modelMapperService.forResponse()
                .map(favorite, FavoriteDTO.class);
    }

    @Override
    public List<FavoriteDTO> getByCustomerId(Long id) {
        this.customerBusinessRules.existsById(id);

        List<Favorite> favorites = this.favoriteRepository.findAllByCustomerId(id);

        return favorites.stream()
                .map(favorite -> this.modelMapperService.forResponse()
                        .map(favorite, FavoriteDTO.class)).toList();
    }

    @Override
    public List<FavoriteDTO> getByParkingLotId(Long id) {
        this.parkingLotBusinessRules.existsById(id);

        List<Favorite> favorites = this.favoriteRepository.findAllByParkingLotId(id);

        return favorites.stream()
                .map(favorite -> this.modelMapperService.forResponse()
                        .map(favorite, FavoriteDTO.class)).toList();
    }

    @Override
    public void delete(Long id) {
        this.favoriteBusinessRules.existsById(id);

        this.favoriteRepository.deleteById(id);

    }

}
