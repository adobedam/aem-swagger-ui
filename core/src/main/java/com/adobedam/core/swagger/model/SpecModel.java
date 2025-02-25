package com.adobedam.core.swagger.model;

import com.adobedam.core.swagger.ConfigService;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Model(adaptables = SlingHttpServletRequest.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class SpecModel {

    private static Logger logger = LoggerFactory.getLogger(SpecModel.class);
    
    @OSGiService
    private ConfigService configService;

    private String apiSpecUrl;

    @PostConstruct
    protected void init() {
        logger.info("Init SpecModel : " + configService.getApiSpecUrl());
        if (configService != null) {
            apiSpecUrl = configService.getApiSpecUrl();
        } else {
            logger.warn("ConfigService is null");
        }
    }

    public String getApiSpecUrl() {
        return apiSpecUrl;
    }
}
