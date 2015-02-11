package com.test.dropwizard;

import com.hubspot.dropwizard.guice.GuiceBundle;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class MyApplication extends Application<MyAppConfiguration> {
	public static void main(String[] args) throws Exception {
		new MyApplication().run(args);
	}

	@Override
	public void initialize(Bootstrap<MyAppConfiguration> bootstrap) {
		bootstrap.addBundle(
				GuiceBundle.<MyAppConfiguration>newBuilder()
						.addModule(new MyAppModule(bootstrap))
						.enableAutoConfig(getClass().getPackage().getName())
						.setConfigClass(MyAppConfiguration.class)
						.build()
		);
	}

	@Override
	public void run(final MyAppConfiguration configuration, final Environment environment) throws Exception {
	}

}  
