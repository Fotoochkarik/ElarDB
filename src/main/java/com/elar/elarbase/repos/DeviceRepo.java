package com.elar.elarbase.repos;

import com.elar.elarbase.entity.Device;
import com.elar.elarbase.entity.Device1;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DeviceRepo extends CrudRepository<Device, Integer> {

    List<Device> findByNameDevice(String nameDevise);
}
