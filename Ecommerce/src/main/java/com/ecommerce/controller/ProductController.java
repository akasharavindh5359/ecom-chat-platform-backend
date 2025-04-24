
package com.ecommerce.controller;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
import com.ecommerce.dto.StatusDto;
import com.ecommerce.product.dto.NewProductDto;
import com.ecommerce.service.ProductService;
@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/ecom")
public class ProductController {

	@Autowired
	ProductService productService;
	
	private Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@PostMapping("/addProductData")
	public ResponseEntity<?> AddProductData(@RequestBody NewProductDto productDto){
		ProductresponseDto ProductDto = null;
		try {
			this.logger.info("<------RestAPIController-------AddProductData()---->Start");
			ProductDto=	productService.AddProductData(productDto);
			this.logger.info("<------RestAPIController-------AddProductData()---->Start");
		} catch (Exception var1) {
			this.logger.info("<------RestAPIController-------AddProductData()---->",var1);
		}
		return new ResponseEntity<>(ProductDto,HttpStatus.OK);
		 
	}
	
	@PostMapping("/addImageData")
	public ResponseEntity<StatusDto> AddImageData(@RequestBody ImageDto imageDto){
		this.logger.info("<------RestAPIController-------AddImageData()---->Start");
		productService.AddImageData(imageDto);
		StatusDto response = new StatusDto();
		response.setMessage("Operation successful");
		response.setStatusCode(HttpStatus.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
				
	}
	
	@GetMapping("/GetProductData")
	public ResponseEntity<?> GetAllData() {
		List <NewProductDto> ListProductData = null;
		try {
			this.logger.info("<------RestAPIController-------AddCatogory()---->Start");
			ListProductData =productService.getAllData();
			this.logger.info("<------RestAPIController-------AddCatogory()---->End");
		} catch (Exception var2) {
			this.logger.info("<------RestAPIController-------AddCatogory()---->",var2);
		}
		
		return new ResponseEntity<>(ListProductData,HttpStatus.OK);
		
		 
		
	}
	
	@PostMapping("/addCatogory")
	public ResponseEntity<?> AddCatogory(@RequestBody CategoryDto categoryDto){
		CategoryresponseDto catDto = null;
		try {
			this.logger.info("<------RestAPIController-------AddCatogory()---->Start");
			catDto =productService.AddCatogory(categoryDto);
			
			this.logger.info("<------RestAPIController-------AddCatogory()---->End");
		}catch (Exception var1) {
			this.logger.error("Error<------RestAPIController-------AddCatogory()---->", var1);
		}
		
		return new ResponseEntity<>(catDto, HttpStatus.OK);
				
	}
	
	@GetMapping("/getCatogory")
	public ResponseEntity<?> GetCatogory() {
		GetCategoryResponceDto CateResDto= null;
		try {
			this.logger.info("<------RestAPIController-------AddCatogory()---->Start");
			CateResDto =productService.GetCatogory();
			this.logger.info("<------RestAPIController-------AddCatogory()---->End");
		} catch (Exception var2) {
			this.logger.info("<------RestAPIController-------AddCatogory()---->",var2);
		}
		
		return new ResponseEntity<>(CateResDto,HttpStatus.OK);
	}
	
	@GetMapping("/getCatogoryID")
	public ResponseEntity<?> GetCatogorybyId(@RequestParam(name = "Id")long ID) {
		GetByIdCategoryResponceDto CateResDto= null;
		try {
			this.logger.info("<------RestAPIController-------AddCatogory()---->Start");
			CateResDto =productService.GetCatogorybyId(ID);
			this.logger.info("<------RestAPIController-------AddCatogory()---->End");
		} catch (Exception var2) {
			this.logger.info("<------RestAPIController-------AddCatogory()---->",var2);
		}
		
		return new ResponseEntity<>(CateResDto,HttpStatus.OK);
	}
	
	
	@PutMapping("/updateCatogory")
	public ResponseEntity<?> UpdateCatogory(@RequestBody UpdateCatogoryDto updateCatDto){
		SubCatogoryResponceDto subCatresDto=null;
		try {
			this.logger.info("<------RestAPIController-------UpdateCatogory()---->Start");
			subCatresDto =productService.UpdateCatogory(updateCatDto);
			this.logger.info("<------RestAPIController-------UpdateCatogory()---->End");
		} catch (Exception var3) {
			this.logger.info("<------RestAPIController-------AddCatogory()---->",var3);
		}
		
		
        return new ResponseEntity<>(subCatresDto, HttpStatus.OK);
				
	}
	
	@GetMapping("/getCatSubcatList")
	public ResponseEntity<?> GetCatSubCatList(){
		GetCatogorySubCatResDto CatsubcatDto = null;
		try {
			this.logger.info("<------RestAPIController-------GetCatSubCatList()---->Start");
			CatsubcatDto = productService.GetCatSubCatList();
			this.logger.info("<------RestAPIController-------GetCatSubCatList()---->End");
		} catch (Exception e) {
			// TODO: handle exception
		}
		  return new ResponseEntity<>(CatsubcatDto, HttpStatus.OK);
	}


	
}