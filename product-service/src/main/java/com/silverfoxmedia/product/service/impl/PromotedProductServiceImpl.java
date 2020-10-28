package com.silverfoxmedia.product.service.impl;

import com.silverfoxmedia.product.entity.PromotedProduct;
import com.silverfoxmedia.product.repository.PromotedProductRepository;
import com.silverfoxmedia.product.service.PromotedProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PromotedProductServiceImpl implements PromotedProductService {

    private final PromotedProductRepository promotedProductRepository;

    @Override
    public List<PromotedProduct> listAllPromotedProduct() {
        return promotedProductRepository.findAll();
    }

    @Override
    public PromotedProduct getPromotedProduct(Long id) {
        return promotedProductRepository.findById(id).orElse(null);
    }

    @Override
    public PromotedProduct createPromotedProduct(PromotedProduct promotedPromotedProduct) {
//        promotedPromotedProduct.setStatus("CREATED");
        promotedPromotedProduct.setCreateAt(new Date());

        return promotedProductRepository.save(promotedPromotedProduct);
    }

    @Override
    public PromotedProduct updatePromotedProduct(PromotedProduct promotedPromotedProduct) {
        PromotedProduct promotedPromotedProductDB = getPromotedProduct(promotedPromotedProduct.getId());
        if (null == promotedPromotedProductDB){
            return null;
        }
        promotedPromotedProductDB.setName(promotedPromotedProduct.getName());
        promotedPromotedProductDB.setDescription(promotedPromotedProduct.getDescription());
        promotedPromotedProductDB.setCategory(promotedPromotedProduct.getCategory());
        promotedPromotedProductDB.setPrice(promotedPromotedProduct.getPrice());
        return promotedProductRepository.save(promotedPromotedProductDB);
    }

    @Override
    public PromotedProduct deletePromotedProduct(Long id) {
        PromotedProduct promotedPromotedProductDB = getPromotedProduct(id);
        if (null == promotedPromotedProductDB){
            return null;
        }
//        promotedPromotedProductDB.setStatus("DELETED");
        return promotedProductRepository.save(promotedPromotedProductDB);
    }
}
