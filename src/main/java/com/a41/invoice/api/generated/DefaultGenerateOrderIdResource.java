
package com.a41.invoice.api.generated;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

import org.springframework.stereotype.Component;

import com.a41.invoice.api.generated.GenerateOrderIdResource;
import com.a41.invoice.api.generated.YaasAwareParameters;
import com.a41.invoice.order.OrderClientService;
import com.a41.invoice.order.model.Order;
import com.a41.invoice.service.DefaultPdfGeneratorService;

/**
* Resource class containing the custom logic. Please put your logic here!
*/
@Component("apiGenerateOrderIdResource")
@Singleton
public class DefaultGenerateOrderIdResource implements GenerateOrderIdResource
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