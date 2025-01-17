/*
 *
 *  *
 *  *  *
 *  *  *  * Copyright 2019-2022 the original author or authors.
 *  *  *  *
 *  *  *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  *  *  * you may not use this file except in compliance with the License.
 *  *  *  * You may obtain a copy of the License at
 *  *  *  *
 *  *  *  *      https://www.apache.org/licenses/LICENSE-2.0
 *  *  *  *
 *  *  *  * Unless required by applicable law or agreed to in writing, software
 *  *  *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  *  *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  *  *  * See the License for the specific language governing permissions and
 *  *  *  * limitations under the License.
 *  *  *
 *  *
 *
 */

package test.org.springdoc.api.v31;

import javax.annotation.PostConstruct;

import test.org.springdoc.api.AbstractCommonTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.web.server.LocalManagementPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.client.RestTemplate;

@TestPropertySource(properties={ "management.endpoints.enabled-by-default=true", "springdoc.api-docs.version=openapi_3_1" })
public abstract class AbstractSpringDocActuatorV31Test extends AbstractCommonTest {

	@LocalManagementPort
	private int managementPort;

	@Autowired
	private RestTemplateBuilder restTemplateBuilder;

	protected RestTemplate actuatorRestTemplate;

	@PostConstruct
	void init() {
		actuatorRestTemplate = restTemplateBuilder
				.rootUri("http://localhost:" + this.managementPort).build();
	}
}
