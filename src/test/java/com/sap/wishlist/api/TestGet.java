/**
 * 
 */
package com.sap.wishlist.api;

import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.MultiPartFeature;

import com.sap.cloud.yaas.servicesdk.jerseysupport.features.BeanValidationFeature;
import com.sap.cloud.yaas.servicesdk.jerseysupport.features.JerseyFeature;
import com.sap.cloud.yaas.servicesdk.jerseysupport.features.JsonFeature;
import com.sap.cloud.yaas.servicesdk.jerseysupport.features.SecurityFeature;
import com.sap.wishlist.api.generated.ApiFeature;
import com.sap.wishlist.order.OrderClientService;

/**
 * @author Can Bayraktar
 *
 */
public class TestGet {
	/**
	* 
	*/
	public TestGet() {
		// TODO Auto-generated constructor stub
	}

	@Inject
	private OrderClientService orderClient;
	
	public static void main(String[] args) {
		TestGet tt = new TestGet();
		tt.orderClient.createMedia(null, "4KMZLJ17", null);
//		
//		String apiUrl = "https://api.yaas.io/hybris/order/v1/allforoneshop/salesorders/4KMZLJ17";
//		Response result = ClientBuilder.newBuilder()
//				.build().target(apiUrl)
//        .request(MediaType.APPLICATION_JSON).header("Authorization", "Bearer 021-07e1e7c9-5c72-4d2a-bcfc-22c0b0f52277").get();
//		System.out.println(result);
		
//		WebTarget target = client.target(apiUrl);
//		
//		Response result = target.request().header("Authorization", "Bearer 021-89ebfbec-e7b9-4068-be06-2d2e541a0df9").get();
		
//		final Response response = client.target(apiUrl).request()
//        		.header("Authorization", "021-89ebfbec-e7b9-4068-be06-2d2e541a0df9")
//                .get();
		
	}
}
