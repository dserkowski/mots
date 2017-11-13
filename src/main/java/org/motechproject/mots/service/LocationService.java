package org.motechproject.mots.service;

import org.motechproject.mots.domain.District;
import org.motechproject.mots.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

  @Autowired
  private DistrictRepository districtRepository;

  public Iterable<District> getDistricts() {
    return districtRepository.findAll();
  }
}