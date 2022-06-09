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
	LocalDate Localdate1 = LocalDate.of(1997, 4, 29);
	LocalDate Localdate2 = LocalDate.now();

	Date date1 = Date.from(Localdate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
	Date date2 = Date.from(Localdate2.atStartOfDay(ZoneId.systemDefault()).toInstant());

	Rating rate1 = new Rating(null, null, null, null, null);
	Rating rate2 = new Rating(10, "SomeOne", 5.0, "Good Service", date1);
	Rating rate3 = new Rating(10, "SomeOne", 1.0, "Bad Service", date2);
	@InjectMocks
	private RatingController ratingController = new RatingController();
	@Mock
	private RatingService ratingService;

	@Test
	void test1() throws JSONException {
		String s = "501 NOT_IMPLEMENTED";
		when(ratingService.checkRating(Mockito.any())).thenReturn(false);
		String status = ratingController.insertRating(rate1).getStatusCode().toString();
		assertEquals(s, status);
	}

	@Test
	void test2() throws JSONException {
		String s = "200 OK";
		when(ratingService.checkRating(Mockito.any())).thenReturn(true);
		String status = ratingController.insertRating(rate2).getStatusCode().toString();
		assertEquals(s, status);
	}

	@Test
	void test3() throws JSONException {
		String s = "200 OK";
		when(ratingService.checkRating(Mockito.any())).thenReturn(true);
		String status = ratingController.insertRating(rate3).getStatusCode().toString();
		assertEquals(s, status);
	}
}
