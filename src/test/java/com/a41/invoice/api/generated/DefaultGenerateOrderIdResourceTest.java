package  com.a41.invoice.api.generated;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.server.ResourceConfig;
import org.junit.Assert;
import org.junit.Test;

import com.a41.invoice.api.generated.AbstractResourceTest;


public final class DefaultGenerateOrderIdResourceTest extends AbstractResourceTest
{
	/**
	 * Server side root resource /generate/{orderId},
	 * evaluated with some default value(s).
	 */
	private static final String ROOT_RESOURCE_PATH = "/generate/orderId";

	/* post(null) /generate/orderId */
	@Test
	public void testPost()
	{
		final WebTarget target = getRootTarget(ROOT_RESOURCE_PATH).path("");

		final Response response = target.request().post(null);

		Assert.assertNotNull("Response must not be null", response);
		Assert.assertEquals("Response does not have expected response code", Status.CREATED.getStatusCode(), response.getStatus());
	}

	@Override
	protected ResourceConfig configureApplication()
	{
		final ResourceConfig application = new ResourceConfig();
		application.register(DefaultGenerateOrderIdResource.class);
		return application;
	}
}
