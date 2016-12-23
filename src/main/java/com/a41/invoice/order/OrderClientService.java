/**
 * 
 */
package com.a41.invoice.order;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Value;

import com.a41.invoice.api.generated.YaasAwareParameters;
import com.a41.invoice.client.order.OrderServiceClient;
import com.a41.invoice.order.model.Order;
import com.a41.invoice.utility.AuthorizationHelper;
import com.sap.cloud.yaas.servicesdk.authorization.AccessToken;
/**
 * @author Can Bayraktar
 *
 */
@ManagedBean
public class OrderClientService {

	@Inject
	private OrderServiceClient orderClient;
	
	@Inject
	private AuthorizationHelper authHelper;

	@Value("${YAAS_CLIENT}")
	private String client;

    private Order getOrderById(final YaasAwareParameters yaasAware, final String id, final AccessToken token) {
        Response documentOrder = orderClient
                .tenant(yaasAware.getHybrisTenant()).salesorders().orderId(id).prepareGet().withAuthorization(token.toAuthorizationHeaderValue()).execute();
        
        System.out.println(documentOrder);
        Order order = documentOrder.readEntity(Order.class);
//        if (response.getStatus() == Status.OK.getStatusCode()) {
//            final Order documentOrder = response.readEntity(Order.class);
//            
            return order;//documentOrder.get(0);
//
//        } else if (response.getStatus() == Status.NOT_FOUND.getStatusCode()) {
//            throw new NotFoundException("Cannot find Order with ID " + id, response);
//        }
//        throw ErrorHandler.resolveErrorResponse(response, token);
    }
    
    public Order getOrderById(final YaasAwareParameters yaasAware, final String orderId) {
		return authHelper.wrapWithAuthorization(yaasAware, yaasAware.getHybrisScopes(),
				token -> getOrderById(yaasAware, orderId, token));
	}
}
