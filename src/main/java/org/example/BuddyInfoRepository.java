package org.example;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Long> {

    List<BuddyInfo> findByName(String Name);

    BuddyInfo findById(long id);

    BuddyInfo findByPhoneNumber(String PhoneNumber);
}
