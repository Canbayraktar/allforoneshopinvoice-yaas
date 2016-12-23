
package com.sap.wishlist.api.generated;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

import org.springframework.stereotype.Component;

import com.allforone.order.model.Order;
import com.sap.wishlist.order.OrderClientService;
import com.sap.wishlist.service.DefaultPdfGeneratorService;

/**
* Resource class containing the custom logic. Please put your logic here!
*/
@Component("apiGenerateOrderIdResource")
@Singleton
public class DefaultGenerateOrderIdResource implements com.sap.wishlist.api.generated.GenerateOrderIdResource
{
	@javax.ws.rs.core.Context
	private javax.ws.rs.core.UriInfo uriInfo;
	
	@Inject
	private DefaultPdfGeneratorService pdfGeneratorService;
	
	@Inject
	private OrderClientService orderClientService;

	/* POST / */
	@Override
	public Response post(final YaasAwareParameters yaasAware, final java.lang.String orderId)
	{
		Order order = orderClientService.getOrderById(yaasAware, orderId);
		StreamingOutput stream = pdfGeneratorService.generate(order);
		return Response.ok(stream, "application/pdf")
			.header("content-disposition","attachment; filename = "+orderId+".pdf")
			.build();
	}

}
