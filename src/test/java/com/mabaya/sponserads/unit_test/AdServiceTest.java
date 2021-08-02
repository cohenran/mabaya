//package com.mabaya.sponserads.unit_test;
//
//
//import com.mabaya.sponserads.dao.CampaignRepository;
//import com.mabaya.sponserads.dao.ProductRepository;
//import com.mabaya.sponserads.model.CampaignEntity;
//import com.mabaya.sponserads.model.ProductEntity;
//import com.mabaya.sponserads.service.impl.AdServiceImpl;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.time.LocalDate;
//import java.util.Collections;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//@Slf4j
//@RunWith(SpringRunner.class)
//public class AdServiceTest {
//	@Mock
//	private CampaignRepository campaignRepository;
//	@Mock
//	private ProductRepository productRepositpry;
//
//	@InjectMocks
//	private AdServiceImpl adService;
//	
//	private final ProductEntity PRODUCT = new ProductEntity("test", "test", 0.1f, "abc");
//	private CampaignEntity testCampaignEntity = new CampaignEntity("test", Collections.singletonList(PRODUCT), LocalDate.now(), 0.1f);
//	/**
//	 * Remove the TEST log file before/after the test
//	 */
//	@Before
//	public void init() {
//	}
//
//	@Test
//	public void createCampaignTest() {
//		when(campaignRepository.save(testCampaignEntity)).thenReturn(testCampaignEntity);
//
//		CampaignEntity returnedCampaignEntity = adService.createCampaign("test", testCampaignEntity);
//
//		assertEquals(returnedCampaignEntity, testCampaignEntity);
//	}
//
//	@Test
//	public void serveAdTest() {
//		when(productRepositpry.findByCategory("test")).thenReturn(Collections.singletonList(PRODUCT));
//		when(campaignRepository.getActiveCampaigns()).thenReturn(Collections.singletonList(testCampaignEntity));
//		ProductEntity returnedProduct = adService.serveAd("test");
//
//		assertEquals(returnedProduct, PRODUCT);		
//	}
//}
