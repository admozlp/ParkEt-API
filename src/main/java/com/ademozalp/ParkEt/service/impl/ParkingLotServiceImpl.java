package com.ademozalp.ParkEt.service.impl;

import com.ademozalp.ParkEt.config.mapper.ModelMapperService;
import com.ademozalp.ParkEt.dto.request.CreateParkingLotRequest;
import com.ademozalp.ParkEt.dto.request.UpdateParkingLotRequest;
import com.ademozalp.ParkEt.dto.response.ParkingLotDTO;
import com.ademozalp.ParkEt.dto.response.PostalCodeDTO;
import com.ademozalp.ParkEt.dto.response.SellerDTO;
import com.ademozalp.ParkEt.model.ParkingLot;
import com.ademozalp.ParkEt.model.PostalCode;
import com.ademozalp.ParkEt.model.Seller;
import com.ademozalp.ParkEt.repository.ParkingLotRepository;
import com.ademozalp.ParkEt.service.ParkingLotService;
import com.ademozalp.ParkEt.service.PostalCodeService;
import com.ademozalp.ParkEt.service.SellerService;
import com.ademozalp.ParkEt.service.rules.ParkingLotBusinessRules;
import com.ademozalp.ParkEt.service.rules.SellerBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ParkingLotServiceImpl implements ParkingLotService {
    private final ParkingLotRepository parkingLotRepository;
    private final ParkingLotBusinessRules parkingLotBusinessRules;
    private final SellerBusinessRules sellerBusinessRules;
    private final ModelMapperService modelMapperService;
    private final SellerService sellerService;
    private final PostalCodeService postalCodeService;

    @Override
    public ParkingLotDTO create(CreateParkingLotRequest createParkingLotRequest) {
        this.parkingLotBusinessRules.existsByName(createParkingLotRequest.getName());

        this.parkingLotBusinessRules.checkUcretGreaterThanZero(createParkingLotRequest.getParkingFee());

        Seller seller = this.sellerService.getSellerByIdForOtherService(createParkingLotRequest
                .getSellerId());

        PostalCode postalCode = this.postalCodeService
                .getPostalCodeByIdForOtherService(createParkingLotRequest.getPostalCodeId());

        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setName(createParkingLotRequest.getName());
        parkingLot.setLatitude(createParkingLotRequest.getLatitude());
        parkingLot.setLongitude(createParkingLotRequest.getLongitude());
        parkingLot.setParkingFee(createParkingLotRequest.getParkingFee());
        parkingLot.setCapacity(createParkingLotRequest.getCapacity());
        parkingLot.setSeller(seller);
        parkingLot.setPostalCode(postalCode);

        ParkingLot savedParkingLot = this.parkingLotRepository.save(parkingLot);

        SellerDTO sellerDTO = this.sellerService.getSellerById(seller.getId());
        PostalCodeDTO postalCodeDTO = this.postalCodeService.getPostalCodeById(postalCode.getId());

        return new ParkingLotDTO(savedParkingLot.getId(), savedParkingLot.getName(),
                savedParkingLot.getLatitude(), savedParkingLot.getLongitude(),
                savedParkingLot.getParkingFee(), savedParkingLot.getCapacity(), sellerDTO, postalCodeDTO);
    }

    @Override
    public List<ParkingLotDTO> getAllParkingLot() {
        List<ParkingLot> parkingLots = parkingLotRepository.findAll();

        return parkingLots.stream().map(parkingLot ->
                this.modelMapperService.forResponse().map
                        (parkingLot, ParkingLotDTO.class)).toList();
    }

    @Override
    public ParkingLotDTO getParkingLotById(Long id) {
        this.parkingLotBusinessRules.existsById(id);

        ParkingLot parkingLot = this.parkingLotRepository.findById(id).orElseThrow();

        return this.modelMapperService.forResponse().map(parkingLot, ParkingLotDTO.class);
    }

    @Override
    public List<ParkingLotDTO> getAllParkingLotBySellerId(Long id) {
        this.parkingLotBusinessRules.existsBySaticiId(id);

        List<ParkingLot> parkingLots = this.parkingLotRepository.findAllBySellerId(id);

        return parkingLots.stream().map(parkingLot -> this.modelMapperService.forResponse()
                .map(parkingLot, ParkingLotDTO.class)).toList();
    }

    @Override
    public List<ParkingLotDTO> getAllParkingLotByPostalCodeId(Long id) {
        this.parkingLotBusinessRules.existsByPostaKoduId(id);

        List<ParkingLot> parkingLots = this.parkingLotRepository.findAllByPostalCodeId(id);

        return parkingLots.stream()
                .map(parkingLot -> this.modelMapperService.forResponse()
                        .map(parkingLot, ParkingLotDTO.class)).toList();
    }

    @Override
    public List<ParkingLotDTO> getByCapacity(Long capacity) {
        List<ParkingLot> parkingLots = this.parkingLotRepository.findAllByCapacityGreaterThanEqual(capacity);


        return parkingLots.stream()
                .map(parkingLot -> this.modelMapperService.forResponse()
                        .map(parkingLot, ParkingLotDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ParkingLotDTO> getByParkingLotFee(Double parkingLotFee) {
        this.parkingLotBusinessRules.checkUcretGreaterThanZero(parkingLotFee);

        List<ParkingLot> parkingLots =
                this.parkingLotRepository.findAllByParkingFeeLessThanEqual(parkingLotFee);

        return parkingLots.stream()
                .map(parkingLot -> this.modelMapperService.forResponse()
                        .map(parkingLot, ParkingLotDTO.class)).toList();
    }

    @Override
    public void delete(Long id) {
        this.parkingLotBusinessRules.existsById(id);

        this.parkingLotRepository.deleteById(id);
    }

    @Override
    public void deleteBySellerId(Long id) {
        this.sellerBusinessRules.checkSaticisExists(id);

        this.parkingLotBusinessRules.existsBySaticiId(id);

        this.parkingLotRepository.deleteBySellerId(id);
    }

    @Override
    public ParkingLotDTO update(UpdateParkingLotRequest updateParkingLotRequest) {
        this.parkingLotBusinessRules.existsById(updateParkingLotRequest.getId());

        ParkingLot parkingLot =
                this.parkingLotRepository.findById(updateParkingLotRequest.getId()).orElseThrow();

        this.modelMapperService.forRequest().map(updateParkingLotRequest, parkingLot);

        this.parkingLotRepository.save(parkingLot);

        return this.getParkingLotById(parkingLot.getId());
    }

}
