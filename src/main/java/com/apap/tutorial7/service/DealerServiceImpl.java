package com.apap.tutorial7.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.tutorial7.model.DealerModel;
import com.apap.tutorial7.repository.DealerDb;

/**
 * DealerServiceImpl
 */
@Service
@Transactional
public class DealerServiceImpl implements DealerService{
	@Autowired
	private DealerDb dealerDb;
	
	@Override
	public List<DealerModel> getAllDealer(){
		return dealerDb.findAll();
	}
	
	@Override
	public Optional<DealerModel> getDealerDetailById(Long id) {
		return dealerDb.findById(id);
	}
	
	@Override
	public DealerModel addDealer (DealerModel dealer) {
		return dealerDb.save(dealer);
	}
	
	@Override
	public void updateDealer(Long dealerId, DealerModel newDealer) {
		DealerModel oldDealer = this.getDealerDetailById(dealerId).get();
		oldDealer.setAlamat(newDealer.getAlamat());
		oldDealer.setNoTelp(newDealer.getNoTelp());
	}
	
	@Override
	public void deleteDealerById(Long dealerId) {
		dealerDb.delete(this.getDealerDetailById(dealerId).get());
	}
	
	@Override
	public void deleteDealer(DealerModel dealer) {
		dealerDb.delete(dealer);
	}
}
