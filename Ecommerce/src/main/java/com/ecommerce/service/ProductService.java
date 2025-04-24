package com.ecommerce.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ecommerce.catogory.dto.GetByIdCategoryResponceDto;
import com.ecommerce.catogory.dto.GetCatogorySubCatResDto;
import com.ecommerce.catogory.dto.SubCatogoryResponceDto;
import com.ecommerce.catogory.dto.UpdateCatogoryDto;
import com.ecommerce.dto.CategoryDto;
import com.ecommerce.dto.GetProductDto;
import com.ecommerce.dto.ImageDto;
import com.ecommerce.dto.ProductDto;
import com.ecommerce.dto.ProductresponseDto;
import com.ecommerce.dto.CategoryresponseDto;

import com.ecommerce.dto.GetCategoryResponceDto;
import com.ecommerce.entity.ProductEntity;
import com.ecommerce.product.dto.NewProductDto;



public interface ProductService {

//	void addProdect(String productDto, List<MultipartFile> file);

	void AddImageData(ImageDto imageDto);

	

	ProductresponseDto AddProductData(NewProductDto productDto);



	List<NewProductDto> getAllData();



//	String AddCatogory(CategoryDto categoryDto);







	CategoryresponseDto AddCatogory(CategoryDto categoryDto);



	GetCategoryResponceDto GetCatogory();



	GetByIdCategoryResponceDto GetCatogorybyId(long iD);



	SubCatogoryResponceDto UpdateCatogory(UpdateCatogoryDto updateCatDto);



	GetCatogorySubCatResDto GetCatSubCatList();






	

}
