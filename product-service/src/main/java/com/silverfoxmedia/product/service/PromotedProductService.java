package com.silverfoxmedia.product.service;

import com.silverfoxmedia.product.entity.Product;
import com.silverfoxmedia.product.entity.PromotedProduct;

import java.util.List;

public interface PromotedProductService {
    
    public List<PromotedProduct> listAllPromotedProduct();
    public PromotedProduct getPromotedProduct(Long id);

    public PromotedProduct createPromotedProduct(PromotedProduct promotedProduct);
    public PromotedProduct updatePromotedProduct(PromotedProduct promotedProduct);
    public  PromotedProduct deletePromotedProduct(Long id);
}
