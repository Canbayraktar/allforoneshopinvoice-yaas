/**
 * 
 */
package com.sap.wishlist.order;

import java.io.InputStream;
import java.util.Iterator;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;

import com.allforone.order.model.Order;
import com.sap.cloud.yaas.servicesdk.authorization.AccessToken;
import com.sap.wishlist.api.generated.YaasAwareParameters;
import com.sap.wishlist.client.order.OrderServiceClient;
import com.sap.wishlist.utility.AuthorizationHelper;

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

	public JSONObject createMedia(final YaasAwareParameters yaasAware, final String orderId,
			final AccessToken token) {

		Response result = orderClient.tenant().salesorders().orderId("4KMZLJ17").prepareGet().execute();

        if (result.getStatus() == Response.Status.OK.getStatusCode()) {
            final JSONObject create = new JSONObject(result.readEntity(String.class));
            Iterator<String> cc = create.keySet().iterator();
            while(cc.hasNext()){
            	System.out.println(cc.next());
            }
            return create;
        }
        return null;
	}

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
