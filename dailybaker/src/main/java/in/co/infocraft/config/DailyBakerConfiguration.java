package in.co.infocraft.config;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

public class DailyBakerConfiguration extends Configuration {

	private static final String DATABASE = "database";

	@Valid
	@NotNull
	private DataSourceFactory dataSourceFactory = new DataSourceFactory();

	@JsonProperty(DATABASE)
	public DataSourceFactory getDataSourceFactory() {
		return dataSourceFactory;
	}

	@JsonProperty(DATABASE)
	public void setDataSourceFactory(final DataSourceFactory dataSourceFactory) {
		this.dataSourceFactory = dataSourceFactory;
	}

}
