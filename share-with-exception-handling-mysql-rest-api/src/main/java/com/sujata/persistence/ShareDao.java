package com.sujata.persistence;

import com.sujata.entity.Share;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShareDao extends JpaRepository<Share,Integer> {


}
