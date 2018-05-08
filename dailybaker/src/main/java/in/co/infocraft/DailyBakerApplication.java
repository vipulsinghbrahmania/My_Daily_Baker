package in.co.infocraft;

import javax.sql.DataSource;

import org.skife.jdbi.v2.DBI;

import in.co.infocraft.config.DailyBakerConfiguration;
import in.co.infocraft.resources.SampleResource;
import in.co.infocraft.services.UserService;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DailyBakerApplication extends Application<DailyBakerConfiguration> {
	
	private static final String SQL = "sql";
	
	public static void main(String[] args) throws Exception {
        new DailyBakerApplication().run(args);
    }
	
	@Override
    public void initialize(Bootstrap<DailyBakerConfiguration> bootstrap) {
        // nothing to do yet
    }

	@Override
	public void run(DailyBakerConfiguration configuration, Environment environment) throws Exception {
		// Datasource configuration
	    final DataSource dataSource =
	        configuration.getDataSourceFactory().build(environment.metrics(), SQL);
	    DBI dbi = new DBI(dataSource);
	    
		final SampleResource sample = new SampleResource(dbi.onDemand(UserService.class));
		environment.jersey().register(sample);
		
	}

}
