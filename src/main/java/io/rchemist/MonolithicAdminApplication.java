/*
 *  Copyright (c) 2022. rchemist.io by Rchemist
 *  Licensed under the Rchemist Common License, Version 1.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License under controlled by Rchemist
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package io.rchemist;

import io.rchemist.common.transformer.PlatformClassTransformHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchRestClientAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * <p>
 * Project : Rchemist Commerce Platform
 * <p>
 * Created by kunner
 **/

/**
 * <p>
 * Project : Rchemist Commerce Platform
 * <p>
 * Created by kunner
 **/
@EnableCaching
@EnableTransactionManagement
@EnableAsync
@EnableScheduling
@SpringBootApplication(
    scanBasePackages = {"io.rchemist"},
    exclude = {  DataSourceAutoConfiguration.class, UserDetailsServiceAutoConfiguration.class, LiquibaseAutoConfiguration.class, MongoAutoConfiguration.class, MongoDataAutoConfiguration.class, ElasticsearchRestClientAutoConfiguration.class})
@Slf4j
public class MonolithicAdminApplication {

  public static void main(String[] args) {
    SpringApplication application = new SpringApplicationBuilder()
        .sources(MonolithicAdminApplication.class)
        .listeners(new ApplicationPidFileWriter("./mono-admin.pid"))
        .build();

    PlatformClassTransformHelper.initializeDefaultTransformedClasses();

    setDefaultProfile(application);

    application.run(args);
  }

  /**
   * spring default profile setting - if null
   * @param application default application
   */
  public static void setDefaultProfile(SpringApplication application) {
    String profile = System.getProperty("spring.profiles.active");
    if(StringUtils.isEmpty(profile)) {
      application.setAdditionalProfiles("local");
    }
  }

}
