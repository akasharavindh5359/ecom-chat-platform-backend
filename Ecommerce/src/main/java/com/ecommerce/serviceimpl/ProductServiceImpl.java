package com.ecommerce.serviceimpl;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.catogory.dto.CatNameDto;
import com.ecommerce.catogory.dto.CategorySubDto;
import com.ecommerce.catogory.dto.GetByIdCategoryResponceDto;
import com.ecommerce.catogory.dto.GetCatogorySubCatResDto;
import com.ecommerce.catogory.dto.SubCatogoryResponceDto;
import com.ecommerce.catogory.dto.Subcatogory;
import com.ecommerce.catogory.dto.UpdateCatogoryDto;
import com.ecommerce.constants.EcommerceConstants;
import com.ecommerce.dto.CategoryDto;
import com.ecommerce.dto.CategoryresponseDto;
import com.ecommerce.dto.ErrorDescription;
import com.ecommerce.dto.GetCategoryResponceDto;
import com.ecommerce.dto.GetProductDto;
import com.ecommerce.dto.ImageDto;
import com.ecommerce.dto.ImageNameDto;
import com.ecommerce.dto.ProductDto;
import com.ecommerce.dto.ProductresponseDto;
import com.ecommerce.entity.CategoryEntity;
import com.ecommerce.entity.ImageEntity;
import com.ecommerce.entity.NewProductEntity;
import com.ecommerce.entity.ProductEntity;
import com.ecommerce.entity.SubCatogoryEntity;
import com.ecommerce.mapper.ProductMapper;
import com.ecommerce.product.dto.NewProductDto;
import com.ecommerce.repo.CategoryRepo;
import com.ecommerce.repo.ImageRepo;
import com.ecommerce.repo.ProductRepo;
import com.ecommerce.repo.SubCatogoryRepo;
import com.ecommerce.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepo productRepo;

	@Autowired
	ImageRepo imageRepo;

	@Autowired
	CategoryRepo categoryRepo;


	@Autowired
	SubCatogoryRepo subCatogoryRepo;

	private Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	//	@Override
	//	public void addProdect(String productDto, List<MultipartFile> file) {

	//		ProductDto productdto = new ProductDto();
	//		ObjectMapper mapper = new ObjectMapper();
	//		
	//		try {
	//			
	//			productdto = mapper.readValue(productDto, ProductDto.class);
	//			System.out.println(productdto);
	//		} catch (JsonMappingException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		} catch (JsonProcessingException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		}
	//		
	//		int imagecount = file.size();
	//		ProductEntity productEntiy = new ProductEntity();
	//		productEntiy.setProductName(productdto.getProductName());
	//		productEntiy.setDescriation(productdto.getDescriation());
	//		productEntiy.setBrand(productdto.getBrand());
	//		productEntiy.setCategory(productdto.getCategory());
	//		productEntiy.setPrice(productdto.getPrice());
	//		productEntiy.setQuantity(productdto.getQuantity());
	//		productEntiy.setRatings(productdto.getRatings());
	//		productEntiy.setImageCount(imagecount);
	//		productEntiy.setAvailable(productdto.getAvailable());
	//		productRepo.save(productEntiy);
	//		
	////		ImageEntity imageEntity = new ImageEntity();
	////		List<ImageEntity>imagefile = new ArrayList<ImageEntity>();
	////		boolean count = false;
	////		for(MultipartFile filedata : file) {
	////			imageEntity.setImageName(filedata.getOriginalFilename());
	////			imageEntity.setImageType(filedata.getContentType());
	////			try {
	////				imageEntity.setImagedata(filedata.getBytes());
	//////				imageEntity.setImageTrackId(productEntiy.getId());
	////				imagefile.add(imageEntity);
	////				
	////				for (ImageEntity fileModal : imagefile) {
	////					imageRepo.saveImageData(fileModal.getImageName(),fileModal.getImageTrackId(),fileModal.getImageType(),fileModal.getImagedata());
	////				}
	////				
	////			} catch (IOException e) {
	////				// TODO Auto-generated catch block
	////				e.printStackTrace();
	////			}
	////	
	////		}
	//		
	//		
	//		
	//		
	//		
	//	}

	//}

	@Override
	public ProductresponseDto AddProductData(NewProductDto productDto) {
		NewProductEntity prodEntity = new NewProductEntity();
		ProductresponseDto ProductRes = new ProductresponseDto();
		
		
		try {
			if(productDto!=null) {
				this.logger.info("<-------RestAPIServiceImpl------AddProductData()-------Start--->");
				prodEntity =ProductMapper.maptoProduct(productDto);
				NewProductEntity EntityRes =productRepo.save(prodEntity);
				if(EntityRes!=null) {
					ProductRes.setStatus(EcommerceConstants.STATUS_SUCCESS);
					ProductRes.setResponseMes(EcommerceConstants.SUCCESS_MESG);
					ProductRes.setProductData(EntityRes);
				}else {
					ProductRes.setStatus(EcommerceConstants.STATUS_FAIL);
					ProductRes.setResponseMes(EcommerceConstants.ERROR_MESG);
				}
				this.logger.info("<-------RestAPIServiceImpl------getAllData()-------End--->");
				return ProductRes;
			}else {
				ProductRes.setStatus(EcommerceConstants.STATUS_FAIL);
				ProductRes.setResponseMes(EcommerceConstants.ERROR_MESG);
			}	
		} catch (Exception var1) {
			this.logger.info("<-------RestAPIServiceImpl------getAllData()----->",var1);
			ProductRes.setStatus(EcommerceConstants.STATUS_FAIL);
			ProductRes.setResponseMes(EcommerceConstants.ERROR_MESG);
			ProductRes.setErrorDetails(Arrays.asList(new ErrorDescription("500" , var1.toString())));
		}
		return ProductRes;


	}

	@Override
	public void AddImageData(ImageDto ImageDto) {

		ImageEntity imageEntity = new ImageEntity();
		List<ImageEntity> ImageData = new ArrayList<ImageEntity>();
		//	for(int i = 0;i<ImageDto.getImgList().size();i++) {
		for (ImageNameDto img : ImageDto.getImgList()) {
			imageEntity.setMasTranId(ImageDto.getMasTranId());
			imageEntity.setImageName(img.getImageName());
			imageEntity.setImageSource(img.getImageSource());
			ImageData.add(imageEntity);
			imageRepo.ImageDataSave(ImageData.get(0).getMasTranId(), ImageData.get(0).getImageName(),
					ImageData.get(0).getImageSource());
			//			return imageEntity;

			//		}

		}
		//	imageEntity.setMasTranId(imageDto.getMasTranId());
		//		return imageEntity;

		//	imageEntity.setImageName(imageDto.getImageName());
		//	imageEntity.setImageSource(imageDto.getImageSource());

	}

	//	@Override
	//	public ArrayList getAllData() {
	//		// TODO Auto-generated method stub
	//		return null;
	//	}

	//	private long masTranId;
	//
	//	private String productName;
	//
	//	private String productdesc;
	//
	//	private float ratings;
	//
	//	private String brand;
	//
	//	private float price;
	//
	//	private String category;
	//
	//	private boolean prodStatus;
	//
	//	private int prodQuantity;
	//
	//	private int discound;
	//
	//	private List<ImageDto> imageDto;

	@Override
	public  List<NewProductDto> getAllData() {
		List<NewProductDto> ProductList = new ArrayList<>();
		try {
			this.logger.info("<-------RestAPIServiceImpl------getAllData()-------Start--->");
			List<NewProductEntity> ProductEntity = productRepo.findAll();
			Iterator<NewProductEntity> iteratorProd = ProductEntity.iterator();
			while(iteratorProd.hasNext()) {
				NewProductEntity proEnity = iteratorProd.next();
				NewProductDto productDto = new NewProductDto();
				productDto.setCategory(proEnity.getCategory());
				productDto.setBatterySize(proEnity.getBatterySize());
				productDto.setBestPrice(proEnity.getBestPrice());
				productDto.setBrandName(proEnity.getBrandName());
				productDto.setCategory(proEnity.getCategory());
//				productDto.setHighestPrice(proEnity.getHighestPrice());
				productDto.setImageSource(proEnity.getImageSource());
//				productDto.setLowestPrice(proEnity.getLowestPrice());
				productDto.setMemorySize(proEnity.getMemorySize());
				productDto.setModelName(proEnity.getModelName());
				productDto.setOs(proEnity.getOs());
				productDto.setPopularity(proEnity.getPopularity());
				productDto.setScreenSize(proEnity.getScreenSize());
				productDto.setSellersAmount(proEnity.getSellersAmount());
				
				ProductList.add(productDto);	
			}
			this.logger.info("<-------RestAPIServiceImpl------getAllData()-------End--->");
			return ProductList;		

		} catch (Exception var2) {
			this.logger.info("<-------RestAPIServiceImpl------getAllData()------->",var2);

		}
		return ProductList;
	}



	@Override
	public CategoryresponseDto AddCatogory(CategoryDto categoryDto) {
		CategoryEntity catEntity = new CategoryEntity();
		CategoryresponseDto catRes = new CategoryresponseDto();
		try {
			this.logger.info("<-------RestAPIServiceImpl------AddCatogory()-------Start--->");
			//		CategoryEntity ExistingCategory =.orElse(null);
			//		CategoryEntity existingCustomer = categoryRepo.findByCategoryName(categoryDto.getCategoryName());
			if(!categoryDto.getCategoryName().isBlank() && !categoryDto.getCategoryImg().isEmpty()){
				catEntity.setCategoryName(categoryDto.getCategoryName());
				catEntity.setCategoryImg(categoryDto.getCategoryImg());

				CategoryEntity res = categoryRepo.save(catEntity);
				if(res != null) {
					catRes.setStatus(EcommerceConstants.STATUS_SUCCESS);
					catRes.setResponseMes(EcommerceConstants.SUCCESS_MESG);
					catRes.setCategoryData(res);
				}else {
					catRes.setStatus(EcommerceConstants.STATUS_FAIL);
					catRes.setResponseMes(EcommerceConstants.ERROR_MESG);
				}
				this.logger.info("<-------RestAPIServiceImpl------AddCatogory()-------End--->");
			}else {	
				catRes.setStatus(EcommerceConstants.STATUS_FAIL);
				catRes.setResponseMes(EcommerceConstants.EXCEPTION);
			}
		}catch (Exception e) {
			catRes.setStatus(EcommerceConstants.STATUS_FAIL);
			catRes.setResponseMes(EcommerceConstants.ERROR_MESG);
			catRes.setErrorDetails(Arrays.asList(new ErrorDescription("500" , e.toString())));
		}
		return catRes ;

	}

	@Override
	public GetCategoryResponceDto GetCatogory() {
		List<CategoryEntity> categoryList = new ArrayList<>();
		CategoryDto catDto = new CategoryDto();
		List<CategoryEntity> categoryEntity = new ArrayList<>();
		CategoryEntity catEntity = new CategoryEntity();
		GetCategoryResponceDto getCateResDto = new GetCategoryResponceDto();
		try {
			this.logger.info("<-------RestAPIServiceImpl------AddCatogory()-------Start--->");
			categoryEntity=categoryRepo.findAll();
			if(categoryEntity != null) {
				Iterator<CategoryEntity> catIterat = categoryEntity.iterator();
				while (catIterat.hasNext()) {
					catEntity = catIterat.next();
					//					catDto.setCategoryName(catEntity.getCategoryName());
					//					catDto.setCategoryImg(catEntity.getCategoryImg());
					//					catDto.set
					categoryList.add(catEntity);
				}
				getCateResDto.setStatus(EcommerceConstants.STATUS_SUCCESS);
				getCateResDto.setResponseMes(EcommerceConstants.FETCHING_SUCCESS);
				getCateResDto.setCatList(categoryList);
				return getCateResDto;
			}else {
				getCateResDto.setStatus(EcommerceConstants.STATUS_FAIL);
				getCateResDto.setResponseMes(EcommerceConstants.ERROR_MESG);
			}
			this.logger.info("<-------RestAPIServiceImpl------AddCatogory()-------End--->");
			;
		} catch (Exception var4) {
			this.logger.info("<-------RestAPIServiceImpl------AddCatogory()-------->"+var4);
			getCateResDto.setStatus(EcommerceConstants.STATUS_FAIL);
			getCateResDto.setResponseMes(EcommerceConstants.ERROR_MESG);
			getCateResDto.setErrorDetails(Arrays.asList(new ErrorDescription("500" , var4.toString())));
		}
		return getCateResDto;
	}

	@Override
	public GetByIdCategoryResponceDto GetCatogorybyId(long id) {
		CategoryEntity catEntity = new CategoryEntity();
		SubCatogoryEntity subCatEntity = new SubCatogoryEntity();
		
		
		
		CategorySubDto catSubDto = new CategorySubDto();
		GetByIdCategoryResponceDto getCateResDto = new GetByIdCategoryResponceDto();
		//		List<CategoryEntity> categoryEntity = new ArrayList<>();
		try {
			if(id!=0) {
				catEntity = categoryRepo.GetCatogorybyId(id);
				if(catEntity!=null) {
					List<SubCatogoryEntity> subCatogoryEntity = subCatogoryRepo.getSubCatData(id);
					Iterator<SubCatogoryEntity> iteratorProd = subCatogoryEntity.iterator();
					List<Subcatogory> subCatList = new ArrayList<>();
					while (iteratorProd.hasNext()) {
						Subcatogory subCatDto = new Subcatogory();
						SubCatogoryEntity subCatoentity =iteratorProd.next();
						subCatDto.setName(subCatoentity.getSubCatName());
						subCatList.add(subCatDto);
					}
					catSubDto.setCategoryName(catEntity.getCategoryName());
					catSubDto.setCategoryImg(catEntity.getCategoryImg());
					catSubDto.setCatTranId(catEntity.getCatTranId());
					getCateResDto.setCatList(catSubDto);
					catSubDto.setSubCatogory(subCatList);
					getCateResDto.setStatus(EcommerceConstants.STATUS_SUCCESS);
					getCateResDto.setResponseMes(EcommerceConstants.FETCHING_SUCCESS);
				}else {
					getCateResDto.setStatus(EcommerceConstants.STATUS_FAIL);
					getCateResDto.setResponseMes(EcommerceConstants.EXCEPTION);
				}

			}else {
				getCateResDto.setStatus(EcommerceConstants.STATUS_FAIL);
				getCateResDto.setResponseMes(EcommerceConstants.ERROR_MESG);
			}
		} catch (Exception var5) {
			getCateResDto.setStatus(EcommerceConstants.STATUS_FAIL);
			getCateResDto.setResponseMes(EcommerceConstants.ERROR_MESG);
			getCateResDto.setErrorDetails(Arrays.asList(new ErrorDescription("500" , var5.toString())));
		}
		return getCateResDto;
	}

	@Override
	public SubCatogoryResponceDto UpdateCatogory(UpdateCatogoryDto updateCatDto) {
		CategoryEntity catEntity = new CategoryEntity();
		List<Subcatogory> subCatArray = new ArrayList<>();
		SubCatogoryResponceDto subCatResDto = new SubCatogoryResponceDto();


		if(updateCatDto.getCatogoryId() != 0 && updateCatDto.getCatogoryName() !=null
				&& updateCatDto.getCatogoryImg() !=null) {
			try {
				int updateCategory = categoryRepo.updateCatogory(updateCatDto.getCatogoryId(),
						updateCatDto.getCatogoryName(),updateCatDto.getCatogoryImg());
				if(updateCategory !=0) {
					int len = updateCatDto.getSubCatogory().size();
					Subcatogory subCat = new Subcatogory();
					subCatArray= updateCatDto.getSubCatogory();
					subCatogoryRepo.deleteSubCategory(updateCatDto.getCatogoryId());
					if(!subCatArray.isEmpty()) {
						for(Subcatogory v : subCatArray){
							SubCatogoryEntity subCatEntity = new SubCatogoryEntity();

							subCatEntity.setCatTranId(updateCatDto.getCatogoryId());
							subCatEntity.setSubCatName(v.getName());
							subCatEntity.setStatus(EcommerceConstants.ACTIVE);
							subCatEntity.setId(null);
							try {
								
								SubCatogoryEntity res =subCatogoryRepo.save(subCatEntity);
								long ResId = res.getId();
								if(ResId != 0) {
									subCatResDto.setStatus(EcommerceConstants.STATUS_SUCCESS);
									subCatResDto.setResponseMes(EcommerceConstants.SUCCESS_UP_MESG);
									subCatResDto.setSubCatogoryId(ResId);

								}else {
									subCatResDto.setStatus(EcommerceConstants.STATUS_FAIL);
									subCatResDto.setResponseMes(EcommerceConstants.EXCEPTION);
								}

							} catch (Exception var7) {
								subCatResDto.setStatus(EcommerceConstants.STATUS_FAIL);
								subCatResDto.setResponseMes(EcommerceConstants.ERROR_MESG);
								subCatResDto.setErrorDetails(Arrays.asList(new ErrorDescription("500" , var7.toString())));
							}



						}
					}else {
						subCatResDto.setStatus(EcommerceConstants.STATUS_SUCCESS);
						subCatResDto.setResponseMes(EcommerceConstants.SUCCESS_UP_MESG);
						
					}
					
				}else {
					subCatResDto.setStatus(EcommerceConstants.STATUS_FAIL);
					subCatResDto.setResponseMes(EcommerceConstants.EXCEPTION);
					subCatResDto.setSubCatogoryId(updateCatDto.getCatogoryId());
				}
				

			} catch (Exception var6) {
				subCatResDto.setStatus(EcommerceConstants.STATUS_FAIL);
				subCatResDto.setResponseMes(EcommerceConstants.ERROR_UPDATE);
				subCatResDto.setErrorDetails(Arrays.asList(new ErrorDescription("500" , var6.toString())));
			}

			//			if(catEntity != null) {
			
			//				System.err.println(SubCatName);
			//				subCatEntity=subCatogoryRepo.addSubCatogory(updateCatDto.getCategoryId());

			//			}else {
			//				getCateResDto.setStatus(EcommerceConstants.STATUS_FAIL);
			//				getCateResDto.setResponseMes(EcommerceConstants.EXCEPTION);
			//			}

		}
		return subCatResDto;


		//		categoryRepo.findAllById(id)

	}

	@Override
	public GetCatogorySubCatResDto GetCatSubCatList() {
		GetCatogorySubCatResDto CatSubcatResDto = new GetCatogorySubCatResDto();
		this.logger.info("<-------RestAPIServiceImpl------GetCatSubCatList()-------Start--->");
		try {
			List<CategoryEntity> categoryEntity = new ArrayList<>();
			CategoryEntity catEntity = new CategoryEntity();
			SubCatogoryEntity subCatEntity = new SubCatogoryEntity();
			
			
			List<CatNameDto> CatNameList = new ArrayList<>();
			categoryEntity = categoryRepo.findAll();
			if(!categoryEntity.isEmpty()) {
				Iterator<CategoryEntity> IteratorCategory = categoryEntity.iterator();
				while (IteratorCategory.hasNext()) {
					List<Subcatogory> subCatList = new ArrayList<>();
					CatNameDto catnameDto = new CatNameDto();
					CategoryEntity CatEntity = IteratorCategory.next();
					catnameDto.setCatId(CatEntity.getCatTranId());
					catnameDto.setCatName(CatEntity.getCategoryName());
					List<SubCatogoryEntity> subCatogoryList = subCatogoryRepo.getSubCatData(CatEntity.getCatTranId());
					if(!subCatogoryList.isEmpty()) {
						Iterator<SubCatogoryEntity> subCatIterator = subCatogoryList.iterator();
						while (subCatIterator.hasNext()) {
							Subcatogory subCat = new Subcatogory();
							SubCatogoryEntity subCatData =subCatIterator.next();
							subCat.setName(subCatData.getSubCatName());
							subCatList.add(subCat);
						}
						catnameDto.setSubCatName(subCatList);
						CatNameList.add(catnameDto);
					}else {
						CatNameList.add(catnameDto);
					}
					catnameDto.setSubCatName(subCatList);
					
				}
				CatSubcatResDto.setCatName(CatNameList);
				CatSubcatResDto.setStatus(EcommerceConstants.STATUS_SUCCESS);
				CatSubcatResDto.setResponseMes(EcommerceConstants.FETCHING_SUCCESS);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		this.logger.info("<-------RestAPIServiceImpl------GetCatSubCatList()-------End--->");
		return CatSubcatResDto;
	}


}

