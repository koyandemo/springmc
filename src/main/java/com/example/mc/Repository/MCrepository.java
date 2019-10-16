package com.example.mc.Repository;

import com.example.mc.Entities.MasterCeremony;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import javax.crypto.Mac;

@Repository
public interface MCrepository extends MongoRepository<MasterCeremony,String> {
  MasterCeremony findMasterCeremonyByName(String name);
  void deleteMasterCeremonyByName(String name);

}
