package com.a41.invoice;

import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.a41.invoice.api.generated.ApiFeature;
import com.sap.cloud.yaas.servicesdk.jerseysupport.features.BeanValidationFeature;
import com.sap.cloud.yaas.servicesdk.jerseysupport.features.JerseyFeature;
import com.sap.cloud.yaas.servicesdk.jerseysupport.features.JsonFeature;
import com.sap.cloud.yaas.servicesdk.jerseysupport.features.SecurityFeature;
import com.sap.cloud.yaas.servicesdk.jerseysupport.logging.RequestResponseLoggingFilter;

/**
 * Defines the REST application.
 */
public class JerseyApplication extends ResourceConfig {
    private static final Logger LOG = LoggerFactory.getLogger(JerseyApplication.class);

    /**
     * Initialized the jersey application.
     */
    public JerseyApplication() {
        // enable error responses in JSON format
        register(JerseyFeature.class);

        // enable JSON support
        register(JsonFeature.class);

        // enable custom resources
        register(ApiFeature.class);

        // hybris-scopes support for @RolesAllowed
        register(SecurityFeature.class);

        // bean validation support
        register(BeanValidationFeature.class);

        // MultiPart Support
        register(MultiPartFeature.class);

        // log incoming requests
        register(new RequestResponseLoggingFilter(LOG));
    }
}