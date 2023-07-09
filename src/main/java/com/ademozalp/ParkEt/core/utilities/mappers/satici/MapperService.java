package com.ademozalp.ParkEt.core.utilities.mappers.satici;

import org.modelmapper.ModelMapper;

public interface MapperService{
	ModelMapper forResponse();
	ModelMapper forRequst();
}
