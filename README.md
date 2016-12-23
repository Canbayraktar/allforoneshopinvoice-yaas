# yaas-allforoneshopinvoice
Purpose and Benefits
------------------

Showcase how a service can be written using Java. Demonstrate the integration with other services in YaaS, including authentication. Topics covered:
- Usage of Spring framework
- Property handling
- Authentication with the YaaS platform
- Consumption of YaaS services
- Deployment to Cloud Foundry
- Testing


Dependencies
------------

- Core Services
  - [OAuth2](https://devportal.yaas.io/services/oauth2/latest/index.html)
  - [Document](https://devportal.yaas.io/services/document/latest/index.html)
  - [Email](https://devportal.yaas.io/services/email/latest/index.html)
  - [Media](https://devportal.yaas.io/services/media/latest/index.html)
  - [Customer](https://devportal.yaas.io/services/customer/latest/index.html)


Build, Test, and Run the Service
-------------------------------

See the [Setup Guide](SETUP.md) for instructions on how to configure this service.

1. Use `mvn clean install` to build the service and run the tests.

2. Run the service locally by calling `mvn jetty:run`, and navigate to the local [API Console](http://localhost:8080).


FAQ / Troubleshooting
---------------------

If you get failed tests while building with `mvn clean install`, such as `response code expected:201 but was:500`, then it might mean that the service can't connect to other YaaS services. This could be related to missing proxy settings.

Hint: In that case, you might want to try it out with:

    mvn clean install -Dhttp.proxyPort=<proxyPort> -Dhttp.proxyHost=<proxyHost> -Dhttps.proxyPort=<proxyPort> -Dhttps.proxyHost=<proxyHost>
