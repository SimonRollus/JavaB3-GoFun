package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.dataAccess.entity.DiscountEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.DiscountRepository;
import com.spring.henallux.firstSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.firstSpringProject.model.Discount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DiscountDAO implements DiscountDataAccess{
    private DiscountRepository discountRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public DiscountDAO(DiscountRepository discountRepository, ProviderConverter providerConverter){
        this.discountRepository = discountRepository;
        this.providerConverter = providerConverter;
    }

    public Discount getDiscount(Integer id) {
        Optional<DiscountEntity> discountEntity = discountRepository.findById(id);
        if(discountEntity.isPresent()){
            return providerConverter.discountEntityToDiscountModel(discountEntity.get());
        }else{
            return null;
        }
    }
}
