package com.sujata.service;

import com.sujata.entity.Share;
import com.sujata.exception.NoSuchShareExistException;
import com.sujata.exception.ShareAlreadyExistException;
import com.sujata.persistence.ShareDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service("service")
public class ShareServiceImpl implements ShareService {


    @Autowired
    private ShareDao shareDao;

    public void setShareDao(ShareDao shareDao) {
        this.shareDao = shareDao;
    }

    @Override
    public List<Share> getAllShares() {
        return shareDao.findAll();
    }

    @Override
    public boolean insertShare(Share share) {
        if(shareDao.existsById(share.getShareId())){
            throw new ShareAlreadyExistException("Share with ID "+share.getShareId()+" already exist");
        }
        else
            shareDao.save(share);
            return true;
    }

    @Override
    public boolean deleteShare(int id) {
        if(!shareDao.existsById(id)){
            throw new NoSuchShareExistException("No Share Exist with ID "+id);
        }
        else
            shareDao.deleteById(id);
        return true;
    }

    @Override
    public boolean updateMarketPrice(int id, int marketPrice) {
        Optional<Share> opShare= shareDao.findById(id);

        if(opShare.isPresent()){
            Share share=opShare.get();
            share.setMarket_price(marketPrice);
            shareDao.save(share);
            return true;
        }

        throw new NoSuchShareExistException("No Share Exist with ID "+id);

    }

    @Override
    public Share getShareById(int id) {
        Optional<Share> opShare= shareDao.findById(id);
        Share share=null;
        if(opShare.isPresent()) {
            share = opShare.get();return share;
        }
        throw new NoSuchShareExistException("No Share Exist with ID "+id);
    }

}
