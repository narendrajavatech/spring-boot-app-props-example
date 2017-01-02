package io.damo.apppropsexample.movies;

import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DataSourceAutoConfiguration.class)
public class RepositoryTestConfiguration {
}
