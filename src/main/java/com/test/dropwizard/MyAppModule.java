package com.test.dropwizard;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import org.hibernate.SessionFactory;

public class MyAppModule extends AbstractModule {
	private final HibernateBundle<MyAppConfiguration> hibernateBundle = new HibernateBundle<MyAppConfiguration>(MyModel.class) {
		@Override
		public DataSourceFactory getDataSourceFactory(MyAppConfiguration configuration) {
			return configuration.getDataSourceFactory();
		}
	};

	public MyAppModule(Bootstrap<MyAppConfiguration> bootstrap) {
		bootstrap.addBundle(hibernateBundle);
	}

	@Provides
	public SessionFactory provideSessionFactory() {
		return hibernateBundle.getSessionFactory();
	}

	@Override
	protected void configure() {
	}

}