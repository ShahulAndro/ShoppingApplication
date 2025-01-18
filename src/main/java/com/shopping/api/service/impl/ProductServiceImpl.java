package com.shopping.api.service.impl;

import com.shopping.api.entity.Product;
import com.shopping.api.exception.RecordNotFoundException;
import com.shopping.api.mapper.ProductDataMapper;
import com.shopping.api.repository.ProductRepository;
import com.shopping.api.dto.ProductDTO;
import com.shopping.api.request.ProductRequest;
import com.shopping.api.service.ProductService;
import com.shopping.api.utility.AppUtility;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<ProductDTO> getProducts() {
        return AppUtility.parseList(productRepository.findAll(), ProductDataMapper::toDTO);
    }

    @Override
    public ProductDTO saveProduct(ProductRequest productRequest) {
        Product product = productRepository.save(ProductDataMapper.toEntity(productRequest));
        return ProductDataMapper.toDTO(product);
    }

    @Override
    public ProductDTO getProduct(Long id) {
        return ProductDataMapper.toDTO(findById(id));
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductRequest productRequest) {
        Product product = productRepository.save(ProductDataMapper.toEntity(productRequest, findById(id)));
        return ProductDataMapper.toDTO(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.delete(findById(id));
    }

    private Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Product not found"));
    }
}
