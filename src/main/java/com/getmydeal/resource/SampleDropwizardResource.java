package com.getmydeal.resource;

import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.getmydeal.bean.SampleDropwizardBean;
import com.google.common.base.Optional;
import com.yammer.metrics.annotation.Timed;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class SampleDropwizardResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public SampleDropwizardResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public SampleDropwizardBean sayHello(@QueryParam("name") Optional<String> name) {
        return new SampleDropwizardBean(counter.incrementAndGet(),
                          String.format(template, name.or(defaultName)));
    }
}
