package com.sap.wishlist.api.generated;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.server.ResourceConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import com.allforone.order.model.Order;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public final class DefaultWishlistsResourceTest extends com.sap.wishlist.api.generated.AbstractResourceTest
{
	/**
	 * Server side root resource /wishlists,
	 * evaluated with some default value(s).
	 */
	private static final String ROOT_RESOURCE_PATH = "/wishlists";

	/* get() /wishlists */
	@Test
	public void testGet()
	{
		WebTarget target = ClientBuilder.newClient().target("https://api.us.yaas.io/hybris/order/v1/allforoneshop/salesorders/4KMZLJ17");
//		
//		final WebTarget target = getRootTarget(ROOT_RESOURCE_PATH).path("");

		 Order response = target.request().header("Authorization", "Bearer 021-7d5edaf0-a171-4b0b-b9d4-e5d670b8713f").get(Order.class);
		 System.out.println(response.getCustomer().getName());
//		System.out.println(create);
//		System.out.println("\n");
//		System.out.println(create.get("totalPrice"));
		Assert.assertNotNull("Response must not be null", response);
		Assert.assertEquals("Response does not have expected response code", Status.OK.getStatusCode(), response.getStatus());
	}

	/* post(entity) /wishlists */
	//@Test
	public void testPostWithWishlist()
	{
		final WebTarget target = getRootTarget(ROOT_RESOURCE_PATH).path("");
		final Wishlist entityBody =
		new Wishlist();
		final javax.ws.rs.client.Entity<Wishlist> entity =
		javax.ws.rs.client.Entity.entity(entityBody,"application/json");

		final Response response = target.request().post(entity);

		Assert.assertNotNull("Response must not be null", response);
		Assert.assertEquals("Response does not have expected response code", Status.CREATED.getStatusCode(), response.getStatus());
	}

	/* get() /wishlists/wishlistId */
	//@Test
	public void testGetByWishlistId()
	{
		final WebTarget target = getRootTarget(ROOT_RESOURCE_PATH).path("/wishlistId");

		final Response response = target.request().get();

		Assert.assertNotNull("Response must not be null", response);
		Assert.assertEquals("Response does not have expected response code", Status.OK.getStatusCode(), response.getStatus());
	}

	/* put(entity) /wishlists/wishlistId */
	//@Test
	public void testPutByWishlistIdWithWishlist()
	{
		final WebTarget target = getRootTarget(ROOT_RESOURCE_PATH).path("/wishlistId");
		final Wishlist entityBody =
		new Wishlist();
		final javax.ws.rs.client.Entity<Wishlist> entity =
		javax.ws.rs.client.Entity.entity(entityBody,"application/json");

		final Response response = target.request().put(entity);

		Assert.assertNotNull("Response must not be null", response);
		Assert.assertEquals("Response does not have expected response code", Status.OK.getStatusCode(), response.getStatus());
	}

	/* delete() /wishlists/wishlistId */
	//@Test
	public void testDeleteByWishlistId()
	{
		final WebTarget target = getRootTarget(ROOT_RESOURCE_PATH).path("/wishlistId");

		final Response response = target.request().delete();

		Assert.assertNotNull("Response must not be null", response);
		Assert.assertEquals("Response does not have expected response code", Status.NO_CONTENT.getStatusCode(), response.getStatus());
	}

	/* post(null) /wishlists/wishlistId/media */
	//@Test
	public void testPostByWishlistIdMedia()
	{
		final WebTarget target = getRootTarget(ROOT_RESOURCE_PATH).path("/wishlistId/media");

		final Response response = target.request().post(null);

		Assert.assertNotNull("Response must not be null", response);
		Assert.assertEquals("Response does not have expected response code", Status.CREATED.getStatusCode(), response.getStatus());
	}

	/* get() /wishlists/wishlistId/media */
	//@Test
	public void testGetByWishlistIdMedia()
	{
		final WebTarget target = getRootTarget(ROOT_RESOURCE_PATH).path("/wishlistId/media");

		final Response response = target.request().get();

		Assert.assertNotNull("Response must not be null", response);
		Assert.assertEquals("Response does not have expected response code", Status.OK.getStatusCode(), response.getStatus());
	}

	/* delete() /wishlists/wishlistId/media/mediaId */
	//@Test
	public void testDeleteByWishlistIdMediaByMediaId()
	{
		final WebTarget target = getRootTarget(ROOT_RESOURCE_PATH).path("/wishlistId/media/mediaId");

		final Response response = target.request().delete();

		Assert.assertNotNull("Response must not be null", response);
		Assert.assertEquals("Response does not have expected response code", Status.NO_CONTENT.getStatusCode(), response.getStatus());
	}

	/* get() /wishlists/wishlistId/wishlistItems */
	//@Test
	public void testGetByWishlistIdWishlistItems()
	{
		final WebTarget target = getRootTarget(ROOT_RESOURCE_PATH).path("/wishlistId/wishlistItems");

		final Response response = target.request().get();

		Assert.assertNotNull("Response must not be null", response);
		Assert.assertEquals("Response does not have expected response code", Status.OK.getStatusCode(), response.getStatus());
	}

	/* post(entity) /wishlists/wishlistId/wishlistItems */
	//@Test
	public void testPostByWishlistIdWishlistItemsWithWishlistItem()
	{
		final WebTarget target = getRootTarget(ROOT_RESOURCE_PATH).path("/wishlistId/wishlistItems");
		final WishlistItem entityBody =
		new WishlistItem();
		final javax.ws.rs.client.Entity<WishlistItem> entity =
		javax.ws.rs.client.Entity.entity(entityBody,"application/json");

		final Response response = target.request().post(entity);

		Assert.assertNotNull("Response must not be null", response);
		Assert.assertEquals("Response does not have expected response code", Status.CREATED.getStatusCode(), response.getStatus());
	}

	@Override
	protected ResourceConfig configureApplication()
	{
		final ResourceConfig application = new ResourceConfig();
		application.register(DefaultWishlistsResource.class);
		return application;
	}
}
