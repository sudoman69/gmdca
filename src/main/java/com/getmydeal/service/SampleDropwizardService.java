package com.getmydeal.service;

import com.getmydeal.configuration.SampleDropwizardConfiguration;
import com.getmydeal.health.SampleDropwizardHealthCheck;
import com.getmydeal.resource.SampleDropwizardResource;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Environment;

public class SampleDropwizardService extends Service<SampleDropwizardConfiguration> {
    public static void main(String[] args) throws Exception {
        new SampleDropwizardService().run(args);
    }

    private SampleDropwizardService() {
        super("hello-world");
    }

    @Override
    protected void initialize(SampleDropwizardConfiguration configuration,
                              Environment environment) {
    	 final String template = configuration.getTemplate();
    	    final String defaultName = configuration.getDefaultName();
    	    environment.addResource(new SampleDropwizardResource(template, defaultName));
    	    environment.addHealthCheck(new SampleDropwizardHealthCheck(template));
    }

}
