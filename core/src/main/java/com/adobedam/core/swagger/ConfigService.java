package com.adobedam.core.swagger;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = ConfigService.class, immediate = true)
@Designate(ocd = Config.class)
public class ConfigService {

    private static final Logger LOG = LoggerFactory.getLogger(ConfigService.class);

    private String apiSpecUrl;

    @Activate
    @Modified
    protected void activate(Config config) {
        this.apiSpecUrl = config.apiSpecUrl();
        LOG.debug("ConfigService Initialized - API Spec URL: {}", this.apiSpecUrl);
    }

    public String getApiSpecUrl() {
        return apiSpecUrl;
    }
}