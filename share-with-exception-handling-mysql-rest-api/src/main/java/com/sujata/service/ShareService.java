package com.sujata.service;

import com.sujata.entity.Share;

import java.util.List;

public interface ShareService {
    List<Share> getAllShares();

    boolean insertShare(Share share);

    boolean deleteShare(int id);

    boolean updateMarketPrice(int id,int marketPrice);

    Share getShareById(int id);
}
