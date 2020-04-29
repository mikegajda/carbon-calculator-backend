package com.mikegajda.carbon.components;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AmazonConfig {
    @Value("${amazon.host}")
    public String amazonHost;

    @Value("${amazon.region}")
    public String amazonRegion;

    @Value("${amazon.paapi5.path}")
    public String amazonPAAPI5Path;

    @Value("${amazon.partner.tag}")
    public String amazonPartnerTag;

    @Value("${amazon.access.key}")
    public String amazonAccessKey;

    @Value("${amazon.secret.key}")
    public String amazonSecretKey;
}
