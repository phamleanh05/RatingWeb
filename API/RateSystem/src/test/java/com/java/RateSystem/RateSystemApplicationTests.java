package com.java.RateSystem;

import com.java.RateSystem.controller.RatingController;
import com.java.RateSystem.models.Rating;
import com.java.RateSystem.service.RatingService;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class RateSystemApplicationTests {
	LocalDate Localdate1 = LocalDate.of(2020, 4, 29);
	LocalDate Localdate2 = LocalDate.now();

	Rating rate1 = new Rating(null, null, null, null, null, null);
	Rating rate2 = new Rating(1, 10, "SomeOne", 5.0, "Good Service", Localdate1);
	Rating rate3 = new Rating(300, 10, "SomeOne", 1.0, "Bad Service", Localdate2);

	@InjectMocks
	private RatingController ratingController = new RatingController();
//	@Mock
//	private RatingService ratingService;

	@Test
	void test1() throws JSONException {
		String s = "501 NOT_IMPLEMENTED";
//		when(ratingService.checkRating(Mockito.any())).thenReturn(false);
		String status = ratingController.insertRating(rate1).getStatusCode().toString();
		assertEquals(s, status);
	}

	@Test
	void test2() throws JSONException {
		String s = "501 NOT_IMPLEMENTED";
		String status = ratingController.insertRating(rate2).getStatusCode().toString();
		assertEquals(s, status);
	}
	@Test
	void test3() throws JSONException {
		String s = "200 OK";
		String status = ratingController.insertRating(rate3).getStatusCode().toString();
		assertEquals(s, status);
	}
}
