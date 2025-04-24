package com.ecommerce.mapper;

import com.ecommerce.constants.EcommerceConstants;
import com.ecommerce.dto.ProductDto;
import com.ecommerce.entity.NewProductEntity;
import com.ecommerce.entity.ProductEntity;
import com.ecommerce.product.dto.NewProductDto;

public class ProductMapper {
	
	private static final int HightpricePercentage=12;
	private static final int LowerpricePercentage=25;
	
	

	public static NewProductEntity maptoProduct(NewProductDto productDto) {
		NewProductEntity prodEntity = new NewProductEntity();
		prodEntity.setCategory(productDto.getCategory());
		prodEntity.setBrandName(productDto.getBrandName());
		prodEntity.setModelName(productDto.getModelName());
		prodEntity.setMemorySize(productDto.getMemorySize());
		prodEntity.setBatterySize(productDto.getBatterySize());
		prodEntity.setScreenSize(productDto.getScreenSize());
		prodEntity.setBestPrice(productDto.getBestPrice());
		prodEntity.setOs(productDto.getOs());
		prodEntity.setPopularity(productDto.getPopularity());
		prodEntity.setProdStatus(EcommerceConstants.ACTIVE);
		prodEntity.setSellersAmount(productDto.getSellersAmount());
		prodEntity.setReleaseDate(productDto.getReleaseDate());
		prodEntity.setImageSource(productDto.getImageSource());
		prodEntity.setLowestPrice(getLowestPrice(productDto.getBestPrice()));
		prodEntity.setHighestPrice(getHightPrice(productDto.getBestPrice()));
		return prodEntity;
		
	}
	
	public static NewProductDto maptoProductDto(NewProductDto prodEntity) {
		NewProductDto produDto = new NewProductDto();
		produDto.setCategory(prodEntity.getCategory());
		produDto.setBrandName(prodEntity.getBrandName());
		produDto.setModelName(prodEntity.getModelName());
		produDto.setMemorySize(prodEntity.getMemorySize());
		produDto.setBatterySize(prodEntity.getBatterySize());
		produDto.setScreenSize(prodEntity.getScreenSize());
		produDto.setBestPrice(prodEntity.getBestPrice());
		produDto.setOs(prodEntity.getOs());
		produDto.setPopularity(prodEntity.getPopularity());
		produDto.setProdStatus(prodEntity.getProdStatus());
		produDto.setSellersAmount(prodEntity.getSellersAmount());
		produDto.setReleaseDate(prodEntity.getReleaseDate());
		produDto.setImageSource(prodEntity.getImageSource());
		produDto.setLowestPrice(prodEntity.getLowestPrice());
		produDto.setHighestPrice(prodEntity.getHighestPrice());
		return produDto;
	}

	private static long getHightPrice(long bestPrice) {
		long percentAmt = (bestPrice * HightpricePercentage) / 100;
		System.out.println(percentAmt);
		long highprice = bestPrice + percentAmt;
		return highprice;
	}

	private static long getLowestPrice(long bestPrice) {
		long percentAmt = (bestPrice * LowerpricePercentage) / 100;
		System.out.println(percentAmt);
		long lowestprice = bestPrice - percentAmt;
		return lowestprice;
	}

	

	

}
